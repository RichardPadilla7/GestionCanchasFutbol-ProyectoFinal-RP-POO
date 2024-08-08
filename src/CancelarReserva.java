import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class CancelarReserva {
    public JTextField canCedulaText;
    public JComboBox canTipoText;
    public JButton btnCancelar;
    public JButton regresarButton;
    public JLabel img;
    public JLabel titulo;
    public JPanel cancelar;
    public JLabel ingreseCedula;
    public JLabel cancelarTipo;
    public JFrame cancelarFrame;
    public JFrame JugaFrame;

    public CancelarReserva(JFrame canceframe, JFrame JugaFrame) {
        this.cancelarFrame = canceframe;
        this.JugaFrame = JugaFrame;

        // Opciones del JComboBox para el modo de registro
        canTipoText.addItem("Cancha de cesped");
        canTipoText.addItem("Cancha de cemento");
        canTipoText.addItem("Cancha de tierra");
        canTipoText.addItem("Cancha sintetico");



        btnCancelar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                String cedula = canCedulaText.getText();
                String tipo = (String) canTipoText.getSelectedItem();
                String sql = "DELETE FROM reservar_canchas WHERE cedula =? AND tipoCanchas_Reservas =?";

                //Conectar a la base de datos
                String url = "jdbc:mysql://localhost:3306/reservasCanchas";
                String user = "root";
                String password = "123456";


                //logica mediante cedulae en la base de datos elimine la reserva.
                try (Connection conn = DriverManager.getConnection(url, user, password);
                     PreparedStatement pstmt = conn.prepareStatement(sql)) {
                    pstmt.setString(1, cedula);
                    pstmt.setString(2, tipo);

                    int consultar = pstmt.executeUpdate();

                    if (consultar > 0) {
                        JOptionPane.showMessageDialog(cancelarFrame, "Reserva cancelada exitosamente!");
                        canCedulaText.setText("");
                        canTipoText.setSelectedIndex(0);

                    } else {
                        JOptionPane.showMessageDialog(cancelarFrame, "No se encontró una reserva con esa cédula y tipo de cancha.");
                        canCedulaText.setText("");
                        canTipoText.setSelectedIndex(0);
                    }
                }catch(Exception ex){
                        ex.printStackTrace();
                        JOptionPane.showMessageDialog(cancelarFrame, "Error en la base de datos");
                    }
            }
        });



        regresarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cancelarFrame.dispose();
                if (JugaFrame != null && !JugaFrame.isVisible()) {
                    JugaFrame.setVisible(true);
                }
            }
        });

    }
}
