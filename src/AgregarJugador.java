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
    public JTextArea MostrarDatos;
    public JComboBox TipoRolText;
    public JLabel tipoRol;
    public JFrame frameAgre;
    public JFrame frameAdmin;

    public AgregarJugador(JFrame frameAg, JFrame frameAdmin){
        this.frameAgre = frameAg;
        this.frameAdmin = frameAdmin;

        // JComboBox
        TipoRolText.addItem("Jugador");
        TipoRolText.addItem("Encargado");

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
                String tipoRol = (String) TipoRolText.getSelectedItem();

                // Conectar a la base de datos
                String url = "jdbc:mysql://localhost:3306/reservasCanchas";
                String user = "root";
                String password = "123456";

                try (Connection conn = DriverManager.getConnection(url, user, password)) {
                    String sql = "INSERT INTO agregar_jugadores (nombre, apellido, edad, cedula, email, contrasenia, telefono, tipo_rol) VALUES (?,?,?,?,?,?,?,?)";
                    PreparedStatement pstmt = conn.prepareStatement(sql); // Consultas en SQL

                    pstmt.setString(1, nombre);
                    pstmt.setString(2, apellido);
                    pstmt.setInt(3, Integer.parseInt(edad));
                    pstmt.setString(4, cedula);
                    pstmt.setString(5, email);
                    pstmt.setString(6, contrasenia);
                    pstmt.setString(7, telefono);
                    pstmt.setString(8, tipoRol);

                    //Limpiar cuadrso de registros
                    nombretext.setText("");
                    apellidotext.setText("");
                    edadtext.setText("");
                    cedulatext.setText("");
                    emailtext.setText("");
                    contratext.setText("");
                    telefonotext.setText("");

                    // Consulta en SQL que modificara en la base de datos como INSERT, DELETE y SELECT
                    int consultar = pstmt.executeUpdate();

                    if (consultar > 0) {
                        JOptionPane.showMessageDialog(frameAgre, "Cliente agregado exitosamente!");
                    } else {
                        JOptionPane.showMessageDialog(frameAgre, "Error al agregar cliente.");
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

                // Conectar a la base de datos
                String url = "jdbc:mysql://localhost:3306/reservasCanchas";
                String user = "root";
                String password = "123456";

                try (Connection conn = DriverManager.getConnection(url, user, password)) {
                    String sql = "SELECT * FROM agregar_jugadores WHERE cedula = ?";
                    PreparedStatement pstmt = conn.prepareStatement(sql);
                    pstmt.setString(1, cedulabuscartext.getText());

                    ResultSet resultSet = pstmt.executeQuery(); // Ejecuta consultas de SQL que devuelve resultados

                    if (resultSet.next()) {
                        String nombre = resultSet.getString("nombre");
                        String apellido = resultSet.getString("apellido");
                        int edad = resultSet.getInt("edad");
                        String cedula = resultSet.getString("cedula");
                        String email = resultSet.getString("email");
                        String contrasenia = resultSet.getString("contrasenia");
                        String telefono = resultSet.getString("telefono");
                        String tipoRol = resultSet.getString("tipo_rol");

                        //Mostrar datos
                        String datosJugador = "Nombre: " + nombre + "\n" +
                                "Apellido: " + apellido + "\n" +
                                "Edad: " + edad + "\n" +
                                "Cédula: " + cedula + "\n" +
                                "Email: " + email + "\n" +
                                "Contraseña: " + contrasenia + "\n" +
                                "Teléfono: " + telefono + "\n" + "Rol: " + tipoRol + "\n";
                        MostrarDatos.setText(datosJugador);

                        // Limpiar los campos de texto
                        nombretext.setText("");
                        apellidotext.setText("");
                        edadtext.setText("");
                        cedulatext.setText("");
                        emailtext.setText("");
                        contratext.setText("");
                        telefonotext.setText("");

                    } else {
                        JOptionPane.showMessageDialog(frameAgre, "Cliente no encontrado.");
                        MostrarDatos.setText("");
                    }
                } catch (Exception ex) {
                    ex.printStackTrace();
                    JOptionPane.showMessageDialog(frameAgre, "Error en la base de datos");
                }
            }
        });


        btneliminarJugador.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                // Conectar a la base de datos
                String url = "jdbc:mysql://localhost:3306/reservasCanchas";
                String user = "root";
                String password = "123456";

                String cedulaEliminar = cedulabuscartext.getText();

                if (cedulaEliminar.isEmpty()) {
                    JOptionPane.showMessageDialog(frameAgre, "Ingrese una cedula para eliminar.");
                    return;
                }
                try (Connection conn = DriverManager.getConnection(url, user, password)) {
                    String sql = "DELETE FROM agregar_jugadores WHERE cedula = ?";
                    PreparedStatement pstmt = conn.prepareStatement(sql);
                    pstmt.setString(1, cedulaEliminar);

                    int consultar = pstmt.executeUpdate();

                    if (consultar > 0) {
                        JOptionPane.showMessageDialog(frameAgre, "Cliente eliminado exitosamente!");
                        MostrarDatos.setText("");
                    } else {
                        JOptionPane.showMessageDialog(frameAgre, "Cliente no encontrado.");
                        MostrarDatos.setText("");
                    }
                } catch (Exception ex) {
                    ex.printStackTrace();
                    JOptionPane.showMessageDialog(frameAgre, "Error en la base de datos");
                }
            }
        });


        regresarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                frameAgre.dispose();

                if (frameAdmin != null && !frameAdmin.isVisible()) {
                    frameAdmin.setVisible(true);
                }
            }
        });
    }
}
