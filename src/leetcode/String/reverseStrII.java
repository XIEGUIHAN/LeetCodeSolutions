package leetcode.String;

public class reverseStrII {
    public static String reverseStrMethod(String s, int k) {
        char[] charArray = s.toCharArray();
        int length = charArray.length;
        for (int i = 0; i < length; i=i+2*k) {
            if (i+k <= length){
                reverse(charArray, i, i+k-1);
            }else {
                reverse(charArray, i, length-1);
            }
        }

        return String.valueOf(charArray);
    }


    public static void reverse( char[] chars, int left, int right ){
        while (left < right){
            char temp = chars[left];
            chars[left] = chars[right];
            chars[right] = temp;
            left++;
            right--;
        }
    }

    public static void main(String[] args) {
        String s = "abcdefg";
        int k = 2;
        String res = reverseStrMethod(s, k);
        System.out.println(res);
    }
}
