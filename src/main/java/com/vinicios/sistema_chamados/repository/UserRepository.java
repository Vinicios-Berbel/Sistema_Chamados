package com.vinicios.sistema_chamados.repository;

import com.vinicios.sistema_chamados.config.ConnectionFactory;
import com.vinicios.sistema_chamados.dto.CreateUserDTO;
import com.vinicios.sistema_chamados.model.User;
import com.vinicios.sistema_chamados.model.UserRole;

import java.net.ConnectException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

public class UserRepository {
    public static void save(User user){
        String sql = "INSERT INTO users (id, identifier, name, email, password, user_role) VALUES (?, ?, ?, ?, ?, ?)";

        try(Connection conn = ConnectionFactory.getConnection();
            PreparedStatement stmt = conn.prepareStatement(sql);){
            stmt.setObject(1, UUID.randomUUID());
            stmt.setLong(2, user.getIdentifier());
            stmt.setString(3, user.getName());
            stmt.setString(4, user.getEmail());
            stmt.setString(5, user.getPassword());
            stmt.setString(6, String.valueOf(user.getUserRole()));
            int rowsAffected = stmt.executeUpdate();
            System.out.println(rowsAffected);

        }catch(SQLException e){
            e.printStackTrace();
        }
    }

    public static List<User> findAll(){
        String sql = "SELECT identifier, name, email, user_role FROM users";

        try(Connection conn = ConnectionFactory.getConnection();
            PreparedStatement stmt = conn.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery()){

            List<User> users = new ArrayList<>();

            while(rs.next()){
                User user = new User.Builder().identifier(rs.getLong("identifier")).name(rs.getString("name")).email(rs.getString("email")).userRole(UserRole.valueOf((rs.getString("user_role")))).build();
                users.add(user);
            }
            return users;
        }catch(SQLException e){
            e.printStackTrace();
            return null;
        }
    }

    public static void delete(UUID id){
        String sql = "DELETE FROM users WHERE id = ?";

        try(Connection conn = ConnectionFactory.getConnection();
            PreparedStatement stmt = conn.prepareStatement(sql);){

            stmt.setObject(1,id);
            int rowsAffected = stmt.executeUpdate();
            System.out.println(rowsAffected);

        }catch(SQLException e){
            e.printStackTrace();
        }
    }

    public static User findByIdentifier(Long identifier){
        String sql = "SELECT id, identifier, name, email, password, user_role FROM users WHERE identifier = ?";

        try(Connection conn = ConnectionFactory.getConnection();
            PreparedStatement stmt = conn.prepareStatement(sql);
            ){
            stmt.setLong(1, identifier);
            try(ResultSet rs = stmt.executeQuery()){
                if(rs.next()){
                    return new User.Builder().id((UUID) rs.getObject("id")).identifier(rs.getLong("identifier")).name(rs.getString("name")).email(rs.getString("email")).password(rs.getString("password")).userRole((UserRole.valueOf(rs.getString("user_role")))).department(null).build();
                }
                return null;
            }

        }catch(SQLException e){
            e.printStackTrace();
            return null;
        }
    }
}
