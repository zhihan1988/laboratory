package thead;

/**
 * Created by liuzhihan on 2016/6/7.
 */
public class WaitNotifyDemo implements Runnable {
    private String name;
    private Object lock;

    public WaitNotifyDemo(String name, Object lock) {
        this.name = name;
        this.lock = lock;
    }
    public void run() {
        while (true) {
            synchronized (lock) {
                System.out.println(Thread.currentThread().getName()+":"+name);
                try {
                    Thread.sleep(1000L);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                lock.notify();
                try {
                    lock.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static void main(String[] args) {
        Object lock = new Object();
        WaitNotifyDemo test = new WaitNotifyDemo("A", lock);
        WaitNotifyDemo test2 = new WaitNotifyDemo("B", lock);
        Thread thread = new Thread(test);
        Thread thread2 = new Thread(test2);
        thread.start();
        thread2.start();

    }
}
