package lab10;

import lab10.interfaces.IStringServer;

import java.util.Arrays;

public class StringServer implements IStringServer {

    @Override
    public String sort(String str) {
        String[] arr = str.split(" ");
        Arrays.sort(arr);
        return String.join(" ", arr);
    }
}
