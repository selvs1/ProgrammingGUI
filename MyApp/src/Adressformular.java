import javafx.application.Application;
import javafx.geometry.HPos;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class Adressformular extends Application {

    @Override
    public void start(Stage stage) throws Exception {
        GridPane root = new GridPane();


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
        root.add(lblHeadline, 0, 0, 4, 1);

        root.add(lblName, 0, 1, 1, 1);
        root.add(txtName, 1, 1, 4, 1);

        root.add(lblVorname, 0, 2, 1, 1);
        root.add(txtVorname, 1, 2, 4, 1);

        root.add(lblStrasse, 0, 3, 1, 1);
        root.add(txtStrasse, 1, 3, 4, 1);

        root.add(lblPlz, 0, 4, 1, 1);
        root.add(txtPlz, 1, 4, 1, 1);
        root.add(lblOrt, 2, 4, 1, 1);
        root.add(txtOrt, 3, 4, 1, 1);

        root.add(buttonOk, 2, 5, 1, 1);
        root.add(buttonCancel, 3, 5, 1, 1);



        // set properties
        root.setGridLinesVisible(true);
        root.setAlignment(Pos.CENTER);
        GridPane.setHalignment(lblHeadline, HPos.RIGHT);
        GridPane.setHalignment(buttonOk, HPos.RIGHT);
        GridPane.setHalignment(buttonCancel, HPos.RIGHT);


        // Create GUI done


        Scene scene = new Scene(root, 500, 300);
        stage.setTitle("Adressformular");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}