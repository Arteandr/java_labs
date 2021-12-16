package lab9;

import java.io.File;

public class Main {
    public static void main(String[] args) {
        try {
            String path = new File(".").getCanonicalPath();
            FileEntity file = new FileEntity(path + "/src/lab9/");
            file.Work();
        } catch (Exception e) {
            e.printStackTrace();
        }
//
    }
}