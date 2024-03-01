package lab1package;

public class Qn12_Thread {
    public static void main(String[] args) {
        Thread t1 = new Thread(new Runnable() {
            public void run() {
                for (int i = 1; i <= 10; i++) {
                    System.out.println(i);
                    try {
                        Thread.sleep(500); // Sleep for 0.5 seconds
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        });

        Thread t2 = new Thread(new Runnable() {
            public void run() {
                for (int i = 11; i <= 20; i++) {
                    System.out.println(i);
                    try {
                        Thread.sleep(1000); // Sleep for 1 second
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        });

        t1.start();
        t2.start();
    }
}
