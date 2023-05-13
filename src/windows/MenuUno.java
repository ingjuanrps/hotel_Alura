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
import javax.swing.border.SoftBevelBorder;

import hall.Conexion;

public class MenuUno extends javax.swing.JFrame {

    private JPanel contentPane;

    public static void main(String[] args) {

        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    MenuUno frame = new MenuUno();
                    frame.setVisible(true);
                } catch (Exception e) {
                    // TODO: handle exception
                    e.printStackTrace();
                }
            }
        });

    }

    public MenuUno () {
        // 0 - Panel
        setResizable(false);
        setUndecorated(true);
        setBounds(0, 0, 630, 430);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setLocationRelativeTo(null);
        setContentPane(contentPane);
        contentPane.setLayout(null);

        // 1- imagen menu
        JLabel JLabel_Logo1 = new JLabel("");
        JLabel_Logo1.setBounds(0, 0, 450, 410);
        contentPane.add(JLabel_Logo1);
        ImageIcon wallpaper_logo1 = new ImageIcon("src/images/menu-img.png","imagen de recepción");
        Icon icono_logo1 = new ImageIcon(wallpaper_logo1.getImage().getScaledInstance(JLabel_Logo1.getWidth(),
                JLabel_Logo1.getHeight(), Image.SCALE_DEFAULT));
        JLabel_Logo1.setIcon(icono_logo1);
        this.repaint();

        // 2 - Imagen logo de hotel alura
        JLabel JLabel_Logo2 = new JLabel("");
        JLabel_Logo2.setBounds(465, 60, 150, 150);
        contentPane.add(JLabel_Logo2);
        ImageIcon wallpaper_logo2 = new ImageIcon("src/images/ah-150px.png", "Logo de hotel alura");
        Icon icono_logo2 = new ImageIcon(wallpaper_logo2.getImage().getScaledInstance(JLabel_Logo2.getWidth(),
                JLabel_Logo2.getHeight(), Image.SCALE_DEFAULT));
        JLabel_Logo2.setIcon(icono_logo2);
        this.repaint();

        // 3- Mensaje de pie de pagina
        JLabel JLabel_footer = new JLabel("Creado por Ing. Juan Ramón Perales ©");
        JLabel_footer.setBounds(250, 414, 490, 12);
        JLabel_footer.setFont(new Font("Arial",Font.BOLD,9));
        JLabel_footer.setForeground(new Color(0,0,0));
        contentPane.add(JLabel_footer);

        // 4 - Imagen pie de pagina azul
        JLabel JLabel_Logo3 = new JLabel("");
        JLabel_Logo3.setBounds(0, 410, 730, 430);
        contentPane.add(JLabel_Logo3);
        ImageIcon wallpaper_logo3 = new ImageIcon("src/images/azul504.jpg", "Barra Azul");
        Icon icono_logo3 = new ImageIcon(wallpaper_logo3.getImage().getScaledInstance(JLabel_Logo3.getWidth(),
                JLabel_Logo3.getHeight(), Image.SCALE_DEFAULT));
        JLabel_Logo3.setIcon(icono_logo3);
        this.repaint();

        // 5 - Boton Salir o cerrar
        JButton boton_salir = new JButton(" X ");
        boton_salir.setBorder(null);
        boton_salir.setFont(new Font("Arial Narrow", Font.BOLD, 18));
        boton_salir.setForeground(new Color(255, 255, 255));
        boton_salir.setBackground(new Color(6, 130, 247));
        boton_salir.setBounds(603, 7, 20, 20);
        contentPane.add(boton_salir);

        boton_salir.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                int result = JOptionPane.showConfirmDialog(null,"¿Seguro que deseas salir?", "Confirmar Salida",
               JOptionPane.YES_NO_OPTION,
               JOptionPane.QUESTION_MESSAGE);
                

                if (result == JOptionPane.YES_OPTION) {
                    System.exit(0);
                }
            }
        });

        // 6 - Boton Login
        JLabel JLabel_login = new JLabel("Login");
        JLabel_login.setFont(new Font("Arial", Font.PLAIN, 15));
        JLabel_login.setForeground(new Color(0, 0, 255));
        JLabel_login.setBounds(521, 210, 100, 100);
        contentPane.add(JLabel_login);

        JButton boton_login = new JButton("");
        boton_login.setBorder(null);
        boton_login.setContentAreaFilled(false);
        boton_login.setFont(new Font("Arial Narrow", Font.PLAIN, 18));
        boton_login.setForeground(new Color(255, 255, 255));
        boton_login.setBounds(509, 270, 67, 67);
        boton_login.setIcon(new ImageIcon("src/images/login.png", " Login para ir a registrar"));
        contentPane.add(boton_login);

        boton_login.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
               
                Login login = new Login();
                login.setVisible(true);
                dispose();
                
            }
        });

        // 7 - Fondo Blanco
        JLabel JLabel_Logo0 = new JLabel("");
        JLabel_Logo0.setBounds(0, 0, 630, 410);
        contentPane.add(JLabel_Logo0);
        ImageIcon wallpaper_logo0 = new ImageIcon("src/images/blanco.png","Fondo Blanco");
        Icon icono_logo0 = new ImageIcon(wallpaper_logo0.getImage().getScaledInstance(JLabel_Logo0.getWidth(),
                JLabel_Logo0.getHeight(), Image.SCALE_DEFAULT));
        JLabel_Logo0.setIcon(icono_logo0);
        this.repaint();
    }
    
}
