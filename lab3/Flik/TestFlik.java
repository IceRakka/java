import static org.junit.Assert.*;
import org.junit.Test;

public class TestFlik {
    @Test
    public void testFlik() {
        assertTrue(128 == 128);
        assertTrue(Flik.isSameNumber(128, 128));
    }
}