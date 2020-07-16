package ec.edu.ups.conexion;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 * Conexion a la base de datos
 *
 *
 * 
 *
 */
public class ConexionBD {

    public static Connection getConnection() {

        try {

            Connection con = DriverManager.getConnection("jdbc:mysql://localhost/mydb" , "root", "cuenca");// path, de la ruta de la base de datos

            //Connection con = DriverManager.getConnection("jdbc:postgresql://localhost/facturacion"+"?userTimezone=true&serverTimezone=UTC", "postgres", "cuenca");// path, de la ruta de la base de datos
            System.out.println("conexion exitosa base ");

            return con;

        } catch (Exception ex1) {
            System.out.println("Database.getConnection() Error -->" + ex1.getMessage());
            return null;
        }

    }

    public static void close(Connection con) {
        try {
            con.close();
        } catch (Exception ex) {
        }
    }

}
