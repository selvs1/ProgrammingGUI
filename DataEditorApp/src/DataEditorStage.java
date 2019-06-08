import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class DataEditorStage extends Stage{

    public DataEditorStage(Model model) {

        try {

            FXMLLoader loader = new FXMLLoader(getClass().getResource("DataEditor.fxml"));
            Parent root = (Parent) loader.load();
            //loader.<DataEditorController>getController().init(model);

            this.setTitle("Model Editor");
            this.setScene(new Scene(root, 300, 300));
            this.show();

        } catch (Exception e) {
            System.out.println("irgend ein Fehler: \n" + e);
        }


    }

}
