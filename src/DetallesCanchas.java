import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.net.URL;
import javax.imageio.ImageIO;
import java.io.IOException;

public class DetallesCanchas {
    public JTextArea mostrarDetallesCanchas;
    public JButton btnDetallesCanchas;
    public JButton regresarButton;
    public JLabel img;
    public JPanel deatallesCanchas;
    public JLabel titulo;
    public JComboBox<String> tipoCanchasDetallesText;
    public JLabel tipoCanchasVer;
    public JLabel mostrarURL;
    public JFrame DetallesFrame;
    public JFrame JugaFrame;


    public DetallesCanchas(JFrame detallesframe, JFrame JugaFrame) {
        this.DetallesFrame = detallesframe;
        this.JugaFrame = JugaFrame;

        // Opciones del JComboBox para los tipos de cancha
        tipoCanchasDetallesText.addItem("Cancha de cesped");
        tipoCanchasDetallesText.addItem("Cancha de cemento");
        tipoCanchasDetallesText.addItem("Cancha de tierra");
        tipoCanchasDetallesText.addItem("Cancha sintetico");

        // Configurar el JLabel para la URL de la imagen
        mostrarURL.setHorizontalAlignment(SwingConstants.CENTER);

        btnDetallesCanchas.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String tipoCancha = (String) tipoCanchasDetallesText.getSelectedItem();

                String url = "jdbc:mysql://localhost:3306/reservasCanchas";
                String user = "root";
                String password = "123456";

                StringBuilder detalles = new StringBuilder();

                try (Connection conn = DriverManager.getConnection(url, user, password)) {
                    // Obtener detalles de la tabla canchas
                    String sqlCanchas = "SELECT * FROM canchas WHERE tipo_cancha = ?";
                    PreparedStatement pstmtCanchas = conn.prepareStatement(sqlCanchas);
                    pstmtCanchas.setString(1, tipoCancha);

                    ResultSet rsCanchas = pstmtCanchas.executeQuery();
                    detalles.append("Detalles de Canchas desde Administrador:\n");
                    if (rsCanchas.next()) {
                        detalles.append("Facultad: ").append(rsCanchas.getString("facultad"))
                                .append("\nCédula: ").append(rsCanchas.getString("cedula"))
                                .append("\nTipo: ").append(rsCanchas.getString("tipo_cancha"))
                                .append("\nUbicación: ").append(rsCanchas.getString("ubicacion"))
                                .append("\nCapacidad: ").append(rsCanchas.getInt("capacidad"))
                                .append("\n\n");
                    } else {
                        detalles.append("No se encontraron canchas para el tipo seleccionado.\n\n");
                    }

                    // Obtener detalles de la tabla horarios
                    String sqlHorarios = "SELECT * FROM horarios WHERE tipo_cancha = ?";
                    PreparedStatement pstmtHorarios = conn.prepareStatement(sqlHorarios);
                    pstmtHorarios.setString(1, tipoCancha);

                    ResultSet rsHorarios = pstmtHorarios.executeQuery();
                    detalles.append("Horarios de Canchas desde Administrador:\n");
                    if (rsHorarios.next()) {
                        detalles.append("Fecha: ").append(rsHorarios.getDate("fecha"))
                                .append("\nHora Inicio: ").append(rsHorarios.getTime("hora_inicio"))
                                .append("\nHora Fin: ").append(rsHorarios.getTime("hora_fin"))
                                .append("\nTipo: ").append(rsHorarios.getString("tipo_cancha"))
                                .append("\n\n");
                    } else {
                        detalles.append("No se encontraron horarios para el tipo seleccionado.\n\n");
                    }

                    // Obtener detalles de la tabla reservar_canchas
                    String sqlReservas = "SELECT * FROM reservar_canchas WHERE tipoCanchas_Reservas = ?";
                    PreparedStatement pstmtReservas = conn.prepareStatement(sqlReservas);
                    pstmtReservas.setString(1, tipoCancha);

                    ResultSet rsReservas = pstmtReservas.executeQuery();
                    detalles.append("Reservas de Canchas desde Jugador:\n");
                    if (rsReservas.next()) {
                        detalles.append("Cédula: ").append(rsReservas.getString("cedula"))
                                .append("\nFecha: ").append(rsReservas.getDate("fecha"))
                                .append("\nHora: ").append(rsReservas.getTime("hora"))
                                .append("\nTipo: ").append(rsReservas.getString("tipoCanchas_Reservas"))
                                .append("\nHora Fin: ").append(rsReservas.getTime("hora_fin"))
                                .append("\n\n");
                    } else {
                        detalles.append("No se encontraron reservas para el tipo seleccionado.\n\n");
                    }

                    mostrarDetallesCanchas.setText(detalles.toString());

                    // Mostrar imagen según el tipo de cancha
                    String imagenURL = "";
                    switch (tipoCancha) {
                        case "Cancha de cesped":
                            imagenURL = "https://th.bing.com/th/id/R.edbaaa001a223066acc4173fdbb05ea7?rik=MXAzkj9mE7R2iQ&riu=http%3a%2f%2fwww.quitoinforma.gob.ec%2fwp-content%2fuploads%2f2018%2f08%2fCancha-de-c%c3%a9sped-sint%c3%a9tico-en-el-parque-de-San-Rafael.jpg&ehk=DauW9PFUCRkglQFLzxw7XrALwJ935o0xOwpI%2fTnaEp4%3d&risl=&pid=ImgRaw&r=0";
                            break;
                        case "Cancha de cemento":
                            imagenURL = "https://grupodimareco.com/wp-content/uploads/2020/12/Cancha_Futbol_Concreto_Hidraulico.jpg";
                            break;
                        case "Cancha de tierra":
                            imagenURL = "https://www.autocontrolplan.es/wp-content/uploads/2020/11/pexels-kelly-lacy-3794764-e1604563645491.jpg";
                            break;
                        case "Cancha sintetico":
                            imagenURL = "https://www.launion.com.py/wp-content/uploads/2020/10/chanchasinteticas-822x539.jpg";
                            break;
                    }

                    if (!imagenURL.isEmpty()) {
                        try {
                            URL urlImagen = new URL(imagenURL);
                            ImageIcon imagen = new ImageIcon(ImageIO.read(urlImagen));

                            // Redimensionar la imagen
                            Image imgEscalada = imagen.getImage().getScaledInstance(200, 200, Image.SCALE_SMOOTH);
                            mostrarURL.setIcon(new ImageIcon(imgEscalada));
                        } catch (IOException ioException) {
                            ioException.printStackTrace();
                            JOptionPane.showMessageDialog(DetallesFrame, "Error al cargar la imagen");
                        }
                    } else {
                        mostrarURL.setIcon(null);
                    }
                } catch (Exception ex) {
                    ex.printStackTrace();
                    JOptionPane.showMessageDialog(DetallesFrame, "Error en la base de datos");
                }
            }
        });

        regresarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                DetallesFrame.dispose();
                if (JugaFrame != null && !JugaFrame.isVisible()) {
                    JugaFrame.setVisible(true);
                }
            }
        });
    }
}
