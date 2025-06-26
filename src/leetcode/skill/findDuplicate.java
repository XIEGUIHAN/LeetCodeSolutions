package leetcode.skill;

public class findDuplicate {
    public static int findDuplicateMethod(int[] nums) {
        int slow = 0;
        int fast = 0;

        // 环形链表法
        do {
            slow = nums[slow];
            fast = nums[nums[fast]];
        }while (slow != fast);

        slow = 0;
        while (slow != fast){
            slow = nums[slow];
            fast = nums[fast];
        }

        return slow;
    }

    public static void main(String[] args) {
        int[] nums = {1,3,4,2,2};
        int duplicateMOne = findDuplicateMethod(nums);
        System.out.println(duplicateMOne);
    }
}
