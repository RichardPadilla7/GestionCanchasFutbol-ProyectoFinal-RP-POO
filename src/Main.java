//Richard Padilla
import javax.swing.*;

public class Main {
    public static void main(String[] args) {

        JFrame frame = new JFrame("Gestion de canchas de futbol");
        frame.setContentPane(new LoginFutbol(frame).login);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300, 300);
        frame.setLocationRelativeTo(null); //Centra la ventana en la pantalla
        frame.pack();
        frame.setVisible(true);
    }
}