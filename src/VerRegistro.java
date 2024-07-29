import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class VerRegistro {
    public JTextArea verRegistros;
    public JButton btnVerRegistros;
    public JLabel img;
    public JPanel visualizar;
    public JLabel VerTipo;
    public JButton regresarButton;
    public JLabel titulo;
    public JFrame verFrame;
    public JComboBox verTipoCancaText;

    public VerRegistro(JFrame verframe) {
        this.verFrame = verframe;

        // Opciones del JComboBox
        verTipoCancaText.addItem("Cancha de cesped");
        verTipoCancaText.addItem("Cancha de cemento");
        verTipoCancaText.addItem("Cancha de tierra");
        verTipoCancaText.addItem("Cancha sintetico");


        btnVerRegistros.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });


        regresarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });

    }
}
