/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.ups.controlador;

import ec.edu.ups.conexion.ConexionBD;
import ec.edu.ups.conexion.conexion;
import ec.edu.ups.modelo.Paciente;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

public class ControladorPaciente {

    private Connection con;
    private conexion conector;
    private List<Paciente> pacientes;

    public void crear(Paciente p) {
        con = null;

        String sql = "INSERT INTO paciente VALUES ('" + p.getPac_cedula() + "', '" + p.getPa_religion() + "', '" + p.getPa_recidencia() + "' , '"
                + p.getPa_procedencia() + "', '" + p.getPa_ocupacion() + "', '" + p.getPERSONA_per_cedula() + "'" + ");";

        try {
            conexion c = new conexion();
            Connection con = c.getConexion();
            con = c.getConexion();
            Statement s = con.createStatement();
            s.executeUpdate(sql);
            c.desconectar();

        } catch (SQLException ex) {
            System.out.println("Error " + ex.getMessage());
            System.out.println(sql);
        }

    }

    public void eliminar(String id) {
        String sql = "DELETE FROM paciente WHERE  pa_cedula  =" + id + ";";
        try {
            conector.getConexion();
            Statement sta = con.createStatement();
            sta.executeUpdate(sql);
            conector.desconectar();
        } catch (SQLException ex) {
            System.out.println("Error " + ex.getMessage());
        }
    }

    public Paciente buscar(String id) {

        String sql = "SELECT * FROM paciente WHERE  pa_cedula  ='" + id + "';";

        try {
            conexion c = new conexion();
            Connection con = c.getConexion();
            con = c.getConexion();
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet reset = ps.executeQuery();

            while (reset.next()) {
                    Paciente p = new Paciente();
                    p.setPa_religion(reset.getString("pa_religion".trim()));
                    p.setPa_recidencia(reset.getString("pa_recidencia".trim()));
                    p.setPa_procedencia(reset.getString("pa_procedencia".trim()));
                    p.setPa_ocupacion(reset.getString("pa_ocupacion".trim()));
                    return p;
                              
                
            }
            c.desconectar();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }

    public void actualizar(Paciente p, String id) {

        String sql = "UPDATE paciente  SET   pa_cedula  = '" + p.getPac_cedula()
                + "', pa_religion = '" + p.getPa_religion()
                + "', pa_recidencia = '" + p.getPa_recidencia()
                + "', pa_procedencia = '" + p.getPa_procedencia()
                + "', pa_ocupacion = '" + p.getPa_ocupacion()
                + " WHERE pa_cedula ='" + id + "';";
        System.out.println(sql);
        try {
            conexion c = new conexion();
            Connection con = c.getConexion();
            con = c.getConexion();
            Statement s = con.createStatement();
            s.executeUpdate(sql);
            c.desconectar();
        } catch (SQLException ex) {
            System.out.println("Error  " + ex.getMessage());
        }
    }

}
