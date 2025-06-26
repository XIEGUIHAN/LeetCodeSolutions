package leetcode.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class groupAnagrams {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> res = new ArrayList<>();
        HashMap< String, List<String> > map = new HashMap<>();
        for (int i = 0; i < strs.length; i++) {
            char[] charArray = strs[i].toCharArray();
            Arrays.sort(charArray);
            String key = new String(charArray);
            if (map.containsKey( key )){
                List<String> path = map.get(key);
                path.add(strs[i]);
                map.put(key, path);
            }else {
                List<String> path = new ArrayList<>();
                path.add(strs[i]);
                map.put(key, path);
            }
        }
        for (List<String> value : map.values()) {
            res.add(new ArrayList<>(value));
        }
        return res;
    }

    public static void main(String[] args) {
        String[] strs = {"eat", "tea", "tan", "ate", "nat", "bat"};
        groupAnagrams groupAnagrams = new groupAnagrams();
        List<List<String>> res = groupAnagrams.groupAnagrams(strs);
        System.out.println(res);

        String aa = "abcse";
        System.out.println(aa);
    }
}
