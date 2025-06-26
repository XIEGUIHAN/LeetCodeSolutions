package leetcode.sort;

// 归并排序---递归

import java.util.Arrays;
public class MergeSort {
    // 主方法，供外部调用
    public static void sort(int[] array) {
        int[] temp = new int[array.length]; // 临时数组用于合并
        mergeSort(array, 0, array.length - 1, temp);
    }

    public static void mergeSort(int[] array, int left, int right, int[] temp){
        // 递归的终止条件
        if (left == right){
            return;
        }
        int mid = (right-left)/2 + left;    // 是+
        mergeSort(array, left, mid, temp);  // 任何的递归，分左右子区间时候，左起点一定不能是0，一定要用left。否则到右子区间就乱套了！
        mergeSort(array, mid+1, right, temp);
        // 合并两个有序序列，参数为左边序列的第一位；右边序列的第一位；
        merge(array, left, mid, right, temp);
    }

    public static void merge(int[] array, int left, int mid, int right, int[] temp){
        int leftFirst = left;
        int rightFirst = mid+1;

        int tempIndex = left;
        while (leftFirst <= mid && rightFirst <= right){
            if (array[leftFirst] <= array[rightFirst]){
                temp[tempIndex] = array[leftFirst];
                tempIndex++;
                leftFirst++;
            }else {
                temp[tempIndex] = array[rightFirst];
                tempIndex++;
                rightFirst++;
            }
        }
        // 哪一边的元素有剩余，就将其拷贝到temp。
        while (leftFirst <= mid){
            temp[tempIndex++] = array[leftFirst++];
        }
        while (rightFirst <= right){
            temp[tempIndex++] = array[rightFirst++];
        }

        // 覆盖回原数组
        for (int i = left, k = left; i <= right; i++) {
            array[i] = temp[k];
            k++;
        }
    }

    // 测试代码
    public static void main(String[] args) {
        int[] arr = {12, 11, 13, 5, 6, 7};
        System.out.println("排序前: " + Arrays.toString(arr));

        sort(arr);
        System.out.println("排序后: " + Arrays.toString(arr));
    }

}
