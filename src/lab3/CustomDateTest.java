package lab3;

import org.junit.Assert;
import org.junit.Test;

public class CustomDateTest {
    @Test
    public void first() {
        CustomDate d = new CustomDate();

        Assert.assertEquals(true, d.DateGreater("12.12.2040", "12.12.2010"));
        Assert.assertEquals(true, d.DateGreater("1.12.2050", "12.12.2040"));
        Assert.assertEquals(true, d.DateGreater("12.12.2050", "1.12.2050"));
    }

    @Test
    public void second() {
        CustomDate d = new CustomDate();

        Assert.assertEquals(true, d.IsLeap(2020));
        Assert.assertEquals(false, d.IsLeap(2021));
        Assert.assertEquals(true, d.IsLeap(2016));
    }
}
