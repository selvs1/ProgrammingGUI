/*
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;


public class DataEditorController {

    private final ObservableList<Data> data;

    private Model model;
    // Konstruktor muss nichts drin initialisiert werden

    @FXML
    private Label lblTitle;

    @FXML
    private TextField tfName, tfQuantity;

    @FXML
    private TableView<Data> table; //warnung: wegen generics

    @FXML
    private TableColumn<Data, Integer> nameCol, quantityCol;


    @FXML
    public void handleClickAdd(ActionEvent event) {
        System.out.println("Name: " + tfName.getText() + " Quantity: " + tfQuantity.getText());
        System.out.println(Integer.parseInt(tfQuantity.getText()));
        model.setQuantity(tfName.getText(), Integer.parseInt(tfQuantity.getText()));
        tfQuantity.setText("");
        tfName.setText("");


    }


    @FXML
    protected void initialize() {
        System.out.println("initialize wurde aufgerufen");
        // !! this.modeo == null !!

        this.data = this.table.getItems();

        nameCol.setCellValueFactory(d -> d.getValue().nameProperty());
        quantityCol.setCellValueFactory(new PropertyValueFactory<>("quantity"));


    }

    public void init(Model model) {
        this.model = model;
        this.model.addObserver(this);

        //TODO: fill up this data
    }


    public static class Data {
        private final StringProperty name;
        private final IntegerProperty quantity;

        public Data(String name, int quantity) {
            this.name = new SimpleStringProperty(name);
            this.quantity = new SimpleIntegerProperty(quantity);
        }

        public String getName() {
            return this.name.get();
        }

        public StringProperty namePropety() {
            return this.name;
        }

        public int getQuantity() {
            return this.quantity.get();
        }

        public void setQuantity(int q) {
            this.quantity.set(q);
        }

        public IntegerProperty quantityProperty() {
            return this.quantity;
        }
    }

}
*/
