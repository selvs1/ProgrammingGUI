import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Calculator {
    private static final String DATA_FILE = ".HistoryData.txt";
    private ArrayList<String> history = new ArrayList<>();
    private static int HISTORY_SIZE = 5;

    int add(int operand1, int operand2) {
        int result = operand1 + operand2;
        addHistory(operand1, operand2, "+", result);
        return result;
    }

    int subtract(int operand1, int operand2) {
        int result = operand1 - operand2;
        addHistory(operand1, operand2, "-", result);
        return result;
    }

    int multiply(int operand1, int operand2) {
        int result = operand1 * operand2;
        addHistory(operand1, operand2, "*", result);
        return result;
    }

    int divide(int operand1, int operand2) throws DivisionByZeroException{
        if (operand2 == 0) {
            throw new DivisionByZeroException("Null Division nicht erlaubt");
        }
        int result = operand1 / operand2;
        addHistory(operand1, operand2, "/", result);
        return result;
    }

    public void addHistory(int operand1, int operand2, String operator, int result) {
        String dataSet = String.format("%d %s %d = %d", operand1, operator, operand2, result);
        history.add(dataSet);
        saveData();
    }

    public List<String> getHistory() {
        if (history.size() > HISTORY_SIZE)
            history.remove(0);
        return history;
    }


    public void saveData() {
        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(DATA_FILE))) {
            out.writeObject(history);
        } catch (IOException e) {
            System.out.println(e);
        }
    }

    public void loadData() {
        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(DATA_FILE))) {
            history = (ArrayList<String>)in.readObject();
        } catch (ClassNotFoundException e) {
            System.out.println(e);
        } catch (IOException e) {
            System.out.println(e);

        }
    }
}
