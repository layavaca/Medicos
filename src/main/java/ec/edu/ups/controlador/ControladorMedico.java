package ec.edu.ups.controlador;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import ec.edu.ups.conexion.ConexionBD;
import ec.edu.ups.modelo.Medico;

public class ControladorMedico {

    ResultSet rs;

    // -------------- Para insertar CLIENTES ------------------- //
    public void insertar(Medico medico) {
        Connection con = null;
        String sql = "insert into medico (med_id, med_numeroconsultorio, med_usuario, med_password, PERSONA_per_id, med_numero ) "
                + "   values (?,?,?,?,?,?);";

        try {
            con = ConexionBD.getConnection();
            PreparedStatement ps = con.prepareStatement(sql);

            ps.setString(1, medico.getMed_id());
            ps.setInt(2, medico.getMed_numeroconsultorio());
            ps.setString(3, medico.getMed_usuario());
            ps.setString(4, medico.getMed_password());
            ps.setString(5, medico.getMed_per_cedula());
            ps.setInt(6, medico.getMed_numero());

            ps.executeUpdate();

            System.out.println(ps);
            

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            ConexionBD.close(con);
        }

    }

    // Metodo Select y listar
    public List<Medico> listar() {

        List<Medico> medico = new ArrayList<Medico>();

        String sql = "SELECT med_id, med_numeroconsultorio, med_usuario, med_password, PERSONA_per_id" + " FROM medico";

        Connection con = null;
        try {
            con = ConexionBD.getConnection();// devuelve la conexion y se
            // conecta
            PreparedStatement ps = con.prepareStatement(sql);// prepara la
            // consulta
            ResultSet rs = ps.executeQuery();// un resultset es cada fila del
            // sql
            while (rs.next())// recorre cada una de las filas
            {

                Medico m = new Medico();
                m.setMed_id(rs.getString("med_id"));
                m.setMed_numeroconsultorio(rs.getInt("med_numeroconsultorio"));
                m.setMed_usuario(rs.getString("med_usuario").trim());
                m.setMed_password(rs.getString("med_password").trim());
                m.setMed_per_cedula(rs.getString("PERSONA_per_id"));

                medico.add(m);// agrega la lista

            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            ConexionBD.close(con);
        }
        return medico;
    }

    // Metodo Buscar
    public Medico BuscarMedico(String id) {
        String sql = "SELECT med_id, med_numeroconsultorio, med_usuario, med_password, PERSONA_per_cedula" + " FROM medico where med_id=" + id;
        Medico m = new Medico();

        Connection con = null;
        try {
            con = ConexionBD.getConnection();
            PreparedStatement ps = con.prepareStatement(sql);
            // resultset es todas las filas de la tabla
            ResultSet rs = ps.executeQuery();
            // el bucle para que recorrra todas las filas- hasta terminar todas
            // las filas
            while (rs.next()) {
                // devulve el nombre de la fila correspondiente

                if (rs.getString("med_id").trim().equals(id)) {

                    m.setMed_numeroconsultorio(rs.getInt("med_numeroconsultorio".trim()));
                    m.setMed_usuario(rs.getString("med_usuario".trim()));
                    m.setMed_password(rs.getString("med_password".trim()));
                    m.setMed_per_cedula(rs.getString("PERSONA_per_cedula".trim()));

                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            ConexionBD.close(con);
        }
        return m;
    }

    // Metodo Actualizar
    public boolean actualizar(Medico medico) {
        boolean b = false;
        Connection con = null;
        try {

            String sql = "UPDATE medico SET med_id ='med_id'," + " med_numeroconsultorio =' med_numeroconsultorio', med_usuario ='med_usuario',"
                    + " med_password =' med_password'," + " PERSONA_per_id ='PERSONA_per_id',"
                    + "WHERE med_id = 'med_id';";

            con = ConexionBD.getConnection();
            Statement ps = con.createStatement();
            ps.executeUpdate(sql);
            b = true;

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            ConexionBD.close(con);
        }
        return b;
    }

    public List<Medico> listarBuscando(String descripcion) {

        List<Medico> persona = new ArrayList<Medico>();

        String sql = "SELECT * FROM medico where PERSONA_per_id LIKE '" + descripcion + "%';";

        try {
            ConexionBD c = new ConexionBD();
            Connection con = c.getConnection();
            con = c.getConnection();
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet resultSet = ps.executeQuery();

            while (resultSet.next())// recorre cada una de las filas
            {

                Medico m = new Medico();
                m.setMed_id(resultSet.getString("med_id"));
                m.setMed_numeroconsultorio(resultSet.getInt("med_numeroconsultorio"));
                m.setMed_usuario(resultSet.getString("med_usuario").trim());
                m.setMed_password(resultSet.getString("med_password").trim());
                m.setMed_per_cedula(resultSet.getString("PERSONA_per_id"));

                persona.add(m);// agrega la lista

            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {

        }

        return persona;
    }

}
