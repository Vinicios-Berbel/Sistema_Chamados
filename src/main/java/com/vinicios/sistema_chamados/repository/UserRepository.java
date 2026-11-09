package com.vinicios.sistema_chamados.repository;

import com.vinicios.sistema_chamados.config.ConnectionFactory;
import com.vinicios.sistema_chamados.dto.CreateUserDTO;
import com.vinicios.sistema_chamados.model.User;
import com.vinicios.sistema_chamados.model.UserRole;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class UserRepository {
    public static void save(User user){
        String sql = "INSERT INTO users (id, identifier, name, email, password, user_role) VALUES ('%s', '%s', '%s', '%s', '%s', '%s')".formatted(UUID.randomUUID() ,user.getIdentifier() ,user.getName(), user.getEmail(), user.getPassword(), user.getUserRole());

        try(Connection conn = ConnectionFactory.getConnection();
            Statement stmt = conn.createStatement()){
            int rowAffected = stmt.executeUpdate(sql);
            System.out.println(rowAffected);
            conn.close();
            stmt.close();

        }catch(SQLException e){
            e.printStackTrace();
        }
    }

    public static List<User> findAll(){
        String sql = "SELECT identifier, name, email, user_role FROM users";

        try(Connection conn = ConnectionFactory.getConnection();
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql)){

            List<User> users = new ArrayList<>();

            while(rs.next()){
                User user = new User.Builder().identifier(rs.getLong("identifier")).name(rs.getString("name")).email(rs.getString("email")).userRole(UserRole.valueOf((rs.getString("user_role")))).build();
                users.add(user);
            }
            return users;
        }catch(SQLException e){
            e.printStackTrace();
        }catch(IllegalArgumentException e){
            e.printStackTrace();
        }
        return null;
    }

    public static User delete(UUID{

    }
}
