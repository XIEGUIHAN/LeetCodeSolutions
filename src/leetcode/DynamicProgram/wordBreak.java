package leetcode.DynamicProgram;

import java.util.ArrayList;
import java.util.*;

public class wordBreak {
    public boolean wordBreak(String s, List<String> wordDict) {

        int n = s.length();
        boolean[] dp = new boolean[n + 1];
        dp[0] = true; // 空字符串可以被拆分

        Set<String> wordSet = new HashSet<>(wordDict); // 用 HashSet 提高查找速度

        for (int i = 0; i < n; i++) {
            if (!dp[i]) continue; // 如果 s[0..i-1] 不能拆分，跳过

            for (int j = i + 1; j <= n; j++) {
                String substring = s.substring(i, j);
                if (wordSet.contains(substring)) {
                    dp[j] = true; // 如果 s[i..j-1] 在字典中，则 s[0..j-1] 可以拆分
                }
            }
        }

        return dp[n]; // 返回整个字符串是否可以拆分
    }

    public static void main(String[] args) {
//        String s = "catsandog";
//        List<String> wordDict = new ArrayList<>();
//        wordDict.add("cats");
//        wordDict.add("dog");
//        wordDict.add("sand");
//        wordDict.add("sand");
//        wordDict.add("cat");

        String s = "applepenapple";
        List<String> wordDict = new ArrayList<>();
        wordDict.add("apple");
        wordDict.add("pen");
        wordBreak w = new wordBreak();
        boolean b = w.wordBreak(s, wordDict);
        System.out.println(b);

    }
}
