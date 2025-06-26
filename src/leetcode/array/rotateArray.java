package leetcode.array;
// nums = [1,2,3,4,5,6,7], k = 3
// [5,6,7,1,2,3,4]

public class rotateArray {
    public void rotate(int[] nums, int k) {
        if (k==0){return;}
        int length = nums.length;
        // 第一次反转
        revert(nums);
        // 真正旋转位数
        int real_k = k % length;

        // 切割数组1
        int[] arr1 = new int[real_k];
        for (int i = 0; i < real_k; i++) {
            arr1[i] = nums[i];
        }
        revert(arr1);

        // 切割数组2
        int[] arr2 = new int[length-real_k];
        for (int i = real_k,j=0; i < length; i++,j++) {
            arr2[j] = nums[i];
        }
        revert(arr2);

        // 合并数组
        for (int i = 0; i < arr1.length; i++) {
            nums[i] = arr1[i];
        }
        for (int i = arr1.length,j=0; i < length; i++,j++) {
            nums[i] = arr2[j];
        }

    }

    public void revert(int[] nums){
        for (int i=0,j=nums.length-1; i < j; i++,j--) {
            int temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
        }
    }
}
