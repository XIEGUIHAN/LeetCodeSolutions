package leetcode.binarSearch;

// 34.在排序数组中查找元素的第一个和最后一个位置
// 两次二分查找，分开查找第一个和最后一个

public class searchRange {
    public int[] searchRange(int[] nums, int target) {

        int first = -1;
        int last = -1;

        int l = 0;
        int r = nums.length-1;

        // 找第一个等于target的位置
        while (l <= r){
            int mid = (r-l)/2+l;
            if (nums[mid] == target){
                first = mid;
                r = mid - 1;
            } else if ( nums[mid] > target ) {
                r = mid - 1;
            }else {
                l = mid + 1;
            }
        }

        l = 0;
        r = nums.length-1;
        // 找最后一个等于target的位置
        while (l <= r){
            int mid = (r-l)/2+l;
            if (nums[mid] == target){
                last = mid;
                l = mid + 1;
            } else if ( nums[mid] > target ) {
                r = mid - 1;
            }else {
                l = mid + 1;
            }
        }

        int[] res = new int[2];
        res[0] = first;
        res[1] = last;
        return res;
    }

}
