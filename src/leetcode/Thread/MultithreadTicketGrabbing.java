package leetcode.Thread;

// 多线程抢票：每个线程只能抢一张票！

public class MultithreadTicketGrabbing {
    static Object lock = new Object();
    int ticketNum = 10;


    public synchronized void getTicket() {
        synchronized (this) {
            if (ticketNum <= 0) {
                return;
            }
            System.out.println(Thread.currentThread().getName() + "抢到一张票,剩余:" + ticketNum);
            // 非原子性操作
            ticketNum--;
        }
    }

    public static void main(String[] args) {
        MultithreadTicketGrabbing ticketDemo = new MultithreadTicketGrabbing();
        for (int i = 0; i < 20; i++) {
            new Thread(() -> ticketDemo.getTicket() ).start();
        }
    }

}
