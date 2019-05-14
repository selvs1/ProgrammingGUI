import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;


public class GFR extends Application {

    Label lblAlter;
    Label lblWeight;
    Label lblConcentration;
    Label lblMaleFemale;
    Label lblGfr;

    ComboBox cbAlter;
    TextField tfWeight;
    TextField tfConcentration;

    ToggleGroup tgMaleFemale;
    RadioButton rbMale;
    RadioButton rbFemale;
    Label lblGfrResult;

    Button btnCalc;


    @Override
    public void start(Stage stage) {

        BorderPane root = new BorderPane();

        // Linke Spalte
        lblAlter = new Label("Alter [Jahre]:");
        lblWeight = new Label("Gewicht [kg]:");
        lblConcentration = new Label("Serum-Kreatinin [mg/dl]:");
        lblMaleFemale = new Label("Geschlecht:");
        lblGfr = new Label("GFR:");

        VBox column1 = new VBox(10);
        column1.getChildren().addAll(lblAlter, lblWeight, lblConcentration, lblMaleFemale, lblGfr);

        // Rechte Spalte
        cbAlter = new ComboBox();
        cbAlter.getItems().addAll(generator(99));
        tfWeight = new TextField();
        tfConcentration = new TextField();


        tgMaleFemale = new ToggleGroup();

        rbMale = new RadioButton("männlich");
        rbMale.setToggleGroup(tgMaleFemale);

        rbFemale = new RadioButton("weiblich");
        rbFemale.setToggleGroup(tgMaleFemale);

        lblGfrResult = new Label("getOutput");

        btnCalc = new Button("Berechnen");
        // geht auch setOnAction

        btnCalc.addEventHandler(ActionEvent.ACTION, event -> {
            // Formel ((140-Alter) * Gewicht) * [falls Weiblich: 0.85])/(72*[Serum Kreatinini in mg/dl])
            int tmpAge = Integer.parseInt(cbAlter.getSelectionModel().getSelectedItem().toString());
            //int tmp2 = (int) cbAlter.getSelectionModel().getSelectedItem();
            double tmpWeight = Double.parseDouble(tfWeight.getText());
            double tmpCreatinin = Double.parseDouble(tfConcentration.getText());
            double tmpMfFactor = 1;
            if (rbFemale.isSelected())
                tmpMfFactor = 0.85;

            double calcResult = ((140 - tmpAge) * tmpWeight) * (tmpMfFactor) / (72 * tmpCreatinin);

            lblGfrResult.setText((String.format("%.2f", calcResult)));


        });
        VBox column2 = new VBox();
        column2.getChildren().addAll(cbAlter, tfWeight, tfConcentration, rbMale, rbFemale, lblGfrResult);


        HBox topContent = new HBox();
        topContent.getChildren().addAll(column1, column2);
        topContent.setStyle("-fx-border-color: black;" + "-fx-border-insets: 10;");


        HBox bottomContent = new HBox();
        bottomContent.getChildren().addAll(btnCalc);
        bottomContent.setAlignment(Pos.CENTER);
        bottomContent.setStyle("-fx-border-color: red;");

        root.setCenter(topContent);
        root.setBottom(bottomContent);

        // done


        Scene scene = new Scene(root, 450, 500);
        stage.setTitle("Cockcroft-Gault-Formel");
        stage.setScene(scene);
        stage.show();
    }


    private Integer[] generator(int count) {
        int size = count;
        Integer[] result = new Integer[size];

        for (int i = 0; i < result.length; i++) {
            result[i] = i + 1;
        }
        return result;
    }


    public static void main(String[] args) {
        launch(args);
    }
}
