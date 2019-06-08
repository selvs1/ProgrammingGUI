import javafx.application.Platform;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.chart.PieChart;

import java.util.Observable;
import java.util.Observer;

public class PieChartController implements Observer {

    private Model model;
    // Chart model
    private ObservableList<PieChart.Data> pieChartData;
    @FXML
    private PieChart pieChart;

    @FXML
    protected void initialize() {
        this.pieChartData = this.pieChart.getData();
        this.pieChart.setLegendVisible(false);
    }

    public void init(Model model) {
        this.model = model;
        for (String name : this.model.getNames()) {
            this.pieChartData.add(
                    new PieChart.Data(name, this.model.getQuantity(name)));
        }
        this.model.addObserver(this);
    }

    @Override
    public void update(Observable o, Object arg) {
        Model.Entry entry = (Model.Entry) arg;
        boolean isNew = true;
        for (PieChart.Data d : pieChartData) {
            if (d.getName().equals(entry.getName()) ) {
                Platform.runLater(()->d.setPieValue(entry.getQuantity()));
                isNew = false;
                break;
            }
        }
        if (isNew) {
            Platform.runLater(()->this.pieChartData.add(
                    new PieChart.Data(entry.getName(), entry.getQuantity())));
        }
    }
}