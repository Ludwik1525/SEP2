

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Start extends Application {
    public static void main(String[] args) {

        System.out.println("PostgreSQL JDBC connection testing ");
        try {
            Class.forName("org.postgresql.Driver");
        } catch (ClassNotFoundException e) {

            System.out.println("Couldnt find the driver, add driver to your library path");
            e.printStackTrace();
            return;

        }
        System.out.println("PostgreSQL JDBC Driver registered");
        Connection connection = null;

        try {
            connection = DriverManager.getConnection(
                    "jdbc:postgresql://localhost:5432/fly_high_database", "postgres",
                    "postgres");

        } catch (SQLException e) {
            System.out.println("Connection failed. Check output console");
            e.printStackTrace();
            return;
        }
        if (connection != null) {
            System.out.println("Connecction established");
        } else {
            System.out.println("Failed to make connection.");
        }
        launch(args);
    }


    @Override
    public void start(Stage primaryStage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("View/FXML/LogIn.fxml"));
        primaryStage.setTitle("Fly High");
        primaryStage.setScene(new Scene(root));
        primaryStage.show();

    }


}
