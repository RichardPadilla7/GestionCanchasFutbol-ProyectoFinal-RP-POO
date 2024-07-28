import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Jugador {
    public JButton btnReservarCanchas;
    public JButton btnDetallesCanchas;
    public JButton btnCancelarReservas;
    public JLabel img;
    public JLabel titulo;
    public JLabel img2;
    public JLabel img3;
    public JLabel img4;
    public JPanel jugador;
    public JFrame JugadorFrame;

    public Jugador(JFrame JugaFrame) {
        this.JugadorFrame = JugaFrame;


        btnReservarCanchas.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                JFrame frame = new JFrame("Reservar Canchas");
                frame.setContentPane(new ReservarCanchas(frame).reservasCanchas);
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setSize(9000, 9000);
                frame.pack();
                frame.setVisible(true);
            }
        });


        btnDetallesCanchas.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {





            }
        });

        
        btnCancelarReservas.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {


            }
        });
    }
}
