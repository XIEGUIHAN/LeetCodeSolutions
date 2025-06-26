package leetcode.Thread;

public class ThreeThreadsPrintAlternately2 {
    // 当前应该打印的字母
    private char currentLetter = 'A';
    private int printCount = 0; // 记录打印次数
    private static final int MAX_PRINT_TIMES = 10; // 最大打印次数

    public static void main(String[] args) {
        ThreeThreadsPrintAlternately2 printer = new ThreeThreadsPrintAlternately2();

        // 创建三个线程
        Thread threadA = new Thread(() -> printer.printLetter('A', 'B'));
        Thread threadB = new Thread(() -> printer.printLetter('B', 'C'));
        Thread threadC = new Thread(() -> printer.printLetter('C', 'A'));

        // 启动线程
        threadA.start();
        threadB.start();
        threadC.start();
    }

    // 打印字母的方法
    private synchronized void printLetter(char letter, char nextLetter) {
        try {
            while (printCount < MAX_PRINT_TIMES * 3) { // 每个字母打印 MAX_PRINT_TIMES 次
                // 如果当前字母不是自己应该打印的字母，则等待
                while (currentLetter != letter) {
                    wait();
                }
                // 打印字母
                System.out.print(letter);
                printCount++;
                // 更新当前字母
                currentLetter = nextLetter;
                // 唤醒其他线程
                notifyAll();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}