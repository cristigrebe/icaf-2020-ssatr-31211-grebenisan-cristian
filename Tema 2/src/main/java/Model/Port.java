package Model;

public class Port {
    private String name;
    private Object value;

    public Port(String name) {
        this.name = name;
        value = 0;
    }

    public synchronized Object getValue() {
        return value;
    }

    public synchronized void setValue(Object value) {
        this.value = value;
    }
}