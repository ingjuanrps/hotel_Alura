package windows;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
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
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

import com.toedter.calendar.JDateChooser;

import hall.Conexion;

public class RegistroHuesped extends javax.swing.JFrame {

    String Date1, Date2, valor, pago, pass, pago_string, user, nombre_Usuario = "", PrimerApellido = "",
            SegundoApellido = "", Apellidos = "", reserva1 = "", fecha_IN = "";
    int nacion_cmb, validacion = 0, Valor_Total = 0, Reserva_idUsuario, Reserva_idReserva, reserva = 0;

    private JComboBox cmb_Nacionalidad;

    JDateChooser dateChooser3;

    private JPanel contentPane;
    private JTextField txt_Nombre, txt_Apellido, txt_Telefono, txt_NoReserva;

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

        user = Login.user;

        // 0 - PENEL
        {
            setResizable(false);
            setUndecorated(true);
            setBounds(0, 0, 630, 430);
            contentPane = new JPanel();
            contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
            setLocationRelativeTo(null);
            setContentPane(contentPane);
            contentPane.setLayout(null);

            try {
                Connection cn5 = Conexion.conectar();
                PreparedStatement pst5 = cn5.prepareStatement(
                        "select id_usuario, id_reserva from reservas where id_reserva = id_reserva");

                ResultSet rs5 = pst5.executeQuery();
                while (rs5.next()) {
                    Reserva_idUsuario = rs5.getInt("id_usuario");
                    Reserva_idReserva = rs5.getInt("id_reserva");
                }
                cn5.close();
            } catch (Exception e5) {
                // TODO: handle exception
                System.err.println("Error al obtener ids de reservas." + e5);
            }

            try {
                Connection cn4 = Conexion.conectar();
                PreparedStatement pst = cn4.prepareStatement(
                        "select nombre_usuario, primer_apellido, segundo_apellido from usuarios where username = '"
                                + user + "'");

                ResultSet rs = pst.executeQuery();
                while (rs.next()) {
                    nombre_Usuario = rs.getString("nombre_usuario");
                    PrimerApellido = rs.getString("primer_apellido");
                    SegundoApellido = rs.getString("segundo_apellido");

                    System.out.println("El Id es: " + nombre_Usuario);
                }
                cn4.close();
            } catch (Exception e4) {
                // TODO: handle exception
                System.err.println("Error al obtenre datos de usuario." + e4);
            }
            Apellidos = PrimerApellido + " " + SegundoApellido + ".";

        }

        // 1- IMAGEN DE USUARIO REGISTRANDOSE
        {
            JLabel JLabel_Logo1 = new JLabel("");
            JLabel_Logo1.setBounds(40, 75, 230, 300);
            contentPane.add(JLabel_Logo1);
            ImageIcon wallpaper_logo1 = new ImageIcon("src/images/registro.png", "imagen de usuario registrandose");
            Icon icono_logo1 = new ImageIcon(wallpaper_logo1.getImage().getScaledInstance(JLabel_Logo1.getWidth(),
                    JLabel_Logo1.getHeight(), Image.SCALE_DEFAULT));
            JLabel_Logo1.setIcon(icono_logo1);
            this.repaint();
        }

        // 2 - LOGO HOTEL ALURA
        {
            JLabel JLabel_Logo2 = new JLabel("");
            JLabel_Logo2.setBounds(130, 20, 60, 60);
            contentPane.add(JLabel_Logo2);
            ImageIcon wallpaper_logo2 = new ImageIcon("src/images/aH-150px.png", "Logo de hotel alura");
            Icon icono_logo2 = new ImageIcon(wallpaper_logo2.getImage().getScaledInstance(JLabel_Logo2.getWidth(),
                    JLabel_Logo2.getHeight(), Image.SCALE_DEFAULT));
            JLabel_Logo2.setIcon(icono_logo2);
            this.repaint();
        }

