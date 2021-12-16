package lab7;

import java.util.Scanner;

public class ControlThread extends Thread {
    private Scanner sc;

    private Thread ct;
    private Store store;

    public ControlThread(Thread ct, Store store) {
        this.sc = new Scanner(System.in);
        this.ct = ct;
        this.store = store;
    }

    @Override
    public void run() {
        while(!this.isInterrupted()) {
            try {
                System.out.println("1 - Вычислить площадь треугольника");
                System.out.println("2 - Выход");
                int key = this.Input("Ваш выбор: ", 1,2, true);
                if(key == 2) {
                    this.interrupt();
                    this.ct.interrupt();
                    break;
                }
                int a,b,c;
                a = this.Input("А: ", 0,0 , false);
                b = this.Input("B: ", 0,0 , false);
                c = this.Input("C: ", 0,0 , false);

                this.store.UpdateValue(a,b,c);

                this.ct.start();
                sleep(100);
            } catch (Exception e) {
                Thread.currentThread().interrupt();
            }
        }
    }

    private int Input(String msg, int min, int max, boolean withCheck) {
       int key;

       do {
           System.out.println(msg);
           while(!this.sc.hasNextInt()) {
               System.out.println(msg);
               this.sc.next();
           }
           key = this.sc.nextInt();
       } while ((key < min || key > max) && withCheck);

       return key;
    }
}
