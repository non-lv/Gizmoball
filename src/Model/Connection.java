package Model;

public class Connection {

    private IGizmo trigger;
    private IGizmo action;

    public Connection(IGizmo trigger, IGizmo action){
        this.trigger = trigger;
        this.action = action;
    }

    public IGizmo getTrigger(){
        return trigger;
    }

    public IGizmo getAction(){
        return action;
    }

    public void triggered(){
        action.trigger();
    }
}
