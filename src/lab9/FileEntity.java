package lab9;

import java.io.*;

public class FileEntity {
    String path;

    public FileEntity(String path) {
        this.path = path;
    }

    public void Work() throws IOException {
        File file = new File(this.path + "/src.txt");

        if(file.exists()) {
            BufferedReader buff = new BufferedReader(new FileReader(this.path + "/src.txt"));
            String line = "";
            while(line.isEmpty()) {
                try {
                    line = buff.readLine().trim();
                } catch (Exception e) {
                    break;
                }
            }

            if(line.isEmpty()) {
                System.out.println("Файл src.txt пуст");
            } else
                this.WriteResult(line);

        } else {
            System.out.println("Файл src.txt несуществует");
            return;
        }
    }

    private void WriteResult(String line ) {
        File file = new File(this.path + "/res.txt");

        if (!file.exists()) {
            try {
                boolean created = file.createNewFile();
                if (created) {
                    file.setWritable(true);
                    System.out.println("Файл res.txt был создан");
                }
            } catch (Exception e) {
                System.out.println(e);
                return;
            }
        }

        try {
            PrintWriter pw = new PrintWriter(this.path + "/res.txt", "UTF-8");
            pw.println(line);
            pw.close();
            System.out.println("Результат успешно записан в файл res.txt");
        } catch (Exception e) {
            System.out.println("[ОШИБКА]: " + e);
            return;
        }
    }
}
