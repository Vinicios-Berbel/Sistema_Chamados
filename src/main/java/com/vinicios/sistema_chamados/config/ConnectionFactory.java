package com.vinicios.sistema_chamados.config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {

    private static final String url = System.getenv("DB_URL");
    private static final String user = System.getenv("DB_USER");
    private static final String password = System.getenv("DB_PASSWORD");

    public static Connection getConnection(){
        try{
            return DriverManager.getConnection(url, user, password);

        } catch(SQLException ex){
            throw new RuntimeException("Erro na conexão com o banco de dados", ex);
        }
    }
}
