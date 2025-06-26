package leetcode.array;

public class sortArrayByParity {
    public static int[] sortArrayByParity(int[] nums) {
        int left = 0;
        int right = nums.length-1;

        while (left < right){
            while (left < right && nums[left] % 2 == 0){
                left++;
            }
            while (left < right && nums[right] % 2 == 1){
                right--;
            }
            swap(nums, left, right);
            left++;
            right--;
        }

        return nums;

    }

    public static void swap( int[] nums, int a, int b ){
        int temp = nums[a];
        nums[a] = nums[b];
        nums[b] = temp;
    }

    public static void main(String[] args) {
        int[] nums = {0,2};
        int[] result = sortArrayByParity(nums);
        for (int i : result) {
            System.out.println(i + " ");
        }
    }
}
