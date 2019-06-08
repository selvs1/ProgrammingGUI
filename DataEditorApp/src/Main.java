import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage stage) throws Exception {
        Model model = new Model();
        new DataEditorStage(model);
        new PieChartStage(model);

    }

    public static void main(String[] args) {
        launch(args);
    }
}