        // 3 - TITULO REGISTRO DE HUESPED
        {
            JLabel JLabel_nombreUsuario = new JLabel("REGISTRO DE HUESPED");
            JLabel_nombreUsuario.setFont(new Font("Arial", Font.BOLD, 18));
            JLabel_nombreUsuario.setForeground(new Color(93, 173, 226));
            JLabel_nombreUsuario.setBounds(370, 33, 250, 20);
            contentPane.add(JLabel_nombreUsuario);
        }

        // 4 - MENSAJE PIE DE PAGINA
        {
            JLabel JLabel_footer = new JLabel("Creado por Ing. Juan Ramón Perales ©");
            JLabel_footer.setBounds(250, 414, 490, 12);
            JLabel_footer.setFont(new Font("Arial", Font.BOLD, 9));
            JLabel_footer.setForeground(new Color(0, 0, 0));
            contentPane.add(JLabel_footer);
            // Imagen pie de pagina azul
            JLabel JLabel_Logo5 = new JLabel("");
            JLabel_Logo5.setBounds(0, 410, 730, 430);
            contentPane.add(JLabel_Logo5);
            ImageIcon wallpaper_logo5 = new ImageIcon("src/images/azul504.jpg", "Barra Azul");
            Icon icono_logo5 = new ImageIcon(wallpaper_logo5.getImage().getScaledInstance(JLabel_Logo5.getWidth(),
                    JLabel_Logo5.getHeight(), Image.SCALE_DEFAULT));
            JLabel_Logo5.setIcon(icono_logo5);
            this.repaint();
        }

        // 5 - NOMBRE(S)
        {
            JLabel JLabel_Nombre = new JLabel("NOMBRE(S): ");
            JLabel_Nombre.setFont(new Font("Arial", Font.BOLD, 14));
            JLabel_Nombre.setForeground(new Color(93, 173, 226));
            JLabel_Nombre.setBounds(350, 70, 150, 12);
            contentPane.add(JLabel_Nombre);

            txt_Nombre = new JTextField();
            txt_Nombre.setText(nombre_Usuario);
            txt_Nombre.setBorder(new LineBorder(Color.WHITE, 1));
            txt_Nombre.setHorizontalAlignment(SwingConstants.LEFT);
            txt_Nombre.setForeground(new Color(0, 0, 255));
            txt_Nombre.setBackground(new Color(255, 255, 255));
            txt_Nombre.setFont(new Font("Arial", Font.PLAIN, 14));
            txt_Nombre.setBounds(350, 85, 210, 18);
            txt_Nombre.setEnabled(false);
            contentPane.add(txt_Nombre);
            txt_Nombre.setColumns(10);
        }

        // 6 - APELLIDOS
        {
            JLabel JLabel_Apellido = new JLabel("APELLIDOS: ");
            JLabel_Apellido.setFont(new Font("Arial", Font.BOLD, 14));
            JLabel_Apellido.setForeground(new Color(93, 173, 226));
            JLabel_Apellido.setBounds(350, 120, 150, 12);
            contentPane.add(JLabel_Apellido);

            txt_Apellido = new JTextField();
            txt_Apellido.setText(Apellidos);
            txt_Apellido.setBorder(new LineBorder(Color.WHITE, 1));
            txt_Apellido.setHorizontalAlignment(SwingConstants.LEFT);
            txt_Apellido.setForeground(new Color(0, 0, 255));
            txt_Apellido.setBackground(new Color(255, 255, 255));
            txt_Apellido.setFont(new Font("Arial", Font.PLAIN, 14));
            txt_Apellido.setBounds(350, 140, 210, 18);
            txt_Apellido.setEnabled(false);
            contentPane.add(txt_Apellido);
            txt_Apellido.setColumns(10);
        }

        // 7 - FECHA DE NACIMINETO
        {
            JLabel JLabel_ApellidoMa = new JLabel("FECHA DE NACIMIENTO: ");
            JLabel_ApellidoMa.setFont(new Font("Arial", Font.BOLD, 14));
            JLabel_ApellidoMa.setForeground(new Color(93, 173, 226));
            JLabel_ApellidoMa.setBounds(350, 170, 200, 12);// 20
            contentPane.add(JLabel_ApellidoMa);

            dateChooser3 = new JDateChooser(new Date());
            dateChooser3.setBounds(350, 190, 210, 20);
            dateChooser3.setFont(new Font("Arial", Font.PLAIN, 12));
            contentPane.add(dateChooser3);

        }

