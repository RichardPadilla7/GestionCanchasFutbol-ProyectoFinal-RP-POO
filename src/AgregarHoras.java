import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentAdapter;
import java.sql.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class AgregarHoras {
    public JTextField fechatext;
    public JTextField hiniciotext;
    public JTextField hfintext;
    public JComboBox tipo_cancha2;
    public JButton btnregistrarHora;
    public JPanel horasPanel;
    public JLabel img;
    public JLabel titulo;
    public JLabel fecha;
    public JLabel hora_inicio;
    public JLabel hora_fin;
    public JLabel tipoCanchas;
    public JButton regresarButton;
    public JButton btnborrarhorario;
    public JButton buscaHorarioButton;
    public JTextArea MostrarDatosHorario;
    public JLabel img2;
    public JLabel titulo2;
    public JTextField ingresefechaText;
    public JComboBox ingreseTipoCanchaText;
    public JLabel ingreseFecha;
    public JLabel ingreseTipoCancha;
    public JFrame frameHora;
    public JFrame frameAdmin;

    public AgregarHoras(JFrame framehora, JFrame frameAdmin) {
        this.frameHora = framehora;
        this.frameAdmin = frameAdmin;

        //Opciones del JComboBox pára el modo de registro
        tipo_cancha2.addItem("Cancha de cesped");
        tipo_cancha2.addItem("Cancha de cemento");
        tipo_cancha2.addItem("Cancha de tierra");
        tipo_cancha2.addItem("Cancha sintetico");

        //Opciones para buscar o borrar en JcomboBox
        ingreseTipoCanchaText.addItem("Cancha de cesped");
        ingreseTipoCanchaText.addItem("Cancha de cemento");
        ingreseTipoCanchaText.addItem("Cancha de tierra");
        ingreseTipoCanchaText.addItem("Cancha sintetico");



        regresarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frameHora.dispose();
                if (frameAdmin != null && !frameAdmin.isVisible()) {
                    frameAdmin.setVisible(true);
                }
            }
        });


        btnregistrarHora.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                String fecha = fechatext.getText();
                String hora_inicio = hiniciotext.getText();
                String hora_fin = hfintext.getText();
                String tipo_cancha = (String) tipo_cancha2.getSelectedItem();

                // Convertir la fecha al formato YY-MM-DD
                SimpleDateFormat inputFormat = new SimpleDateFormat("dd/MM/yyyy"); //Analiza la fecha y le da un formato
                SimpleDateFormat outputFormat = new SimpleDateFormat("yyyy-MM-dd"); //Le imprime la fecha
                String fechaFormateada = null; //Inicializado

                try {
                    fechaFormateada = outputFormat.format(inputFormat.parse(fecha));
                } catch (ParseException ex) {
                    ex.printStackTrace();
                    JOptionPane.showMessageDialog(null, "Error en el formato de la fecha. Use DD/MM/YY.");
                    return;
                }

                //Agregar cancha a la base de datos
                String url = "jdbc:mysql://localhost:3306/reservasCanchas";
                String user = "root";
                String password = "123456";

                try(Connection conn = DriverManager.getConnection(url, user, password)) {
                    String sql = "INSERT INTO horarios (fecha, hora_inicio, hora_fin, tipo_cancha) VALUES (?,?,?,?)";
                    PreparedStatement pstmt = conn.prepareStatement(sql);

                    pstmt.setString(1, fechaFormateada);
                    pstmt.setString(2, hora_inicio);
                    pstmt.setString(3, hora_fin);
                    pstmt.setString(4, tipo_cancha);

                    //limpiar cuadros de registros
                    fechatext.setText("");
                    hiniciotext.setText("");
                    hfintext.setText("");

                    int consultar = pstmt.executeUpdate();

                    if (consultar > 0) {
                        JOptionPane.showMessageDialog(null, "Hora registrada exitosamente!");
                    } else {
                        JOptionPane.showMessageDialog(null, "Error al registrar la hora!");
                    }

                }catch(Exception ex){
                    ex.printStackTrace(); //Imprime en ña consola las exepciones o errores durante la ejecucion
                    JOptionPane.showMessageDialog(null, "Error en la base de datos");
                }
            }
        });


        buscaHorarioButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                String fecha = ingresefechaText.getText();
                String tipo_cancha = (String) ingreseTipoCanchaText.getSelectedItem();

                // Convertir la fecha al formato yyyy-MM-dd
                SimpleDateFormat inputFormat = new SimpleDateFormat("dd/MM/yyyy");
                SimpleDateFormat outputFormat = new SimpleDateFormat("yyyy-MM-dd");
                String fechaFormateada = null;

                try {
                    fechaFormateada = outputFormat.format(inputFormat.parse(fecha));
                } catch (ParseException ex) {
                    ex.printStackTrace();
                    JOptionPane.showMessageDialog(null, "Error en el formato de la fecha. Use dd/MM/yyyy.");
                    return;
                }

                //Buscar cancha en la base de datos
                String url = "jdbc:mysql://localhost:3306/reservasCanchas";
                String user = "root";
                String password = "123456";

                try(Connection conn = DriverManager.getConnection(url, user, password)) {
                    String sql = "SELECT * FROM horarios WHERE fecha =? AND tipo_cancha =?";
                    PreparedStatement pstmt = conn.prepareStatement(sql);

                    pstmt.setString(1, fechaFormateada);
                    pstmt.setString(2, tipo_cancha);

                    ResultSet resultSet = pstmt.executeQuery();

                    if (resultSet.next()) {
                        MostrarDatosHorario.setText(
                                "Fecha: " + resultSet.getString("fecha") +
                                        "\nHora inicio: " + resultSet.getString("hora_inicio") +
                                        "\nHora fin: " + resultSet.getString("hora_fin") +
                                        "\nTipo de cancha: " + resultSet.getString("tipo_cancha"));

                        // Limpiar los campos de texto
                        fechatext.setText("");
                        hiniciotext.setText("");
                        hfintext.setText("");
                        ingresefechaText.setText("");

                    } else {
                        JOptionPane.showMessageDialog(frameHora, "Horario no encontrada");
                        MostrarDatosHorario.setText("");
                        }

                    }catch (Exception ex) {
                    ex.printStackTrace();
                    JOptionPane.showMessageDialog(frameHora, "Error en la base de datos");
                }
            }
        });


        btnborrarhorario.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                String fecha = ingresefechaText.getText();
                String tipo_cancha = (String) ingreseTipoCanchaText.getSelectedItem();

                // Convertir la fecha al formato yyyy-MM-dd
                SimpleDateFormat inputFormat = new SimpleDateFormat("dd/MM/yyyy");
                SimpleDateFormat outputFormat = new SimpleDateFormat("yyyy-MM-dd");
                String fechaFormateada = null;
                try {
                    fechaFormateada = outputFormat.format(inputFormat.parse(fecha));
                } catch (ParseException ex) {
                    ex.printStackTrace();
                    JOptionPane.showMessageDialog(frameHora, "Error en el formato de la fecha. Use dd/MM/yyyy.");
                    return;
                }

                //Borrar cancha de la base de datos
                String url = "jdbc:mysql://localhost:3306/reservasCanchas";
                String user = "root";
                String password = "123456";

                try(Connection conn = DriverManager.getConnection(url, user, password)) {
                    String sql = "DELETE FROM horarios WHERE fecha =? AND tipo_cancha =?";
                    PreparedStatement pstmt = conn.prepareStatement(sql);

                    pstmt.setString(1, fechaFormateada);
                    pstmt.setString(2, tipo_cancha);

                    int rowsAffected = pstmt.executeUpdate();

                    if (rowsAffected > 0) {
                        JOptionPane.showMessageDialog(frameHora, "Hora eliminada exitosamente!");
                        MostrarDatosHorario.setText("");
                    } else {
                        JOptionPane.showMessageDialog(frameHora, "No se encontró la hora para el tipo de cancha seleccionado.");
                        MostrarDatosHorario.setText("");
                    }
                }catch (Exception ex){
                        ex.printStackTrace();
                        JOptionPane.showMessageDialog(frameHora, "Error en la base de datos");
                    }
                }
        });
    }
}
