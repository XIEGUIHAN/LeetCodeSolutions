package leetcode.binarSearch;

public class FindMinInRotationSortedArray {
    public static int findMin(int[] nums) {
        if (nums.length == 0){return -1;}
        int min = nums[0];

        int l = 0;
        int r = nums.length-1;

        while (l <= r){

            int mid = (r-l)/2+l;
            if (nums[mid] < min ){
                min = nums[mid];
            }
            if ( nums[mid] < nums[r] ){
                r = mid-1;
            }else {
                l = mid+1;
            }

        }
        return min;
    }

    public static void main(String[] args) {
        int[] nums = {3,4,5,1,2};
        int min = findMin(nums);
        System.out.println(min);
    }
}
