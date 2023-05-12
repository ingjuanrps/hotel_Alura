package hall;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class BotonSalir {

    private JPanel contentPane;
    
    public BotonSalir () {

        JButton botonSalir = new JButton(" X ");
        botonSalir.setBorder(null);
        botonSalir.setFont(new Font("Arial Narrow", Font.BOLD, 18));
        botonSalir.setForeground(new Color(255, 255, 255));
        botonSalir.setBackground(new Color(6, 130, 247));
        botonSalir.setBounds(703, 7, 20, 20);
        contentPane.add(botonSalir);

        botonSalir.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                int result = JOptionPane.showConfirmDialog(null,"¿Seguro que deseas salir?", "Confirmar Salida",
               JOptionPane.YES_NO_OPTION,
               JOptionPane.QUESTION_MESSAGE);
                

                if (result == JOptionPane.YES_OPTION) {
                    System.exit(0);
                }
            }
        });
    }
}
