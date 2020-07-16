/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.ups.controlador;

import ec.edu.ups.conexion.conexion;
import ec.edu.ups.modelo.Historial_Clinico;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class ControladorHistorial {
     
      public int obtenerCodigo() {
        String sql = "SELECT MAX(pro_id) FROM HISTORIALCLINICO ";
        int codigo = 0;
       
        return codigo + 1;
        
    }
    
    public void crear(Historial_Clinico p) {
        String sql = "INSERT INTO `HISTORIALCLINICO` "
                + "(`hist_descripcion`, `hist_tipo`, `hist_fecha`, "
                + "`PACIENTE_pa_cedula`) "
                + "VALUES "
                + "('" + p.getDescripcion() + "', "
                + "'" +  p.getTipo() +"', "
                + "now() , "
                + "'" + p.getPACIENTE_pa_cedula() + "');"; 


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
}
