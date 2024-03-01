package lab1package;

class MyRunnable implements Runnable {
    private int start;
    private int end;
    private int interval;

    public MyRunnable(int start, int end, int interval) {
        this.start = start;
        this.end = end;
        this.interval = interval;
    }

    public void run() {
        for (int i = start; i <= end; i++) {
            System.out.println(Thread.currentThread().getName() + ": " + i);
            try {
                Thread.sleep(interval);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

public class Qn13_PriorityThread {
    public static void main(String[] args) {
        Thread t1 = new Thread(new MyRunnable(1, 4, 500));
        Thread t2 = new Thread(new MyRunnable(5, 10, 1000));
        Thread t3 = new Thread(new MyRunnable(11, 15, 1500));

        t1.setPriority(Thread.MIN_PRIORITY);
        t2.setPriority(Thread.NORM_PRIORITY);
        t3.setPriority(Thread.MAX_PRIORITY);

        t1.start();
        t2.start();
        t3.start();
    }
}

