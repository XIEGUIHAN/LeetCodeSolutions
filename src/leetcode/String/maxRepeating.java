package leetcode.String;

// 1668. 最大重复子字符串-注意点：子字符串！必须是连续，不是子串！
// 无法用暴力破解！！！非常恶心。首先要【连续】。其次从左到右遍历过程，如果中间断开了，逻辑就变了，得从前面重新开始了。取Max了还是不行
//"aaabaaaabaaabaaaabaaaabaaaabaaaaba"; "aaaba"，答案为5
public class maxRepeating {
    // 暴力解法
    public int maxRepeatingMethod(String sequence, String word) {
        int result = 0;
        int number = 0;

        char[] charSequence = sequence.toCharArray();
        char[] charWord = word.toCharArray();

        for (int i = 0; i < sequence.length(); i++) {
            if (charSequence[i] == charWord[0]){
                int temp = 0;   // 定义一个临时变量 记录每个字符重复次数，如果重复次数为word的长度 = 即完全重复
                int word_point = 0; //定义word 的指针
                for (int j = i; j < i+charWord.length && j < i+charWord.length; j++) {
                    if (charSequence[j] == charWord[word_point]){
                        temp ++;
                        word_point++;
                    }
                }
                if(temp == charWord.length){
                    number++;
//                    i = i+charWord.length-1;
                }else{
                    // 断开了，不是子字符串了，number归零
                    number = 0;
                }

                result = Math.max(result, number);
            }else{
                // 断开了，不是子字符串了，number归零
                number = 0;
            }
        }
        return result;
    }
}
