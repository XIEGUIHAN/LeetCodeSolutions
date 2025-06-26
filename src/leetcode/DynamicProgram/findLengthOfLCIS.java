package leetcode.DynamicProgram;

public class findLengthOfLCIS {
    public static int findLengthOfLCIS(int[] nums) {

        int[] dp = new int[nums.length];
        int maxlen = 1;

        //初始化
        for (int i = 0; i < nums.length; i++) {
            dp[i] = 1;
        }

        for(int i = 1; i < nums.length; i++){
            if(nums[i] > nums[i-1]){
                dp[i] = dp[i-1] + 1;
                maxlen = Math.max( maxlen, dp[i] );
            }
        }

        return maxlen;
    }

    public static void main(String[] args) {
        int[] nums = {1,3,5,4,2,3,4,5};
        int lengthOfLCIS = findLengthOfLCIS(nums);
        System.out.println(lengthOfLCIS);
    }
}
