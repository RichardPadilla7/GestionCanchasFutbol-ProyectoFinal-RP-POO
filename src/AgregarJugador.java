import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

public class AgregarJugador {
    public JTextField nombretext;
    public JTextField apellidotext;
    public JTextField edadtext;
    public JTextField cedulatext;
    public JTextField emailtext;
    public JPasswordField contratext;
    public JTextField telefonotext;
    public JButton btnagregarJugador;
    public JTextField cedulabuscartext;
    public JButton btnbuscarJugador;
    public JButton btneliminarJugador;
    public JPanel masjugador;
    public JLabel img;
    public JLabel titulo;
    public JLabel nombre;
    public JLabel apellido;
    public JLabel edad;
    public JLabel cedula;
    public JLabel email;
    public JLabel contra;
    public JLabel telefono;
    public JLabel img2;
    public JLabel titulo2;
    public JLabel buscarCedula;
    public JButton regresarButton;
    public JFrame frameAgre;

    public AgregarJugador(JFrame frameAg) {
        this.frameAgre = frameAg;

        regresarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frameAgre.dispose();
                JFrame adminFrame = new JFrame("Administrador");
                adminFrame.setContentPane(new Administrador(adminFrame).admin);
                adminFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                adminFrame.setSize(900, 600);
                adminFrame.pack();
                adminFrame.setVisible(true);
            }
        });


        btnagregarJugador.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String nombre = nombretext.getText();
                String apellido = apellidotext.getText();
                String edad = edadtext.getText();
                String cedula = cedulatext.getText();
                String email = emailtext.getText();
                String contrasenia = new String(contratext.getPassword());
                String telefono = telefonotext.getText();

                // Conectar a la base de datos
                String url = "jdbc:mysql://localhost:3306/reservasCanchas";
                String user = "root";
                String password = "123456";

                try (Connection conn = DriverManager.getConnection(url, user, password)) {
                    String sql = "INSERT INTO agregar_jugadores (nombre, apellido, edad, cedula, email, contrasenia, telefono) VALUES (?,?,?,?,?,?,?)";
                    PreparedStatement pstmt = conn.prepareStatement(sql);

                    pstmt.setString(1, nombre);
                    pstmt.setString(2, apellido);
                    pstmt.setInt(3, Integer.parseInt(edad));
                    pstmt.setString(4, cedula);
                    pstmt.setString(5, email);
                    pstmt.setString(6, contrasenia);
                    pstmt.setString(7, telefono);

                    int rowsAffected = pstmt.executeUpdate();

                    if (rowsAffected > 0) {
                        JOptionPane.showMessageDialog(frameAgre, "Jugador agregado exitosamente!");
                    } else {
                        JOptionPane.showMessageDialog(frameAgre, "Error al agregar jugador.");
                    }
                }catch (Exception ex){
                    ex.printStackTrace();
                    JOptionPane.showMessageDialog(frameAgre, "Error en la base de datos");
                }


            }
        });


        btnbuscarJugador.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {


            }
        });


        btneliminarJugador.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
    }
}
