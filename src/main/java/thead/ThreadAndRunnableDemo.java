package thead;

/**
 * Thread类中run()和start()方法的区别如下：
   run()方法:在本线程内调用该Runnable对象的run()方法，可以重复多次调用；
   start()方法:启动一个线程，调用该Runnable对象的run()方法，不能多次启动一个线程；
 * Created by liuzhihan on 2016/6/7.
 */
public class ThreadAndRunnableDemo implements Runnable {
    private String name;

    public ThreadAndRunnableDemo(String name) {
        this.name = name;
    }
    public void run() {
        System.out.println(Thread.currentThread().getName() + ":" + name);
        try {
            Thread.sleep(1000L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

    public static void main(String[] args) {
        Object lock = new Object();
        ThreadAndRunnableDemo test = new ThreadAndRunnableDemo("A");
        ThreadAndRunnableDemo test2 = new ThreadAndRunnableDemo("B");
        test.run();   //main:A
        test2.run();  //main:B
        Thread thread = new Thread(test);
        Thread thread2 = new Thread(test2);
        thread.start();//Thread-0:A
        thread2.start();//Thread-1:B

    }
}
