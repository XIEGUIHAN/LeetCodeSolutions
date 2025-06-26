//package leetcode.greed;
//import java.util.Arrays;
//import java.util.Comparator;
//
//
//public class coinChange {
//    public static int coinChange(int[] coins, int amount) {
//
//        int minLen = 0;
//
//
//        int[] coins11 = {3, 2, 5};
//        Arrays.sort(coins11, new Comparator< int >() {
//            public int compare(Integer o1, Integer o2) {
//                return o2-o1;
//            }
//        });
//
//        for (int coin : coins) {
//            System.out.println(coin);
//        }
//
//
//        return minLen;
//
//    }
//
//    public static void main(String[] args) {
//        int[] coins = {3, 2, 5};
//        int i = coinChange(coins, 11);
//        System.out.println(i);
//    }
//}
