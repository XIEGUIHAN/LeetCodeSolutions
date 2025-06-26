package leetcode.Thread;

// 三个线程交替打印ABC
// 思路：每个线程会进入for循环 3 次，然后竞争锁，如未抢到锁则会被挂起进入阻塞队列（只要锁释放就可以继续竞争）。
// 获取到锁的幸运儿线程会判断 state 是否符合自己的目标状态
// 如果不符合，也就会 wait() 阻塞进入等待队列并释放锁，等待被 notifyAll() 唤醒。
// 如果符合，那就执行打印逻辑，然后唤醒其他的所有线程，逻辑执行结束后释放锁。

// 核心点：释放锁后所有线程都可以争抢无所谓：你只要保证该打印B的时候，只有B线程是运行态，其他的线程都是阻塞态就行，不管是比B先拿到锁还是怎么样，都会被阻塞。不影响。
// 还有执行循环的逻辑放在哪里：因为你的结果是每个线程各打印10次。那么在线程的run中写。
// 还有

public class ThreeThreadsPrintAlternately {
    private static final Object LOCK = new Object();
    private static int state = 0; // 0 打印 A, 1 打印 B, 2 打印 C
//    private static int currentState = 0;

    public static void main(String[] args) {
        new Thread(() -> print('A', 0), "线程 A").start();
        new Thread(() -> print('B', 1), "线程 B").start();
        new Thread(() -> print('C', 2), "线程 C").start();
    }

    public static void print(char letter, int targetState) {
        for (int i = 0; i < 5; i++) { // 打印 5 轮 ABC
            synchronized (LOCK) {
                // 为什么不能用if呢？同样是判断：答案在2.
                //while语句属于循环语句，在判断时，如果条件为true，则会继续判断，直到false为止，即会进行多次判断（除非一开始条件就是错的）。break还可以添加break跳出循环。
//                currentState = state % 3;
                while (state % 3 != targetState) {  // 如果targetState不等于自己的编号，那么就一直循环等待判断！ if就无法循环等待。
                    try {
                        LOCK.wait(); // 阻塞线程，等待唤醒  // TODO阻塞线程为什么不是Thread.wait()?为什么不能用currentState = state % 3;
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                System.out.print(letter);
                state++;
                LOCK.notifyAll(); // 唤醒所有线程
            }
        }
    }
}
//1. 锁释放：
// wait（）已经拿到锁的线程执行wait()会释放锁然后进入阻塞。 线程正常执行完synchronized语句。
//2.线程 A 释放锁后所有线程都被唤醒，但只有一个线程能成功获取锁，如果假设是线程C线竞争到锁呢？然后是B，然后A获取不到锁是阻塞还是自旋等待啊？
// 答：在JVM中 A获取不到锁会被阻塞，也就是挂起，通常不会自旋空转cpu。
//3.改成if后，线程在 被唤醒后，是执行哪个语句啊？线程在 被唤醒后是不是应该是继续在synchronized (LOCK)语句块内？还是在while (state % 3 != targetState) 语句块内？如果是在while (state % 3 != targetState) 语句块的外面，那么改成if后它是不是依然会再检查 state？
// 线程被 wait() 进入等待后，notifyAll() 唤醒它时，不会重新执行之前的逻辑，而是从 wait() 之后继续执行，但前提是它必须先竞争到锁。
// if 只检查一次，while 会重新检查，因此只有while能保证顺序执行正确。
//4. 在 JVM 中，未抢到锁的线程分两种情况：
//因 wait() 进入等待队列的线程（需要 notify 或 notifyAll 唤醒）。等待是等待外部条件满足，等他其他对象唤醒自己，比如等待录取通知书。
//因竞争锁失败进入阻塞队列的线程（不需要 notify，只要锁释放就可以继续竞争）。阻塞是和其他对象抢资源，没抢过，排队等待再抢，比如抢厕所。
//5.阻塞线程wait的用法:
//





