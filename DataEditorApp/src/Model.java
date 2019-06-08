import java.util.HashMap;
import java.util.Observable;
import java.util.Set;

public class Model extends Observable {

    private HashMap<String, Integer> data = new HashMap<>();

    public Model() {
        // Just some test data! Data might be retrieved from anywhere...
        this.data.put("Tomate", 25);
        this.data.put("Fenchel", 22);
        this.data.put("Radisli", 30);
        this.data.put("Test", 99);
    }
    public Set<String> getNames() {
        return this.data.keySet();
    }
    public int getQuantity(String name) {
        return this.data.get(name);
    }
    public void setQuantity(String name, int quantity) {
        this.data.put(name, quantity);
        this.setChanged();
        this.notifyObservers(new Entry(name, quantity));
    }

    // Immutable Data Transfer Object
    public static class Entry {
        private String name;
        private int quntity;

        private Entry(String name, int quantity) {
            this.name = name;
            this.quntity = quantity;
        }
        public String getName() {
            return this.name;
        }
        public int getQuantity() {
            return this.quntity;
        }
    }
}