package leetcode.greed;

public class leastJumpNums {
    public static int jump(int[] nums) {
        if (nums.length == 1){
            return 0;
        }
        // 最远可达距离
        int farthest = nums[0];
        int step = 1;
        int cycleMax = 0;

        for (int i = 0; i < nums.length; i++) {

            if (farthest >= nums.length-1){
                break;
            }
            if (i+nums[i]>cycleMax){
                cycleMax = i+nums[i];
            }
            if (i == farthest){
                farthest = cycleMax;
                step++;
                cycleMax = 0;
            }
        }
        return step;
    }

    public static void main(String[] args) {
        int[] nums = {7,0,9,6,9,6,1,7,9,0,1,2,9,0,3};
        int jump = jump(nums);
        System.out.println(jump);
    }
}
