//Richard Padilla
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
    public JComboBox<String> modosbtn;
    private JLabel imagenLogin;
    private JLabel titulo;
    private JLabel usuario;
    private JLabel contraseña;
    private JLabel modosTitulo;
    public JFrame LoginFrame;

    public LoginFutbol(JFrame frame) {
        this.LoginFrame = frame;

        // Opciones del JComboBox para el modo de registro
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
                frame.setSize(300, 300);
                frame.setLocationRelativeTo(null); // Centra la ventana en la pantalla
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

                try (Connection conn = DriverManager.getConnection(url, user, password)) {

                    // Verificar en la tabla agregar_jugadores por parte del administrador
                    String sql = "SELECT tipo_rol FROM agregar_jugadores WHERE email = ? AND contrasenia = ?";
                    PreparedStatement pstmt = conn.prepareStatement(sql);
                    pstmt.setString(1, email);
                    pstmt.setString(2, contrasenia);

                    ResultSet resultSet = pstmt.executeQuery();

                    if (resultSet.next()) {
                        String rol = resultSet.getString("tipo_rol");

                        if (rol.equals(modoSeleccionado)) {
                            JOptionPane.showMessageDialog(null, "Inicio de sesión exitoso! Bienvenido " + email);

                            // Abrir la ventana dependiendo del modo de registro
                            if (rol.equals("Administrador")) {

                                LoginFrame.dispose();
                                JFrame adminFrame = new JFrame("Administrador");
                                adminFrame.setContentPane(new Administrador(adminFrame).admin);
                                adminFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                                adminFrame.setSize(300, 300);
                                adminFrame.setLocationRelativeTo(null); //Centra la ventana en la pantalla
                                adminFrame.pack();
                                adminFrame.setVisible(true);

                            } else if (rol.equals("Jugador")) {

                                LoginFrame.dispose();
                                JFrame JugadorFrame = new JFrame("Jugador");
                                JugadorFrame.setContentPane(new Jugador(JugadorFrame).jugador);
                                JugadorFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                                JugadorFrame.setSize(300, 300);
                                JugadorFrame.setLocationRelativeTo(null); //Centra la ventana en la pantalla
                                JugadorFrame.pack();
                                JugadorFrame.setVisible(true);

                            } else if (rol.equals("Encargado")) {

                                LoginFrame.dispose();
                                JFrame encargadoFrame = new JFrame("Encargado");
                                encargadoFrame.setContentPane(new Encargado(encargadoFrame).encargado);
                                encargadoFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                                encargadoFrame.setSize(300, 300);
                                encargadoFrame.setLocationRelativeTo(null); //Centra la ventana en la pantalla
                                encargadoFrame.pack();
                                encargadoFrame.setVisible(true);
                            }
                            LoginFrame.dispose();
                        } else {
                            JOptionPane.showMessageDialog(null, "El modo seleccionado no coincide con el registrado.");
                        }
                    } else {

                        //Si no se encuentra en la primera tabla verificar en la segunda tabla
                        sql = "SELECT modo FROM usuarios WHERE email = ? AND contrasenia = ?";
                        pstmt = conn.prepareStatement(sql);
                        pstmt.setString(1, email);
                        pstmt.setString(2, contrasenia);

                        resultSet = pstmt.executeQuery();

                        if (resultSet.next()) {
                            String modo = resultSet.getString("modo");

                            if (modo.equals(modoSeleccionado)) {
                                JOptionPane.showMessageDialog(null, "Inicio de sesión exitoso! Bienvenido " + email);

                                // Abrir la ventana dependiendo del modo de registro
                                if (modo.equals("Administrador")) {

                                    LoginFrame.dispose();
                                    JFrame adminFrame = new JFrame("Administrador");
                                    adminFrame.setContentPane(new Administrador(adminFrame).admin);
                                    adminFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                                    adminFrame.setSize(300, 300);
                                    adminFrame.setLocationRelativeTo(null); //Centra la ventana en la pantalla
                                    adminFrame.pack();
                                    adminFrame.setVisible(true);

                                } else if (modo.equals("Jugador")) {

                                    LoginFrame.dispose();
                                    JFrame JugadorFrame = new JFrame("Jugador");
                                    JugadorFrame.setContentPane(new Jugador(JugadorFrame).jugador);
                                    JugadorFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                                    JugadorFrame.setSize(300, 300);
                                    JugadorFrame.setLocationRelativeTo(null); //Centra la ventana en la pantalla
                                    JugadorFrame.pack();
                                    JugadorFrame.setVisible(true);

                                } else if (modo.equals("Encargado")) {

                                    LoginFrame.dispose();
                                    JFrame encargadoFrame = new JFrame("Encargado");
                                    encargadoFrame.setContentPane(new Encargado(encargadoFrame).encargado);
                                    encargadoFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                                    encargadoFrame.setSize(300, 300);
                                    encargadoFrame.setLocationRelativeTo(null); //Centra la ventana en la pantalla
                                    encargadoFrame.pack();
                                    encargadoFrame.setVisible(true);
                                }
                                LoginFrame.dispose();
                            } else {
                                JOptionPane.showMessageDialog(null, "El modo seleccionado no coincide con el registrado.");
                            }
                        } else {
                            JOptionPane.showMessageDialog(null, "Usuario no encontrado o contraseña incorrecta");
                        }
                    }
                } catch (SQLException ex) {
                    ex.printStackTrace();
                    JOptionPane.showMessageDialog(null, "Error en la base de datos.");
                }
            }
        });
    }
}
