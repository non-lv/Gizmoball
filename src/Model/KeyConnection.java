package Model;

public class KeyConnection {

    private IGizmo action;
    private int key;

    public KeyConnection(IGizmo action, int key) {
        this.action = action;
        this.key = key;
    }

    public void doAction() {
        action.trigger();
    }

    public int getKey() {
        return key;
    }
}
