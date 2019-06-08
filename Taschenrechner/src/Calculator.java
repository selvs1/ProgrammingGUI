import java.util.ArrayList;
import java.util.List;

public class Calculator {

    private List<String> history = new ArrayList<>();
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
        history.add(String.format("%d %s %d = %d", operand1, operator, operand2, result));
    }

    public List<String> getHistory() {
        if (history.size() > HISTORY_SIZE)
            history.remove(0);
        return history;
    }
}
