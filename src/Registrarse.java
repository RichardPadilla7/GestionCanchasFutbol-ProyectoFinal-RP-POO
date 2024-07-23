import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Registrarse {
    public JPanel registro;
    public JComboBox modotypes;
    public JButton btnGuardar;
    public JTextField textField1;
    public JTextField textField2;
    public JTextField textField3;
    public JTextField textField4;
    public JButton btnRegresar;
    private JLabel imagenregist;
    private JLabel titulo2;
    private JLabel nombre;
    private JLabel email;
    private JLabel contrasenia;
    private JLabel cedula;
    private JLabel modo;
    private JLabel apellido;
    private JTextField textField5;
    public JFrame registrosFrame;

    public Registrarse(JFrame frame) {
        this.registrosFrame = frame;


        btnRegresar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                registrosFrame.dispose();

                JFrame frame = new JFrame("Gestion de canchas de futbol");
                frame.setContentPane(new LoginFutbol(frame).login);
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setSize(9000, 9000);
                frame.pack();
                frame.setVisible(true);
            }
        });
    }
}
