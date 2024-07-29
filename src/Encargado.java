import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Encargado {
    public JButton btnVisualizar;
    public JButton btnActualizar;
    public JButton btnControlAcceso;
    public JLabel img;
    public JLabel titulo;
    public JLabel img2;
    public JLabel img3;
    public JLabel img4;
    public JPanel encargado;
    public JFrame encargadoFrame;

    public Encargado(JFrame encargadoframe) {
        this.encargadoFrame = encargadoframe;


        btnVisualizar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                JFrame frame = new JFrame("Visualizar Reservas Actuales");
                frame.setContentPane(new VerRegistro(frame).visualizar);
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setSize(9000, 9000);
                frame.pack();
                frame.setVisible(true);

            }
        });


        btnActualizar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });


        btnControlAcceso.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });


    }
}
