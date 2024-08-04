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

                encargadoFrame.dispose();

                JFrame visualizarReservasFrame = new JFrame("Visualizar Reservas Actuales");
                visualizarReservasFrame.setContentPane(new VerRegistro(visualizarReservasFrame,encargadoFrame).visualizar);
                visualizarReservasFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                visualizarReservasFrame.setSize(300, 300);
                visualizarReservasFrame.setLocationRelativeTo(null); // Centra la ventana en la pantalla
                visualizarReservasFrame.pack();
                visualizarReservasFrame.setVisible(true);
            }
        });


        btnActualizar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                encargadoFrame.dispose();

                JFrame mantenimientoFrame = new JFrame("Actualizar Estado de la Cancha");
                mantenimientoFrame.setContentPane(new ActualizarCanchas(mantenimientoFrame, encargadoFrame).mantenimiento);
                mantenimientoFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                mantenimientoFrame.setSize(300, 300);
                mantenimientoFrame.setLocationRelativeTo(null); // Centra la ventana en la pantalla
                mantenimientoFrame.pack();
                mantenimientoFrame.setVisible(true);
            }
        });


        btnControlAcceso.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                encargadoFrame.dispose();

                JFrame controlarFrame = new JFrame("Control de Acceso a la Cancha");
                controlarFrame.setContentPane(new ControlAcceso(controlarFrame,encargadoFrame).controlar);
                controlarFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                controlarFrame.setSize(300, 300);
                controlarFrame.setLocationRelativeTo(null); // Centra la ventana en la pantalla
                controlarFrame.pack();
                controlarFrame.setVisible(true);
            }
        });

    }
}
