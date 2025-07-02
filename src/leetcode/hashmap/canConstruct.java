package leetcode.hashmap;

import java.util.HashMap;

public class canConstruct {
    public static boolean canConstruct(String ransomNote, String magazine) {
        HashMap<Character, Integer> map = new HashMap<>();
        char[] charArray = ransomNote.toCharArray();
        for (char c : charArray) {
            map.put(c, map.getOrDefault(c, 0)+1);
        }
        for (int i = 0; i < magazine.length(); i++) {
            char s = magazine.charAt(i);
            map.put(s, map.getOrDefault(s, 0)-1);
        }
        for (Integer value : map.values()) {
            if (value > 0){
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        String ransomNote = "aa";
        String magazine = "aab";
        boolean res = canConstruct(ransomNote, magazine);
        System.out.println(res);
    }
}
