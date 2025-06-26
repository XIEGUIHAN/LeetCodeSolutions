package leetcode.hashmap;
import java.lang.reflect.MalformedParameterizedTypeException;
import java.util.*;

// 3.无重复字符的最长子串
public class lengthOfLongestSubstring {
    // 辅助队列 + 滑动窗口
    public int lengthOfLongestSubstringMethod(String s) {
        Queue<Character> queue = new LinkedList<>();
//        LinkedList<Character> queue = new LinkedList<>();
        int index = 0;
        int max = 0;
        char[] charArray = s.toCharArray();
        for (int i = 0; i < charArray.length; i++) {
            if (!queue.contains( charArray[i] )){
                queue.add( charArray[i] );
                max = Math.max( max, queue.size());
            }else {
                while (queue.peek()!=null && queue.peek()!=charArray[i]){
                    queue.poll();
                }
                queue.poll();
                queue.add(charArray[i]);
                max = Math.max( max, queue.size());
            }
        }
        return max;
    }

    public static void main(String[] args) {
        lengthOfLongestSubstring ll = new lengthOfLongestSubstring();
        String s = "abcabcbb";
        int i = ll.lengthOfLongestSubstringMethod(s);
        System.out.println(i);
    }

}
