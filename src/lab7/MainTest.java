package lab7;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class MainTest {
    private Store store;
    @Before
    public void Init() {
        this.store = new Store();
    }

    @Test
    public void first() throws  InterruptedException {
        store.UpdateValue(4,4,4);
        Assert.assertEquals((int) store.Calculate(), (int)6.928203230275509);
    }

    @Test
    public void second() throws InterruptedException {
        store.UpdateValue(2,2,2);
        Assert.assertEquals((int) store.Calculate(), (int)1.7320508075688772);
    }

    @Test
    public void third() throws InterruptedException {
        store.UpdateValue(4,44,44);
        Assert.assertEquals((int) store.Calculate(), (int)1.7320508075688772);
    }
}
