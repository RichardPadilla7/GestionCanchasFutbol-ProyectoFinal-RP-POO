import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class ReservarCanchas {
    public JPanel reservasCanchas;
    public JTextArea mostrarCanchasDispo;
    public JButton btncanchasDisponibles;
    public JTextField cedulaReseText;
    public JTextField fechaReservText;
    public JTextField horaReservText;
    public JButton btnConfirmarReserva;
    public JButton regresarButton;
    public JLabel img;
    public JLabel titulo;
    public JLabel cedulaReserva;
    public JLabel fechaReserva;
    public JLabel HoraInicioReserva;
    public JComboBox<String> TipoReservaCanchasBox;
    public JLabel tipoCanchaReservas;
    public JTextField horafinReservText;
    public JLabel horafinReserva;
    public JFrame ReservaFrame;

    public ReservarCanchas(JFrame Reservaframe) {
        this.ReservaFrame = Reservaframe;

        // Opciones del JComboBox para el modo de registro
        TipoReservaCanchasBox.addItem("Cancha de cesped");
        TipoReservaCanchasBox.addItem("Cancha de cemento");
        TipoReservaCanchasBox.addItem("Cancha de tierra");
        TipoReservaCanchasBox.addItem("Cancha sintetico");


        btnConfirmarReserva.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String cedula = cedulaReseText.getText();
                String fecha = fechaReservText.getText();
                String horaInicio = horaReservText.getText();
                String horaFin = horafinReservText.getText();
                String tipoCancha = (String) TipoReservaCanchasBox.getSelectedItem();

                // Validar entrada
                if (cedula.isEmpty() || fecha.isEmpty() || horaInicio.isEmpty() || horaFin.isEmpty() || tipoCancha.isEmpty()) {
                    JOptionPane.showMessageDialog(ReservaFrame, "Por favor, complete todos los campos.");
                    return;
                }

                // Convertir la fecha al formato yyyy-MM-dd
                SimpleDateFormat inputFormat = new SimpleDateFormat("dd/MM/yyyy");
                SimpleDateFormat outputFormat = new SimpleDateFormat("yyyy-MM-dd");
                String fechaFormateada;
                try {
                    fechaFormateada = outputFormat.format(inputFormat.parse(fecha));
                } catch (ParseException ex) {
                    ex.printStackTrace();
                    JOptionPane.showMessageDialog(ReservaFrame, "Error en el formato de la fecha. Use dd/MM/yyyy.");
                    return;
                }

                // Insertar reserva en la base de datos
                String url = "jdbc:mysql://localhost:3306/reservasCanchas";
                String user = "root";
                String password = "123456";

                try (Connection conn = DriverManager.getConnection(url, user, password)) {
                    // Verificar el estado de la cancha
                    String sqlCheckEstado = "SELECT estado FROM estado WHERE tipo_cancha = ?";
                    PreparedStatement pstmtCheckEstado = conn.prepareStatement(sqlCheckEstado);
                    pstmtCheckEstado.setString(1, tipoCancha);
                    ResultSet rsEstado = pstmtCheckEstado.executeQuery();

                    if (rsEstado.next()) {
                        String estadoCancha = rsEstado.getString("estado");
                        if ("Mantenimiento".equals(estadoCancha) || "Cerrada".equals(estadoCancha)) {
                            JOptionPane.showMessageDialog(ReservaFrame, "La cancha está " + estadoCancha + ". No se puede reservar.");
                            return;
                        }
                    }

                    // Verificar disponibilidad en reservar_canchas
                    String sqlCheckReservas = "SELECT COUNT(*) FROM reservar_canchas WHERE fecha = ? AND tipoCanchas_Reservas = ? AND (hora <= ? AND hora_fin >= ?)";
                    PreparedStatement pstmtCheckReservas = conn.prepareStatement(sqlCheckReservas);

                    pstmtCheckReservas.setString(1, fechaFormateada);
                    pstmtCheckReservas.setString(2, tipoCancha);
                    pstmtCheckReservas.setString(3, horaInicio);
                    pstmtCheckReservas.setString(4, horaFin);

                    ResultSet rsReservas = pstmtCheckReservas.executeQuery();
                    rsReservas.next();
                    int countReservas = rsReservas.getInt(1);

                    // Verificar disponibilidad en horarios
                    String sqlCheckHorarios = "SELECT COUNT(*) FROM horarios WHERE fecha = ? AND tipo_cancha = ? AND (hora_inicio <= ? AND hora_fin >= ?)";
                    PreparedStatement pstmtCheckHorarios = conn.prepareStatement(sqlCheckHorarios);

                    pstmtCheckHorarios.setString(1, fechaFormateada);
                    pstmtCheckHorarios.setString(2, tipoCancha);
                    pstmtCheckHorarios.setString(3, horaInicio);
                    pstmtCheckHorarios.setString(4, horaFin);

                    ResultSet rsHorarios = pstmtCheckHorarios.executeQuery();
                    rsHorarios.next();
                    int countHorarios = rsHorarios.getInt(1);

                    if (countReservas > 0 || countHorarios > 0) {
                        JOptionPane.showMessageDialog(ReservaFrame, "La cancha ya está reservada para esa fecha y hora.");
                    } else {
                        // Insertar reserva
                        String sqlInsert = "INSERT INTO reservar_canchas (cedula, fecha, hora, hora_fin, tipoCanchas_Reservas) VALUES (?, ?, ?, ?, ?)";
                        PreparedStatement pstmtInsert = conn.prepareStatement(sqlInsert);

                        pstmtInsert.setString(1, cedula);
                        pstmtInsert.setString(2, fechaFormateada);
                        pstmtInsert.setString(3, horaInicio);
                        pstmtInsert.setString(4, horaFin);
                        pstmtInsert.setString(5, tipoCancha);

                        int rowsAffected = pstmtInsert.executeUpdate();

                        if (rowsAffected > 0) {
                            JOptionPane.showMessageDialog(ReservaFrame, "Reserva confirmada exitosamente!");
                            // Limpiar los campos de texto
                            cedulaReseText.setText("");
                            fechaReservText.setText("");
                            horaReservText.setText("");
                            horafinReservText.setText("");
                        } else {
                            JOptionPane.showMessageDialog(ReservaFrame, "Error al confirmar la reserva. Intente nuevamente.");
                        }
                    }
                } catch (Exception ex) {
                    ex.printStackTrace();
                    JOptionPane.showMessageDialog(ReservaFrame, "Error en la base de datos");
                }
            }
        });


        regresarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ReservaFrame.dispose();
                JFrame jugadorFrame = new JFrame("Jugador");
                jugadorFrame.setContentPane(new Jugador(jugadorFrame).jugador);
                jugadorFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                jugadorFrame.setSize(900, 600);
                jugadorFrame.pack();
                jugadorFrame.setVisible(true);
            }
        });
    }
}
