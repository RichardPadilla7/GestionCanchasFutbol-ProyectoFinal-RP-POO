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

                JugadorFrame.dispose();

                JFrame reservarCanchasFrame = new JFrame("Reservar Canchas");
                reservarCanchasFrame.setContentPane(new ReservarCanchas(reservarCanchasFrame,JugadorFrame).reservasCanchas);
                reservarCanchasFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                reservarCanchasFrame.setSize(300, 300);
                reservarCanchasFrame.setLocationRelativeTo(null); // Centra la ventana en la pantalla
                reservarCanchasFrame.pack();
                reservarCanchasFrame.setVisible(true);
            }
        });


        btnDetallesCanchas.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                JugadorFrame.dispose();

                JFrame cancelarFrame = new JFrame("Detalles de otras Canchas");
                cancelarFrame.setContentPane(new DetallesCanchas(cancelarFrame,JugadorFrame).deatallesCanchas);
                cancelarFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                cancelarFrame.setSize(300, 300);
                cancelarFrame.setLocationRelativeTo(null); // Centra la ventana en la pantalla
                cancelarFrame.pack();
                cancelarFrame.setVisible(true);
            }
        });

        
        btnCancelarReservas.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                JugadorFrame.dispose();

                JFrame cancelarFrame = new JFrame("Cancelar Reserva");
                cancelarFrame.setContentPane(new CancelarReserva(cancelarFrame,JugadorFrame).cancelar);
                cancelarFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                cancelarFrame.setSize(300, 300);
                cancelarFrame.setLocationRelativeTo(null); // Centra la ventana en la pantalla
                cancelarFrame.pack();
                cancelarFrame.setVisible(true);
            }
        });
    }
}