        // 8 - NACIONALIDAD
        {
            JLabel JLabel_Passsword = new JLabel("NACIONALIDAD: ");
            JLabel_Passsword.setFont(new Font("Arial", Font.BOLD, 14));
            JLabel_Passsword.setForeground(new Color(93, 173, 226));
            JLabel_Passsword.setBounds(350, 220, 150, 20);
            contentPane.add(JLabel_Passsword);

            cmb_Nacionalidad = new JComboBox();
            cmb_Nacionalidad.setModel(new DefaultComboBoxModel(new String[] { "Afganistán", "Alemania",
                    "Arabia Saudita",
                    "Argentina", "Australia", "Bélgica", "Bolivia",
                    "Brasil", "Camboya", "Canadá", "Chile", "China", "Colombia", "Corea", "Costa Rica", "Cuba",
                    "Dinamarca",
                    "Ecuador", "Egipto", "El Salvador", "Escocia", "España", "Estados Unidos",
                    "Estonia", "Etiopia", "Filipinas", "Finlandia", "Francia", "Gales", "Grecia", "Guatemala", "Haití",
                    "Holanda", "Honduras", "Indonesia", "Inglaterra", "Irak", "Irán", "Irlanda",
                    "Israel", "Italia", "Japón", "Jordania", "Laos", "Letonia", "Lituania", "Malasia", "Marruecos",
                    "México", "Nicaragua", "Noruega", "Nueva Zelanda", "Panamá", "Paraguay", "Perú",
                    "Polonia", "Portugal", "Puerto Rico", "Republica Dominicana", "Rumania", "Rusia", "Suecia", "Suiza",
                    "Tailandia", "Taiwán", "Turquía", "Ucrania", "Uruguay", "Venezuela", "Vietnam" }));
            cmb_Nacionalidad.setBounds(350, 240, 210, 18);
            contentPane.add(cmb_Nacionalidad);
        }

        // 9 - TELEFONO
        {
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
        }

        // 10 - BOTON CERRAR ----------------------------
        {
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
        }

