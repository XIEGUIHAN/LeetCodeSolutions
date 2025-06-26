package leetcode.array;

public class ContainersLargestWater {
    public int maxArea(int[] height) {
        int left = 0;
        int right = height.length-1;

        int area = 0;
        while( left<right ){

            area = Math.max( Math.min( height[left], height[right] ) * (right-left), area );

            if (height[left] > height[right]){
                right--;
            }else {
                left++;
            }
        }
        return area;
    }
}
