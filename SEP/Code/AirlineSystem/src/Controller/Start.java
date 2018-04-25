package Controller;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Start extends Application {
    public static void main(String []args){
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        Parent root= FXMLLoader.load(getClass().getResource("../View/FXML/LogIn.fxml"));
        primaryStage.setTitle("Fly High");
        primaryStage.setScene(new Scene(root));
        primaryStage.show();
    }
}
