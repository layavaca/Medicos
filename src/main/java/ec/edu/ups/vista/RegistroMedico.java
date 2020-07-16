package ec.edu.ups.vista;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import ec.edu.ups.controlador.ControladorMedico;
import ec.edu.ups.controlador.PersonaBD;
import ec.edu.ups.modelo.Medico;
import ec.edu.ups.modelo.Persona;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;

public class RegistroMedico extends JFrame {

    private JPanel contentPane;
    public JTextField textIdMedico;
    public JTextField textConsultorio;
    public JTextField textUsuario;
    public JTextField textCedula;
    private JPasswordField passwordField;

    /**
     * Launch the application.
     */
    /**
     * Create the frame.
     */
    public RegistroMedico() {
        setTitle("Registro de Medicos");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 785, 508);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JLabel lblIdDelMedico = new JLabel("Id del Medico:");
        lblIdDelMedico.setBounds(44, 72, 93, 16);
        contentPane.add(lblIdDelMedico);

        JLabel lblNewLabel = new JLabel("Numero Consultorio:");
        lblNewLabel.setBounds(44, 130, 129, 25);
        contentPane.add(lblNewLabel);

        JLabel lblUsuario = new JLabel("Usuario:");
        lblUsuario.setBounds(44, 198, 79, 16);
        contentPane.add(lblUsuario);

        JLabel lblContrasea = new JLabel("Contrase\u00F1a:");
        lblContrasea.setBounds(44, 266, 93, 16);
        contentPane.add(lblContrasea);

        JLabel lblCedulaMedico = new JLabel("Cedula Medico:");
        lblCedulaMedico.setBounds(44, 333, 115, 16);
        contentPane.add(lblCedulaMedico);

        textIdMedico = new JTextField();
        textIdMedico.setBounds(227, 69, 116, 22);
        contentPane.add(textIdMedico);
        textIdMedico.setColumns(10);

        textConsultorio = new JTextField();
        textConsultorio.setBounds(227, 131, 116, 22);
        contentPane.add(textConsultorio);
        textConsultorio.setColumns(10);

        textUsuario = new JTextField();
        textUsuario.setBounds(227, 195, 116, 22);
        contentPane.add(textUsuario);
        textUsuario.setColumns(10);

        textCedula = new JTextField();
        textCedula.setBounds(227, 330, 116, 22);
        contentPane.add(textCedula);
        textCedula.setColumns(10);

        JButton btnRegistrar = new JButton("Registrar");
        btnRegistrar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {

                guardarC();
                Settear();

            }
        });
        btnRegistrar.setBounds(543, 95, 97, 25);
        contentPane.add(btnRegistrar);

        passwordField = new JPasswordField();
        passwordField.setBounds(227, 263, 116, 22);
        contentPane.add(passwordField);
    }

    //Metodo guardar
    public void guardarC() {

        Medico m = new Medico();
        ControladorMedico mBD = new ControladorMedico();

        m.setMed_id(textIdMedico.getText());
        m.setMed_numeroconsultorio(Integer.parseInt(textConsultorio.getText()));
        m.setMed_usuario(textUsuario.getText());
        m.setMed_password(passwordField.getText());
        m.setMed_per_cedula(textCedula.getText());
        m.setMed_numero(1);

        mBD.insertar(m);
        ;

    }

    public void Settear() {

        textCedula.setText("");
        textConsultorio.setText("");
        textIdMedico.setText("");
        passwordField.setText("");
        textUsuario.setText("");

    }
}
