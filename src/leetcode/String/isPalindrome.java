package leetcode.String;
import java.util.ArrayList;
import java.util.HashSet;
// 字符串基本操作题：小恶心，但是做过2次之后，第3次写就一次ac了。
// 字符有'A'-'a','0'-'9'，没有'12'
// (char)('A'+32) = 'a'。大小写转化相差32
// string.toCharArray()
// newcharArray.toString()

// 125.验证回文子串
// s = "A man, a plan, a canal: Panama" true amanaplanacanalpanama
public class isPalindrome {
    public boolean isPalindromeMethod(String s) {
        ArrayList charArray = remove(s);
        for (int i = 0, j = charArray.size()-1; i < j; i++,j--) {
            if (charArray.get(i) != charArray.get(j)){
                return false;
            }
        }
        return true;
    }

    // 将string移除非字母数字字符
    public ArrayList remove(String s){
        ArrayList newcharArray = new ArrayList();
        char[] oldcharArray = s.toCharArray();
        for (char c : oldcharArray) {
            if ((c>='A'&& c<='Z') || (c>='a'&& c<='z') || (c>='0'&& c<='9')){
                if (c>='A'&& c<='Z'){
                    c = (char)(c + 32);
                }
                newcharArray.add(c);
            }
        }
        System.out.println(newcharArray.toString());
        return newcharArray;
    }

    public static void main(String[] args) {
        isPalindrome isPalindrome = new isPalindrome();
        String s = "A man, a plan, a canal: Panama";
        boolean palindromeMethod = isPalindrome.isPalindromeMethod(s);
        System.out.println(palindromeMethod);
    }
}

//a=97, A=122，只有'0'=48，'9'=57，没有'12'这些。
//A=65, Z=90， 相差32
//        System.out.println((int)'0');
//        System.out.println((int)'9');
//        System.out.println((char)('A'+32)); 'a'