package lab7;

public class Main {
    public static Store store = new Store();

    public static void main(String[] args) {
        Thread comp_t = new ComputingThread(store);
        Thread control_t = new ControlThread(comp_t, store);

        control_t.start();
    }

}
