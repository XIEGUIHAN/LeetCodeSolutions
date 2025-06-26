package leetcode.Thread;

// 多线程点餐，模拟高并发，多个线程同时发起请求

// 多线程抢单秒杀:100个线程同抢5个商品

// 多线程交替打印数字

public class MultiThread {
    // 多线程点餐，模拟高并发，多个线程同时发起请求
    static void order(){
        System.out.println("线程"+ Thread.currentThread().getName() + "点餐成功！");
    }

    // 多线程抢单秒杀:100个线程同抢5个商品
    static Object lock_sale = new Object(); // 锁
    static int storage = 5; // 商品数量
    static void killSale(){
        synchronized (lock_sale){
            if (storage > 0){
                storage--;
                System.out.println("线程"+ Thread.currentThread().getName() + "抢到演唱会门票啦！");
            }
        }
    }

    // 多线程交替打印数字------转化为：两个线程交替自增++数字并打印！
    // 重点：notifyAll();和 wait()；【wait是锁调用的方法，草！太傻逼了。而不是thread调用！】【重点逻辑】多个线程争抢全局共享变量，所以变量的定义不在方法内！！！
    // 思路：每个线程其实都是执行同一个方法，但是这个方法需要设计得：分辨不同的线程，管理他们
    // 不能用for，因为for里面的int i注定是方法内，不是全局共享变量。】
    // 思路：所有线程都进来争夺锁，但是拿到锁不意味着就能打印。拿到锁后还要判断是否真的是你打印，不是就睡觉自动释放锁。如果是你打印那么打印完需要唤醒所有的线程，再一起竞争下一次的自增。
    static Object twothread_lock = new Object();
    static int printIndex = 0;
    static void TwoThreadPrint(int ThreadIndex){ // 方法只要执行结束了,线程就结束了
        while (printIndex <= 100) {
            // 一个时刻只能有一个线程获取到锁
            synchronized (twothread_lock) {
                // 巧妙利用共享自增变量 对 2取余，来决定由哪个线程打印。若不是当前线程打印,那么就wait。wait会自动释放锁，所以其他线程可以进来。
                // 当线程被唤醒时，会尝试重新进入synchronized代码块
                if (printIndex % 2 == ThreadIndex){
                    System.out.println("线程"+ ThreadIndex + "打印:" + printIndex);
                    printIndex++;
                    twothread_lock.notifyAll();
                }else {
                    // 下面这一段又臭又长的东西只有一行代码有用：wait睡眠。
                    try {
                        twothread_lock.wait();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }


    // 三个线程交替打印0-100  => 转化：三个线程轮流自增共享变量！
    static Object three_lock = new Object();
    static int count = 0;
    static void ThreeThreadPrint(int threadId){
        while (count < 100){
            synchronized (three_lock){
                // 检查是否轮到当前线程
                if (count % 3 == threadId) {
                    System.out.println("线程" + threadId + ":" + count);
                    count++;
                    three_lock.notifyAll(); // 唤醒其他线程
                } else {
                    try {
                        three_lock.notifyAll();
                    } catch (Exception e) {
                        throw new RuntimeException(e);
                    }
                }
            }
        }
    }


    // 3个线程交替打印ABC
    // 思路：和上面的思路一致，3个线程同时自增共享变量，0线程打印A，1线程打印B，2线程打印C
    static Object ABC_lock = new Object();
    static int ABC_count = 0;
    static void threePrintABC(int threadId, char word){
        while (ABC_count < 100){
            synchronized (ABC_lock){
                // 检查持有锁的线程是否是正确的该打印的线程
                if (ABC_count % 3 == threadId){
                    if (threadId == 0){
                        System.out.println("线程"+threadId+"打印"+word);
                    }
                    if (threadId == 1){
                        System.out.println("线程"+threadId+"打印"+word);
                    }
                    if (threadId == 2){
                        System.out.println("线程"+threadId+"打印"+word);
                    }
                    ABC_count++;
                    ABC_lock.notifyAll();

                }else {
                    try {
                        ABC_lock.wait();
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
            }
        }
    }


    public static void main(String[] args) {
        // 多线程点餐，模拟高并发，多个线程同时发起请求
//        for (int i = 0; i < 20; i++) {
//            new Thread( ()->{ order();}, "thread-"+i ).start();
//        }

        // 多线程抢单:100个线程同抢10个单
//        for (int i = 0; i < 100; i++) {
//            new Thread( ()->{ killSale();}, "thread-"+i ).start();
//        }

        // 多线程交替打印数字
//        new Thread( ()->{ TwoThreadPrint(0);} ).start();
//        new Thread( ()->{ TwoThreadPrint(1);} ).start();

        // 3个线程交替打印数字
//        new Thread( ()->{ ThreeThreadPrint(0);} ).start();
//        new Thread( ()->{ ThreeThreadPrint(1);} ).start();
//        new Thread( ()->{ ThreeThreadPrint(2);} ).start();

        // 3个线程交替打印ABC
        // 0%3=0; 1%3=1; 2%3=2; 3%3=0; ...
        new Thread( ()->{ threePrintABC(0, 'A');} ).start();
        new Thread( ()->{ threePrintABC(1, 'B');} ).start();
        new Thread( ()->{ threePrintABC(2, 'C');} ).start();

    }

}
