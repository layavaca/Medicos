package ec.edu.ups.controlador;

import java.sql.Connection;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import ec.edu.ups.conexion.ConexionBD;
import ec.edu.ups.modelo.Persona;

public class PersonaBD {

	ResultSet rs;

	// -------------- Para insertar CLIENTES ------------------- //
	public void insertar(Persona persona) {
		Connection con = null;
		String sql = "insert into persona (per_id, per_cedula, per_nombres, per_apellidos, per_telefono, per_direccion ,per_email, per_fecha_nacimiento ) "
				+ "   values (?,?,?,?,?,?,?,?);";

		try {
			con = ConexionBD.getConnection();
			PreparedStatement ps = con.prepareStatement(sql);

			ps.setInt(1, persona.getId());
			ps.setString(2, persona.getCedula());
			ps.setString(3, persona.getNombres());
			ps.setString(4, persona.getApellidos());
			ps.setString(5, persona.getTelefono());
			ps.setString(6, persona.getDireccion());
			ps.setString(7, persona.getEmail());
			ps.setDate(8, persona.getFecha_nacimiento());
			

			ps.executeUpdate();

			System.out.println(ps);
			{

			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			ConexionBD.close(con);
		}

	}

	// Metodo Select y listar

	public List<Persona> listar() {

		List<Persona> persona = new ArrayList<Persona>();

		String sql = "SELECT per_id, per_cedula, per_nombres, per_apellidos, per_telefono, per_direccion , per_email, per_fecha_nacimiento" + " FROM persona";

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

				Persona p = new Persona() ;
				p.setId(rs.getInt("per_id"));
				p.setCedula(rs.getString("per_cedula"));
				p.setNombres(rs.getString("per_nombres").trim());
				p.setApellidos(rs.getString("per_apellidos").trim());
				p.setTelefono(rs.getString("per_telefono").trim());
				p.setDireccion(rs.getString("per_direccion").trim());
				p.setEmail(rs.getString("per_email").trim());
				p.setFecha_nacimiento(rs.getDate("per_fecha_nacimiento"));
				
				
				
			

				persona.add(p);// agrega la lista

			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			ConexionBD.close(con);
		}
		return persona;
	}

        
        
        
        
        
        
        public int obtenerCodigo() {
    	Connection con = null;
    	con = ConexionBD.getConnection();
        int codigo = 0;
//        
        String sql = "SELECT count(per_id)"
                + "	FROM persona;";
       
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


        
        
        
        
        
        
	// Metodo Buscar

	public Persona BuscarPersona(String cedula) {
		String sql = "SELECT per_id, per_cedula, per_nombres, per_apellidos, per_telefono,  per_direccion, per_email, per_fecha_nacimiento" + " FROM persona";
		Persona p = new Persona();

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

				if (rs.getString("per_id").trim().equals(cedula)) {

					p.setCedula(rs.getString("per_cedula".trim()));
					p.setNombres(rs.getString("per_nombres".trim()));
					p.setApellidos(rs.getString("per_apellidos".trim()));
					p.setTelefono(rs.getString("per_telefono".trim()));
					p.setDireccion(rs.getString("per_direccion".trim()));
					p.setEmail(rs.getString("per_email".trim()));
					p.setFecha_nacimiento(rs.getDate("per_fecha_nacimiento".trim()));
					
					
					

				}
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			ConexionBD.close(con);
		}
		return p;
	}

	// Metodo Actualizar

		public boolean actualizar(Persona persona) {
			boolean b = false;
			Connection con = null;
			try {

				String sql = "UPDATE persona SET per_cedula ='per_cedula'," + " per_nombres =' per_nombres', per_apellidos ='per_apellidos',"
						+ " per_telefono =' per_telefono'," + " per_direccion ='per_direccion',"
						+ " per_email =' per_email', per_fecha_nacimiento ='per_fecha_nacimiento'," +

						"WHERE per_cedula = 'per_cedula';";

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
		
		
		
		
		
		
		

		
		  public List<Persona> listarBuscando(String descripcion) {

		        List<Persona> persona = new ArrayList<Persona>();

		        String sql = "SELECT * FROM persona where per_cedula LIKE '" + descripcion + "%';";

		        try {
		            ConexionBD c = new ConexionBD();
		            Connection con = c.getConnection();
		            con = c.getConnection();
		            PreparedStatement ps = con.prepareStatement(sql);
		            ResultSet resultSet = ps.executeQuery();

		            while (resultSet.next())// recorre cada una de las filas
		            {

		                Persona p = new Persona();
		                p.setId(resultSet.getInt("per_id"));
		                p.setCedula(resultSet.getString("per_cedula").trim());
		                p.setNombres(resultSet.getString("per_nombres").trim());
		                p.setApellidos(resultSet.getString("per_apellidos").trim());
		                p.setTelefono(resultSet.getString("per_telefono").trim());
		                p.setDireccion(resultSet.getString("per_direccion").trim());
		                p.setEmail(resultSet.getString("per_email"));
		                p.setFecha_nacimiento(resultSet.getDate("per_fecha_nacimiento"));

		                persona.add(p);// agrega la lista

		            }

		        } catch (Exception e) {
		            e.printStackTrace();
		        } finally {

		        }

		        return persona;
		    }
		


}
