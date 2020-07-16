/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.ups.conexion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * 
 */
public class conexion {

    private static Connection conn;
    private final String driver;
    private final String user;
    private final String password;
    private final String url;

    public conexion() {
        conn = null;
        driver = "com.mysql.jdbc.Driver";
//        user = "damian";
//        password = "12345";
//        url = "jdbc:mysql://192.168.2.10:3306/facturacion?autoReconnect=true&useSSL=false";

        user = "root";
        password = "7121997cumple";
        url = "jdbc:mysql://localhost:3306/mydb?autoReconnect=true&useSSL=false";
    }

  

    public Connection getConexion() {
        try {
            Class.forName(driver);
            conn = DriverManager.getConnection(url, user, password);
            if (conn != null) {
                System.out.println("conexion exitosa");
            } else {
                System.out.println("no hay conexion");
            }

        } catch (SQLException e) {
            System.out.println("error en la conexion" + e.getMessage());
            System.out.println(e.getMessage());
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(conexion.class.getName()).log(Level.SEVERE, null, ex);
        }
        return conn;
    }

    public void desconectar() {
        conn = null;
        if (conn == null) {
            System.out.println("conexion terminada");
        }

    }
}
