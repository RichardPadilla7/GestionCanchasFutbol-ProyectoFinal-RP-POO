import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ActualizarCanchas {
    public JComboBox<String> tipoCanchaBox;
    public JComboBox<String> estadoBox;
    public JButton btnActualizar;
    public JTextArea mostrarEstado;
    public JLabel img;
    public JLabel titulo;
    public JLabel tipoCancha;
    public JLabel estado;
    public JPanel mantenimiento;
    public JButton regresarButton;
    public JFrame estadoFrame;
    public JFrame encargadoFrame;

    public ActualizarCanchas(JFrame estadoframe, JFrame encargadoframe) {
        this.estadoFrame = estadoframe;
        this.encargadoFrame = encargadoframe;

        // JComboBox de tipos de canchas
        tipoCanchaBox.addItem("Cancha de cesped");
        tipoCanchaBox.addItem("Cancha de cemento");
        tipoCanchaBox.addItem("Cancha de tierra");
        tipoCanchaBox.addItem("Cancha sintetico");

        // JComboBox de estados de la cancha
        estadoBox.addItem("Disponible");
        estadoBox.addItem("Mantenimiento");
        estadoBox.addItem("Cerrada");

        btnActualizar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String tipo_cancha = (String) tipoCanchaBox.getSelectedItem();
                String estado_cancha = (String) estadoBox.getSelectedItem();

                actualizarEstadoCancha(tipo_cancha, estado_cancha);
                mostrarEstadoCanchas(tipo_cancha);
            }
        });


        regresarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                estadoFrame.dispose();
                if (encargadoframe != null && !encargadoframe.isVisible()) {
                    encargadoframe.setVisible(true);
                }
            }
        });
    }

    private void actualizarEstadoCancha(String tipo_cancha, String estado_cancha) {
        String url = "jdbc:mysql://localhost:3306/reservasCanchas";
        String user = "root";
        String password = "123456";

        String query = "REPLACE INTO estado (tipo_cancha, estado) VALUES (?, ?)";

        try (Connection conn = DriverManager.getConnection(url, user, password);
             PreparedStatement pstmt = conn.prepareStatement(query)) {
            pstmt.setString(1, tipo_cancha);
            pstmt.setString(2, estado_cancha);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private void mostrarEstadoCanchas(String tipo_cancha) {
        String url = "jdbc:mysql://localhost:3306/reservasCanchas";
        String user = "root";
        String password = "123456";

        String query = "SELECT tipo_cancha, estado FROM estado WHERE tipo_cancha = ?";

        try (Connection conn = DriverManager.getConnection(url, user, password);
             PreparedStatement pstmt = conn.prepareStatement(query)) {
            pstmt.setString(1, tipo_cancha);
            ResultSet resultados = pstmt.executeQuery();

            if (resultados.next()) {
                String estado = resultados.getString("estado");
                StringBuilder sb = new StringBuilder();
                sb.append("Tipo Cancha: ").append(resultados.getString("tipo_cancha"))
                        .append("\nEstado: ").append(estado)
                        .append("\n");
                mostrarEstado.setText(sb.toString());
            } else {
                mostrarEstado.setText("No se encontró informacion para la cancha seleccionada.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
