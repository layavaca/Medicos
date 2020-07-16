/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.ups.controlador;

import ec.edu.ups.conexion.conexion;
import ec.edu.ups.modelo.Especialidad;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;


public class ControladorEspecialidad {
    
    public void crear(Especialidad p) {
        String sql = "INSERT INTO ESPECIALIDAD (`espe_especialidad`) VALUES ('" + p.espe_especialidad + "');";

        try {
            conexion c = new conexion();
            Connection con = c.getConexion();
            con = c.getConexion();
            Statement s = con.createStatement();
            s.executeUpdate(sql);
            c.desconectar();

        } catch (SQLException e) {
            System.out.println("Error en el SQL " + e);
        }

    }
    
    public List<Especialidad> listar() {

        List<Especialidad> especialidad = new ArrayList<Especialidad>();

        String sql = "SELECT espe_especialidad from especialidad;";

        try {
            conexion c = new conexion();
            Connection con = c.getConexion();
            con = c.getConexion();
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet resultSet = ps.executeQuery();

            // conecta
            // prepara la
            // consulta
            // un resultset es cada fila del
            // sql
            while (resultSet.next())// recorre cada una de las filas
            {

                Especialidad p = new Especialidad(0, sql);
                p.setEspe_especialidad(resultSet.getString("espe_especialidad"));
               

                especialidad.add(p);// agrega la lista

            }
            c.desconectar();

        } catch (Exception e) {
            e.printStackTrace();
        } finally {

        }

        return especialidad;
    }
}
