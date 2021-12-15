package lab2;

import org.junit.Assert;
import org.junit.Test;

public class CustomArrayTest {
    @Test
    public void first() {
        CustomArray arr = new CustomArray();

        int[] expected1 = new int[] {1,2,3,4,5};
        int[] actual = arr.booble(new int[] {5,1,2,3,4});
        Assert.assertArrayEquals(expected1, actual);
    }

    @Test
    public void second() {
        CustomArray arr = new CustomArray();

        int[] expected1 = new int[] {123,234,235};
        int[] actual = arr.booble(new int[] {234,123,235});
        Assert.assertArrayEquals(expected1, actual);
    }

    @Test
    public void third() {
        CustomArray arr = new CustomArray();

        int[] expected1 = new int[] {10, 20, 30, 40};
        int[] actual = arr.booble(new int[] {40, 10, 20 ,30});
        Assert.assertArrayEquals(expected1, actual);
    }
}
