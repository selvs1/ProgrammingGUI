import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;

public class Controller {

    private Calculator model;

    private int result;

    @FXML
    private TextField tfOperand1;

    @FXML
    private TextField tfOperand2;

    @FXML
    private Label lblOperator;


    @FXML
    private Label lblResult;

    @FXML
    private Button btnPlus;

    @FXML
    private Button btnMinus;

    @FXML
    private Button btnMultiply;

    @FXML
    private Button btnDivide;

    @FXML
    private ListView<String> lvHistory;

    @FXML
    public void handleClickDivide(ActionEvent event) {

        try {

            result = model.divide(Integer.parseInt(tfOperand1.getText()), Integer.parseInt(tfOperand2.getText()));
            lblResult.setText(String.valueOf(result));
            updateHistory();

        } catch (DivisionByZeroException e) {
            System.out.println(e.getMessage());
            lblResult.setText("NaN");
        } finally {
            lblOperator.setText("/");
        }

    }

    @FXML
    public void handleClickMinus(ActionEvent event) {
        result = model.subtract(Integer.parseInt(tfOperand1.getText()), Integer.parseInt(tfOperand2.getText()));
        lblResult.setText(String.valueOf(result));
        lblOperator.setText("-");
//        calcHistory.add(String.format("%s + %s = %d", tfOperand1.getText(), tfOperand2.getText(), result));
        updateHistory();

    }

    @FXML
    public void handleClickMultiply(ActionEvent event) {
        result = model.multiply(Integer.parseInt(tfOperand1.getText()), Integer.parseInt(tfOperand2.getText()));
        lblResult.setText(String.valueOf(result));
        lblOperator.setText("*");
//        calcHistory.add(String.format("%s + %s = %d", tfOperand1.getText(), tfOperand2.getText(), result));
        updateHistory();

    }

    @FXML
    public void handleClickPlus(ActionEvent event) {
        result = model.add(Integer.parseInt(tfOperand1.getText()), Integer.parseInt(tfOperand2.getText()));
        lblResult.setText(String.valueOf(result));
        lblOperator.setText("+");
//        calcHistory.add(String.format("%s + %s = %d", tfOperand1.getText(), tfOperand2.getText(), result));
        updateHistory();


    }

    public void init(Calculator model) {
        this.model = model;
//        this.model.addObserver(this);
    }

    @FXML
    protected void initialize() {
//        lvHistory = new ListView<String>();
        //updateHistory();

    }

    private void updateHistory() {
        lvHistory.getItems().clear();
        lvHistory.getItems().addAll(model.getHistory());
    }


}
