/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Daniele Harumi Ito
 */
public class Conexao {
    private Connection connection;

    private static final String JDBC_URL = "jdbc:sqlserver://localhost:1433;databaseName=Emea";
    private static final String USER = "sa";
    private static final String PASSWORD = "tblk3856*";
    private static final String DRIVER = "com.microsoft.sqlserver.jdbc.SQLServerDriver";

    public Conexao() throws SQLException {
        try {
            Class.forName(DRIVER);
            connection = DriverManager.getConnection(JDBC_URL, USER, PASSWORD);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Conexao.class.getName()).log(Level.SEVERE, null, ex);
        }        
    }

    public Connection getConnection() {
        return this.connection;
    }

    public void closeConnection() {
        try {
            this.connection.close();
        } catch (SQLException ex) {
            Logger.getLogger(Conexao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}