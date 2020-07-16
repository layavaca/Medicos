package ec.edu.ups.vista;

import java.awt.EventQueue;


import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import ec.edu.ups.conexion.ConexionBD;

import ec.edu.ups.modelo.Medico;
import ec.edu.ups.modelo.Persona;
import ec.edu.ups.controlador.ControladorMedico;
import ec.edu.ups.controlador.PersonaBD;

import java.awt.Color;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

/**
 * Conexion a la base de datos
 * 
 *
 * @author Geovanny Duchitanga
 *
 */


public class ListadoPersonas extends JInternalFrame {
	private JTextField textId;
	private JTextField textNombres;
	private JTextField textApellidos;
	private JTextField textCedula;
	private JTable table;
	private JTextField textTelefono;
	private JLabel lblErrorCedula;

	Connection connection = null;
	private JTextField textB;
	
	/**
	 * Launch the application.
	 */
	

	/**
	 * Create the frame.
	 */
	public ListadoPersonas() {
		getContentPane().setBackground(Color.WHITE);
		setTitle("Administrar Datos de Clientes");
		setIconifiable(true);
		setMaximizable(true);
		setClosable(true);
		setBounds(10, 10, 1286, 849);
		getContentPane().setLayout(null);
		
		JLabel lblDatosDeClientes = new JLabel("Datos de Personas");
		lblDatosDeClientes.setFont(new Font("Tahoma", Font.ITALIC, 18));
		lblDatosDeClientes.setBounds(407, 24, 202, 31);
		getContentPane().add(lblDatosDeClientes);
		
		JLabel lblCedula = new JLabel("Direccion:");
		lblCedula.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblCedula.setBounds(12, 393, 82, 31);
		getContentPane().add(lblCedula);
		
		JLabel lblNombres = new JLabel("Nombres:");
		lblNombres.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNombres.setBounds(12, 170, 98, 31);
		getContentPane().add(lblNombres);
		
		JLabel lblApellidos = new JLabel("Apellidos:");
		lblApellidos.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblApellidos.setBounds(28, 241, 82, 31);
		getContentPane().add(lblApellidos);
		
		JLabel lblDireccion = new JLabel("Cedula:");
		lblDireccion.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblDireccion.setBounds(12, 115, 82, 31);
		getContentPane().add(lblDireccion);
		
		textId = new JTextField();
		textId.setBounds(113, 70, 241, 20);
		getContentPane().add(textId);
		textId.setColumns(10);
		
		textNombres = new JTextField();
		textNombres.setColumns(10);
		textNombres.setBounds(113, 175, 241, 20);
		getContentPane().add(textNombres);
		
		textApellidos = new JTextField();
		textApellidos.setColumns(10);
		textApellidos.setBounds(97, 245, 241, 20);
		getContentPane().add(textApellidos);
		
		textCedula = new JTextField();
		
		textCedula.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent evt) {
				
				
					
					
					char car = evt.getKeyChar();
					if (!Character.isDigit(car)  ) {
						evt.consume();
						 lblErrorCedula.setText("Escribe solo numeros");
			} else {
				lblErrorCedula.setText("");  
			}
					
					
				
				
				
			}
			@Override
			public void keyPressed(KeyEvent evt) {
				
		        if ((evt.getKeyCode() == KeyEvent.VK_ENTER)) {
		            
		            if(validacionCedula(textCedula.getText())==true){
		                 JOptionPane.showMessageDialog(null, "Cedula Correcta");
		            }else{
		                JOptionPane.showMessageDialog(null, "Cedula Incorrecta");
		            }
		            
		        }

				
			}
		});
		textCedula.setColumns(10);
		textCedula.setBounds(106, 120, 241, 20);
		getContentPane().add(textCedula);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(376, 122, 882, 586);
		getContentPane().add(scrollPane);
		
		table = new JTable();
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent evt) {
				
				
				if (evt.getClickCount() == 1 ){
						
					textId.setText(table.getValueAt(table.getSelectedRow(), 0).toString());	
					textCedula.setText(table.getValueAt(table.getSelectedRow(), 1).toString());
					textNombres.setText(table.getValueAt(table.getSelectedRow(), 2).toString());
					textApellidos.setText(table.getValueAt(table.getSelectedRow(), 3).toString());
					textTelefono.setText(table.getValueAt(table.getSelectedRow(), 4).toString());
					textDireccion.setText(table.getValueAt(table.getSelectedRow(), 5).toString());
					textEmail.setText(table.getValueAt(table.getSelectedRow(), 6).toString());
					textFecha.setText(table.getValueAt(table.getSelectedRow(), 7).toString());
					
				}
				
				
			}
		});
		
		
		
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null, null, null, null, null},
			},
			new String[] {
				"Id", "Cedula", "Nombres", "Apellidos", "Telefono", "Direccion", "Email", "Fecha Nacimiento"
			}
		));
		scrollPane.setViewportView(table);
		
		JButton btnBuscar = new JButton("Cargar");
		btnBuscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				
				
				
			}
		});
		btnBuscar.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnBuscar.setIcon(new ImageIcon("Imageneg\\Cargar.png"));
		btnBuscar.setBounds(362, 721, 111, 37);
		getContentPane().add(btnBuscar);
		
		JButton btnActualizar = new JButton("Actualizar");
		btnActualizar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			
			
				Persona m = new Persona();

				actualizar(m);
				JOptionPane.showMessageDialog(null, "Datos del cliente actualizados con exito");
			
			Settear();
			
			}
		});
		btnActualizar.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnActualizar.setIcon(new ImageIcon("Imagenes\\Update.png"));
		btnActualizar.setBounds(485, 721, 119, 37);
		getContentPane().add(btnActualizar);
		
		JButton btnEliminar = new JButton("Imagenes\\Eliminar");
		btnEliminar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Persona cl = new Persona();
				borrar(cl);
				JOptionPane.showMessageDialog(null, "Se ha eliminado los datos del cliente!");
				Settear();
				
				
			}
		});
		btnEliminar.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnEliminar.setIcon(new ImageIcon("Delete.png"));
		btnEliminar.setBounds(614, 721, 118, 37);
		getContentPane().add(btnEliminar);
		
		JButton btnListar = new JButton("Listar");
		btnListar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				
				PersonaBD pBD = new PersonaBD();
				pBD.listar();
				tabla();
				Settear();
				
				
				
			}
		});
		btnListar.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnListar.setIcon(new ImageIcon("Iamgenes\\Check.png"));
		btnListar.setBounds(742, 721, 117, 37);
		getContentPane().add(btnListar);
		
		JLabel lblEmail = new JLabel("Telefono:");
		lblEmail.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblEmail.setBounds(12, 318, 82, 31);
		getContentPane().add(lblEmail);
		
		textTelefono = new JTextField();
		textTelefono.setColumns(10);
		textTelefono.setBounds(97, 323, 241, 20);
		getContentPane().add(textTelefono);
		
		 lblErrorCedula = new JLabel("");
		lblErrorCedula.setBounds(106, 141, 241, 16);
		lblErrorCedula.setForeground(Color.red);
		getContentPane().add(lblErrorCedula);
		
		textB = new JTextField();
		textB.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				listaBuscada();
			}
			
			public void keyReleased(KeyEvent e) {
				listaBuscada();
			}
			
			public void keyTyped(KeyEvent e) {
				listaBuscada();
			}
		});
		textB.setBounds(1010, 84, 222, 22);
		getContentPane().add(textB);
		textB.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Búsqueda por cedula:");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel.setBounds(1010, 61, 222, 16);
		getContentPane().add(lblNewLabel);
		
		JLabel lblId = new JLabel("Id:");
		lblId.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblId.setBounds(12, 72, 56, 16);
		getContentPane().add(lblId);
		
		textDireccion = new JTextField();
		textDireccion.setBounds(123, 397, 231, 22);
		getContentPane().add(textDireccion);
		textDireccion.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Email:");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_1.setBounds(12, 463, 56, 16);
		getContentPane().add(lblNewLabel_1);
		
		JLabel lblFechaNacimiento = new JLabel("Fecha Nacimiento: ");
		lblFechaNacimiento.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblFechaNacimiento.setBounds(12, 520, 122, 16);
		getContentPane().add(lblFechaNacimiento);
		
		textEmail = new JTextField();
		textEmail.setBounds(104, 460, 234, 22);
		getContentPane().add(textEmail);
		textEmail.setColumns(10);
		
		textFecha = new JTextField();
		textFecha.setBounds(146, 517, 116, 22);
		getContentPane().add(textFecha);
		textFecha.setColumns(10);

	}
	
	
	
	
	
	
	
	
	
	
	
	 //Metodo guardar
		public void guardarC() {

			Medico m = new Medico();
			ControladorMedico mBD = new ControladorMedico();

		

			m.setMed_id(textId.getText());
			m.setMed_numeroconsultorio(Integer.parseInt(textNombres.getText()));
			m.setMed_usuario(textApellidos.getText());
			m.setMed_password(textTelefono.getText());
			m.setMed_per_cedula(textCedula.getText());
			
			mBD.insertar(m);
			;

		}

	
	public void Settear(){
		textId.setText("");
		textNombres.setText("");
		textApellidos.setText("");
		textTelefono.setText("");
		textCedula.setText("");
		textDireccion.setText("");
		textEmail.setText("");
		textFecha.setText("");
		
		
		
	}
	
	
	
	
	
	
	
	public void listar() {
		try {
			String sql = "SELECT per_id, per_cedula, per_nombres, per_apellidos, per_telefono, per_direccion, per_email, per_fecha_nacimiento"
					+ " FROM persona;";
			PreparedStatement ps = connection.prepareStatement(sql);
			// resultset es todas las filas de la tabla
			ResultSet rs = ps.executeQuery();
			// table.setModel(resultSetToTableModel(rs));

			// textarea.add( p);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void tabla() {

		DefaultTableModel tabla = (DefaultTableModel) table.getModel();
		Object[] persona = new Object[8];

		// metodo para limpiar la tabla
		// devuelve la cantidad de filas que hay en la tabla
		int filas = tabla.getRowCount();
		for (int i = filas - 1; i >= 0; i--) {
			tabla.removeRow(i);
		}
		PersonaBD mBD = new PersonaBD();
		for (Persona m : mBD.listar()) {

			persona[0] = m.getId();
			persona[1] = m.getCedula();
			persona[2] = m.getNombres();
			persona[3] = m.getApellidos();
			persona[4] = m.getTelefono();
			persona[5] = m.getDireccion();
			persona[6] = m.getEmail();
			persona[7] = m.getFecha_nacimiento();
			
			
			

			System.out.println(persona);

			// agregamos la fila a la lista
			tabla.addRow(persona);
		}

		table.setModel(tabla);

	}
	
	
	
	public boolean actualizar(Persona persona) {
		boolean b = false;
		Connection con = null;
		try {
			
			String sql = "UPDATE persona SET per_id = '" + textId.getText() + "'," 
					  + " per_cedula = '" + textCedula.getText() + "',"
			        + " per_nombres = '" + textNombres.getText() + "',"
			        		 + " per_apellidos = '" + textApellidos.getText() + "',"
						        + " per_telefono = '" + textTelefono.getText() + "',"
						        		 + " per_direccion = '" + textDireccion.getText() + "',"
									        + " per_email = '" + textEmail.getText() + "',"
					+ "per_fecha_nacimiento= '" + textFecha.getText() + "'"
				
					
					+ "WHERE per_cedula = '"+ textCedula.getText() + "';";

			con = ConexionBD.getConnection();
			Statement ps = con.createStatement();
			ps.executeUpdate(sql);
			b = true;

		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "El registro no se ha actualizado");
		} finally {
			ConexionBD.close(con);
		}
		return b;
	}
	
	
	
	
	
	
	
	
	
	//Metodo borrar
		public void borrar(Persona persona) {
			Connection con = null;
			try {

				String sql = "delete from persona where per_cedula = '" + textCedula.getText() + "';";

				con = ConexionBD.getConnection();
				Statement ps = con.createStatement();
				ps.executeUpdate(sql);
			} catch (Exception e) {
				JOptionPane.showMessageDialog(null, "Los datos no han podido ser eliminados");
			} finally {
				ConexionBD.close(con);
			}

		}
	
	
		
		//Metodo para validar cedula
		
		
		public void ValidarCedula() {
	        
		        String cedula=textId.getText();
		        
		        if (cedula.length() < 10) {
		        	JOptionPane.showMessageDialog(null, "Datos del cliente no han sido guardados, verifique cedula");
		        } else {
		            if (cedula.length() > 10) {
		            	JOptionPane.showMessageDialog(null, "Demasiados digites en el campo cedula");
		            } else {
		                int c, suma = 0, acum, resta = 0;
		                for (int i = 0; i < cedula.length() - 1; i++) {

		                    c = Integer.parseInt(cedula.charAt(i) + "");
		                    if (i % 2 == 0) {
		                        c = c * 2;
		                        if (c > 9) {
		                            c = c - 9;
		                        }
		                    }
		                    suma = suma + c;
		                }

		                if (suma % 10 != 0) {
		                    acum = ((suma / 10) + 1) * 10;
		                    resta = acum - suma;
		                }

		                int ultimo = Integer.parseInt(cedula.charAt(9) + "");

		                if (ultimo == resta) {
		                	guardarC();
		                	JOptionPane.showMessageDialog(null, "Datos del cliente guardados con exito");
		                } else {
		                	JOptionPane.showMessageDialog(null, "Datos del cliente no han sido guardados, verifique cedula");
		                }
		            }
		        }
		    }
		        	
		
		
		
		
		
		
		
		
		public void listaBuscada() {

	        DefaultTableModel tabla = (DefaultTableModel) table.getModel();
	        Object[] persona = new Object[8];

	        // metodo para limpiar la tabla
	        // devuelve la cantidad de filas que hay en la tabla
	        int filas = tabla.getRowCount();
	        for (int i = filas - 1; i >= 0; i--) {
	            tabla.removeRow(i);
	        }
	        PersonaBD cP = new PersonaBD();
	        for (Persona pL : cP.listarBuscando(textB.getText().toUpperCase())) {

	        	 persona[0] = pL.getId();
	        	 persona[1] = pL.getCedula();
	        	 persona[2] = pL.getNombres();
	        	 persona[3] = pL.getApellidos();
	        	 persona[4] = pL.getTelefono();
	        	 persona[5] = pL.getDireccion();
	        	 persona[6] = pL.getEmail();
	        	 persona[7] = pL.getFecha_nacimiento();
	        	

	            System.out.println(persona);

	            // agregamos la fila a la lista
	            tabla.addRow(persona);
	        }

	        table.setModel(tabla);
	    }
		
		
		
		
		
		
		
		private static final int NUM_PROVINCIAS=24;
		private JTextField textDireccion;
		private JTextField textEmail;
		private JTextField textFecha;
		public Boolean validacionCedula(String cedula) {
	        boolean isValid = false;
	        System.out.println(cedula.length());
	        if (cedula == null || cedula.length() != 10) {
	            isValid = false;

	        } else {
	            if (cedula.length() == 10) {
	                final int prov = Integer.parseInt(cedula.substring(0, 2));

	                if (!((prov > 0) && (prov <= NUM_PROVINCIAS))) {
	                    isValid = false;
	                }

	                int[] d = new int[10];
	                for (int i = 0; i < d.length; i++) {
	                    d[i] = Integer.parseInt(cedula.charAt(i) + "");
	                }

	                int imp = 0;
	                int par = 0;

	                for (int i = 0; i < d.length; i += 2) {
	                    d[i] = ((d[i] * 2) > 9) ? ((d[i] * 2) - 9) : (d[i] * 2);
	                    imp += d[i];
	                }

	                for (int i = 1; i < (d.length - 1); i += 2) {
	                    par += d[i];
	                }

	                final int suma = imp + par;

	                int d10 = Integer.parseInt(String.valueOf(suma + 10).substring(0, 1)
	                        + "0")
	                        - suma;

	                d10 = (d10 == 10) ? 0 : d10;

	                if (d10 == d[9]) {
	                    isValid = true;
//	                    System.out.println("valida");
	                } else if (cedula.length() <= 9) {
	                    isValid = false;
	                    

//	                    System.out.println("invalida");
	                }

	            }
	        }
	        System.out.println("Cedula: " + isValid);
	        return isValid;
	    }

		
		
		
		
		
		//metodo para validar correo electronio
				public boolean isEmail(String correo) {
				Pattern pat = null;
				Matcher mat = null; 
				pat = Pattern.compile("^([0-9a-zA-Z]([_.w]*[0-9a-zA-Z])*@([0-9a-zA-Z][-w]*[0-9a-zA-Z].)+([a-zA-Z]{2,9}.)+[a-zA-Z]{2,3})$");
				mat = pat.matcher(correo);
				if (mat.find()) {
				System.out.println("[" + mat.group() + "]");
				
				//lblErrorMail.setText("Email correcto");
				//lblErrorMail.setForeground(Color.blue);
				return true;
				
				}else{
					//lblErrorMail.setText("Email incorrecto");
					//lblErrorMail.setForeground(Color.RED);
				return false;
				} 
				}
}

	
	
	
	

