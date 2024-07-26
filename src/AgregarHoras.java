import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

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
    public JFrame frameHora;

    public AgregarHoras(JFrame framehora) {
        this.frameHora = framehora;

        //Opciones del JComboBox pára el modo de registro
        tipo_cancha2.addItem("Cancha de cesped");
        tipo_cancha2.addItem("Cancha de cemento");
        tipo_cancha2.addItem("Cancha de tierra");
        tipo_cancha2.addItem("Cancha sintetico");

        regresarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frameHora.dispose();
                JFrame adminFrame = new JFrame("Administrador");
                adminFrame.setContentPane(new Administrador(adminFrame).admin);
                adminFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                adminFrame.setSize(900, 600);
                adminFrame.pack();
                adminFrame.setVisible(true);
            }
        });


        btnregistrarHora.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String fecha = fechatext.getText();
                String hora_inicio = hiniciotext.getText();
                String hora_fin = hfintext.getText();
                String tipo_cancha = (String) tipo_cancha2.getSelectedItem();

                //Agregar cancha a la base de datos
                String url = "jdbc:mysql://localhost:3306/reservasCanchas";
                String user = "root";
                String password = "123456";

                try(Connection conn = DriverManager.getConnection(url, user, password)) {
                    String sql = "INSERT INTO horarios (fecha, hora_inicio, hora_fin, tipo_cancha) VALUES (?,?,?,?)";
                    PreparedStatement pstmt = conn.prepareStatement(sql);

                    pstmt.setString(1, fecha);
                    pstmt.setString(2, hora_inicio);
                    pstmt.setString(3, hora_fin);
                    pstmt.setString(4, tipo_cancha);

                    int rowsAffected = pstmt.executeUpdate();

                    if (rowsAffected > 0) {
                        JOptionPane.showMessageDialog(null, "Hora registrada exitosamente!");
                    } else {
                        JOptionPane.showMessageDialog(null, "Error al registrar la hora!");
                    }
                }catch(Exception ex){
                    ex.printStackTrace();
                    JOptionPane.showMessageDialog(null, "Error en la base de datos");
                }
            }
        });
    }
}
