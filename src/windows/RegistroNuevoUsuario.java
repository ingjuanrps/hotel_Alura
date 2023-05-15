package windows;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.BorderFactory;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.SwingConstants;
import javax.swing.WindowConstants;
import javax.swing.border.BevelBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.border.SoftBevelBorder;

import org.w3c.dom.Text;

import hall.BotonSalir;
import hall.Conexion;

public class RegistroNuevoUsuario extends javax.swing.JFrame {

    private JPanel contentPane;
    private JTextField txt_Nombre, txt_Apellido, txt_ApellidoMa, txt_Username;
    private JPasswordField txt_password;

    String nombre, apellido1, apellido2, username, pass;
    int permisos_cmb, validacion = 0;

    public void main(String[] args) {

        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    RegistroNuevoUsuario frame = new RegistroNuevoUsuario();
                    frame.setVisible(true);
                } catch (Exception e) {
                    // TODO: handle exception
                    e.printStackTrace();
                }
            }
        });

    }

    public RegistroNuevoUsuario() {

        // 0 - Panel
        setResizable(false);
        setUndecorated(true);
        setBounds(0, 0, 630, 430);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setLocationRelativeTo(null);
        setContentPane(contentPane);
        contentPane.setLayout(null);

        // 1- imagen Registro
        JLabel JLabel_Logo1 = new JLabel("");
        JLabel_Logo1.setBounds(395, 60, 230, 300);
        contentPane.add(JLabel_Logo1);
        ImageIcon wallpaper_logo1 = new ImageIcon("src/images/registroNuevo.png", "imagen de Registro");
        Icon icono_logo1 = new ImageIcon(wallpaper_logo1.getImage().getScaledInstance(JLabel_Logo1.getWidth(),
                JLabel_Logo1.getHeight(), Image.SCALE_DEFAULT));
        JLabel_Logo1.setIcon(icono_logo1);
        this.repaint();

        // 2 - Imagen logo de hotel alura
        JLabel JLabel_Logo2 = new JLabel("");
        JLabel_Logo2.setBounds(10, 40, 48, 48);
        contentPane.add(JLabel_Logo2);
        ImageIcon wallpaper_logo2 = new ImageIcon("src/images/lOGO-50PX.png", "Logo de hotel alura");
        Icon icono_logo2 = new ImageIcon(wallpaper_logo2.getImage().getScaledInstance(JLabel_Logo2.getWidth(),
                JLabel_Logo2.getHeight(), Image.SCALE_DEFAULT));
        JLabel_Logo2.setIcon(icono_logo2);
        this.repaint();

        // 3 - Etiqueta Inicio de sesion
        JLabel JLabel_nombreUsuario = new JLabel("REGISTRO DE USUARIO");
        JLabel_nombreUsuario.setFont(new Font("Arial", Font.BOLD, 18));
        JLabel_nombreUsuario.setForeground(new Color(255, 255, 255));
        JLabel_nombreUsuario.setBounds(70, 53, 250, 20);
        contentPane.add(JLabel_nombreUsuario);

        // 4 - Mensaje de pie de pagina
        JLabel JLabel_footer = new JLabel("Creado por Ing. Juan Ramón Perales ©");
        JLabel_footer.setBounds(250, 414, 490, 12);
        JLabel_footer.setFont(new Font("Arial", Font.BOLD, 9));
        JLabel_footer.setForeground(new Color(0, 0, 0));
        contentPane.add(JLabel_footer);
        // 4 - Imagen pie de pagina azul
        JLabel JLabel_Logo5 = new JLabel("");
        JLabel_Logo5.setBounds(0, 410, 730, 430);
        contentPane.add(JLabel_Logo5);
        ImageIcon wallpaper_logo5 = new ImageIcon("src/images/azul504.jpg", "Barra Azul");
        Icon icono_logo5 = new ImageIcon(wallpaper_logo5.getImage().getScaledInstance(JLabel_Logo5.getWidth(),
                JLabel_Logo5.getHeight(), Image.SCALE_DEFAULT));
        JLabel_Logo5.setIcon(icono_logo5);
        this.repaint();

        // 6 - JLabel Usuario
        JLabel JLabel_Nombre = new JLabel("NOMBRE(S): ");
        JLabel_Nombre.setFont(new Font("Arial", Font.BOLD, 15));
        JLabel_Nombre.setForeground(new Color(255, 255, 255));
        JLabel_Nombre.setBounds(30, 110, 150, 20);
        contentPane.add(JLabel_Nombre);

        txt_Nombre = new JTextField();
        txt_Nombre.setText("");
        txt_Nombre.setBorder(new LineBorder(Color.blue, 1));
        txt_Nombre.setHorizontalAlignment(SwingConstants.LEFT);
        txt_Nombre.setForeground(new Color(0, 0, 255));
        txt_Nombre.setBackground(new Color(255, 255, 255));
        txt_Nombre.setFont(new Font("Arial", Font.PLAIN, 15));
        txt_Nombre.setBounds(30, 130, 210, 20);
        txt_Nombre.setEnabled(true);
        contentPane.add(txt_Nombre);
        txt_Nombre.setColumns(10);

        // 6 - JLabel Usuario
        JLabel JLabel_Apellido = new JLabel("PRIMER APELLIDO: ");
        JLabel_Apellido.setFont(new Font("Arial", Font.BOLD, 15));
        JLabel_Apellido.setForeground(new Color(255, 255, 255));
        JLabel_Apellido.setBounds(30, 160, 150, 20);
        contentPane.add(JLabel_Apellido);

        txt_Apellido = new JTextField();
        txt_Apellido.setText("");
        txt_Apellido.setBorder(new LineBorder(Color.blue, 1));
        txt_Apellido.setHorizontalAlignment(SwingConstants.LEFT);
        txt_Apellido.setForeground(new Color(0, 0, 255));
        txt_Apellido.setBackground(new Color(255, 255, 255));
        txt_Apellido.setFont(new Font("Arial", Font.PLAIN, 15));
        txt_Apellido.setBounds(30, 180, 210, 20);
        txt_Apellido.setEnabled(true);
        contentPane.add(txt_Apellido);
        txt_Apellido.setColumns(10);

        // 6 - JLabel Usuario
        JLabel JLabel_ApellidoMa = new JLabel("SEGUNDO APELLIDO: ");
        JLabel_ApellidoMa.setFont(new Font("Arial", Font.BOLD, 15));
        JLabel_ApellidoMa.setForeground(new Color(255, 255, 255));
        JLabel_ApellidoMa.setBounds(30, 210, 200, 20);
        contentPane.add(JLabel_ApellidoMa);

        txt_ApellidoMa = new JTextField();
        txt_ApellidoMa.setText("");
        txt_ApellidoMa.setBorder(new LineBorder(Color.blue, 1));
        txt_ApellidoMa.setHorizontalAlignment(SwingConstants.LEFT);
        txt_ApellidoMa.setForeground(new Color(0, 0, 255));
        txt_ApellidoMa.setBackground(new Color(255, 255, 255));
        txt_ApellidoMa.setFont(new Font("Arial", Font.PLAIN, 15));
        txt_ApellidoMa.setBounds(30, 230, 210, 20);
        txt_ApellidoMa.setEnabled(true);
        contentPane.add(txt_ApellidoMa);
        txt_ApellidoMa.setColumns(10);

        // 6 - JLabel Usurname
        JLabel JLabel_Username = new JLabel("USER-NAME: ");
        JLabel_Username.setFont(new Font("Arial", Font.BOLD, 15));
        JLabel_Username.setForeground(new Color(255, 255, 255));
        JLabel_Username.setBounds(30, 260, 200, 20);
        contentPane.add(JLabel_Username);

        txt_Username = new JTextField();
        txt_Username.setText("");
        txt_Username.setBorder(new LineBorder(Color.blue, 1));
        txt_Username.setHorizontalAlignment(SwingConstants.LEFT);
        txt_Username.setForeground(new Color(0, 0, 255));
        txt_Username.setBackground(new Color(255, 255, 255));
        txt_Username.setFont(new Font("Arial", Font.PLAIN, 15));
        txt_Username.setBounds(30, 280, 210, 20);
        txt_Username.setEnabled(true);
        contentPane.add(txt_Username);
        txt_Username.setColumns(10);

        // 6 - Usuario
        JLabel JLabel_Passsword = new JLabel("PASSWORD: ");
        JLabel_Passsword.setFont(new Font("Arial", Font.BOLD, 15));
        JLabel_Passsword.setForeground(new Color(255, 255, 255));
        JLabel_Passsword.setBounds(30, 310, 150, 20);
        contentPane.add(JLabel_Passsword);

        txt_password = new JPasswordField();
        txt_password.getText();
        txt_password.setForeground(new Color(0, 0, 255));
        txt_password.setHorizontalAlignment(SwingConstants.CENTER);
        txt_password.setFont(new Font("Arial", Font.PLAIN, 18));
        txt_password.setBackground(new Color(255, 255, 255));
        txt_password.setBorder(new LineBorder(Color.blue, 1));
        txt_password.setBounds(30, 330, 210, 20);
        contentPane.add(txt_password);

        // 6 - Boton Salir o cerrar
        JButton boton_salir = new JButton(" X ");
        boton_salir.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0));
        boton_salir.setFont(new Font("Arial Narrow", Font.BOLD, 18));
        boton_salir.setForeground(new Color(255, 255, 255));
        boton_salir.setBackground(new Color(6, 130, 247));
        boton_salir.setBounds(603, 7, 20, 20);
        contentPane.add(boton_salir);

        boton_salir.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                int result = JOptionPane.showConfirmDialog(null, "¿Seguro que deseas salir?", "Confirmar Salida",
                        JOptionPane.YES_NO_OPTION,
                        JOptionPane.QUESTION_MESSAGE);

                if (result == JOptionPane.YES_OPTION) {
                    System.exit(0);
                }
            }
        });

        // 7 - Boton Registrar
        JButton boton_login = new JButton("REGISTRAR");
        boton_login.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
        boton_login.setFont(new Font("Arial Narrow", Font.PLAIN, 18));
        boton_login.setForeground(new Color(255, 255, 255));
        boton_login.setBackground(new Color(93, 173, 226));
        boton_login.setBounds(140, 370, 100, 25);
        contentPane.add(boton_login);

        boton_login.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                nombre = txt_Nombre.getText().trim();
                apellido1 = txt_Apellido.getText().trim();
                apellido2 = txt_ApellidoMa.getText().trim();
                username = txt_Username.getText().trim();
                pass = txt_password.getText().trim();

                if (nombre.equals("")) {
                    txt_Nombre.setBackground(Color.red);
                    validacion++;
                }

                if (apellido1.equals("")) {
                    txt_Apellido.setBackground(Color.red);
                    validacion++;
                }

                if (apellido2.equals("")) {
                    txt_ApellidoMa.setBackground(Color.red);
                    validacion++;
                }

                if (username.equals("")) {
                    txt_Username.setBackground(Color.red);
                    validacion++;
                }

                if (pass.equals("")) {
                    txt_password.setBackground(Color.red);
                    validacion++;
                }

                try {
                    Connection cn1 = Conexion.conectar();
                    PreparedStatement pst1 = cn1
                            .prepareStatement("select username from usuarios where username = '" + username + "'");

                    ResultSet rs = pst1.executeQuery();
                    if (rs.next()) {
                        txt_Username.setBackground(Color.red);
                        JOptionPane.showMessageDialog(null, "Nomber de usuario no disponible");
                        cn1.close();
                    } else {
                        cn1.close();
                        if (validacion == 0) {
                            try {
                                Connection cn2 = Conexion.conectar();
                                PreparedStatement pst2 = cn2
                                        .prepareStatement("insert into usuarios values (?,?,?,?,?,?)");

                                pst2.setInt(1, 0);
                                pst2.setString(2, nombre);
                                pst2.setString(3, apellido1);
                                pst2.setString(4, apellido2);
                                pst2.setString(5, username);
                                pst2.setString(6, pass);

                                pst2.executeUpdate();
                                cn2.close();

                                Limpiar();
                                txt_Nombre.setBackground(Color.green);
                                txt_Apellido.setBackground(Color.green);
                                txt_ApellidoMa.setBackground(Color.green);
                                txt_Username.setBackground(Color.green);
                                txt_password.setBackground(Color.green);

                                JOptionPane.showMessageDialog(null, "Registro Exitoso");
                                Login login = new Login();
                                login.setVisible(true);
                                dispose();

                            } catch (SQLException e2) {
                                // TODO: handle exception
                                System.err.println("Error en Registrar usuario." + e2);
                                JOptionPane.showMessageDialog(null, "Error al registrar, contactar al administrador.");
                            }
                        } else {
                            JOptionPane.showMessageDialog(null, "Debes de llenar todos los campos");
                        }
                    }
                } catch (Exception e1) {
                    // TODO: handle exception
                    System.err.println("Erroren validar nombre de usuario" + e1);
                    JOptionPane.showMessageDialog(null, "Error al comparar usuario, concata al administrador");
                }

            }
        });

        // 8 - Boton REGRESAR
        JButton boton_Regresar = new JButton("");
        ImageIcon iconoRegresar = new ImageIcon("src/images/atras.png", "Imagen Regresar");
        boton_Regresar.setIcon(iconoRegresar);
        boton_Regresar.setContentAreaFilled(false);
        boton_Regresar.setBorder(null);
        boton_Regresar.setFont(new Font("Arial Narrow", Font.BOLD, 18));

        boton_Regresar.setBackground(new Color(255, 255, 255, 1));
        boton_Regresar.setBounds(5, 7, 22, 22);
        contentPane.add(boton_Regresar);

        boton_Regresar.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {

                Login login = new Login();
                login.setVisible(true);
                dispose();

            }
        });

        // 5 - Imagen azul lado Izquierdo
        JLabel JLabel_Logo3 = new JLabel("");
        JLabel_Logo3.setBounds(0, 0, 375, 430);
        contentPane.add(JLabel_Logo3);
        ImageIcon wallpaper_logo3 = new ImageIcon("src/images/azul504.jpg", "Barra Azul Izquierda");
        Icon icono_logo3 = new ImageIcon(wallpaper_logo3.getImage().getScaledInstance(JLabel_Logo3.getWidth(),
                JLabel_Logo3.getHeight(), Image.SCALE_DEFAULT));
        JLabel_Logo3.setIcon(icono_logo3);
        this.repaint();

        // 13 - Fondo Blanco
        JLabel JLabel_Logo0 = new JLabel("");
        JLabel_Logo0.setBounds(0, 0, 630, 430);
        contentPane.add(JLabel_Logo0);
        ImageIcon wallpaper_logo0 = new ImageIcon("src/images/blanco.png", "Fondo Blanco");
        Icon icono_logo0 = new ImageIcon(wallpaper_logo0.getImage().getScaledInstance(JLabel_Logo0.getWidth(),
                JLabel_Logo0.getHeight(), Image.SCALE_DEFAULT));
        JLabel_Logo0.setIcon(icono_logo0);
        this.repaint();
    }

    public void paint(Graphics g) { // linaea blaca

        super.paint(g);

        g.setColor(Color.WHITE);
        g.drawLine(70, 76, 288, 76);
    }

    public void Limpiar() {

        txt_Nombre.setText("");
        txt_Apellido.setText("");
        txt_ApellidoMa.setText("");
        txt_Username.setText("");
        txt_password.setText("");

    }
}
