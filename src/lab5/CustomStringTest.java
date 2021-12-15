package lab5;

import org.junit.Assert;
import org.junit.Test;

public class CustomStringTest {
    @Test
    public void first() {
        CustomString cs = new CustomString();

        Assert.assertEquals("a b c d e", cs.Sort("b e d c a"));
        Assert.assertEquals("а б в г д", cs.Sort("б д г в а"));
        Assert.assertEquals("ананас заец кот", cs.Sort("заец ананас кот"));
    }

    @Test
    public void second() {
        CustomString cs = new CustomString();

        Assert.assertEquals(true, cs.IsValid("a b c d e"));
    }
}
