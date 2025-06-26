package leetcode.greed;

// 55. 跳跃游戏

public class canJump {
    public static boolean canJump(int[] nums) {
        int length = nums.length;
        // 最远可达的位置
        int farthestPos = 0;
        for (int i = 0; i < length; ++i) {
            if (i <= farthestPos) {
                farthestPos = Math.max(farthestPos, i + nums[i]);
                if (farthestPos >= length - 1) {
                    return true;
                }
            }
        }
        return false;


//        // 最远可达的位置
//        int farthestPos = 0;
//        for (int i = 0; i < nums.length; i++) {
//            if (i > farthestPos){
//                return false;
//            }
//            if (i+nums[i] > farthestPos){
//                farthestPos = i + nums[i];
//            }
//            if (farthestPos >= nums.length-1){
//                return true;
//            }
//        }
//        return false;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{2,3,1,1,4};
        boolean b = canJump(nums);
        System.out.println(b);
    }
}
