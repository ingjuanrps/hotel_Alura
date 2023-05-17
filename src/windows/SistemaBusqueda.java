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
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
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
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.SwingConstants;
import javax.swing.border.BevelBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.border.SoftBevelBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JTextField;

import org.w3c.dom.Text;

import com.toedter.calendar.JDateChooser;

import hall.BotonSalir;
import hall.Conexion;

public class SistemaBusqueda extends javax.swing.JFrame {

    DefaultTableModel model = new DefaultTableModel();
    public static String user_update = "";

    private JTable Table_usuarios, Table_RESERVA, Table_BUSCAR;
    private JScrollPane scrollPane;

    private JComboBox cmb_equipo, cmb_Nacionalidad;

    JDateChooser dateChooser3;
    String reserva = "";
    private JPanel contentPane;
    private JTextField txt_Nombre, txt_Apellido, txt_Telefono, txt_NoReserva;
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

    public SistemaBusqueda() {

        // 0 - Panel
        setResizable(false);
        setUndecorated(true);
        setBounds(0, 0, 630, 430);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setLocationRelativeTo(null);
        setContentPane(contentPane);
        contentPane.setLayout(null);

        // 2 - Imagen logo de hotel alura
        JLabel JLabel_Logo2 = new JLabel("");
        JLabel_Logo2.setBounds(30, 10, 90, 90);
        contentPane.add(JLabel_Logo2);
        ImageIcon wallpaper_logo2 = new ImageIcon("src/images/aH-150px.png", "Logo de hotel alura");
        Icon icono_logo2 = new ImageIcon(wallpaper_logo2.getImage().getScaledInstance(JLabel_Logo2.getWidth(),
                JLabel_Logo2.getHeight(), Image.SCALE_DEFAULT));
        JLabel_Logo2.setIcon(icono_logo2);
        this.repaint();

        // 3 - Etiqueta Inicio de sesion
        JLabel JLabel_nombreUsuario = new JLabel("SISTEMA DE BÚSQUEDA");
        JLabel_nombreUsuario.setFont(new Font("Arial", Font.BOLD, 18));
        JLabel_nombreUsuario.setForeground(new Color(93, 173, 226));
        JLabel_nombreUsuario.setBounds(220, 45, 250, 20);
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
        // 2
        scrollPane = new JScrollPane();
        scrollPane.setBounds(5, 130, 620, 200);
        scrollPane.setEnabled(false);
        contentPane.add(scrollPane);

        // 3
        Table_usuarios = new JTable();
        Table_usuarios.setBounds(7, 133, 614, 193);
        Table_usuarios.setEnabled(false);
        contentPane.add(Table_usuarios);

        // 7 - Boton HUESPEDES
        JButton boton_Huespedes = new JButton("Huesped");
        ImageIcon iconoHuesped = new ImageIcon("src/images/icon-buscar.png", "Imagen Regresar");
        boton_Huespedes.setIcon(iconoHuesped);
        boton_Huespedes.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
        boton_Huespedes.setFont(new Font("Arial Narrow", Font.PLAIN, 18));
        boton_Huespedes.setForeground(new Color(255, 255, 255));
        boton_Huespedes.setBackground(new Color(93, 173, 226));
        boton_Huespedes.setBounds(5, 102, 100, 25);
        contentPane.add(boton_Huespedes);

        boton_Huespedes.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                model.setRowCount(0);
                model.setColumnCount(0);
                try {
                    Connection cn = Conexion.conectar();
                    PreparedStatement pst = cn.prepareStatement(
                            "select id_reservas,nombre_usuario, apellidos_usuario, fecha_entrada, fecha_salida, forma_pago ,valor  from registro_h A inner join reservas B on A.id_usuario = B.id_usuario");

                    ResultSet rs = pst.executeQuery();

                    Table_usuarios = new JTable(model);
                    Table_usuarios.setEnabled(true);
                    scrollPane.setViewportView(Table_usuarios);

                    model.addColumn("ID");
                    model.addColumn("NOMBRE");
                    model.addColumn("APELLIDOS");
                    model.addColumn("ENTRADA");
                    model.addColumn("SALIDA");
                    model.addColumn(" $ PAGO");
                    model.addColumn(" $ COSTO");
                    while (rs.next()) {
                        Object[] file = new Object[7];

                        for (int i = 0; i < 7; i++) {
                            file[i] = rs.getObject(i + 1);
                        }
                        model.addRow(file);
                    }

                    cn.close();

                } catch (SQLException e1) {
                    // TODO: handle exception
                    System.err.println("Error al llenar table" + e1);
                    JOptionPane.showMessageDialog(null, "Error al mostrar informacion, conectate con el administrador");

                }

                /*
                 * Table_usuarios.addMouseListener(new MouseAdapter() {
                 * 
                 * @Override // para sobre escribir metodos
                 * public void mouseClicked(MouseEvent e) {
                 * int fila_point = Table_usuarios.rowAtPoint(e.getPoint()); // para que
                 * seleccione la fila
                 * int columna_point = 1; // que se seleccione la columna 2
                 * 
                 * if (fila_point > -1) { // apartir de la fila 0
                 * user_update = (String) model.getValueAt(fila_point, columna_point);
                 * EditarRegistros editarRegistros = new EditarRegistros();
                 * editarRegistros.setVisible(true);
                 * dispose();
                 * 
                 * }
                 * }
                 * });
                 */

            }
        });

        // 7 - Boton RESERVA
        JButton boton_Reserva = new JButton("Rervas");
        ImageIcon iconoReserva = new ImageIcon("src/images/reservado.png", "Imagen Regresar");
        boton_Reserva.setIcon(iconoReserva);
        boton_Reserva.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
        boton_Reserva.setFont(new Font("Arial Narrow", Font.PLAIN, 18));
        boton_Reserva.setForeground(new Color(255, 255, 255));
        boton_Reserva.setBackground(new Color(93, 173, 226));
        boton_Reserva.setBounds(107, 102, 90, 25);
        contentPane.add(boton_Reserva);

        boton_Reserva.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                model.setRowCount(0);
                model.setColumnCount(0);

                try {
                    Connection cn = Conexion.conectar();
                    PreparedStatement pst = cn.prepareStatement(
                            "select * from reservas A inner join registro_h B on A.id_usuario = B.id_usuario");

                    ResultSet rs = pst.executeQuery();

                    Table_RESERVA = new JTable(model);
                    scrollPane.setViewportView(Table_RESERVA);

                    model.addColumn("No.");
                    model.addColumn("ENTRADA");
                    model.addColumn("SALIDA");
                    model.addColumn("$ COSTO");
                    model.addColumn("FORMA DE PAGO");
                    while (rs.next()) {
                        Object[] file = new Object[5];

                        for (int i = 0; i < 5; i++) {
                            file[i] = rs.getObject(i + 1);
                        }
                        model.addRow(file);
                    }
                    cn.close();

                } catch (SQLException e1) {
                    // TODO: handle exception
                    System.err.println("Error al llenar table" + e1);
                    JOptionPane.showMessageDialog(null, "Error al mostrar informacion, conectate con el administrador");

                }

                Table_usuarios.addMouseListener(new MouseAdapter() {
                    @Override // para sobre escribir metodos
                    public void mouseClicked(MouseEvent e) {
                        int fila_point = Table_usuarios.rowAtPoint(e.getPoint()); // para que seleccione la fila
                        int columna_point = 2; // que se seleccione la columna 2

                        if (fila_point > -1) { // apartir de la fila 0
                            user_update = (String) model.getValueAt(fila_point, columna_point);
                            JOptionPane.showMessageDialog(null, "SEGUIREMOS CON LA SIGUIENTE VENTANA");
                        }
                    }
                });

            }
        });

        // 7 - Boton BUSCAR
        txt_NoReserva = new JTextField();
        txt_NoReserva.setText("");
        txt_NoReserva.setBorder(new LineBorder(Color.BLUE, 1));
        txt_NoReserva.setHorizontalAlignment(SwingConstants.LEFT);
        txt_NoReserva.setForeground(new Color(0, 0, 255));
        txt_NoReserva.setBackground(new Color(255, 255, 255));
        txt_NoReserva.setFont(new Font("Arial", Font.PLAIN, 14));
        txt_NoReserva.setBounds(320, 102, 200, 25);
        txt_NoReserva.setEnabled(true);
        contentPane.add(txt_NoReserva);
        txt_NoReserva.setColumns(10);

        JButton boton_Buscar = new JButton("BUSCAR");
        boton_Buscar.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
        boton_Buscar.setFont(new Font("Arial Narrow", Font.PLAIN, 18));
        boton_Buscar.setForeground(new Color(255, 255, 255));
        boton_Buscar.setBackground(new Color(93, 173, 226));
        boton_Buscar.setBounds(523, 102, 100, 25);
        contentPane.add(boton_Buscar);

        boton_Buscar.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {

                model.setRowCount(0);
                model.setColumnCount(0);
                reserva = txt_NoReserva.getText().trim();
                try {
                    Connection cn = Conexion.conectar();
                    PreparedStatement pst = cn.prepareStatement(
                            "select No_reserva, fecha_entrada, fecha_salida, valor, nombre_usuario, apellidos_usuario, fecha_nacimiento from registro_h A inner join reservas B on A.No_reserva ='"
                                    + reserva + "'");

                    ResultSet rs = pst.executeQuery();

                    Table_BUSCAR = new JTable(model);
                    scrollPane.setViewportView(Table_BUSCAR);

                    model.addColumn("No. RESERVA");
                    model.addColumn("ENTRADA");
                    model.addColumn("SALIDA");
                    model.addColumn("VALOR");
                    model.addColumn("USUARIO");
                    model.addColumn("APELLIDOS");
                    model.addColumn("FECHA NACIMIENTO");

                    while (rs.next()) {
                        Object[] file = new Object[7];

                        for (int i = 0; i < 7; i++) {
                            file[i] = rs.getObject(i + 1);
                        }
                        model.addRow(file);
                    }
                    cn.close();

                } catch (SQLException e1) {
                    // TODO: handle exception
                    System.err.println("Error al llenar table" + e1);
                    JOptionPane.showMessageDialog(null, "Error al mostrar informacion, conectate con el administrador");

                }

                txt_NoReserva.setText("");
                Table_usuarios.addMouseListener(new MouseAdapter() {
                    @Override // para sobre escribir metodos
                    public void mouseClicked(MouseEvent e) {
                        int fila_point = Table_usuarios.rowAtPoint(e.getPoint()); // para que seleccione la fila
                        int columna_point = 2; // que se seleccione la columna 2

                        if (fila_point > -1) { // apartir de la fila 0
                            user_update = (String) model.getValueAt(fila_point, columna_point);
                            JOptionPane.showMessageDialog(null, "SEGUIREMOS CON LA SIGUIENTE VENTANA");
                        }
                    }
                });
            }
        });

        // 7 - Boton EDITAR
        JButton boton_Editar = new JButton("EDITAR");
        boton_Editar.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
        boton_Editar.setFont(new Font("Arial Narrow", Font.PLAIN, 18));
        boton_Editar.setForeground(new Color(255, 255, 255));
        boton_Editar.setBackground(new Color(93, 173, 226));
        boton_Editar.setBounds(390, 370, 100, 25);
        contentPane.add(boton_Editar);

        boton_Editar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Editar_table();
            }
        });

        // 7 - Boton ELIMINAR
        JButton boton_Eliminar = new JButton("ELIMINAR");
        boton_Eliminar.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
        boton_Eliminar.setFont(new Font("Arial Narrow", Font.PLAIN, 18));
        boton_Eliminar.setForeground(new Color(255, 255, 255));
        boton_Eliminar.setBackground(new Color(93, 173, 226));
        boton_Eliminar.setBounds(522, 370, 100, 25);
        contentPane.add(boton_Eliminar);

        boton_Eliminar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                model.setRowCount(0);
                model.setColumnCount(0);
            }
        });

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

                MenuUsuario menuUsuario = new MenuUsuario();
                menuUsuario.setVisible(true);
                dispose();

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

    public void Limpiar() {

        model.addColumn("No.");
        model.addColumn("ENTRADA");
        model.addColumn("SALIDA");
        model.addColumn("$ COSTO");
        model.addColumn("FORMA DE PAGO");

    }

    public void Editar_table() {
        int fila = Table_usuarios.getSelectedRow();

        int id = (int) Table_usuarios.getValueAt(fila, 0);
        String nom = Table_usuarios.getValueAt(fila, 1).toString();
        String ape = Table_usuarios.getValueAt(fila, 2).toString();
        String entr = Table_usuarios.getValueAt(fila, 3).toString();
        String sali = Table_usuarios.getValueAt(fila, 4).toString();
        String f_pago = Table_usuarios.getValueAt(fila, 5).toString();

        try {
            Connection cn = Conexion.conectar();
            PreparedStatement pst = cn.prepareStatement(
                    "UPDATE registro_h  SET nombre_usuario = '" + nom + "', apellidos_usuario = '" + ape
                            + "' WHERE id_reservas = '" + id + "'");

            pst.executeUpdate();
            cn.close();

            JOptionPane.showMessageDialog(null, "Edición Exitosa.");

        } catch (SQLException e1) {
            // TODO: handle exception
            System.err.println("Error al Actualizar table" + e1);
            JOptionPane.showMessageDialog(null, "Error al Editar TABLA, conectate con el administrador");

        }
    }
}
