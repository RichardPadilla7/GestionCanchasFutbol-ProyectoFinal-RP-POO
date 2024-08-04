import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Administrador {
    public JButton btnAgregar;
    public JButton btnCanchas;
    public JButton btnHorarios;
    public JLabel TituloAdmin;
    public JLabel imgAdmin;
    public JPanel admin;
    public JFrame AdminsFrame;

    public Administrador(JFrame frameAdmin) {
        this.AdminsFrame = frameAdmin;

        btnAgregar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                AdminsFrame.dispose();

                JFrame agregarJugadorFrame = new JFrame("Agregar Clientes");
                agregarJugadorFrame.setContentPane(new AgregarJugador(agregarJugadorFrame, AdminsFrame).masjugador);
                agregarJugadorFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                agregarJugadorFrame.setSize(300, 300);
                agregarJugadorFrame.setLocationRelativeTo(null); // Centra la ventana en la pantalla
                agregarJugadorFrame.pack();
                agregarJugadorFrame.setVisible(true);
            }
        });


        btnCanchas.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                AdminsFrame.dispose();

                JFrame agregarCanchaFrame = new JFrame("Agregar Cancha");
                agregarCanchaFrame.setContentPane(new AgregarCancha(agregarCanchaFrame, AdminsFrame).canchaPanel);
                agregarCanchaFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                agregarCanchaFrame.setSize(300, 300);
                agregarCanchaFrame.setLocationRelativeTo(null); // Centra la ventana en la pantalla
                agregarCanchaFrame.pack();
                agregarCanchaFrame.setVisible(true);
            }
        });


        btnHorarios.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                AdminsFrame.dispose();

                JFrame agregarHorasFrame = new JFrame("Agregar Horarios");
                agregarHorasFrame.setContentPane(new AgregarHoras(agregarHorasFrame, AdminsFrame).horasPanel);
                agregarHorasFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                agregarHorasFrame.setSize(300, 300);
                agregarHorasFrame.setLocationRelativeTo(null); // Centra la ventana en la pantalla
                agregarHorasFrame.pack();
                agregarHorasFrame.setVisible(true);
            }
        });
    }
}
