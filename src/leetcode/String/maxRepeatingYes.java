package leetcode.String;

import java.util.Arrays;

public class maxRepeatingYes {
    public int maxRepeating(String sequence, String word) {
        int n = sequence.length(), word_lenth = word.length();
        if (n < word_lenth) {
            return 0;
        }

        int[] f = new int[n];
        for (int i = word_lenth - 1; i < n; ++i) {
            boolean valid = true;
            for (int j = 0; j < word_lenth; ++j) {
                if (sequence.charAt(i - word_lenth + j + 1) != word.charAt(j)) {
                    valid = false;
                    break;
                }
            }
            if (valid) {
                f[i] = (i == word_lenth - 1 ? 0 : f[i - word_lenth]) + 1;
            }
        }

        return Arrays.stream(f).max().getAsInt();
    }
}
