package leetcode.Backtracking;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

public class letterCombinations {
    static HashMap<Character, String> phoneMap = new HashMap<Character, String>(){{
        put('2', "abc");
        put('3', "def");
        put('4', "ghi");
        put('5', "jkl");
        put('6', "mno");
        put('7', "pqrs");
        put('8', "tuv");
        put('9', "wxyz");
    }};

    public static List<String> letterCombinations(String digits) {
        List<String> result = new LinkedList<>(); // 大结果容器

        StringBuffer temp = new StringBuffer();
        backTracking(digits, result, 0, temp);
        return result;

    }
    public static void backTracking(String digits, List<String> result, int index, StringBuffer temp){
        // 终止条件
        if ( index == digits.length() ){
            result.add(temp.toString());
        }else {
            // index代表第几层！
            String letters = phoneMap.get( digits.charAt(index) );
            for (int i = 0; i < letters.length(); i++) {
                temp = temp.append(letters.charAt(i));
                backTracking(digits, result, index+1, temp);
                temp = temp.deleteCharAt( index );
            }
        }
    }

    public static void main(String[] args) {
        List<String> strings = letterCombinations("23");
        System.out.println(strings);
    }

}
