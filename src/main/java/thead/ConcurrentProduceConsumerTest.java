package thead;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

/**
 * Created by liuzhihan on 2017/3/15.
 */
public class ConcurrentProduceConsumerTest {
    BlockingQueue<Integer> blockingQueue = new ArrayBlockingQueue(6);
    class Producer implements Runnable {

        @Override
        public void run() {
            for (int i = 0; i < 20; i++) {
                try {
                    System.out.println("生产：" + i);
                    blockingQueue.put(i);
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    class Consumer implements Runnable {
        @Override
        public void run() {
            for (int i = 0; i < 20; i++) {
                try {
                    System.out.println("消费：" + blockingQueue.take());
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public void run(){
        new Thread(new Consumer()).start();
        new Thread(new Producer()).start();
    }



    public static void main(String[] args) {
        ConcurrentProduceConsumerTest threadTest = new ConcurrentProduceConsumerTest();
        threadTest.run();
    }

}
