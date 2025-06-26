package leetcode.binarSearch;

//33.搜索旋转排序数组

public class SearchingForRotatedSortedArrays {
    public static int search(int[] nums, int target) {
        if (nums.length == 0) {return -1;}
        if (nums.length == 1) {return nums[0] == target ? 0 : -1;}
        int res = -1;

        int l = 0;
        int r = nums.length-1;

        while (l <= r){
            // 左右端点 + 中点都是观测点
            if (nums[l] == target){return l;}
            if (nums[r] == target){return r;}
            int mid = (l+r)/2;
            if (nums[mid] == target){return mid;}

            // 判断左半部分是否有序
            if (nums[l] <= nums[mid]) {
                // 目标在左半部分
                if (target >= nums[l] && target < nums[mid]) {
                    r = mid - 1;
                } else {
                    l = mid + 1;
                }
            } else {
                // 右半部分有序
                if (target > nums[mid] && target <= nums[r]) {
                    l = mid + 1;
                } else {
                    r = mid - 1;
                }
            }

//            //左右中都没有的话，搜索左右两边哪个是有序的
//            if (mid-1>=0 && nums[l] <= nums[mid-1]){ //左边有序     //边界？
//                if (target >= nums[l] && target <= nums[mid-1]){
//                    r = mid-1;
//                }else {
//                    l = mid+1;
//                }
//            }else{   //右边有序
//                if (mid+1<nums.length && target >= nums[mid+1] && target <= nums[r]){    //边界？？
//                    l = mid+1;
//                }else {
//                    r = mid-1;
//                }
//            }
        }

        return res;
    }

    public static void main(String[] args) {
        int[] nums = {4,5,6,7,0,1,2};
        int search = search(nums, 5);
        System.out.println(search);

    }

}
