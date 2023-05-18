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

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

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

public class RegistroReservas extends javax.swing.JFrame {

    JDateChooser dateChooser1, dateChooser2;

    private JPanel contentPane;
    private JTextField txt_valor;
    private JComboBox cmb_pago;

    String Date1, Date2, valor, pago, pass, pago_string, user;
    int pagos_cmb, validacion = 0, Valor_Total = 0, ID = 0;

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

    public RegistroReservas() {

        user = Login.user;
        // 0 - PANEL
        {
            setResizable(false);
            setUndecorated(true);
            setBounds(0, 0, 630, 430);
            contentPane = new JPanel();
            contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
            setLocationRelativeTo(null);
            setContentPane(contentPane);
            contentPane.setLayout(null);
        }

        // 1- IMAGEN HOTEL ALURA
        {
            JLabel JLabel_LogoInicio = new JLabel("");
            JLabel_LogoInicio.setBounds(470, 30, 100, 100);
            contentPane.add(JLabel_LogoInicio);
            ImageIcon wallpaper_logoInicio = new ImageIcon("src/images/Ha-100px.png", "imagen de hotel alura");
            Icon icono_logoInicio = new ImageIcon(
                    wallpaper_logoInicio.getImage().getScaledInstance(JLabel_LogoInicio.getWidth(),
                            JLabel_LogoInicio.getHeight(), Image.SCALE_DEFAULT));
            JLabel_LogoInicio.setIcon(icono_logoInicio);
            this.repaint();
        }

        // 2- IMAGEN REGISTRO DE RESERVA
        {
            JLabel JLabel_Logo1 = new JLabel("");
            JLabel_Logo1.setBounds(395, 90, 230, 300);
            contentPane.add(JLabel_Logo1);
            ImageIcon wallpaper_logo1 = new ImageIcon("src/images/reservas-img-3.png", "imagen de Registro de reserva");
            Icon icono_logo1 = new ImageIcon(wallpaper_logo1.getImage().getScaledInstance(JLabel_Logo1.getWidth(),
                    JLabel_Logo1.getHeight(), Image.SCALE_DEFAULT));
            JLabel_Logo1.setIcon(icono_logo1);
            this.repaint();
        }

        // 3 - IMAGEN LOGO DE HOTEL ALURA
        {
            JLabel JLabel_Logo2 = new JLabel("");
            JLabel_Logo2.setBounds(10, 40, 48, 48);
            contentPane.add(JLabel_Logo2);
            ImageIcon wallpaper_logo2 = new ImageIcon("src/images/lOGO-50PX.png", "Logo de hotel alura");
            Icon icono_logo2 = new ImageIcon(wallpaper_logo2.getImage().getScaledInstance(JLabel_Logo2.getWidth(),
                    JLabel_Logo2.getHeight(), Image.SCALE_DEFAULT));
            JLabel_Logo2.setIcon(icono_logo2);
            this.repaint();
        }

        // 4 - JLABEL INICIO DE SESION
        {
            JLabel JLabel_nombreUsuario = new JLabel("REGISTRO DE RESERVA");
            JLabel_nombreUsuario.setFont(new Font("Arial", Font.BOLD, 18));
            JLabel_nombreUsuario.setForeground(new Color(93, 173, 226));
            JLabel_nombreUsuario.setBounds(70, 53, 250, 20);
            contentPane.add(JLabel_nombreUsuario);
        }

        // 5 -MENSAJE DE PIR DE PAGINA
        {
            JLabel JLabel_footer = new JLabel("Creado por Ing. Juan Ramón Perales ©");
            JLabel_footer.setBounds(250, 414, 490, 12);
            JLabel_footer.setFont(new Font("Arial", Font.BOLD, 9));
            JLabel_footer.setForeground(new Color(0, 0, 0));
            contentPane.add(JLabel_footer);
        }
        // 6 - IMAGEN DE PIE DE PAGINA AZUL
        {
            JLabel JLabel_Logo5 = new JLabel("");
            JLabel_Logo5.setBounds(0, 410, 730, 430);
            contentPane.add(JLabel_Logo5);
            ImageIcon wallpaper_logo5 = new ImageIcon("src/images/azul504.jpg", "Barra Azul");
            Icon icono_logo5 = new ImageIcon(wallpaper_logo5.getImage().getScaledInstance(JLabel_Logo5.getWidth(),
                    JLabel_Logo5.getHeight(), Image.SCALE_DEFAULT));
            JLabel_Logo5.setIcon(icono_logo5);
            this.repaint();
        }

        // 7 - JLABEL CHECK-IN
        {
            JLabel JLabel_Nombre = new JLabel("FECHA CHECK IN: ");
            JLabel_Nombre.setFont(new Font("Arial", Font.BOLD, 15));
            JLabel_Nombre.setForeground(new Color(93, 173, 226));
            JLabel_Nombre.setBounds(30, 110, 150, 20);
            contentPane.add(JLabel_Nombre);

            dateChooser1 = new JDateChooser(new Date());
            dateChooser1.setBounds(30, 130, 210, 20);
            dateChooser1.setFont(new Font("Arial", Font.PLAIN, 12));
            contentPane.add(dateChooser1);
        }

        // 8 - JLABEL CHECK OUT
        {
            JLabel JLabel_Apellido = new JLabel("FECHA CHECK OUT: ");
            JLabel_Apellido.setFont(new Font("Arial", Font.BOLD, 15));
            JLabel_Apellido.setForeground(new Color(93, 173, 226));
            JLabel_Apellido.setBounds(30, 160, 200, 20);
            contentPane.add(JLabel_Apellido);

            dateChooser2 = new JDateChooser(new Date());
            dateChooser2.setBounds(30, 179, 210, 20);
            dateChooser2.setFont(new Font("Arial", Font.PLAIN, 12));
            contentPane.add(dateChooser2);
        }

        // 9 - JLABEL VALOR RESERVA
        {
            JLabel JLabel_ApellidoMa = new JLabel("VALOR DE RESERVA: ");
            JLabel_ApellidoMa.setFont(new Font("Arial", Font.BOLD, 15));
            JLabel_ApellidoMa.setForeground(new Color(93, 173, 226));
            JLabel_ApellidoMa.setBounds(30, 210, 200, 20);
            contentPane.add(JLabel_ApellidoMa);

            txt_valor = new JTextField();
            txt_valor.setText("$" + Valor_Total);
            txt_valor.setBorder(new LineBorder(Color.blue, 1));
            txt_valor.setHorizontalAlignment(SwingConstants.LEFT);
            txt_valor.setForeground(new Color(0, 0, 255));
            txt_valor.setBackground(new Color(255, 255, 255));
            txt_valor.setFont(new Font("Arial", Font.PLAIN, 15));
            txt_valor.setBounds(30, 230, 210, 20);
            txt_valor.setEnabled(true);
            contentPane.add(txt_valor);
            txt_valor.setColumns(10);
        }

        // 10 - JLABEL FORMA DE PAGO
        {
            JLabel JLabel_Passsword = new JLabel("FORMA DE PAGO: ");
            JLabel_Passsword.setFont(new Font("Arial", Font.BOLD, 15));
            JLabel_Passsword.setForeground(new Color(93, 173, 226));
            JLabel_Passsword.setBounds(30, 260, 150, 20);
            contentPane.add(JLabel_Passsword);

            cmb_pago = new JComboBox();
            cmb_pago.setModel(new DefaultComboBoxModel(
                    new String[] { "Tarjeta Credito", "Tarjeta Dedito", "Trasferencia Bancaria", "PayPal" }));
            cmb_pago.setBounds(30, 280, 210, 20);
            contentPane.add(cmb_pago);
        }

        // 11 - BOTON SALIR-------------------------------------
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

        // 12 - BOTON REGRESAR--------------------------------------------
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

                    MenuUsuario menuUsuario = new MenuUsuario();
                    menuUsuario.setVisible(true);
                    dispose();

                }
            });
        }

        // 13 - BOTON CALCULAR ---------------------------
        {
            JButton boton_login = new JButton("CALCULAR");
            boton_login.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
            boton_login.setFont(new Font("Arial Narrow", Font.PLAIN, 18));
            boton_login.setForeground(new Color(255, 255, 255));
            boton_login.setBackground(new Color(93, 173, 226));
            boton_login.setBounds(20, 350, 100, 25);
            contentPane.add(boton_login);

            boton_login.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {

                    try {
                        Connection cn4 = Conexion.conectar();
                        PreparedStatement pst = cn4.prepareStatement(
                                "select id_usuario from usuarios where username = '" + user + "'");

                        ResultSet rs = pst.executeQuery();
                        while (rs.next()) {
                            ID = rs.getInt("id_usuario");
                            System.out.println("El Id es: " + ID);
                        }
                        cn4.close();
                    } catch (Exception e4) {
                        // TODO: handle exception
                    }

                    Calendar Calendario1 = dateChooser1.getCalendar();

                    String month1 = "", month2 = "";

                    int dia1 = Calendario1.get(Calendar.DATE);
                    int mes1 = Calendario1.get(Calendar.MONTH);
                    int year1 = Calendario1.get(Calendar.YEAR);

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

                    Calendar Calendario2 = dateChooser2.getCalendar();
                    int dia2 = Calendario2.get(Calendar.DATE);
                    int mes2 = Calendario2.get(Calendar.MONTH);
                    int year2 = Calendario2.get(Calendar.YEAR);

                    {
                        if (mes2 == 0) {
                            mes2 = 1;
                            if (mes2 == 1) {
                                month2 = Integer.toString(mes2);
                                month2 = "01";
                            }
                        } else if (mes2 == 1) {
                            mes2 = 2;
                            if (mes2 == 2) {
                                month2 = Integer.toString(mes2);
                                month2 = "02";
                            }
                        } else if (mes2 == 2) {
                            mes2 = 3;
                            if (mes2 == 3) {
                                month2 = Integer.toString(mes2);
                                month2 = "03";
                            }
                        } else if (mes2 == 3) {
                            mes2 = 4;
                            if (mes2 == 4) {
                                month2 = Integer.toString(mes2);
                                month2 = "04";
                            }
                        } else if (mes2 == 4) {
                            mes2 = 5;
                            if (mes2 == 5) {
                                month2 = Integer.toString(mes2);
                                month2 = "05";
                            }
                        } else if (mes2 == 5) {
                            mes2 = 6;
                            if (mes2 == 6) {
                                month2 = Integer.toString(mes2);
                                month2 = "06";
                            }
                        } else if (mes2 == 6) {
                            mes2 = 7;
                            if (mes2 == 7) {
                                month2 = Integer.toString(mes2);
                                month2 = "07";
                            }
                        } else if (mes2 == 7) {
                            mes2 = 8;
                            if (mes2 == 8) {
                                month2 = Integer.toString(mes2);
                                month2 = "08";
                            }
                        } else if (mes2 == 8) {
                            mes2 = 9;
                            if (mes2 == 9) {
                                month2 = Integer.toString(mes2);
                                month2 = "09";
                            }
                        } else if (mes2 == 9) {
                            mes2 = 10;
                            if (mes2 == 10) {
                                month2 = Integer.toString(mes2);
                            }
                        } else if (mes2 == 10) {
                            mes2 = 11;
                            if (mes2 == 11) {
                                month2 = Integer.toString(mes2);
                            }
                        } else {
                            mes2 = 12;
                            if (mes2 == 12) {
                                month2 = Integer.toString(mes2);
                            }
                        }
                    }

                    String day2 = Integer.toString(dia2);
                    String Year2 = Integer.toString(year2);
                    String fecha_IN = (Year1 + "-" + month1 + "-" + day1);
                    String fecha_OUT = (Year2 + "-" + month2 + "-" + day2);

                    LocalDate in_fecha = LocalDate.parse(fecha_IN);
                    LocalDate out_fecha = LocalDate.parse(fecha_OUT);
                    long NumerDay = ChronoUnit.DAYS.between(in_fecha, out_fecha);

                    int NoDias = (int) NumerDay;
                    int valorNoche = 730;
                    int valorTotal = (valorNoche * NoDias);
                    Valor_Total = valorTotal;
                    txt_valor.setText("$" + Valor_Total);
                    pagos_cmb = cmb_pago.getSelectedIndex() + 1;

                    {
                        if (pagos_cmb == 1) {
                            pago_string = "Tarjeta Credito";
                        } else if (pagos_cmb == 2) {
                            pago_string = "Tarjeta Debito";
                        } else if (pagos_cmb == 3) {
                            pago_string = "Trasferencia Bancaria";
                        } else if (pagos_cmb == 4) {
                            pago_string = "PayPal";
                        }
                    }

                    try {
                        Connection cn1 = Conexion.conectar();
                        PreparedStatement pst1 = cn1
                                .prepareStatement("insert into reservas values (?,?,?,?,?,?)");

                        pst1.setInt(1, 0);
                        pst1.setString(2, fecha_IN);
                        pst1.setString(3, fecha_OUT);
                        pst1.setInt(4, valorTotal);
                        pst1.setString(5, pago_string);
                        pst1.setInt(6, ID);

                        pst1.executeUpdate();
                        cn1.close();

                    } catch (SQLException e2) {
                        // TODO: handle exception
                        System.err.println("Error en Registrar usuario." + e2);
                        JOptionPane.showMessageDialog(null, "Error al registrar, contactar al administrador.");
                    }

                    if (Valor_Total == 0) {
                        JOptionPane.showMessageDialog(null, "Debes de Registrar tus fechas de ingreso y salida.");

                    }
                    if (Valor_Total < 0) {
                        JOptionPane.showMessageDialog(null, "Favor de verivicaar tus fechas.");
                    } else {
                        JOptionPane.showMessageDialog(null, "Calculo Realizado con Exito.");

                    }

                }
            });
        }

        // 14 - BOTON USUARIO ----------------------------------------------
        {
            JButton botton_Confirmar = new JButton("CONFIRMAR");
            botton_Confirmar.setBorder(null);
            botton_Confirmar.setFont(new Font("Arial Narrow", Font.PLAIN, 18));
            botton_Confirmar.setForeground(new Color(255, 255, 255));
            botton_Confirmar.setBackground(new Color(93, 173, 226));
            botton_Confirmar.setBounds(140, 350, 100, 25);
            botton_Confirmar.setIcon(new ImageIcon("src/images/images/addUser.png", " Agregar Usuario"));
            contentPane.add(botton_Confirmar);

            botton_Confirmar.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {

                    if (Valor_Total == 0) {
                        JOptionPane.showMessageDialog(null, "Debes de Registrar tus fechas de ingreso y salida.");

                    }
                    if (Valor_Total < 0) {
                        JOptionPane.showMessageDialog(null, "Favor de verivicaar tus fechas.");
                    } else {
                        RegistroHuesped registroHuesped = new RegistroHuesped();
                        registroHuesped.setVisible(true);
                        dispose();
                    }
                }
            });
        }

        // 15 - IMAGEN AZUL LADO IZQUIERDO
        {
            JLabel JLabel_Logo3 = new JLabel("");
            JLabel_Logo3.setBounds(375, 0, 375, 430);
            contentPane.add(JLabel_Logo3);
            ImageIcon wallpaper_logo3 = new ImageIcon("src/images/azul504.jpg", "Barra Azul Izquierda");
            Icon icono_logo3 = new ImageIcon(wallpaper_logo3.getImage().getScaledInstance(JLabel_Logo3.getWidth(),
                    JLabel_Logo3.getHeight(), Image.SCALE_DEFAULT));
            JLabel_Logo3.setIcon(icono_logo3);
            this.repaint();
        }

        // 16 - FONDO BLANCO
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

        g.setColor(Color.blue);
        g.drawLine(70, 76, 290, 76);
    }

}
