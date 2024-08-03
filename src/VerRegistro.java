import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

public class VerRegistro {
    public JTextArea verRegistros;
    public JButton btnVerRegistros;
    public JLabel img;
    public JPanel visualizar;
    public JLabel VerTipo;
    public JButton regresarButton;
    public JLabel titulo;
    public JComboBox<String> verCanchaText;
    public JFrame verFrame;
    public JFrame encargadoFrame;

    public VerRegistro(JFrame verframe,JFrame encargadoframe) {
        this.verFrame = verframe;
        this.encargadoFrame = encargadoframe;

        // Opciones del JComboBox
        verCanchaText.addItem("Cancha de cesped");
        verCanchaText.addItem("Cancha de cemento");
        verCanchaText.addItem("Cancha de tierra");
        verCanchaText.addItem("Cancha sintetico");

        btnVerRegistros.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Detalles de la base de datos
                String url = "jdbc:mysql://localhost:3306/reservasCanchas";
                String user = "root";
                String password = "123456";

                String tipoCancha = (String) verCanchaText.getSelectedItem();
                StringBuilder sb = new StringBuilder();

                try (Connection conn = DriverManager.getConnection(url, user, password)) {
                    // Consultar reservas
                    String sqlReservas = "SELECT * FROM reservar_canchas WHERE tipoCanchas_Reservas = ?";
                    PreparedStatement pstmtReservas = conn.prepareStatement(sqlReservas);
                    pstmtReservas.setString(1, tipoCancha);
                    ResultSet rsReservas = pstmtReservas.executeQuery();

                    if (rsReservas.next()) {
                        sb.append("Reservas de Canchas desde Jugador:\n");
                        do {
                            sb.append("Cédula: ").append(rsReservas.getString("cedula")).append("\n")
                                    .append("Fecha: ").append(rsReservas.getDate("fecha")).append("\n")
                                    .append("Hora: ").append(rsReservas.getTime("hora")).append("\n")
                                    .append("Hora Fin: ").append(rsReservas.getTime("hora_fin")).append("\n\n");
                        } while (rsReservas.next());
                    } else {
                        sb.append("No hay registros de reservas de canchas.\n\n");
                    }

                    // Consultar canchas
                    String sqlCanchas = "SELECT * FROM canchas WHERE tipo_cancha = ?";
                    PreparedStatement pstmtCanchas = conn.prepareStatement(sqlCanchas);
                    pstmtCanchas.setString(1, tipoCancha);
                    ResultSet rsCanchas = pstmtCanchas.executeQuery();

                    if (rsCanchas.next()) {
                        sb.append("Detalles de Canchas desde administrador:\n");
                        do {
                            sb.append("Facultad: ").append(rsCanchas.getString("facultad")).append("\n")
                                    .append("Cédula: ").append(rsCanchas.getString("cedula")).append("\n")
                                    .append("Tipo de Cancha: ").append(rsCanchas.getString("tipo_cancha")).append("\n")
                                    .append("Ubicación: ").append(rsCanchas.getString("ubicacion")).append("\n")
                                    .append("Capacidad: ").append(rsCanchas.getInt("capacidad")).append("\n\n");
                        } while (rsCanchas.next());
                    } else {
                        sb.append("No hay registros de detalles de canchas.\n\n");
                    }

                    // Consultar horarios
                    String sqlHorarios = "SELECT * FROM horarios WHERE tipo_cancha = ?";
                    PreparedStatement pstmtHorarios = conn.prepareStatement(sqlHorarios);
                    pstmtHorarios.setString(1, tipoCancha);
                    ResultSet rsHorarios = pstmtHorarios.executeQuery();

                    if (rsHorarios.next()) {
                        sb.append("Horarios de Canchas desde Administrador:\n");
                        do {
                            sb.append("Fecha: ").append(rsHorarios.getDate("fecha")).append("\n")
                                    .append("Hora de Inicio: ").append(rsHorarios.getTime("hora_inicio")).append("\n")
                                    .append("Hora de Fin: ").append(rsHorarios.getTime("hora_fin")).append("\n")
                                    .append("Tipo de Cancha: ").append(rsHorarios.getString("tipo_cancha")).append("\n\n");
                        } while (rsHorarios.next());
                    } else {
                        sb.append("No hay registros de horarios de canchas.\n\n");
                    }

                    verRegistros.setText(sb.toString());
                } catch (SQLException ex) {
                    JOptionPane.showMessageDialog(verFrame, "Error en la base de datos");
                    ex.printStackTrace();
                }
            }
        });

        regresarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                verFrame.dispose();
                if (encargadoframe != null && !encargadoframe.isVisible()) {
                    encargadoframe.setVisible(true);
                }
            }
        });
    }
}