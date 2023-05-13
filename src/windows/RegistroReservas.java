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

public class RegistroReservas extends javax.swing.JFrame {

    JDateChooser dateChooser1,dateChooser2;
    
    private JPanel contentPane;
    private JTextField txt_Nombre,txt_Apellido,txt_ApellidoMa;
    private JPasswordField txt_password;
    private JComboBox cmb_equipo, cmb_MArca;

    public void main(String[] args) {

        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    RegistroReservas frame = new RegistroReservas();
                    frame.setVisible(true);
                } catch (Exception e) {
                    // TODO: handle exception
                    e.printStackTrace();
                }
            }
        });

    }

    public RegistroReservas () {

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
        JLabel JLabel_LogoInicio = new JLabel("");
        JLabel_LogoInicio.setBounds(470, 30, 100, 100);
        contentPane.add(JLabel_LogoInicio);
        ImageIcon wallpaper_logoInicio = new ImageIcon("src/images/Ha-100px.png", "imagen de hotel alura");
        Icon icono_logoInicio = new ImageIcon(wallpaper_logoInicio.getImage().getScaledInstance(JLabel_LogoInicio.getWidth(),
                JLabel_LogoInicio.getHeight(), Image.SCALE_DEFAULT));
        JLabel_LogoInicio.setIcon(icono_logoInicio);
        this.repaint();

        // 1- imagen Registro de reserva
        JLabel JLabel_Logo1 = new JLabel("");
        JLabel_Logo1.setBounds(395, 90, 230, 300);
        contentPane.add(JLabel_Logo1);
        ImageIcon wallpaper_logo1 = new ImageIcon("src/images/reservas-img-3.png", "imagen de Registro de reserva");
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
        JLabel JLabel_nombreUsuario = new JLabel("REGISTRO DE RESERVA");
        JLabel_nombreUsuario.setFont(new Font("Arial", Font.BOLD, 18));
        JLabel_nombreUsuario.setForeground(new Color(93, 173, 226));
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
        JLabel JLabel_Nombre = new JLabel("FECHA CHECK IN: ");
        JLabel_Nombre.setFont(new Font("Arial", Font.BOLD, 15));
        JLabel_Nombre.setForeground(new Color(93, 173, 226));
        JLabel_Nombre.setBounds(30, 110, 150, 20);
        contentPane.add(JLabel_Nombre);

        dateChooser1 = new JDateChooser(new Date());
        dateChooser1.setBounds(30, 130, 210, 20);
        dateChooser1.setFont(new Font("Arial", Font.PLAIN, 12));
        contentPane.add(dateChooser1);
        
        

       

        // 6 - JLabel Usuario
        JLabel JLabel_Apellido = new JLabel("FECHA CHECK OUT: ");
        JLabel_Apellido.setFont(new Font("Arial", Font.BOLD, 15));
        JLabel_Apellido.setForeground(new Color(93, 173, 226));
        JLabel_Apellido.setBounds(30, 160, 200, 20);
        contentPane.add(JLabel_Apellido);

        dateChooser2 = new JDateChooser(new Date());
        dateChooser2.setBounds(30, 179, 210, 20);
        dateChooser2.setFont(new Font("Arial", Font.PLAIN, 12));
        contentPane.add(dateChooser2);

       
            
        
        // 6 - JLabel Usuario
        JLabel JLabel_ApellidoMa = new JLabel("VALOR DE RESERVA: ");
        JLabel_ApellidoMa.setFont(new Font("Arial", Font.BOLD, 15));
        JLabel_ApellidoMa.setForeground(new Color(93, 173, 226));
        JLabel_ApellidoMa.setBounds(30, 210, 200, 20);
        contentPane.add(JLabel_ApellidoMa);

        Calendar Calendario1 = dateChooser1.getCalendar();
        int dia1 = Calendario1.get(Calendar.DATE);
        int mes1 = Calendario1.get(Calendar.MONTH);
        int year1 = Calendario1.get(Calendar.YEAR);
        System.out.println("Dia" + dia1);
        System.out.println("Dia" + mes1);
        System.out.println("Dia" + year1);

        Calendar Calendario2 = dateChooser2.getCalendar();
        int dia2 = Calendario2.get(Calendar.DATE);
        int mes2 = Calendario2.get(Calendar.MONTH);
        int year2 = Calendario2.get(Calendar.YEAR);
        System.out.println("Dia" + dia2);
        System.out.println("Dia" + mes2);
        System.out.println("Dia" + year2);

        int valorNoche = 1230;
        int valorTotal;
        valorTotal = (dia2 -dia1)+ (mes2-mes1) + (year2-year1);
        System.out.println(valorTotal);

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

        

        // 6 - Usuario
        JLabel JLabel_Passsword = new JLabel("FORMA DE PAGO: ");
        JLabel_Passsword.setFont(new Font("Arial", Font.BOLD, 15));
        JLabel_Passsword.setForeground(new Color(93, 173, 226));
        JLabel_Passsword.setBounds(30, 260, 150, 20);
        contentPane.add(JLabel_Passsword);

        cmb_MArca = new JComboBox();
        cmb_MArca.setModel(new DefaultComboBoxModel(new String[] { "Tarjeta Credito", "Tarjeta Dedito", "Trasferencia Bancaria", "PayPal" }));
        cmb_MArca.setBounds(30, 280, 210, 20);
        contentPane.add(cmb_MArca);

       

        

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

                MenuUsuario menuUsuario = new MenuUsuario();
                menuUsuario.setVisible(true);
                dispose();
                
            }
        });
        // 7 - Boton Registrar
        JButton boton_login = new JButton("REGISTRAR");
        boton_login.setBorder(BorderFactory.createEmptyBorder(5,5, 5, 5));
        boton_login.setFont(new Font("Arial Narrow", Font.PLAIN, 18));
        boton_login.setForeground(new Color(255, 255, 255));
        boton_login.setBackground(new Color(93, 173, 226));
        boton_login.setBounds(140, 350, 100, 25);
        contentPane.add(boton_login);

        boton_login.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                RegistroHuesped registroHuesped = new RegistroHuesped();
                registroHuesped.setVisible(true);
                dispose();
                
              
                
            }
        });

       

        // 5 - Imagen azul lado Izquierdo
        JLabel JLabel_Logo3 = new JLabel("");
        JLabel_Logo3.setBounds(375, 0, 375, 430);
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

        g.setColor(Color.blue);
        g.drawLine(70, 76, 290, 76);
    }
    
}
