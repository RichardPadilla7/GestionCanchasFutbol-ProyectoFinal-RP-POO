import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.*;

public class VerRegistro {
    public JTextArea verRegistros;
    public JButton btnVerRegistros;
    public JLabel img;
    public JPanel visualizar;
    public JLabel VerTipo;
    public JButton regresarButton;
    public JLabel titulo;
    public JFrame verFrame;
    public JComboBox verCanchaText;

    public VerRegistro(JFrame verframe) {
        this.verFrame = verframe;

        // Opciones del JComboBox
        verCanchaText.addItem("Cancha de cesped");
        verCanchaText.addItem("Cancha de cemento");
        verCanchaText.addItem("Cancha de tierra");
        verCanchaText.addItem("Cancha sintetico");


        btnVerRegistros.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // detalles de la base de datos de reservar_cancha
                String url = "jdbc:mysql://localhost:3306/reservasCanchas";
                String user = "root";
                String password = "123456";

                String tipoCancha = (String) verCanchaText.getSelectedItem();
                StringBuilder sb = new StringBuilder();

                try(Connection conn = DriverManager.getConnection(url, user, password)){
                    String sql = "SELECT * FROM reservar_canchas WHERE tipoCanchas_Reservas = ?";
                    PreparedStatement pstmt = conn.prepareStatement(sql);
                    pstmt.setString(1, tipoCancha);
                    ResultSet rs = pstmt.executeQuery();

                    while(rs.next()){
                        sb.append("Cédula: ").append(rs.getString("cedula")).append("\n")
                               .append("Fecha: ").append(rs.getDate("fecha")).append("\n")
                               .append("Hora: ").append(rs.getTime("hora")).append("\n")
                               .append("Tipo de Cancha: ").append(rs.getString("tipoCanchas_Reservas")).append("\n")
                                .append("Hora Fin: ").append(rs.getTime("hora_fin")).append("\n\n");
                    }
                    verRegistros.setText(sb.toString());
                }catch (Exception ex){
                    JOptionPane.showMessageDialog(verFrame, "Error en la base de datos");
                    ex.printStackTrace();
                }


                //detalle de la base de datos de canchas
                try(Connection conn = DriverManager.getConnection(url, user, password)){
                    String sql = "SELECT * FROM canchas WHERE tipoCanchas =?";
                    PreparedStatement pstmt = conn.prepareStatement(sql);
                    pstmt.setString(1, tipoCancha);
                    ResultSet rs = pstmt.executeQuery();

                    while(rs.next()){
                        sb.append("\n")
                               .append("Faculatad: ").append(rs.getString("facultad")).append("\n")
                               .append("Cedula: ").append(rs.getString("cedula")).append("\n")
                               .append("Tpo de cancha: ").append(rs.getString("tipo_cancha")).append("\n")
                                .append("Ubicacion: ").append(rs.getString("ubicacion")).append("\n")
                                .append("Capacidad: ").append(rs.getInt("capacidad")).append("\n\n");
                    }
                    img.setText(sb.toString());
                }catch (Exception ex) {
                    JOptionPane.showMessageDialog(verFrame, "Error en la base de datos");
                }

                // base de datos detalla de la tabla horarios
                try(Connection conn = DriverManager.getConnection(url, user, password)){
                    String sql = "SELECT * FROM horarios WHERE tipoCanchas_Horarios =?";
                    PreparedStatement pstmt = conn.prepareStatement(sql);
                    pstmt.setString(1, tipoCancha);
                    ResultSet rs = pstmt.executeQuery();

                    while(rs.next()){
                        sb.append("\n")
                               .append("Fecha: ").append(rs.getString("fecha")).append("\n")
                               .append("Hora de inicio: ").append(rs.getTime("hora_inicio")).append("\n")
                               .append("Hora de fin: ").append(rs.getTime("hora_fin")).append("\n")
                                .append("Tipo de cancha").append(rs.getString("tipo_cancha")).append("\n\n");
                    }
                    verRegistros.setText(sb.toString());
                }catch (Exception ex) {
                    JOptionPane.showMessageDialog(verFrame, "Error en la base de datos");
                }
            }
        });


        regresarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });

    }
}
