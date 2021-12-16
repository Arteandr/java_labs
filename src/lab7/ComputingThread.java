package lab7;

public class ComputingThread extends Thread {
    private Store store;

    public ComputingThread(Store store) {
        this.store = store;
    }

    @Override
    public void run() {
        while(!isInterrupted()) {
            try {
                double volume = store.Calculate();
                System.out.println("Площадь треугольника равна: " + volume);

                sleep(700);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
    }
}