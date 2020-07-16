/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
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
import ec.edu.ups.controlador.ControladorMedico;

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


public class ListadoMedicos extends javax.swing.JInternalFrame {

    private JTextField textId;
    private JTextField textConsultorio;
    private JTextField textUsuario;
    private JTextField textCedula;
    private JTable table;
    private JTextField textPassword;
    private JLabel lblErrorNombre;
    private JLabel lblErrorApellido;
    private JLabel lblErrorCedula;
    private JLabel lblErrorTelefono;
    private JLabel labelc;
    private JLabel lblErrorMail;
    Connection connection = null;
    private JTextField textB;

    /**
     * Creates new form ListadoMedicos
     */
    public ListadoMedicos() {
        initComponents();
        getContentPane().setBackground(Color.WHITE);
        setTitle("Administrar Datos de Clientes");
        setIconifiable(true);
        setMaximizable(true);
        setClosable(true);
        setBounds(10, 10, 1286, 849);
        getContentPane().setLayout(null);

        JLabel lblDatosDeClientes = new JLabel("Datos de Clientes");
        lblDatosDeClientes.setFont(new Font("Tahoma", Font.ITALIC, 18));
        lblDatosDeClientes.setBounds(407, 24, 202, 31);
        getContentPane().add(lblDatosDeClientes);

        JLabel lblCedula = new JLabel("Id:");
        lblCedula.setFont(new Font("Tahoma", Font.BOLD, 12));
        lblCedula.setBounds(12, 393, 82, 31);
        getContentPane().add(lblCedula);

        JLabel lblNombres = new JLabel("N\u00B0 Consultorio:");
        lblNombres.setFont(new Font("Tahoma", Font.BOLD, 12));
        lblNombres.setBounds(12, 170, 98, 31);
        getContentPane().add(lblNombres);

        JLabel lblApellidos = new JLabel("Usuario:");
        lblApellidos.setFont(new Font("Tahoma", Font.BOLD, 12));
        lblApellidos.setBounds(28, 241, 82, 31);
        getContentPane().add(lblApellidos);

        JLabel lblDireccion = new JLabel("Cedula:");
        lblDireccion.setFont(new Font("Tahoma", Font.BOLD, 12));
        lblDireccion.setBounds(12, 115, 82, 31);
        getContentPane().add(lblDireccion);

        textId = new JTextField();
        textId.setBounds(97, 398, 241, 20);
        getContentPane().add(textId);
        textId.setColumns(10);

        textConsultorio = new JTextField();
        textConsultorio.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent evt) {

                char car = evt.getKeyChar();
                if (!Character.isDigit(car)) {
                    evt.consume();
                    lblErrorNombre.setText("Escribe solo numeros");
                } else {
                    lblErrorNombre.setText("");
                }

            }
        });
        textConsultorio.setColumns(10);
        textConsultorio.setBounds(113, 175, 241, 20);
        getContentPane().add(textConsultorio);

        textUsuario = new JTextField();
        textUsuario.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent evt) {

                char car = evt.getKeyChar();
                if (!Character.isLetter(car) && car != KeyEvent.VK_SPACE) {
                    evt.consume();
                    lblErrorApellido.setText("Escribe solo letras");
                } else {
                    lblErrorApellido.setText("");
                }

            }
        });
        textUsuario.setColumns(10);
        textUsuario.setBounds(97, 245, 241, 20);
        getContentPane().add(textUsuario);

        textCedula = new JTextField();

        textCedula.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent evt) {

                char car = evt.getKeyChar();
                if (!Character.isDigit(car)) {
                    evt.consume();
                    lblErrorCedula.setText("Escribe solo numeros");
                } else {
                    lblErrorCedula.setText("");
                }

            }

            @Override
            public void keyPressed(KeyEvent evt) {

                if ((evt.getKeyCode() == KeyEvent.VK_ENTER)) {

                    if (validacionCedula(textCedula.getText()) == true) {
                        JOptionPane.showMessageDialog(null, "Cedula Correcta");
                    } else {
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

                if (evt.getClickCount() == 1) {

                    textId.setText(table.getValueAt(table.getSelectedRow(), 0).toString());
                    textConsultorio.setText(table.getValueAt(table.getSelectedRow(), 1).toString());
                    textUsuario.setText(table.getValueAt(table.getSelectedRow(), 2).toString());
                    textPassword.setText(table.getValueAt(table.getSelectedRow(), 3).toString());
                    textCedula.setText(table.getValueAt(table.getSelectedRow(), 4).toString());
                }

            }
        });

        table.setModel(new DefaultTableModel(
                new Object[][]{
                    {null, null, null, null, null},},
                new String[]{
                    "Id", "Numero Consultorio", "Usuario", "Contrase\u00F1a", "Cedula"
                }
        ));
        scrollPane.setViewportView(table);

        JButton btnBuscar = new JButton("Cargar");
        btnBuscar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

            }
        });
        btnBuscar.setFont(new Font("Tahoma", Font.BOLD, 11));
        btnBuscar.setIcon(new ImageIcon("C:\\Users\\GeovannyAbad\\eclipse-workspace\\CitasMedicasIngenieria\\img\\Cargar.png"));
        btnBuscar.setBounds(362, 721, 111, 37);
        getContentPane().add(btnBuscar);

        JButton btnActualizar = new JButton("Actualizar");
        btnActualizar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                Medico m = new Medico();

                actualizar(m);
                JOptionPane.showMessageDialog(null, "Datos del cliente actualizados con exito");

                Settear();

            }
        });
        btnActualizar.setFont(new Font("Tahoma", Font.BOLD, 11));
        btnActualizar.setIcon(new ImageIcon("C:\\Users\\GeovannyAbad\\eclipse-workspace\\CitasMedicasIngenieria\\img\\Update.png"));
        btnActualizar.setBounds(485, 721, 119, 37);
        getContentPane().add(btnActualizar);

        JButton btnEliminar = new JButton("Eliminar");
        btnEliminar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                Medico cl = new Medico();
                borrar(cl);
                JOptionPane.showMessageDialog(null, "Se ha eliminado los datos del cliente!");
                Settear();

            }
        });
        btnEliminar.setFont(new Font("Tahoma", Font.BOLD, 11));
        btnEliminar.setIcon(new ImageIcon("C:\\Users\\GeovannyAbad\\eclipse-workspace\\CitasMedicasIngenieria\\img\\Delete.png"));
        btnEliminar.setBounds(614, 721, 118, 37);
        getContentPane().add(btnEliminar);

        JButton btnListar = new JButton("Listar");
        btnListar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                ControladorMedico mBD = new ControladorMedico();
                mBD.listar();
                tabla();
                Settear();

            }
        });
        btnListar.setFont(new Font("Tahoma", Font.BOLD, 11));
        btnListar.setIcon(new ImageIcon("C:\\Users\\GeovannyAbad\\eclipse-workspace\\CitasMedicasIngenieria\\img\\Check.png"));
        btnListar.setBounds(742, 721, 117, 37);
        getContentPane().add(btnListar);

        JLabel lblEmail = new JLabel("Contrase\u00F1a:");
        lblEmail.setFont(new Font("Tahoma", Font.BOLD, 12));
        lblEmail.setBounds(12, 318, 82, 31);
        getContentPane().add(lblEmail);

        textPassword = new JTextField();
        textPassword.setColumns(10);
        textPassword.setBounds(97, 323, 241, 20);
        getContentPane().add(textPassword);

        labelc = new JLabel("");
        labelc.setBounds(113, 385, 97, 37);
        getContentPane().add(labelc);

        lblErrorNombre = new JLabel("");
        lblErrorNombre.setBounds(97, 192, 241, 16);
        getContentPane().add(lblErrorNombre);
        lblErrorNombre.setForeground(Color.red);

        lblErrorApellido = new JLabel("");
        lblErrorApellido.setBounds(97, 266, 241, 16);
        getContentPane().add(lblErrorApellido);
        lblErrorApellido.setForeground(Color.red);

        lblErrorCedula = new JLabel("");
        lblErrorCedula.setBounds(106, 141, 241, 16);
        lblErrorCedula.setForeground(Color.red);
        getContentPane().add(lblErrorCedula);

        lblErrorTelefono = new JLabel("");
        lblErrorTelefono.setBounds(97, 503, 241, 16);
        lblErrorTelefono.setForeground(Color.red);
        getContentPane().add(lblErrorTelefono);

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

        lblErrorMail = new JLabel("");
        lblErrorMail.setBounds(97, 344, 241, 16);
    }

    //Metodo guardar
    public void guardarC() {

        Medico m = new Medico();
        ControladorMedico mBD = new ControladorMedico();

        m.setMed_id(textId.getText());
        m.setMed_numeroconsultorio(Integer.parseInt(textConsultorio.getText()));
        m.setMed_usuario(textUsuario.getText());
        m.setMed_password(textPassword.getText());
        m.setMed_per_cedula(textCedula.getText());

        mBD.insertar(m);
        ;

    }

    public void Settear() {
        textId.setText("");
        textConsultorio.setText("");
        textUsuario.setText("");
        textPassword.setText("");
        textCedula.setText("");

    }

    public void listar() {
        try {
            String sql = "SELECT med_id, med_numeroconsultorio, med_usuario, med_password, med_per_cedula"
                    + " FROM medico;";
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
        Object[] medico = new Object[5];

        // metodo para limpiar la tabla
        // devuelve la cantidad de filas que hay en la tabla
        int filas = tabla.getRowCount();
        for (int i = filas - 1; i >= 0; i--) {
            tabla.removeRow(i);
        }
        ControladorMedico mBD = new ControladorMedico();
        for (Medico m : mBD.listar()) {

            medico[0] = m.getMed_id();
            medico[1] = m.getMed_numeroconsultorio();
            medico[2] = m.getMed_usuario();
            medico[3] = m.getMed_password();
            medico[4] = m.getMed_per_cedula();

            System.out.println(medico);

            // agregamos la fila a la lista
            tabla.addRow(medico);
        }

        table.setModel(tabla);

    }

    public boolean actualizar(Medico medico) {
        boolean b = false;
        Connection con = null;
        try {

            String sql = "UPDATE medico SET med_id = '" + textId.getText() + "',"
                    + " med_numeroconsultorio = '" + textConsultorio.getText() + "',"
                    + " med_usuario = '" + textUsuario.getText() + "',"
                    + "med_password= '" + textPassword.getText() + "'"
                    + "WHERE med_per_cedula = '" + textCedula.getText() + "';";

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
    public void borrar(Medico medico) {
        Connection con = null;
        try {

            String sql = "delete from medico where med_per_cedula = '" + textId.getText() + "';";

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

        String cedula = textId.getText();

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
        Object[] medico = new Object[5];

        // metodo para limpiar la tabla
        // devuelve la cantidad de filas que hay en la tabla
        int filas = tabla.getRowCount();
        for (int i = filas - 1; i >= 0; i--) {
            tabla.removeRow(i);
        }
        ControladorMedico cP = new ControladorMedico();
        for (Medico pL : cP.listarBuscando(textB.getText().toUpperCase())) {

            medico[0] = pL.getMed_id();
            medico[1] = pL.getMed_numeroconsultorio();
            medico[2] = pL.getMed_usuario();
            medico[3] = pL.getMed_password();
            medico[4] = pL.getMed_per_cedula();

            System.out.println(medico);

            // agregamos la fila a la lista
            tabla.addRow(medico);
        }

        table.setModel(tabla);
    }

    private static final int NUM_PROVINCIAS = 24;

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

            lblErrorMail.setText("Email correcto");
            lblErrorMail.setForeground(Color.blue);
            return true;

        } else {
            lblErrorMail.setText("Email incorrecto");
            lblErrorMail.setForeground(Color.RED);
            return false;
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 394, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 274, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
