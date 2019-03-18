package Model;

public class KeyConnection {

    private IGizmo action;
    private int key;
    private KeyStatus status;
    public enum KeyStatus {
        DOWN, UP
    }

    public KeyConnection(IGizmo action, int key, KeyStatus status) {
        this.action = action;
        this.key = key;
        this.status = status;
    }

    public void doAction() {
        action.trigger(null);
    }

    public int getKey() {
        return key;
    }

    public KeyStatus getStatus(){
        return status;
    }
}
