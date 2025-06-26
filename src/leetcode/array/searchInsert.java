package leetcode.array;

// 35. 搜索插入位置【二分搜索】

public class searchInsert {
    public static int searchInsert(int[] nums, int target) {
        int left = 0;
        int right = nums.length-1;
        while (left < right){
            int mid = (left + right)/2;
            if (nums[mid] == target){
                return mid;
            }else if (nums[mid] > target){
                right = mid -1;
            }else {
                left = mid + 1;
            }
        }
        if (target > nums[left]){
            return left+1;
        }else {
            return left-1;
        }

    }

    public static void main(String[] args) {
        int[] nums = {1,3,5,6};
        int target = 5;
        int res = searchInsert(nums, target);
        System.out.println(res);
    }
}
