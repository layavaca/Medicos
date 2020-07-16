/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.ups.controlador;

import ec.edu.ups.conexion.ConexionBD;
import ec.edu.ups.conexion.conexion;
import ec.edu.ups.modelo.Diagnostico;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import java.util.List;
import javax.swing.JOptionPane;


public class ControladorDiagnostico {

    private Statement statement;
    private ResultSet r;
    private conexion conexion;
    private PreparedStatement ps;

    Diagnostico diagnostico = new Diagnostico();

    private List<Diagnostico> listaDiagnstico;

    public ControladorDiagnostico() {

        listaDiagnstico = new ArrayList<Diagnostico>();


    }
public void crear(Diagnostico diagnostico) throws SQLException {
		Connection con = null;
		String sql = "insert into diagnostico (diag_id, diag_enfermedadActual, diag_boca, diag_torax, diag_abdomen , diag_extremidades, "
                        + "diag_regionPerineal, diag_valoracionNeuronal, diag_ie10, diag_tratamiento, CITAMEDICA_cita_id, CITAMEDICA_PACIENTE_pa_cedula, HISTORIAL CLINICO_hist_id) "
				+ "   values (?,?,?,?,?,?,?,?,?,?,?,?,?);";
                
                try {
        
    

			con = ConexionBD.getConnection();
			PreparedStatement ps = con.prepareStatement(sql);

			ps.setInt(1, diagnostico.getCodigoDiagnostico());
			ps.setString(2, diagnostico.getEnfermedadActual());
			ps.setString(3, diagnostico.getBoca());
			ps.setString(4, diagnostico.getTorax());
			ps.setString(5, diagnostico.getAbdomen());
			ps.setString(6, diagnostico.getExtremidades());
                        ps.setString(7, diagnostico.getRegionPerineal());
			ps.setString(8, diagnostico.getValoracionNeurologica());
			ps.setString(9, diagnostico.getIce10());
			ps.setString(10, diagnostico.getTratamientos());
			ps.setInt(11, diagnostico.getCITAMEDICA_cita_id());
                        	ps.setString(12, diagnostico.getCITAMEDICA_PACIENTE_pa_cedula());
                        ps.setInt(13, diagnostico.getHISTORIALCLINICO_hist_id());
		

			ps.executeUpdate();
                       
               
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            ConexionBD.close(con);
        }

    }

    public int obtenerCodigo() {
        Connection con = null;
        con = ConexionBD.getConnection();
        int codigo = 0;
//        
        String sql = "SELECT count(diag_id)"
                + "	FROM diagnostico;";

        Statement sentencia;
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            rs.next();
            codigo = rs.getInt(1);
            rs.close();

        } catch (SQLException ex) {
            System.out.println("Error de SQL " + ex);
        }

        return ++codigo;
    }

    public void modificarDiagnostico(Diagnostico diagnostico) {
        String sql = "UPDATE Diagnostico set enfermedadActual=?, boca=?, torax=?, abdomen=?, extremidades=?, regionPerineal=?, valoracionNeurologica=?, ice10=?, tratamientos=?  where cedula='" + diagnostico.getCodigoDiagnostico() + "';";

        try {
            conexion = new conexion();
            ps = conexion.getConexion().prepareStatement(sql);
            ps.setString(1, diagnostico.getEnfermedadActual());
            ps.setString(2, diagnostico.getBoca());
            ps.setString(3, diagnostico.getTorax());
            ps.setString(4, diagnostico.getAbdomen());
            ps.setString(5, diagnostico.getExtremidades());
            ps.setString(6, diagnostico.getRegionPerineal());
            ps.setString(7, diagnostico.getValoracionNeurologica());
            ps.setString(8, diagnostico.getIce10());
            ps.setString(9, diagnostico.getTratamientos());

        } catch (Exception e) {
            System.out.println("error" + e.getMessage());
            JOptionPane.showMessageDialog(null, "NO EXISTE");
        } finally {
            conexion.desconectar();
        }
    }
}