package lab7;

public class Store {
    private int a,b,c;

    private boolean f = true;

    public synchronized void UpdateValue(int a, int b, int c) throws InterruptedException {
        while(!f)
            wait();

        this.f = false;

        notifyAll();

        this.a = a;
        this.b = b;
        this.c = c;
    }

    public synchronized double Calculate() throws InterruptedException {
        while(f)
            wait();

        this.f = true;

        notifyAll();
        System.out.println(this.a+this.b+this.c);
        int p = (this.a + this.b + this.c) / 2;
        double s = Math.sqrt(p * (p-a) * (p-b) * (p-c));

        return s;
    }
}
