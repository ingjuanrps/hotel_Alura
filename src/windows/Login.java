package windows;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
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
import javax.swing.SwingConstants;
import javax.swing.border.BevelBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.border.SoftBevelBorder;

import hall.BotonSalir;
import hall.Conexion;

public class Login extends javax.swing.JFrame {

    private JPanel contentPane;
    private JTextField txt_Usuario;
    private JPasswordField txt_password;

    public void main(String[] args) {

        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    Login frame = new Login();
                    frame.setVisible(true);
                } catch (Exception e) {
                    // TODO: handle exception
                    e.printStackTrace();
                }
            }
        });

    }

    public Login() {

        // 0 - Panel
        setResizable(false);
        setUndecorated(true);
        setBounds(0, 0, 630, 430);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setLocationRelativeTo(null);
        setContentPane(contentPane);
        contentPane.setLayout(null);

        // 1- imagen hotel
        JLabel JLabel_Logo1 = new JLabel("");
        JLabel_Logo1.setBounds(395, 60, 230, 300);
        contentPane.add(JLabel_Logo1);
        ImageIcon wallpaper_logo1 = new ImageIcon("src/images/img-hotel-login-.png", "imagen de hotel alura");
        Icon icono_logo1 = new ImageIcon(wallpaper_logo1.getImage().getScaledInstance(JLabel_Logo1.getWidth(),
                JLabel_Logo1.getHeight(), Image.SCALE_DEFAULT));
        JLabel_Logo1.setIcon(icono_logo1);
        this.repaint();

        // 2 - Imagen logo de hotel alura
        JLabel JLabel_Logo2 = new JLabel("");
        JLabel_Logo2.setBounds(30, 40, 48, 48);
        contentPane.add(JLabel_Logo2);
        ImageIcon wallpaper_logo2 = new ImageIcon("src/images/lOGO-50PX.png", "Logo de hotel alura");
        Icon icono_logo2 = new ImageIcon(wallpaper_logo2.getImage().getScaledInstance(JLabel_Logo2.getWidth(),
                JLabel_Logo2.getHeight(), Image.SCALE_DEFAULT));
        JLabel_Logo2.setIcon(icono_logo2);
        this.repaint();

        // 3 - Etiqueta Inicio de sesion
        JLabel JLabel_nombreUsuario = new JLabel("INICIAR SESIÓN");
        JLabel_nombreUsuario.setFont(new Font("Arial", Font.BOLD, 18));
        JLabel_nombreUsuario.setForeground(new Color(93, 173, 226));
        JLabel_nombreUsuario.setBounds(30, 110, 200, 20);
        contentPane.add(JLabel_nombreUsuario);

        // 4 - Mensaje de pie de pagina
        JLabel JLabel_footer = new JLabel("Creado por Ing. Juan Ramón Perales ©");
        JLabel_footer.setBounds(250, 414, 490, 12);
        JLabel_footer.setFont(new Font("Arial", Font.BOLD, 9));
        JLabel_footer.setForeground(new Color(0, 0, 0));
        contentPane.add(JLabel_footer);

        // 5 - Imagen azul lado derecho
        JLabel JLabel_Logo3 = new JLabel("");
        JLabel_Logo3.setBounds(385, 0, 245, 430);
        contentPane.add(JLabel_Logo3);
        ImageIcon wallpaper_logo3 = new ImageIcon("src/images/azul504.jpg", "Barra Azul Derecha");
        Icon icono_logo3 = new ImageIcon(wallpaper_logo3.getImage().getScaledInstance(JLabel_Logo3.getWidth(),
                JLabel_Logo3.getHeight(), Image.SCALE_DEFAULT));
        JLabel_Logo3.setIcon(icono_logo3);
        this.repaint();
        // 6 - Usuario
        JLabel JLabel_Usuario = new JLabel("USUARIO: ");
        JLabel_Usuario.setFont(new Font("Arial", Font.BOLD, 15));
        JLabel_Usuario.setForeground(new Color(93, 173, 226));
        JLabel_Usuario.setBounds(30, 150, 150, 20);
        contentPane.add(JLabel_Usuario);

        txt_Usuario = new JTextField();
        txt_Usuario.setText("");
        txt_Usuario.setBorder(new LineBorder(Color.blue, 1));
        txt_Usuario.setHorizontalAlignment(SwingConstants.LEFT);
        txt_Usuario.setForeground(new Color(0, 0, 1));
        txt_Usuario.setBackground(new Color(255, 255, 255));
        txt_Usuario.setFont(new Font("Arial", Font.ITALIC, 15));
        txt_Usuario.setBounds(30, 170, 210, 20);
        txt_Usuario.setEnabled(true);
        contentPane.add(txt_Usuario);
        txt_Usuario.setColumns(10);

        // 6 - Usuario
        JLabel JLabel_Passsword = new JLabel("PASSWORD: ");
        JLabel_Passsword.setFont(new Font("Arial", Font.BOLD, 15));
        JLabel_Passsword.setForeground(new Color(93, 173, 226));
        JLabel_Passsword.setBounds(30, 220, 150, 20);
        contentPane.add(JLabel_Passsword);

        txt_password = new JPasswordField();
        txt_password.setForeground(new Color(255, 255, 255));
        txt_password.setHorizontalAlignment(SwingConstants.CENTER);
        txt_password.setFont(new Font("Arial", Font.PLAIN, 18));
        txt_password.setBackground(new Color(255, 255, 255));
        txt_password.setBorder(new LineBorder(Color.blue, 1));
        txt_password.setBounds(30, 250, 210, 20);
        contentPane.add(txt_password);

        // 6 - Boton Salir o cerrar
        JButton boton_salir = new JButton(" X ");
        boton_salir.setBorder(BorderFactory.createEmptyBorder(0,0, 0, 0));
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

        // 7 - Boton Entrar
        JButton boton_login = new JButton("ENTRAR");
        boton_login.setBorder(BorderFactory.createEmptyBorder(5,5, 5, 5));
        boton_login.setFont(new Font("Arial Narrow", Font.PLAIN, 18));
        boton_login.setForeground(new Color(255, 255, 255));
        boton_login.setBackground(new Color(93, 173, 226));
        boton_login.setBounds(30, 350, 80, 25);
        contentPane.add(boton_login);

        boton_login.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

            }
        });

        // 8 - Boton Registrar
        JButton boton_Registrar = new JButton("REGISTRAR");
        boton_Registrar.setBorder(null);
        boton_Registrar.setFont(new Font("Arial Narrow", Font.PLAIN, 18));
        boton_Registrar.setForeground(new Color(255, 255, 255));
        boton_Registrar.setBackground(new Color(93, 173, 226));
        boton_Registrar.setBounds(150, 350, 90, 25);
        contentPane.add(boton_Registrar);

        boton_Registrar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

            }
        });

        // 9 - Fondo Blanco
        JLabel JLabel_Logo0 = new JLabel("");
        JLabel_Logo0.setBounds(0, 0, 630, 430);
        contentPane.add(JLabel_Logo0);
        ImageIcon wallpaper_logo0 = new ImageIcon("src/images/blanco.png", "Fondo Blanco");
        Icon icono_logo0 = new ImageIcon(wallpaper_logo0.getImage().getScaledInstance(JLabel_Logo0.getWidth(),
                JLabel_Logo0.getHeight(), Image.SCALE_DEFAULT));
        JLabel_Logo0.setIcon(icono_logo0);
        this.repaint();

    }
}
