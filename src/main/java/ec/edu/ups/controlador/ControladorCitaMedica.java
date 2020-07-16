/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.ups.controlador;

import ec.edu.ups.conexion.conexion;
import ec.edu.ups.modelo.CitaMedica;
import ec.edu.ups.modelo.Medico;
import ec.edu.ups.modelo.Paciente;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.AbstractList;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.locks.StampedLock;
import javax.swing.JOptionPane;

public class ControladorCitaMedica {

    private Connection con;
    private List<CitaMedica> listacitaMedica;
    private Statement statement;
    private ResultSet r;
    private conexion conexion;
    private PreparedStatement ps;

    public ControladorCitaMedica() {
        
    }

    public void crearCitaMedica(CitaMedica citaMedica) {
        String sql = "INSERT INTO CITAMEDICA (cita_id, cita_fecha, cita_hora, cita_motivo, MEDICO_med_id, PACIENTE_pa_cedula " + ")" + " values (?,?,?,?,?,?);";
        try {
            conexion = new conexion();
            ps = conexion.getConexion().prepareStatement(sql);
            ps.setInt(1, citaMedica.getCita_id());
            ps.setString(2, citaMedica.getCita_fecha());
            ps.setString(3, citaMedica.getCita_hora());
            ps.setString(4, citaMedica.getCita_motivo());
            ps.setString(5, citaMedica.MEDICO_med_id);
            ps.setString(6, citaMedica.PACIENTE_pa_cedula);
            ps.execute();
            
            System.out.println(ps);
            
            System.out.println(sql);

        } catch (Exception e) {
            System.out.println("error " + e);
            JOptionPane.showMessageDialog(null, "Los Datos no han sido Guardados");
        } finally {
            conexion.desconectar();
        }
    }

    public void eliminarCitaMedica(CitaMedica citaMedica, int id) {
        try {
            statement = conexion.getConexion().createStatement(r.TYPE_SCROLL_SENSITIVE, r.CONCUR_UPDATABLE);
            statement.executeUpdate("DELETE FROM citasMedicas WHERE id =" + id + ";");
            JOptionPane.showMessageDialog(null, "cita medica eliminada ");
        } catch (Exception e) {
            System.out.println("problema al conectarse a la BD" + e);
            JOptionPane.showMessageDialog(null, "cita medica no eliminada");
        }

    }

    public void modificarCitaMedica(CitaMedica citaMedica, int id) {

        try {
            statement = conexion.getConexion().createStatement(r.TYPE_SCROLL_SENSITIVE, r.CONCUR_UPDATABLE);
            statement.executeUpdate("UPDATE citasMedicas set cita_id  = '" + citaMedica.getCita_id()
                    + "', cita_fecha = '" + citaMedica.getCita_fecha()
                    + "', cita_hora = '" + citaMedica.getCita_hora()
                    + "', cita_motivo = '" + citaMedica.getCita_motivo()
                    + "', MEDICO_med_id= '" + citaMedica.getMEDICO_med_id()
                    + "', PACIENTE_pa_cedula = '" + citaMedica.getPACIENTE_pa_cedula()
                    + "WHERE cita_id = '" + id + "';");
            JOptionPane.showMessageDialog(null, "Citas Medicas Actualizados con Exito");

        } catch (Exception e) {
            System.out.println("error" + e);
            JOptionPane.showMessageDialog(null, "Datos no actualizados");
        }

    }
    public CitaMedica buscarCita (int id) throws SQLException{
        
        conexion =  new conexion();
        CitaMedica citaMedica =  new CitaMedica();
        ControladorPaciente cp = new ControladorPaciente();
        ControladorMedico cm =  new ControladorMedico();
        ControladorCitaMedica controladorCitaMedica = new ControladorCitaMedica();
        
        try {
            statement =  conexion.getConexion().createStatement(r.TYPE_SCROLL_SENSITIVE, r.CONCUR_UPDATABLE);
            r = statement.executeQuery("SELECT * FROM CITAMEDICA WHERE cita_id = '" + id +"';");
            
            while (r.next()) {
                int cod = r.getInt(1);
                String fecha = r.getString(2);
                String hora = r.getString(3);
                String codPaciente = r.getString(6);
                Paciente p = cp.buscar(codPaciente);
                String codMedico = r.getString(5);
                Medico m = cm.BuscarMedico(codMedico);
                String motivo = r.getString(4);
                
                citaMedica.setCita_id(cod);
                citaMedica.setCita_fecha(fecha);
                citaMedica.setCita_hora(hora);
                citaMedica.setMEDICO_med_id(codMedico);
                citaMedica.setPACIENTE_pa_cedula(codPaciente);
                citaMedica.setCita_motivo(motivo);
                
            }
            r.close();
            statement.close();
        } catch (Exception e) {
             System.out.println("error " + e);
        }
        
        return citaMedica;
    }
    
       public int obtenerCodigo(){
        conexion = new conexion();
        CitaMedica citaMedica =  new CitaMedica();
        ControladorCitaMedica controladorCitaMedica =  new ControladorCitaMedica();
        int codigo = 0;
        try {
            statement = conexion.getConexion().createStatement(r.TYPE_SCROLL_SENSITIVE, r.CONCUR_UPDATABLE);
            r = statement.executeQuery("SELECT max(cita_id) from CITAMEDICA; ");
            
            r.next();
            codigo=r.getInt(1);

            
            r.close();
            statement.close();
        } catch (SQLException ex) {
            System.out.println("problema al conectar  a la base de datos ");
        }
        return ++codigo;
    }
        

}
