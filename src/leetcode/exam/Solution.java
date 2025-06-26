package leetcode.exam;

public class Solution {
    public static int[] minimumNumber (int[] target, int tar) {

        int[] coins = {1,2,3,4};
        int[] dp = new int[target.length];
        for (int i = 1; i < tar; i++) {
            dp[i] = 16;
        }
        dp[0] = 0;

//        for (int bag : target) {
            // 先遍历物品
            for (int coin : coins) {
                //再遍历背包
                for (int j = 0; j < 16; j++) {
                    if (j>=coin){
                        dp[j] = Math.min( dp[j], dp[j-coin]+1 );
                    }
                }
            }
//        }
        System.out.println(dp[16-1]);
        return null;

    }

    public static void main(String[] args) {
        int[] arr = {10,12,3,4};
        minimumNumber(arr, 16);

    }
}


