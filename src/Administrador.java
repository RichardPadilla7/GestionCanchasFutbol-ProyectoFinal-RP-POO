import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Administrador {
    public JButton btnAgregar;
    public JButton btnCanchas;
    public JButton btnHorarios;
    private JLabel TituloAdmin;
    private JLabel imgAdmin;
    public JPanel admin;
    public JFrame AdminsFrame;

    public Administrador(JFrame frameAdmin) {
        this.AdminsFrame = frameAdmin;

        btnAgregar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                AdminsFrame.dispose();

                JFrame adminFrame = new JFrame("Agregar Jugador");
                adminFrame.setContentPane(new AgregarJugador(AdminsFrame).masjugador);
                adminFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                adminFrame.setSize(900, 600);
                adminFrame.pack();
                adminFrame.setVisible(true);

            }
        });

        btnCanchas.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                AdminsFrame.dispose();

                JFrame adminFrame = new JFrame("Agregar Cancha");
                adminFrame.setContentPane(new AgregarCancha(AdminsFrame).canchaPanel);
                adminFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                adminFrame.setSize(900, 600);
                adminFrame.pack();
                adminFrame.setVisible(true);

            }
        });

        btnHorarios.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                AdminsFrame.dispose();

                JFrame adminFrame = new JFrame("Agregar Horarios");
                adminFrame.setContentPane(new AgregarHoras(AdminsFrame).horasPanel);
                adminFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                adminFrame.setSize(900, 600);
                adminFrame.pack();
                adminFrame.setVisible(true);


            }
        });
    }
}
