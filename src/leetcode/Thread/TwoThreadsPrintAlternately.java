package leetcode.Thread;

// 两个线程交替打印奇数和偶数
//方法一：锁：创建两个线程，一个线程负责打印奇数，另一个线程打印偶数，两个线程竞争同一个对象锁，每次打印一个数字后释放锁，然后另一个线程拿到锁打印下一个数字。
//方法二：join()

//public class TwoThreadsPrintAlternately {
//    //方法一：锁
//    private static final Object mylock = new Object();
//    private static int cur;
//    // 这里要理解cur如何使线程交替执行。如果是for(在这里cur++)的话就是绝对错的。首先cur是static是内存共享的变量，所有线程共享。
//    // cur++应该是要在锁里面进行自增。而外面的循环只是起到判断的作用。这样来看for循环就不合适，只有while循环是判断的符合要求。
//    public static void main(String[] args) {
//
//        // 线程1 怎么创建线程呢，其实线程Thread相当于Arraylist、HashMap一类的创建方法是一致的！
//        // 线程有5种创建方式：这里是第5中：匿名函数创建法。箭头函数省略的其实是必须重写的run函数。
//        // 线程有5种创建方式：https://blog.csdn.net/weixin_43824267/article/details/112706385
//        // 总结：继承于Thread类的子类，必须重写run。
//        //      实现了Runnable接口的类，必须重写run。
//        //      匿名函数，必须重写run，但是用()->{}来代替。
//        //      线程池：先按照上面的方式1or2创建线程，再放入线程池里面！今晚实现！
//        new Thread(()->{
//            while (cur < 10) {
//                synchronized (mylock) {
//                    if (cur % 2 == 0) {
//                        System.out.println(Thread.currentThread().getName() + ":" + cur++);
//                    }
//                    //线程执行完if语句就会释放锁
//                }
//                //线程执行完所有的语句:执行完while后才会停止线程。
//            }
//        },"偶数线程").start();
//
//        // 线程2
//        new Thread(()->{
//            while (cur < 10) {
//                synchronized (mylock) {
//                    if (cur % 2 == 1) {
//                        System.out.println(Thread.currentThread().getName() + ":" + cur++);
//                    }
//                }
//            }
//        },"奇数线程").start();
//
//    }
//
//
//}


// 两个线程交替打印奇数和偶数
// 我的思路：保证该执行奇数的时候，奇数线程正常，而偶数线程阻塞即可。
// 还有执行循环的逻辑放在哪里：因为你的结果是每个线程各打印10次。那么在线程的run中写。

// 本题synchronized就可以实现
// 三个线程那个题需要synchronized + wait + notify！
public class TwoThreadsPrintAlternately {
    private static Object l = new Thread();
    private static int num = 1;

    public static void printjishunumber(){
        while (num < 100)
            synchronized (l){   // 尝试竞争锁，竞争不到就阻塞排队
                if(num % 2 == 1){
                    System.out.println(Thread.currentThread().getName()+":"+ num++);
                }
            }
    }

    public static void printoushunumber(){
        while (num < 100)
            synchronized (l){   // 尝试竞争锁，竞争不到就阻塞排队
                if(num % 2 == 0){
                    System.out.println(Thread.currentThread().getName()+":"+ num++);
                }
            }
    }

    public static void main(String[] args) {
        new Thread(()->printjishunumber(),"奇数线程").start();
        new Thread(()->printoushunumber(),"偶数线程").start();

    }

}
