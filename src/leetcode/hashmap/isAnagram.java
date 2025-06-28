package leetcode.hashmap;

import java.util.HashMap;

public class isAnagram {
    public static boolean isAnagram(String s, String t) {
        if (s.length() != t.length()){
            return false;
        }
        HashMap<Character, Integer> map = new HashMap<>(s.length());
        for (int i = 0; i < s.length(); i++) {
            map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0)+1);
        }

        for (int i = 0; i < t.length(); i++) {
            map.put(t.charAt(i), map.getOrDefault(t.charAt(i), 0)-1);
            if ( map.get(t.charAt(i))<0 ){
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        String  s = "rat";
        String t = "car";
        boolean anagram = isAnagram(s, t);
        System.out.println(anagram);
    }
}
