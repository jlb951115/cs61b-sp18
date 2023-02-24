import org.junit.Test;
import static org.junit.Assert.*;
public class TestOffByN {
    static OffByN offByN = new OffByN(5);

    @Test
    public void testequalsChars(){
        assertFalse(offByN.equalChars('f', 'h'));
        assertTrue(offByN.equalChars('a', 'f'));
        assertTrue(offByN.equalChars('f', 'a'));
    }
}
