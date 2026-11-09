package com.vinicios.sistema_chamados.config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {

    private static final String url = "jdbc:postgresql://localhost:5432/sistema_chamados";
    private static final String user = "root";
    private static final String password = "281202";

    public static Connection getConnection(){
        try{
            return DriverManager.getConnection(url, user, password);

        } catch(SQLException ex){
            throw new RuntimeException("Erro na conexão com o banco de dados", ex);
        }
    }
}
