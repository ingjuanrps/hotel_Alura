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
import javax.swing.border.BevelBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.border.SoftBevelBorder;

import org.w3c.dom.Text;

import hall.BotonSalir;
import hall.Conexion;

public class MenuUsuario extends javax.swing.JFrame {

    private JPanel contentPane;
    private JTextField txt_Usuario;
    private JPasswordField txt_password;

    public void main(String[] args) {

        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    MenuUsuario frame = new MenuUsuario();
                    frame.setVisible(true);
                } catch (Exception e) {
                    // TODO: handle exception
                    e.printStackTrace();
                }
            }
        });

    }

    public MenuUsuario() {

        // 0 - Panel
        setResizable(false);
        setUndecorated(true);
        setBounds(0, 0, 630, 430);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setLocationRelativeTo(null);
        setContentPane(contentPane);
        contentPane.setLayout(null);

        // 1 - Imagen logo de hotel alura
        JLabel JLabel_Logo2 = new JLabel("");
        JLabel_Logo2.setBounds(50, 25, 100, 100);
        contentPane.add(JLabel_Logo2);
        ImageIcon wallpaper_logo2 = new ImageIcon("src/images/aH-150px.png", "Logo de hotel alura");
        Icon icono_logo2 = new ImageIcon(wallpaper_logo2.getImage().getScaledInstance(JLabel_Logo2.getWidth(),
                JLabel_Logo2.getHeight(), Image.SCALE_DEFAULT));
        JLabel_Logo2.setIcon(icono_logo2);
        this.repaint();

        // 2 - Etiqueta Sistema de Reservas Hotel Alura
        JLabel JLabel_nombreUsuario = new JLabel("Sistema de Reservsas Hotel Alura");
        JLabel_nombreUsuario.setFont(new Font("Arial", Font.BOLD, 18));
        JLabel_nombreUsuario.setForeground(new Color(255, 255, 255));
        JLabel_nombreUsuario.setBounds(285, 70, 290, 20);
        JLabel_nombreUsuario.setBackground(new Color(12, 15, 253));
        contentPane.add(JLabel_nombreUsuario);

        // 3 - Etiqueta Hoy es
        JLabel JLabel_hoy_es = new JLabel("Hoy es : ");
        JLabel_hoy_es.setFont(new Font("Arial", Font.BOLD, 16));
        JLabel_hoy_es.setForeground(new Color(255, 255, 255));
        JLabel_hoy_es.setBounds(295, 100, 290, 20);
        JLabel_hoy_es.setBackground(new Color(12, 15, 253));
        contentPane.add(JLabel_hoy_es);

        // 4 - Etiqueta Bienvenidos
        JLabel JLabel_Bienvenidos = new JLabel("Bienvenidos.");
        JLabel_Bienvenidos.setFont(new Font("Arial", Font.BOLD, 18));
        JLabel_Bienvenidos.setForeground(new Color(0, 0, 0));
        JLabel_Bienvenidos.setBounds(230, 165, 200, 20);
        JLabel_Bienvenidos.setBackground(new Color(12, 15, 253));
        contentPane.add(JLabel_Bienvenidos);

        // 5 - Panel De Informacion.
        JTextPane tex_pane = new JTextPane();
        tex_pane.setText("Sistema de reserva de hotel. Controle y administre de forma óptima y fácil \n"
        + "el flujo de resserva y de huspédes del hotel. \n \n"
        + "Esta herraminta le permitirá llevar un control completo y detallado de sus \n"
        + "reservas y huéspedes, tendrá acceso a herramintas especiales para tareas \n"
        + "especiales como lo son: \n \n"
        + " - Registro de Reservas y Huéspedes. \n"
        + " - Edicion de Reservas y Huéspedes exixtentes. \n"
        + " - Eliminar todo tipo de registros.");
        tex_pane.setBounds(215, 200, 420, 190);
        tex_pane.setEditable(false);
        contentPane.add(tex_pane);

        // 6 - Mensaje de pie de pagina
        JLabel JLabel_footer = new JLabel("Creado por Ing. Juan Ramón Perales ©");
        JLabel_footer.setBounds(250, 414, 490, 12);
        JLabel_footer.setFont(new Font("Arial", Font.BOLD, 9));
        JLabel_footer.setForeground(new Color(0, 0, 0));
        contentPane.add(JLabel_footer);
         // 7 - Imagen pie de pagina azul
         JLabel JLabel_Logo5 = new JLabel("");
         JLabel_Logo5.setBounds(0, 410, 730, 430);
         contentPane.add(JLabel_Logo5);
         ImageIcon wallpaper_logo5 = new ImageIcon("src/images/azul504.jpg", "Barra Azul");
         Icon icono_logo5 = new ImageIcon(wallpaper_logo5.getImage().getScaledInstance(JLabel_Logo5.getWidth(),
                 JLabel_Logo5.getHeight(), Image.SCALE_DEFAULT));
         JLabel_Logo5.setIcon(icono_logo5);
         this.repaint();

         // 8 - Boton Registro de reservas
        JButton boton_RegistroReservas = new JButton(" Registro de Reservas");
        ImageIcon icono = new ImageIcon("src/images/icon-reservas.png", "Imagen Reserva");
        boton_RegistroReservas.setIcon(icono);
        boton_RegistroReservas.setContentAreaFilled(false);
        boton_RegistroReservas.setBorder(BorderFactory.createEmptyBorder(5,5, 5, 5));
        boton_RegistroReservas.setFont(new Font("Arial Narrow", Font.PLAIN, 18));
        boton_RegistroReservas.setForeground(new Color(255, 255, 255));
        boton_RegistroReservas.setBackground(new Color(255, 255, 255,1));
        boton_RegistroReservas.setBounds(10, 170, 190, 35);
        contentPane.add(boton_RegistroReservas);

        boton_RegistroReservas.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                RegistroReservas registroReservas = new RegistroReservas();
                registroReservas.setVisible(true);
                dispose();
                
            }
        });

        // 9 - Boton Busqueda
        JButton boton_Busqueda = new JButton("   Busqueda");
        ImageIcon iconoBusqueda = new ImageIcon("src/images/icon-buscar.png", "Imagen Buscar");
        boton_Busqueda.setIcon(iconoBusqueda);
        boton_Busqueda.setContentAreaFilled(false);
        boton_Busqueda.setBorder(null);
        boton_Busqueda.setFont(new Font("Arial Narrow", Font.PLAIN, 18));
        boton_Busqueda.setForeground(new Color(255, 255, 255));
        boton_Busqueda.setBackground(new Color(93, 173, 226,1));
        boton_Busqueda.setBounds(10, 250, 130, 35);
        contentPane.add(boton_Busqueda);

        boton_Busqueda.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                SistemaBusqueda sistemaBusqueda = new SistemaBusqueda();
                sistemaBusqueda.setVisible(true);
                dispose();
                
            }
        });

        // 10 - Imagen azul lado Izquierdo
        JLabel JLabel_Logo3 = new JLabel("");
        JLabel_Logo3.setBounds(0, 0, 205, 430);
        contentPane.add(JLabel_Logo3);
        ImageIcon wallpaper_logo3 = new ImageIcon("src/images/azul504.jpg", "Barra Azul Derecha");
        Icon icono_logo3 = new ImageIcon(wallpaper_logo3.getImage().getScaledInstance(JLabel_Logo3.getWidth(),
                JLabel_Logo3.getHeight(), Image.SCALE_DEFAULT));
        JLabel_Logo3.setIcon(icono_logo3);
        this.repaint();

        // 11 - Imagen azul vertical
        JLabel JLabel_Logo4 = new JLabel("");
        JLabel_Logo4.setBounds(205, 60, 425, 70);
        contentPane.add(JLabel_Logo4);
        ImageIcon wallpaper_logo4 = new ImageIcon("src/images/centroAzul.jpg", "Barra Azul Derecha");
        Icon icono_logo4 = new ImageIcon(wallpaper_logo4.getImage().getScaledInstance(JLabel_Logo4.getWidth(),
                JLabel_Logo4.getHeight(), Image.SCALE_DEFAULT));
        JLabel_Logo4.setIcon(icono_logo4);
        this.repaint();

        

        // 12 - Boton Salir o cerrar
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
        g.drawLine(30, 130, 175, 130);
    }
}
