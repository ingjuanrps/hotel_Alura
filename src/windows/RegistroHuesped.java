package windows;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.TextField;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Calendar;
import java.util.Date;

import javax.swing.BorderFactory;
import javax.swing.DefaultComboBoxModel;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
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
import javax.swing.JTextField;

import org.w3c.dom.Text;

import com.toedter.calendar.JDateChooser;

import hall.BotonSalir;
import hall.Conexion;

public class RegistroHuesped extends javax.swing.JFrame {

    private JComboBox cmb_equipo, cmb_Nacionalidad;

    JDateChooser dateChooser3;

    private JPanel contentPane;
    private JTextField txt_Nombre, txt_Apellido, txt_Telefono,txt_NoReserva;
    private JPasswordField txt_password;

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

    public RegistroHuesped() {

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
        JLabel_Logo1.setBounds(40, 75, 230, 300);
        contentPane.add(JLabel_Logo1);
        ImageIcon wallpaper_logo1 = new ImageIcon("src/images/registro.png", "imagen de Registro");
        Icon icono_logo1 = new ImageIcon(wallpaper_logo1.getImage().getScaledInstance(JLabel_Logo1.getWidth(),
                JLabel_Logo1.getHeight(), Image.SCALE_DEFAULT));
        JLabel_Logo1.setIcon(icono_logo1);
        this.repaint();

        // 2 - Imagen logo de hotel alura
        JLabel JLabel_Logo2 = new JLabel("");
        JLabel_Logo2.setBounds(130, 20, 60, 60);
        contentPane.add(JLabel_Logo2);
        ImageIcon wallpaper_logo2 = new ImageIcon("src/images/aH-150px.png", "Logo de hotel alura");
        Icon icono_logo2 = new ImageIcon(wallpaper_logo2.getImage().getScaledInstance(JLabel_Logo2.getWidth(),
                JLabel_Logo2.getHeight(), Image.SCALE_DEFAULT));
        JLabel_Logo2.setIcon(icono_logo2);
        this.repaint();

        // 3 - Etiqueta Inicio de sesion
        JLabel JLabel_nombreUsuario = new JLabel("REGISTRO DE HUESPED");
        JLabel_nombreUsuario.setFont(new Font("Arial", Font.BOLD, 18));
        JLabel_nombreUsuario.setForeground(new Color(93, 173, 226));
        JLabel_nombreUsuario.setBounds(370, 33, 250, 20);
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
        JLabel_Nombre.setFont(new Font("Arial", Font.BOLD, 14));
        JLabel_Nombre.setForeground(new Color(93, 173, 226));
        JLabel_Nombre.setBounds(350, 70, 150, 12);
        contentPane.add(JLabel_Nombre);

        txt_Nombre = new JTextField();
        txt_Nombre.setText("");
        txt_Nombre.setBorder(new LineBorder(Color.WHITE, 1));
        txt_Nombre.setHorizontalAlignment(SwingConstants.LEFT);
        txt_Nombre.setForeground(new Color(0, 0, 255));
        txt_Nombre.setBackground(new Color(255, 255, 255));
        txt_Nombre.setFont(new Font("Arial", Font.PLAIN, 14));
        txt_Nombre.setBounds(350, 85, 210, 18);
        txt_Nombre.setEnabled(true);
        contentPane.add(txt_Nombre);
        txt_Nombre.setColumns(10);

        // 6 - JLabel Apellido
        JLabel JLabel_Apellido = new JLabel("APELLIDO: ");
        JLabel_Apellido.setFont(new Font("Arial", Font.BOLD, 14));
        JLabel_Apellido.setForeground(new Color(93, 173, 226));
        JLabel_Apellido.setBounds(350, 120, 150, 12);
        contentPane.add(JLabel_Apellido);

        txt_Apellido = new JTextField();
        txt_Apellido.setText("");
        txt_Apellido.setBorder(new LineBorder(Color.WHITE, 1));
        txt_Apellido.setHorizontalAlignment(SwingConstants.LEFT);
        txt_Apellido.setForeground(new Color(0, 0, 255));
        txt_Apellido.setBackground(new Color(255, 255, 255));
        txt_Apellido.setFont(new Font("Arial", Font.PLAIN, 14));
        txt_Apellido.setBounds(350, 140, 210, 18);
        txt_Apellido.setEnabled(true);
        contentPane.add(txt_Apellido);
        txt_Apellido.setColumns(10);

        // 6 - JLabel Usuario
        JLabel JLabel_ApellidoMa = new JLabel("FECHA DE NACIMIENTO: ");
        JLabel_ApellidoMa.setFont(new Font("Arial", Font.BOLD, 14));
        JLabel_ApellidoMa.setForeground(new Color(93, 173, 226));
        JLabel_ApellidoMa.setBounds(350, 170, 200, 12);//20
        contentPane.add(JLabel_ApellidoMa);

        dateChooser3 = new JDateChooser(new Date());
        dateChooser3.setBounds(350, 190, 210, 20);
        dateChooser3.setFont(new Font("Arial", Font.PLAIN, 12));
        contentPane.add(dateChooser3);

        // 6 - Usuario
        JLabel JLabel_Passsword = new JLabel("NACIONALIDAD: ");
        JLabel_Passsword.setFont(new Font("Arial", Font.BOLD, 14));
        JLabel_Passsword.setForeground(new Color(93, 173, 226));
        JLabel_Passsword.setBounds(350, 220, 150, 20);
        contentPane.add(JLabel_Passsword);

        cmb_Nacionalidad = new JComboBox();
        cmb_Nacionalidad.setModel(new DefaultComboBoxModel(new String[] { "Afganistán", "Alemania", "Arabia Saudita",
                "Argentina", "Australia", "Bélgica", "Bolivia",
                "Brasil", "Camboya", "Canadá", "Chile", "China", "Colombia", "Corea", "Costa Rica", "Cuba", "Dinamarca",
                "Ecuador", "Egipto", "El Salvador", "Escocia", "España", "Estados Unidos",
                "Estonia", "Etiopia", "Filipinas", "Finlandia", "Francia", "Gales", "Grecia", "Guatemala", "Haití",
                "Holanda", "Honduras", "Indonesia", "Inglaterra", "Irak", "Irán", "Irlanda",
                "Israel", "Italia", "Japón", "Jordania", "Laos", "Letonia", "Lituania", "Malasia", "Marruecos",
                "México", "Nicaragua", "Noruega", "Nueva Zelanda", "Panamá", "Paraguay", "Perú",
                "Polonia", "Portugal", "Puerto Rico", "Republica Dominicana", "Rumania", "Rusia", "Suecia", "Suiza",
                "Tailandia", "Taiwán", "Turquía", "Ucrania", "Uruguay", "Venezuela", "Vietnam" }));
        cmb_Nacionalidad.setBounds(350, 240, 210, 18);
        contentPane.add(cmb_Nacionalidad);

        // 6 - JLabel Telefono
        JLabel JLabel_Telefono = new JLabel("TELEFONO: ");
        JLabel_Telefono.setFont(new Font("Arial", Font.BOLD, 14));
        JLabel_Telefono.setForeground(new Color(93, 173, 226));
        JLabel_Telefono.setBounds(350, 270, 150, 20);
        contentPane.add(JLabel_Telefono);

        txt_Telefono = new JTextField();
        txt_Telefono.setText("");
        txt_Telefono.setBorder(new LineBorder(Color.WHITE, 1));
        txt_Telefono.setHorizontalAlignment(SwingConstants.LEFT);
        txt_Telefono.setForeground(new Color(0, 0, 255));
        txt_Telefono.setBackground(new Color(255, 255, 255));
        txt_Telefono.setFont(new Font("Arial", Font.PLAIN, 14));
        txt_Telefono.setBounds(350, 290, 210, 18);
        txt_Telefono.setEnabled(true);
        contentPane.add(txt_Telefono);
        txt_Telefono.setColumns(10);

        // 6 - JLabel Numero de Reserva
        JLabel JLabel_NoReserva = new JLabel("NUMERO DE RESERVA: ");
        JLabel_NoReserva.setFont(new Font("Arial", Font.BOLD, 14));
        JLabel_NoReserva.setForeground(new Color(93, 173, 226));
        JLabel_NoReserva.setBounds(350, 320, 200, 20);
        contentPane.add(JLabel_NoReserva);

        txt_NoReserva = new JTextField();
        txt_NoReserva.setText("");
        txt_NoReserva.setBorder(new LineBorder(Color.WHITE, 1));
        txt_NoReserva.setHorizontalAlignment(SwingConstants.LEFT);
        txt_NoReserva.setForeground(new Color(0, 0, 255));
        txt_NoReserva.setBackground(new Color(255, 255, 255));
        txt_NoReserva.setFont(new Font("Arial", Font.PLAIN, 14));
        txt_NoReserva.setBounds(350, 340, 210, 18);
        txt_NoReserva.setEnabled(true);
        contentPane.add(txt_NoReserva);
        txt_NoReserva.setColumns(10);


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
        JButton boton_login = new JButton("GUARDAR");
        boton_login.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
        boton_login.setFont(new Font("Arial Narrow", Font.PLAIN, 18));
        boton_login.setForeground(new Color(255, 255, 255));
        boton_login.setBackground(new Color(93, 173, 226));
        boton_login.setBounds(470, 370, 100, 25);
        contentPane.add(boton_login);

        boton_login.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

            }
        });

        // 8 - Boton REGRESAR
        JButton boton_Regresar = new JButton("");
        ImageIcon iconoRegresar = new ImageIcon("src/images/atras.png", "Imagen Regresar");
        boton_Regresar.setIcon(iconoRegresar);
        boton_Regresar.setContentAreaFilled(false);
        boton_Regresar.setBorder(null);
        boton_Regresar.setFont(new Font("Arial Narrow", Font.BOLD, 18));
        
        boton_Regresar.setBackground(new Color(255, 255, 255,1));
        boton_Regresar.setBounds(5, 7, 22, 22);
        contentPane.add(boton_Regresar);

        boton_Regresar.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                RegistroReservas registroReservas = new RegistroReservas();
                registroReservas.setVisible(true);
                dispose();
                
            }
        });
       

        // 5 - Imagen azul lado Izquierdo
        JLabel JLabel_Logo3 = new JLabel("");
        JLabel_Logo3.setBounds(0, 0, 335, 430);
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
        g.setColor(Color.BLUE);
        g.drawLine(370, 55, 590, 55);
        g.drawLine(350, 105, 560, 105);
        g.drawLine(350, 160, 560, 160);
        g.drawLine(350, 311, 560, 311);
        g.drawLine(350, 360, 560, 360);
    }

}
