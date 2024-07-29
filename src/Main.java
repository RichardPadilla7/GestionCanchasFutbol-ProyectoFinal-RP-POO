//Richard Padilla
import javax.swing.*;

public class Main {
    public static void main(String[] args) {

        JFrame frame = new JFrame("Gestion de canchas de futbol");
        frame.setContentPane(new LoginFutbol(frame).login);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(9000, 9000);
        frame.pack();
        frame.setVisible(true);

    }
}