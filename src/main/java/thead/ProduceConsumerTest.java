package thead;

/**
 * Created by liuzhihan on 2017/3/15.
 */
public class ProduceConsumerTest {

    class Bag {
        final int MAX_NUM = 6;//最大值
        int i=3;
        public synchronized void inc() throws InterruptedException {
            while (i == MAX_NUM) {//满
                wait();
            }
            System.out.println("生产：" + ++i);
            notify();
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        public synchronized void dec() throws InterruptedException {
            while (i == 0) {//空
                wait();
            }
            System.out.println("消费：" + --i);
            notify();
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    class Producer implements Runnable {
        private Bag bag;
        public Producer(Bag bag) {
            this.bag = bag;
        }

        @Override
        public void run() {
            for (int i = 0; i < 20; i++) {
                try {
                    bag.inc();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    class Consumer implements Runnable {
        private Bag bag;
        public Consumer(Bag bag) {
            this.bag = bag;
        }
        @Override
        public void run() {
            for (int i = 0; i < 20; i++) {
                try {
                    bag.dec();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public void run(){
        Bag bag = new Bag();
        new Thread(new Consumer(bag)).start();
        new Thread(new Producer(bag)).start();
    }



    public static void main(String[] args) {
        ProduceConsumerTest threadTest = new ProduceConsumerTest();
        threadTest.run();
    }

}
