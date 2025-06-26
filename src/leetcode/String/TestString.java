package leetcode.String;

public class TestString {
    public static void main(String[] args) {
        String str = "aaabaaaabaaabaaaabaaaabaaaabaaaaba";
        String word = "aaaba";

        maxRepeatingYes mr = new maxRepeatingYes();
        int res = mr.maxRepeating(str, word);
        System.out.println(res);
    }
}
