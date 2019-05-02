import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;


public class GFR extends Application {

    Label lblAlter;
    Label lblWeight;
    Label lblConcentration;
    Label lblSex;
    Label lblGfr;

    ComboBox cbAlter;
    TextField tfWeight;
    TextField tfConcentration;

    ToggleGroup tgMaleFemale;
    RadioButton rbMale;
    RadioButton rbFemale;




    @Override
    public void start(Stage stage) {


        BorderPane root = new BorderPane();







        Scene scene = new Scene(root, 350, 300);
        stage.setTitle("Cockcroft-Gault-Formel");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
