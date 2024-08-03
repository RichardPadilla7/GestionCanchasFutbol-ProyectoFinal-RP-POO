import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

public class ControlAcceso {
    public JTextArea textArea1;
    public JTextField cedulaText;
    public JTextField correoText;
    public JButton autorizarButton;
    public JButton regresarButton;
    public JLabel img;
    public JLabel mostrarInfo;
    public JLabel cedula;
    public JLabel correoRegistrado;
    public JPanel controlar;
    public JFrame controlFrame;
    public JFrame encargadoFrame;

    public ControlAcceso(JFrame controlframe, JFrame encargadoframe) {
        this.controlFrame = controlframe;
        this.encargadoFrame = encargadoframe;


        autorizarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Conectar a la base de datos
                String url = "jdbc:mysql://localhost:3306/reservasCanchas";
                String user = "root";
                String password = "123456";

                String cedula = cedulaText.getText();
                String correo = correoText.getText();

                if (cedula.isEmpty() || correo.isEmpty()) {
                    JOptionPane.showMessageDialog(controlFrame, "Ingrese cedula y correo electronico.");
                    return;
                }

                try (Connection conn = DriverManager.getConnection(url, user, password)) {
                    String sql = "SELECT * FROM usuarios WHERE cedula = ? AND email = ?";
                    PreparedStatement pstmt = conn.prepareStatement(sql);
                    pstmt.setString(1, cedula);
                    pstmt.setString(2, correo);

                    ResultSet resultSet = pstmt.executeQuery();

                    if (resultSet.next()) {
                        // Obtener los detalles del usuario
                        String nombre = resultSet.getString("nombre");
                        StringBuilder info = new StringBuilder();
                        info.append("Bienvenido, ").append(nombre).append("\n");

                        // Obtener los detalles de la reserva
                        String sqlReserva = "SELECT * FROM reservar_canchas WHERE cedula = ?";
                        PreparedStatement pstmtReserva = conn.prepareStatement(sqlReserva);
                        pstmtReserva.setString(1, cedula);

                        ResultSet rsReserva = pstmtReserva.executeQuery();
                        if (rsReserva.next()) {
                            info.append("Detalles de la Reserva:\n");
                            info.append("\nFecha: ").append(rsReserva.getDate("fecha")).append("\n");
                            info.append("\nHora Inicio: ").append(rsReserva.getTime("hora")).append("\n");
                            info.append("\nHora Fin: ").append(rsReserva.getTime("hora_fin")).append("\n");
                            info.append("\nTipo de Cancha: ").append(rsReserva.getString("tipoCanchas_Reservas")).append("\n");
                            info.append("\nDisfrute su partido!.");
                        } else {
                            info.append("\nNo tiene reservas registradas.");
                        }
                        mostrarInfo.setText(info.toString());
                        cedulaText.setEditable(false);
                        correoText.setEditable(false);
                        autorizarButton.setEnabled(false);
                        regresarButton.setEnabled(true);
                    } else {
                        JOptionPane.showMessageDialog(controlFrame, "Cedula o correo electronico incorrectos. No esta autorizado, registrese en el sistema de manera correcta.");

                    }
                } catch (SQLException ex) {
                    ex.printStackTrace();
                    JOptionPane.showMessageDialog(controlFrame, "Error en la base de datos.");
                }
            }
        });


        regresarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                controlFrame.dispose();
                if (encargadoframe != null && !encargadoframe.isVisible()) {
                    encargadoframe.setVisible(true);
                }
            }
        });
    }
}