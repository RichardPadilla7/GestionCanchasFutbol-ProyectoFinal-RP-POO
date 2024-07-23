import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoginFutbol {
    public JPanel login;
    public JTextField usertext;
    public JPasswordField contratext;
    public JButton btnsesion;
    public JButton bntregistrar;
    public JComboBox modosbtn;
    private JLabel imagenLogin;
    private JLabel titulo;
    private JLabel usuario;
    private JLabel contraseña;
    private JLabel modosTitulo;
    public JFrame LoginFrame;

    public LoginFutbol(JFrame frame) {
        this.LoginFrame = frame;

        bntregistrar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                
                LoginFrame.dispose();
                
                JFrame frame = new JFrame("Registrarse");
                frame.setContentPane(new Registrarse(frame).registro);
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setSize(9000, 9000);
                frame.pack();
                frame.setVisible(true);


            }
        });
    }
}
