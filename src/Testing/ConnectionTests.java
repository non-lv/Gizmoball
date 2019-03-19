package Testing;
import Model.Connection;
import Model.IGizmo;
import org.junit.Test;
import Model.Model;
import static org.junit.Assert.*;
public class ConnectionTests {
    IGizmo a;
    IGizmo b;
    Model m = new Model();
    Connection c = new Connection(a,b);

    @Test
    public void addingConnection(){
        m.addConnection(c);
        assertTrue(m.getConnections().contains(c));
        m.removeConnection(c);
        assertFalse(m.getConnections().contains(c));

        assertEquals(c.getAction(),b);
        assertEquals(c.getTrigger(),a);
    }
}
