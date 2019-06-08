import javafx.application.Platform;
import javafx.geometry.Pos;
import javafx.scene.control.*;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

import java.util.Observable;
import java.util.Observer;


public class Stopwatch extends BorderPane implements Observer {

    // keine unnötige Instanzvariablen erstellen
    private final Timer timer;
    private Label lblTmr;
    private Label lblStatus;
    private Button buttonStart;
    private Button buttonStopp;


    public Stopwatch(final Timer timer) {

/*        timer = new Timer(10);
        timer.attach(this);
        timer.run();*/

        this.timer = timer;
        this.timer.addObserver(this);


        // custom design start



        // Designbereich

        // Menubar
        MenuBar menuBar = new MenuBar();

        Menu fileMenu = new Menu("File");
        Menu helpMenu = new Menu("Help");

        MenuItem newItem = new Menu("New");
        MenuItem closeItem = new Menu("Close all");
        MenuItem aboutItem = new Menu("About");

        closeItem.setOnAction(event -> {
            System.exit(0);
        });

        fileMenu.getItems().addAll(newItem, closeItem);
        helpMenu.getItems().addAll(aboutItem);

        menuBar.getMenus().addAll(fileMenu, helpMenu);




        // Struktur rechts
        HBox display = new HBox();
        this.setCenter(display);
        // objekte erstellen
        Label lblSeconds = new Label("Sekunden:");
        lblTmr = new Label("0:00");
        // Zuweisen
        display.getChildren().addAll(lblSeconds, lblTmr);
        // Properties
        display.setStyle("-fx-border-color: black;" + "-fx-border-insets: 10;");
        display.setAlignment(Pos.CENTER);
        display.setSpacing(10);


        // Struktur links
        VBox childLeft = new VBox();
        this.setBottom(childLeft);
        // Objekte erstellen
        buttonStart = new Button("Start");
        buttonStart.setOnAction(event -> {
            timer.start();
        });


        buttonStopp = new Button("Stopp");
        buttonStopp.setOnAction(event -> {
            timer.stop();
        });
        Button buttonReset = new Button("Reset");
        buttonReset.setOnAction(event -> {
            timer.reset();
        });

        lblStatus = new Label("getStatus");
        HBox controls = new HBox();
        // Zuweisen
        controls.getChildren().addAll(buttonStart, buttonStopp, buttonReset);
        controls.setStyle("-fx-border-color: blue;");
        controls.setAlignment(Pos.CENTER);
        controls.setSpacing(10);
        childLeft.getChildren().addAll(controls, lblStatus);


        this.setTop(menuBar);
        // custom design finish

        //Locher: BorderPane.setMargin(childRight, new Insets(10, 10, 5, 10));


    }


    @Override
    public void update(Observable o, Object arg) {

        //Display Update
        Platform.runLater(() -> {
            // nicht ressourcen schonend? abkl. ev. mit $
            lblTmr.setText(String.format("%02d:%02d:%02d:%02d", timer.getHours(), timer.getMinutes(), timer.getSeconds(), (int) (timer.getTime() * 100) % 100));
            //System.out.println("test");
        });

        if ((timer.isRunning())) {
            lblStatus.setText("Running");
            buttonStart.setDisable(true);
            buttonStopp.setDisable(false);
            // Das mit dem Button ausgrauen hier implementieren
        } else {
            lblStatus.setText("Stopped");
            buttonStopp.setDisable(true);
            buttonStart.setDisable(false);
        }


        // der Scene Graf darf nur durch Gui Thread verändert werden

    }
}



// Platform.runLater -> nur dort wo notwendig ist verwenden