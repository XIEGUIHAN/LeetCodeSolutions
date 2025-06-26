package leetcode.Math;

public class rand10 {
    public static int rand7realizerand10() {

        int row, col, randomNum;
        do {
            // 注意：不能直接rand7() * rand7()，因为这样会导致例如6和7出现的概率不同。6=1*6，2*3；7=1*7；
            // 正解：用rand7()模拟出一个7x7的矩阵。1-49每个数都有自己的位置。自己画一个矩阵出来就知道怎么填了.出现是等概率的。
            // 最后1-10的概率：1可以由1、11、21、31; 2可以由2、12、22、32; 10可以由10、20、30、40取模的来。故1-10每个数出现的概率都是4/49.
            row = rand7();  // 1~7
            col = rand7();  // 1~7
            randomNum = col + (row - 1) * 7;  // 1~49 的均匀分布
        } while (randomNum > 40);  // 只保留 1~40

        // 结果取模：把 1~40 对10取模只能转换成 0~9，我们要1-10，其实只需把0改成10即可。
        if (randomNum % 10 == 0) {
            return 10;  // 10, 20, 30, 40 映射到 10
        } else {
            return randomNum % 10;  // 其余情况直接取模
        }

    }

    public static int rand7(){
        // random函数生成 [0,1)的数。乘7 → 缩放至 [0.0, 7.0)。强转为int得到 0,1,2,3,4,5,6。最后+1 → 最终得到 1,2,3,4,5,6,7。
        return (int)(Math.random() * 7) + 1;
    }

    public static void main(String[] args) {
        int i = rand7realizerand10();
        System.out.println(i);
    }

}
