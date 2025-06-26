package leetcode.String;

// 409.最长回文子串

import java.util.ArrayList;
import java.util.HashMap;

public class longestPalindrome {
    public int longestPalindromeMethod(String s) {
        if (s.length() == 1)
            return 1;
        if (s.length() == 0)
            return 0;

        // 偶数的话，全加。有奇数的话：若奇数为1，则跳过。奇数大于1，则先-1再加。最后结果再加1。
        // 数据结构：
        // [2 ,3 ,1 ,4] = 2+2+0+4 + 1
        HashMap<Character, Integer> map = new HashMap<Character, Integer>();
        char[] charArray = s.toCharArray();
        for (char c : charArray) {
            if (!map.containsKey(c)){
                map.put(c, 1);
            }else {
                map.put(c, map.get(c)+1);
            }
        }

        int res = 0;
        int jishucishu = 0;
        // 遍历哈希表将次数取出来做计算
        for(Integer value : map.values()){
            if (value % 2 == 0){
                // value 是偶数
                res += value;
            }
            if ( value % 2 == 1){
                jishucishu++;
                // value 是奇数
                if (value != 1){
                    value--;
                    res = res + value;
                }
            }
        }

        if(jishucishu >= 1)
            res += 1;

        return res;
    }

    public static void main(String[] args) {
        String s = "ABBCCD";
        longestPalindrome l = new longestPalindrome();
        int i = l.longestPalindromeMethod(s);

        System.out.println(i);
    }
}
