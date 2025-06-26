package leetcode.array;
import java.util.Arrays;

// 合并两个有序数组

public class mergeArray {
    //nums1 = [1,2,3,7,0,0,0], m = 4, nums2 = [2,5,6], n = 3
    // [1,2,2,3,5,6,7]
    public void mergeArrayMethod(int[] nums1, int m, int[] nums2, int n) {
//        // 先merge 再调用排序方法
//        for (int i = 0; i < n; i++) {
//            nums1[i+m] = nums2[i];
//        }
//        Arrays.sort(nums1);

        //标准方法：后插入法-要讨论m，n为0的情况
        int rear = nums1.length-1;
        for (int i = rear; i >= 0 ; i--) {
            if(m == 0){
                nums1[rear] = nums2[n-1];
                n--;
                rear--;
            }else if (n == 0) {}
            else{
                if (nums1[m-1] >= nums2[n-1]){
                    nums1[rear] = nums1[m-1];
                    m--;
                }else {
                    nums1[rear] = nums2[n-1];
                    n--;
                }
                rear--;
            }
        }

    }
}
