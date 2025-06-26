package leetcode.greed;

// 121.买卖股票的最佳时机

// 贪心算法：一次遍历即可解决。左边取最小值，右边取最大值

public class marketMaxPrifit {
    public static int maxProfit(int[] prices) {
        int profit = 0;
        int min = prices[0];

        for (int i = 1; i < prices.length; i++) {
            if (prices[i] < min){
                min = prices[i];
            }
            if (prices[i]-min > profit ){
                profit = prices[i]-min;
            }
        }

        return profit;
    }

    public static void main(String[] args) {
        int[] prices = {7,1,5,3,6,4};

        int maxProfit = maxProfit(prices);
        System.out.println(maxProfit);
    }
}
