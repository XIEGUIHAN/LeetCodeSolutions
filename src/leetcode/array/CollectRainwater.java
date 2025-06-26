package leetcode.array;






public class CollectRainwater {

    // 42.接雨水---按列来计算雨水
    public int trap(int[] height) {
        // 数组长度
        int length = height.length;
        int[] leftMax = new int[length];
        int[] rightMax = new int[length];
        // 总雨水量
        int total = 0;

        // 求每一列的左边的最高的列
        int leftm = 0;
        for (int i = 1; i < length-1; i++) {
            leftm = Math.max( leftm, height[i-1] );
            leftMax[i] = leftm;
        }

        // 求每一列的右边的最高的列
        int rightm = 0;
        for (int i = length-2; i > 0; i--) {
            rightm = Math.max( rightm, height[i+1] );
            rightMax[i] = rightm;
        }

        // 根据每一列的左边和右边最高的列，有3种情况，然后可以求每一列能存储的水量
        for (int k = 1; k < length-1; k++) {
            int minColumn = Math.min( leftMax[k], rightMax[k] );
            if (minColumn > height[k]){
                total += minColumn-height[k];
            }
        }

        return total;
    }







    // 42.接雨水---按行一层一层计算雨水---正确但已经超时了
//    public int trap(int[] height) {
//        // 数组长度
//        int length = height.length;
//        // 最大的高度
//        int maxheight = 0;
//        for (int i = 0; i < length; i++) {
//            maxheight = Math.max( maxheight, height[i]);
//        }
//        // 总雨水量
//        int total = 0;
//        int curheight = 1;
//        while (curheight <= maxheight){
//            int maybeVolume = 0;
//            boolean l = false;
//            for (int k = 0; k < length; k++) {
//                if (maybeVolume==0 && height[k] >= curheight){
//                    l = true;
//                } else if (l == true && height[k] < curheight){
//                    maybeVolume++;
//                } else if (l == true && maybeVolume>0 && height[k] >= curheight){
//                    total += maybeVolume;
//                    maybeVolume = 0;
//                }
//            }
//            curheight++;
//        }
//        return total;
//    }

    public static void main(String[] args) {
//        int[] nums = {4,2,0,3,2,5};
        int[] nums = {2,0,2};
//        int[] nums = {0,1,0,2,1,0 ,1,3,2,1,2,1};
        CollectRainwater collectRainwater = new CollectRainwater();
        int total = collectRainwater.trap(nums);
        System.out.println(total);
    }
}
