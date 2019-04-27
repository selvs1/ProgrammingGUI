import javafx.application.Application;
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


public class MyApp extends Application {

    @Override
    public void start(Stage stage) throws Exception {

        // custom design start


        // Designbereich
        BorderPane root = new BorderPane();


        // Struktur rechts
        HBox childRight = new HBox();
        root.setCenter(childRight);
        // objekte erstellen
        Label lblSeconds = new Label("Sekunden:");
        Label lblTmr = new Label("0:00");
        // Zuweisen
        childRight.getChildren().addAll(lblSeconds, lblTmr);
        // Properties
        childRight.setStyle("-fx-border-color: black;" + "-fx-border-insets: 10;");
        childRight.setAlignment(Pos.CENTER);
        childRight.setSpacing(10);


        // Struktur links
        VBox childLeft = new VBox();
        root.setBottom(childLeft);
        // Objekte erstellen
        Button buttonStart = new Button("Start");
        Button buttonStopp = new Button("Stopp");
        Button buttonReset = new Button("Reset");
        Label lblStatus = new Label("getStatus");
        HBox childLeftSub = new HBox();
        // Zuweisen
        childLeftSub.getChildren().addAll(buttonStart, buttonStopp, buttonReset);
        childLeftSub.setStyle("-fx-border-color: blue;");
        childLeftSub.setAlignment(Pos.CENTER);
        childLeftSub.setSpacing(10);
        childLeft.getChildren().addAll(childLeftSub, lblStatus);


        // custom design finish


        Scene scene = new Scene(root, 300, 300);
        stage.setTitle("My App");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }


}