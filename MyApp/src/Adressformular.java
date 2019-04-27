import javafx.application.Application;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.awt.*;

public class Adressformular extends Application {

    @Override
    public void start(Stage stage) throws Exception {
        GridPane root = new GridPane();
        root.setGridLinesVisible(true);

        // Create GUI

        // creating Objects
        Label lblHeadline = new Label("Adresse");

        Label lblName = new Label("Name");
        TextField txtName = new TextField();

        Label lblVorname = new Label("Vorname");
        TextField txtVorname = new TextField();

        Label lblStrasse = new Label("Strasse");
        TextField txtStrasse = new TextField();

        Label lblPlz = new Label("PLZ");
        TextField txtPlz = new TextField();

        Label lblOrt = new Label("Ort");
        TextField txtOrt = new TextField();

        Button buttonOk = new Button("OK");
        Button buttonCancel = new Button("Cancel");

        // input in gridpane
        root.add(lblHeadline, 0, 0);

        root.add(lblName, 0, 1);
        root.add(txtName, 1, 1);

        root.add(lblVorname, 0, 2);
        root.add(txtVorname, 1, 2);

        root.add(lblStrasse, 0, 3);
        root.add(txtStrasse, 1, 3);

        root.add(lblPlz, 0, 4);
        root.add(txtPlz, 1, 4);
        root.add(lblOrt, 2, 4);
        root.add(txtOrt, 3, 4);

        root.add(buttonOk, 0, 5);
        root.add(buttonCancel, 1, 5);


        // Create GUI done




        Scene scene = new Scene(root, 300,300);
        stage.setTitle("Adressformular");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}