//Richard Padilla
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.*;

public class Main {
    public static void main(String[] args) {
/*
        String URL = "jdbc:mysql://localhost:3306/gestionCanchas";
        String USER = "root";
        String PASSWORD = "123456";

        try (Connection connection = DriverManager.getConnection(URL, USER, PASSWORD)) {
            System.out.println("Conectado a la base de datos");
            String query = "select * from usuarios";
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);
        }catch (SQLException e) {
            System.out.println(e.getMessage());
        }*/


        JFrame frame = new JFrame("Gestion de canchas de futbol");
        frame.setContentPane(new LoginFutbol().login);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(9000, 9000);
        frame.pack();
        frame.setVisible(true);

    }
}