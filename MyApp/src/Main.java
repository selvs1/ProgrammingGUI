import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.beans.EventHandler;


public class Main extends Application {

    @Override
    public void start(Stage stage) throws Exception {

        Timer time = new Timer(10);

        Stopwatch sw1 = new Stopwatch(time);
        Scene scene = new Scene(sw1, 350, 300);
        stage.setTitle("sw1");
        stage.setScene(scene);
        stage.show();


        Stopwatch sw2 = new Stopwatch(time);
        Scene scene2 = new Scene(sw2, 350, 300);
        Stage stage2 = new Stage();
        stage2.setTitle("sw2");
        stage2.setScene(scene2);
        stage2.show();



    }

    public static void main(String[] args) {
        launch(args);
    }


}