        // 11 - BOTON GUARDAR -----------------------------
        {
            JButton boton_login = new JButton("GUARDAR");
            boton_login.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
            boton_login.setFont(new Font("Arial Narrow", Font.PLAIN, 18));
            boton_login.setForeground(new Color(255, 255, 255));
            boton_login.setBackground(new Color(93, 173, 226));
            boton_login.setBounds(470, 370, 100, 25);
            contentPane.add(boton_login);

            boton_login.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {

                    String Telefono = txt_Telefono.getText().trim();

                    Calendar Calendario3 = dateChooser3.getCalendar();
                    String month1 = "";

                    int dia1 = Calendario3.get(Calendar.DATE);
                    int mes1 = Calendario3.get(Calendar.MONTH);
                    int year1 = Calendario3.get(Calendar.YEAR);

                    {

                        if (mes1 == 0) {
                            mes1 = 1;
                            if (mes1 == 1) {
                                month1 = Integer.toString(mes1);
                                month1 = "01";
                            }
                        } else if (mes1 == 1) {
                            mes1 = 2;
                            if (mes1 == 2) {
                                month1 = Integer.toString(mes1);
                                month1 = "02";
                            }
                        } else if (mes1 == 2) {
                            mes1 = 3;
                            if (mes1 == 3) {
                                month1 = Integer.toString(mes1);
                                month1 = "03";
                            }
                        } else if (mes1 == 3) {
                            mes1 = 4;
                            if (mes1 == 4) {
                                month1 = Integer.toString(mes1);
                                month1 = "04";
                            }
                        } else if (mes1 == 4) {
                            mes1 = 5;
                            if (mes1 == 5) {
                                month1 = Integer.toString(mes1);
                                month1 = "05";
                            }
                        } else if (mes1 == 5) {
                            mes1 = 6;
                            if (mes1 == 6) {
                                month1 = Integer.toString(mes1);
                                month1 = "06";
                            }
                        } else if (mes1 == 6) {
                            mes1 = 7;
                            if (mes1 == 7) {
                                month1 = Integer.toString(mes1);
                                month1 = "07";
                            }
                        } else if (mes1 == 7) {
                            mes1 = 8;
                            if (mes1 == 8) {
                                month1 = Integer.toString(mes1);
                                month1 = "08";
                            }
                        } else if (mes1 == 8) {
                            mes1 = 9;
                            if (mes1 == 9) {
                                month1 = Integer.toString(mes1);
                                month1 = "09";
                            }
                        } else if (mes1 == 9) {
                            mes1 = 10;
                            if (mes1 == 10) {
                                month1 = Integer.toString(mes1);
                            }
                        } else if (mes1 == 10) {
                            mes1 = 11;
                            if (mes1 == 11) {
                                month1 = Integer.toString(mes1);
                            }
                        } else {
                            mes1 = 12;
                            if (mes1 == 12) {
                                month1 = Integer.toString(mes1);
                            }
                        }
                    }

                    String day1 = Integer.toString(dia1);
                    String Year1 = Integer.toString(year1);

                    fecha_IN = (Year1 + "-" + month1 + "-" + day1);
                    reserva = ((year1 - 2000) + (mes1 + 1) + dia1 + Reserva_idUsuario + Reserva_idReserva);
                    nacion_cmb = cmb_Nacionalidad.getSelectedIndex() + 1;

                    {

                        if (nacion_cmb == 1) {
                            pago_string = "Afganistán";
                        } else if (nacion_cmb == 2) {
                            pago_string = "Alemania";
                        } else if (nacion_cmb == 3) {
                            pago_string = "Arabia Saudita";
                        } else if (nacion_cmb == 4) {
                            pago_string = "Argentina";
                        } else if (nacion_cmb == 5) {
                            pago_string = "Australia";
                        } else if (nacion_cmb == 6) {
                            pago_string = "Bélgica";
                        } else if (nacion_cmb == 7) {
                            pago_string = "Bolivia";
                        } else if (nacion_cmb == 8) {
                            pago_string = "Brasil";
                        } else if (nacion_cmb == 9) {
                            pago_string = "Camboya";
                        } else if (nacion_cmb == 10) {
                            pago_string = "Canadá";
                        } else if (nacion_cmb == 11) {
                            pago_string = "Chile";
                        } else if (nacion_cmb == 12) {
                            pago_string = "China";
                        } else if (nacion_cmb == 13) {
                            pago_string = "Colombia";
                        } else if (nacion_cmb == 14) {
                            pago_string = "Corea";
                        } else if (nacion_cmb == 15) {
                            pago_string = "Costa Rica";
                        } else if (nacion_cmb == 16) {
                            pago_string = "Cuba";
                        } else if (nacion_cmb == 17) {
                            pago_string = "Dinamarca";
                        } else if (nacion_cmb == 18) {
                            pago_string = "Ecuador";
                        } else if (nacion_cmb == 19) {
                            pago_string = "Egipto";
                        } else if (nacion_cmb == 20) {
                            pago_string = "El Salvador";
                        } else if (nacion_cmb == 21) {
                            pago_string = "Escocia";
                        } else if (nacion_cmb == 22) {
                            pago_string = "España";
                        } else if (nacion_cmb == 23) {
                            pago_string = "Estados Unidos";
                        } else if (nacion_cmb == 24) {
                            pago_string = "Estonia";
                        } else if (nacion_cmb == 25) {
                            pago_string = "Etiopia";
                        } else if (nacion_cmb == 26) {
                            pago_string = "Filipinas";
                        } else if (nacion_cmb == 27) {
                            pago_string = "Finlandia";
                        } else if (nacion_cmb == 28) {
                            pago_string = "Francia";
                        } else if (nacion_cmb == 29) {
                            pago_string = "Gales";
                        } else if (nacion_cmb == 30) {
                            pago_string = "Grecia";
                        } else if (nacion_cmb == 31) {
                            pago_string = "Guatemala";
                        } else if (nacion_cmb == 32) {
                            pago_string = "Haití";
                        } else if (nacion_cmb == 33) {
                            pago_string = "Holanda";
                        } else if (nacion_cmb == 34) {
                            pago_string = "Honduras";
                        } else if (nacion_cmb == 35) {
                            pago_string = "Indonesia";
                        } else if (nacion_cmb == 36) {
                            pago_string = "Inglaterra";
                        } else if (nacion_cmb == 37) {
                            pago_string = "Irak";
                        } else if (nacion_cmb == 38) {
                            pago_string = "Irán";
                        } else if (nacion_cmb == 39) {
                            pago_string = "Irlanda";
                        } else if (nacion_cmb == 40) {
                            pago_string = "Israel";
                        } else if (nacion_cmb == 41) {
                            pago_string = "Italia";
                        } else if (nacion_cmb == 42) {
                            pago_string = "Japón";
                        } else if (nacion_cmb == 43) {
                            pago_string = "Jordania";
                        } else if (nacion_cmb == 44) {
                            pago_string = "Laos";
                        } else if (nacion_cmb == 45) {
                            pago_string = "Letonia";
                        } else if (nacion_cmb == 46) {
                            pago_string = "Lituania";
                        } else if (nacion_cmb == 47) {
                            pago_string = "Malasia";
                        } else if (nacion_cmb == 48) {
                            pago_string = "Marruecos";
                        } else if (nacion_cmb == 49) {
                            pago_string = "México";
                        } else if (nacion_cmb == 50) {
                            pago_string = "Nicaragua";
                        } else if (nacion_cmb == 51) {
                            pago_string = "Noruega";
                        } else if (nacion_cmb == 52) {
                            pago_string = "Nueva Zelanda";
                        } else if (nacion_cmb == 53) {
                            pago_string = "Panamá";
                        } else if (nacion_cmb == 54) {
                            pago_string = "Paraguay";
                        } else if (nacion_cmb == 55) {
                            pago_string = "Perú";
                        } else if (nacion_cmb == 56) {
                            pago_string = "Polonia";
                        } else if (nacion_cmb == 57) {
                            pago_string = "Portugal";
                        } else if (nacion_cmb == 58) {
                            pago_string = "Puerto Rico";
                        } else if (nacion_cmb == 59) {
                            pago_string = "Republica Dominicana";
                        } else if (nacion_cmb == 60) {
                            pago_string = "Rumania";
                        } else if (nacion_cmb == 61) {
                            pago_string = "Rusia";
                        } else if (nacion_cmb == 62) {
                            pago_string = "Suecia";
                        } else if (nacion_cmb == 63) {
                            pago_string = "Suiza";
                        } else if (nacion_cmb == 64) {
                            pago_string = "Tailandia";
                        } else if (nacion_cmb == 65) {
                            pago_string = "Taiwán";
                        } else if (nacion_cmb == 66) {
                            pago_string = "Turquía";
                        } else if (nacion_cmb == 67) {
                            pago_string = "Ucrania";
                        } else if (nacion_cmb == 68) {
                            pago_string = "Uruguay";
                        } else if (nacion_cmb == 69) {
                            pago_string = "Venezuela";
                        } else if (nacion_cmb == 70) {
                            pago_string = "Vietnam";
                        }

                    }

                    try {
                        Connection cn1 = Conexion.conectar();
                        PreparedStatement pst1 = cn1
                                .prepareStatement("insert into registro_h values (?,?,?,?,?,?,?,?,?)");
                        System.out.println("VOY A REGISTRAR DATOS");
                        pst1.setInt(1, 0);
                        System.out.println("VOY A REGISTRAR ID REGISTRO");
                        pst1.setInt(2, Reserva_idReserva);
                        System.out.println("VOY A REGISTRAR ID RESERVAS");
                        pst1.setString(3, nombre_Usuario);
                        System.out.println("VOY A REGISTRAR NOMBRE");
                        pst1.setString(4, Apellidos);
                        System.out.println("VOY A REGISTRAR APELLIDOS");
                        pst1.setString(5, fecha_IN);
                        System.out.println("VOY A REGISTRAR FECHA");
                        pst1.setInt(6, nacion_cmb);
                        System.out.println("VOY A REGISTRAR NACION");
                        pst1.setString(7, Telefono);
                        System.out.println("VOY A REGISTRAR TELEFONO");
                        pst1.setInt(8, reserva);
                        System.out.println("VOY A REGISTRAR RESERVA");

                        pst1.setInt(9, Reserva_idUsuario);

                        pst1.executeUpdate();
                        cn1.close();

                        JOptionPane.showMessageDialog(null, "Registro Exitoso");
                        reserva1 = Integer.toString(reserva);
                    } catch (SQLException e2) {
                        // TODO: handle exception
                        System.err.println("Error en Registrar REGISTRO." + e2);
                        JOptionPane.showMessageDialog(null, "Error al registrar, contactar al administrador.");
                    }

                    JOptionPane.showMessageDialog(null, "Su número de Reserva es: " + reserva1);

                    int result = JOptionPane.showConfirmDialog(null, "¿Desea continuar Dentro de la App?",
                            "Salir de la App",
                            JOptionPane.YES_NO_OPTION,
                            JOptionPane.QUESTION_MESSAGE);

                    if (result == JOptionPane.YES_OPTION) {
                        MenuUsuario menuUsuario = new MenuUsuario();
                        menuUsuario.setVisible(true);

                    } else {
                        System.exit(0);
                    }

                }
            });
        }

        // 12 - NUMERO DE RESERVA
        {
            JLabel JLabel_NoReserva = new JLabel("NUMERO DE RESERVA: ");
            JLabel_NoReserva.setFont(new Font("Arial", Font.BOLD, 14));
            JLabel_NoReserva.setForeground(new Color(93, 173, 226));
            JLabel_NoReserva.setBounds(350, 320, 200, 20);
            contentPane.add(JLabel_NoReserva);

            txt_NoReserva = new JTextField();
            txt_NoReserva.setText(reserva1);
            txt_NoReserva.setBorder(new LineBorder(Color.WHITE, 1));
            txt_NoReserva.setHorizontalAlignment(SwingConstants.LEFT);
            txt_NoReserva.setForeground(new Color(0, 0, 255));
            txt_NoReserva.setBackground(new Color(255, 255, 255));
            txt_NoReserva.setFont(new Font("Arial", Font.PLAIN, 14));
            txt_NoReserva.setBounds(350, 340, 210, 18);
            txt_NoReserva.setEnabled(true);
            contentPane.add(txt_NoReserva);
            txt_NoReserva.setColumns(10);
        }

        // 13 - BOTON REGRESAR -----------------------------------
        {
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
                    RegistroReservas registroReservas = new RegistroReservas();
                    registroReservas.setVisible(true);
                    dispose();

                }
            });
        }

        // 14 - IMAGEN AZUL LADO
        {
            JLabel JLabel_Logo3 = new JLabel("");
            JLabel_Logo3.setBounds(0, 0, 335, 430);
            contentPane.add(JLabel_Logo3);
            ImageIcon wallpaper_logo3 = new ImageIcon("src/images/azul504.jpg", "Barra Azul Izquierda");
            Icon icono_logo3 = new ImageIcon(wallpaper_logo3.getImage().getScaledInstance(JLabel_Logo3.getWidth(),
                    JLabel_Logo3.getHeight(), Image.SCALE_DEFAULT));
            JLabel_Logo3.setIcon(icono_logo3);
            this.repaint();
        }

        // 15 - FONDO BLANCO
        {
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
