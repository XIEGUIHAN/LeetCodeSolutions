package leetcode.Backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// 【二刷】131. 分割回文串

public class partition {

    List<String> path = new ArrayList<>();
    List<List<String>> res = new ArrayList<>();

    public List<List<String>> partition(String s) {
        char[] charArray = s.toCharArray();
        backtracking(charArray, 0);
        return res;
    }

    void backtracking(char[] charArray, int startIndex) {
        if (startIndex == charArray.length){  // 切割线切到了字符串最后面，说明找到了一种切割方法。
            res.add(new ArrayList<>(path));
        }
        for (int i = startIndex; i < charArray.length; i++) {
            char[] newChar = Arrays.copyOfRange(charArray, startIndex, i+1);
            if (isPalindrome(newChar)){     // 截取的区间是回文。
                path.add( new String(newChar) );
            }else {
                continue;
            }
            backtracking(charArray, i+1);
            path.remove(path.size()-1);
        }
    }

    boolean isPalindrome(char[] newChar){
        for (int i = 0,j = newChar.length-1; i < j; i++,j--) {
            if (newChar[i] != newChar[j]){
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        String s = "aab";
        partition partition = new partition();

        List<List<String>> result = partition.partition(s);
        System.out.println(result);
    }

}




















//public class partition {
//    List<List<String>> res = new ArrayList<>();
//    List<String> path = new ArrayList<>();
//
//    public List<List<String>> partition(String s) {
//        DFS(s, 0, new StringBuilder());
//        return res;
//    }
//    void DFS(String s, int startIndex, StringBuilder sb){
//        if (startIndex >= s.length()){
//            res.add(new ArrayList<>(path));
//            return;
//        }
//        for (int i = startIndex; i < s.length(); i++) {     //【这里也是难点，i=startIndex】
//            sb.append( s.charAt(i) );
//            if (isPalindrome(sb)){
//                path.add(sb.toString());
//                DFS(s, i+1, new StringBuilder());   //【这里难！startIndex要怎么和i关联！？？！】
//                path.remove(path.size()-1);
//            }
//        }
//
//    }
//    boolean isPalindrome(StringBuilder sb){
//        int start = 0;
//        int end = sb.length()-1;
//        while (start < end){
//            char l = sb.charAt(start);
//            char r = sb.charAt(end);
//            if (l != r){
//                return false;
//            }
//            start++;
//            end--;
//        }
//        return true;
//    }
//
//    public static void main(String[] args) {
//        String s = "aab";
//        partition partition = new partition();
//
//        List<List<String>> result = partition.partition(s);
//        System.out.println(result);
//    }
//}
