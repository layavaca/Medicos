package ec.edu.ups.vista;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import ec.edu.ups.controlador.PersonaBD;
import ec.edu.ups.modelo.Persona;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class RegistroPersona extends JFrame {
    PersonaBD p = new PersonaBD();

	public JPanel contentPane;
	public JTextField textId;
	public JTextField textCedula;
	public JTextField textNombre;
	public JTextField textApellido;
	public JTextField textTelefono;
	public JTextField textDireccion;
	public JTextField textEmail;
	public JTextField textFechaNacimiento;
	public JButton btnRegistrar;
	
	public Date date;


	/**
	 * Create the frame.
	 */
	public RegistroPersona() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 775, 579);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblId = new JLabel("Id: ");
		lblId.setBounds(56, 66, 57, 27);
		contentPane.add(lblId);
		
		JLabel lblCedula = new JLabel("Cedula:");
		lblCedula.setBounds(56, 119, 56, 16);
		contentPane.add(lblCedula);
		
		JLabel lblNombres = new JLabel("Nombres:");
		lblNombres.setBounds(57, 180, 56, 16);
		contentPane.add(lblNombres);
		
		JLabel lblApellidos = new JLabel("Apellidos:");
		lblApellidos.setBounds(56, 242, 56, 16);
		contentPane.add(lblApellidos);
		
		JLabel lblTelefono = new JLabel("Telefono:");
		lblTelefono.setBounds(56, 302, 56, 16);
		contentPane.add(lblTelefono);
		
		JLabel lblDireccion = new JLabel("Direccion:");
		lblDireccion.setBounds(57, 366, 77, 16);
		contentPane.add(lblDireccion);
		
		JLabel lblEmail = new JLabel("Email:");
		lblEmail.setBounds(56, 423, 56, 16);
		contentPane.add(lblEmail);
		
		JLabel lblFechaNacimiento = new JLabel("Fecha nacimiento:");
		lblFechaNacimiento.setBounds(56, 476, 117, 16);
		contentPane.add(lblFechaNacimiento);
		
		textId = new JTextField();
		textId.setBounds(197, 68, 116, 22);
		contentPane.add(textId);
		textId.setColumns(10);
              textId.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
  
        textId.setText(String.valueOf(p.obtenerCodigo()));
      }
    });
		
		textCedula = new JTextField();
		textCedula.addKeyListener(new KeyAdapter() {
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
				
			}
		);
		textCedula.setBounds(197, 116, 116, 22);
		contentPane.add(textCedula);
		textCedula.setColumns(10);
		
		textNombre = new JTextField();
		textNombre.setBounds(197, 177, 116, 22);
		contentPane.add(textNombre);
		textNombre.setColumns(10);
		
		textApellido = new JTextField();
		textApellido.setBounds(197, 239, 116, 22);
		contentPane.add(textApellido);
		textApellido.setColumns(10);
		
		textTelefono = new JTextField();
		textTelefono.setBounds(197, 299, 116, 22);
		contentPane.add(textTelefono);
		textTelefono.setColumns(10);
		
		textDireccion = new JTextField();
		textDireccion.setBounds(197, 363, 116, 22);
		contentPane.add(textDireccion);
		textDireccion.setColumns(10);
		
		textEmail = new JTextField();
		textEmail.setBounds(197, 420, 116, 22);
		contentPane.add(textEmail);
		textEmail.setColumns(10);
		
		textFechaNacimiento = new JTextField();
		textFechaNacimiento.setBounds(197, 473, 116, 22);
		contentPane.add(textFechaNacimiento);
		textFechaNacimiento.setColumns(10);
		
		btnRegistrar = new JButton("Registrar");
		btnRegistrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				guardarC();
				Settear();
				
			}
		});
		btnRegistrar.setBounds(535, 102, 97, 25);
		contentPane.add(btnRegistrar);
	}
	
	
	
	
	
	
	 //Metodo guardar
	public void guardarC() {

		Persona p = new Persona();
		PersonaBD pBD = new PersonaBD();

	
		
		java.util.Date fecha1 = new java.util.Date(textFechaNacimiento.getText());
        java.sql.Date sqlDate = new java.sql.Date(fecha1.getTime());
	
		
	
		
		p.setId(Integer.parseInt(textId.getText()));
		p.setCedula(textCedula.getText());
		p.setNombres(textNombre.getText());
		p.setApellidos(textApellido.getText());
		p.setTelefono(textTelefono.getText());
		p.setDireccion(textDireccion.getText());
		p.setEmail(textEmail.getText());
		p.setFecha_nacimiento(sqlDate);
		
		
	
		pBD.insertar(p);
		;

	}


public void Settear(){
	textId.setText("");
	textCedula.setText("");
	textNombre.setText("");
	textApellido.setText("");
	textEmail.setText("");
	textDireccion.setText("");
	textTelefono.setText("");
	textFechaNacimiento.setText("");
	
	
}
	
	
	
	
	
	
	
private static final int NUM_PROVINCIAS=24;
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
//                System.out.println("valida");
            } else if (cedula.length() <= 9) {
                isValid = false;
                

//                System.out.println("invalida");
            }

        }
    }
    System.out.println("Cedula: " + isValid);
    return isValid;
}



	
	
	
	
	
	
}
