import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

public class AgregarCancha {
    public JButton btnagregarCancha;
    public JTextField facultadtext;
    public JTextField cedulatext;
    public JTextField ubitext;
    public JTextField capacidadtext;
    public JButton btnregresar;
    public JComboBox tipo_cancha1;
    public JPanel canchaPanel;
    public JLabel img;
    public JLabel titulo;
    public JLabel facultad;
    public JLabel cedula;
    public JLabel cancha;
    public JLabel ubicacion;
    public JLabel capacidad;
    public JButton btnborrarcancha;
    public JTextField ingresaFacutext;
    public JTextField ingresaCeduText;
    public JButton btnBuscarCancha;
    public JTextArea MostrarDatosCancha;
    private JLabel img2;
    private JLabel titulo2;
    private JLabel ingresefacultad;
    private JLabel ingresecedula;
    public JFrame frameCancha;
    public JFrame frameAdmin;

    public AgregarCancha(JFrame framecan, JFrame frameAdmin) {
        this.frameCancha = framecan;
        this.frameAdmin = frameAdmin;

        //Opciones del JComboBox pára el modo de registro
        tipo_cancha1.addItem("Cancha de cesped");
        tipo_cancha1.addItem("Cancha de cemento");
        tipo_cancha1.addItem("Cancha de tierra");
        tipo_cancha1.addItem("Cancha sintetico");


        btnregresar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                frameCancha.dispose();

                if (frameAdmin != null && !frameAdmin.isVisible()) {
                    frameAdmin.setVisible(true);
                }
            }
        });


        btnagregarCancha.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //Validar datos
                String facultad = facultadtext.getText();
                String cedula = cedulatext.getText();
                String tipo_cancha = (String) tipo_cancha1.getSelectedItem();
                String ubicacion = ubitext.getText();
                String capacidad = capacidadtext.getText();

                //Agregar cancha a la base de datos
                String url = "jdbc:mysql://localhost:3306/reservasCanchas";
                String user = "root";
                String password = "123456";

                try(Connection conn = DriverManager.getConnection(url, user, password)) {
                    String sql = "INSERT INTO canchas (facultad, cedula, tipo_cancha, ubicacion, capacidad) VALUES (?,?,?,?,?)";
                    PreparedStatement pstmt = conn.prepareStatement(sql);

                    pstmt.setString(1, facultad);
                    pstmt.setString(2, cedula);
                    pstmt.setString(3, tipo_cancha);
                    pstmt.setString(4, ubicacion);
                    pstmt.setInt(5, Integer.parseInt(capacidad));

                    //Limpiar las casilla
                    facultadtext.setText("");
                    cedulatext.setText("");
                    ubitext.setText("");
                    capacidadtext.setText("");

                    int rowsAffected = pstmt.executeUpdate();

                    if (rowsAffected > 0) {
                        JOptionPane.showMessageDialog(frameCancha, "Cancha agregada exitosamente!");
                    } else {
                        JOptionPane.showMessageDialog(frameCancha, "Error al agregar cancha. Intente nuevamente.");
                    }
                }catch (Exception ex){
                    ex.printStackTrace();
                    JOptionPane.showMessageDialog(frameCancha, "Error en la base de datos");
                }
            }
        });


        btnBuscarCancha.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Conectar a la base de datos
                String url = "jdbc:mysql://localhost:3306/reservasCanchas";
                String user = "root";
                String password = "123456";

                String cedulaBuscar = ingresaCeduText.getText();
                String facultadBuscar = ingresaFacutext.getText();

                try(Connection conn = DriverManager.getConnection(url, user, password)){
                    String sql = "SELECT * FROM canchas WHERE cedula =? AND facultad =?";
                    PreparedStatement pstmt = conn.prepareStatement(sql);

                    pstmt.setString(1, cedulaBuscar);
                    pstmt.setString(2, facultadBuscar);

                    ResultSet resultSet = pstmt.executeQuery();

                    if (resultSet.next()) {
                        MostrarDatosCancha.setText("Facultad: " + resultSet.getString("facultad") +
                                "\nCedula: " + resultSet.getString("cedula") +
                                "\nTipo de cancha: " + resultSet.getString("tipo_cancha") +
                                "\nUbicacion: " + resultSet.getString("ubicacion") +
                                "\nCapacidad: " + resultSet.getInt("capacidad"));

                        // Limpiar los campos de texto
                        facultadtext.setText("");
                        cedulatext.setText("");
                        ubitext.setText("");
                        capacidadtext.setText("");

                    } else {
                        JOptionPane.showMessageDialog(frameCancha, "Cancha no encontrada");
                        MostrarDatosCancha.setText("");
                    }
                }catch (Exception ex){
                    ex.printStackTrace();
                    JOptionPane.showMessageDialog(frameCancha, "Error en la base de datos");
                }
            }
        });


        btnborrarcancha.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Conectar a la base de datos
                String url = "jdbc:mysql://localhost:3306/reservasCanchas";
                String user = "root";
                String password = "123456";

                //Validar los objetos
                String cedulaBorrar = ingresaCeduText.getText();
                String facultadBorrar = ingresaFacutext.getText();

                try(Connection conn = DriverManager.getConnection(url, user, password)){
                    String sql = "DELETE FROM canchas WHERE cedula =? AND facultad =?";
                    PreparedStatement pstmt = conn.prepareStatement(sql);

                    pstmt.setString(1, cedulaBorrar);
                    pstmt.setString(2, facultadBorrar);

                    int consultar = pstmt.executeUpdate();

                    if (consultar > 0) {
                        JOptionPane.showMessageDialog(frameCancha, "Cancha eliminada exitosamente!");
                        MostrarDatosCancha.setText("");
                    } else {
                        JOptionPane.showMessageDialog(frameCancha, "Cancha no encontrado.");
                        MostrarDatosCancha.setText("");
                    }
                } catch (Exception ex) {
                    ex.printStackTrace();
                    JOptionPane.showMessageDialog(frameCancha, "Error en la base de datos");
                }

            }
        });
    }
}
