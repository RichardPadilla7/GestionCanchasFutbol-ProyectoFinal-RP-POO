import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;


public class Registrarse {
    public JPanel registro;
    public JComboBox modotypes;
    public JButton btnGuardar;
    public JTextField textField1;
    public JTextField textField2;
    public JTextField textField3;
    public JTextField textField4;
    public JTextField textField5;
    public JButton btnRegresar;
    private JLabel imagenregist;
    private JLabel titulo2;
    private JLabel nombre;
    private JLabel apellido;
    private JLabel email;
    private JLabel contrasenia;
    private JLabel cedula;
    private JLabel modo;
    public JFrame registrosFrame;

    public Registrarse(JFrame frame) {
        this.registrosFrame = frame;

        //Opciones del JComboBox pára el modo de registro
        modotypes.addItem("Administrador");
        modotypes.addItem("Jugador");
        modotypes.addItem("Encargado");


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


        btnGuardar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                String nombre = textField1.getText();
                String apellido = textField5.getText();
                String email = textField2.getText();
                String contrasenia = textField3.getText();
                String cedula = textField4.getText();
                String modo = (String) modotypes.getSelectedItem();

                String url = "jdbc:mysql://localhost:3306/reservasCanchas";
                String user = "root";
                String password = "123456";

                try (Connection conn = DriverManager.getConnection(url, user, password)) {
                    String sql = "INSERT INTO usuarios (nombre, apellido, email, contrasenia, cedula, modo) VALUES (?,?,?,?,?,?)";
                    PreparedStatement pstmt = conn.prepareStatement(sql);

                    pstmt.setString(1, nombre);
                    pstmt.setString(2, apellido);
                    pstmt.setString(3, email);
                    pstmt.setString(4, contrasenia);
                    pstmt.setString(5, cedula);
                    pstmt.setString(6, modo);

                    int rowsAffected = pstmt.executeUpdate();

                    if (rowsAffected > 0) {
                        JOptionPane.showMessageDialog(null, "Registro exitoso!");
                    } else {
                        JOptionPane.showMessageDialog(null, "Error al registrarse. Intente nuevamente.");
                    }
                } catch (SQLException ex) {
                    ex.printStackTrace();
                    JOptionPane.showMessageDialog(null, "Error en la base de datos: ");
                }
            }
        });









    }
}
