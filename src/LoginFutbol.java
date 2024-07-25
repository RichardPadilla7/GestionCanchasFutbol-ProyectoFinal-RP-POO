import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

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

        //Opciones del JComboBox pára el modo de registro
        modosbtn.addItem("Administrador");
        modosbtn.addItem("Jugador");
        modosbtn.addItem("Encargado");


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


        btnsesion.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                String email = usertext.getText();
                String contrasenia = new String(contratext.getPassword());
                String modoSeleccionado = (String) modosbtn.getSelectedItem();

                // Conectar a la base de datos
                String url = "jdbc:mysql://localhost:3306/reservasCanchas";
                String user = "root";
                String password = "123456";

                // Validar los datos del usuario en la base de datos
                try (Connection conn = DriverManager.getConnection(url, user, password)) {
                    String sql = "SELECT modo FROM usuarios WHERE email = ? AND contrasenia = ?";
                    PreparedStatement pstmt = conn.prepareStatement(sql);
                    pstmt.setString(1, email);
                    pstmt.setString(2, contrasenia);

                    ResultSet resultSet = pstmt.executeQuery();

                    if (resultSet.next()) {
                        String modo = resultSet.getString("modo");

                        if (modo.equals(modoSeleccionado)) {
                            JOptionPane.showMessageDialog(null, "Inicio de sesión exitoso!. Bienvenido " + email);

                            // Abrir la ventana dependiendo del modo de registro
                            if (modo.equals("Administrador")) {

                                LoginFrame.dispose();
                                JFrame adminFrame = new JFrame("Administrador");
                                adminFrame.setContentPane(new Administrador(adminFrame).admin);
                                adminFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                                adminFrame.setSize(900, 600);
                                adminFrame.pack();
                                adminFrame.setVisible(true);


                            } else if (modo.equals("Jugador")) {
                                JOptionPane.showMessageDialog(null,"Hola jugador");








                            } else if (modo.equals("Encargado")) {
                                JOptionPane.showMessageDialog(null,"Hola encargado");









                            }

                            LoginFrame.dispose();

                        } else {
                            JOptionPane.showMessageDialog(null, "El modo seleccionado no coincide con el registrado.");
                        }
                    } else {
                        JOptionPane.showMessageDialog(null, "Usuario no encontrado o contraseña incorrecta");
                    }
                } catch (SQLException ex) {
                    ex.printStackTrace();
                    JOptionPane.showMessageDialog(null, "Error en la base de datos: ");
                }
            }
        });
    }
}
