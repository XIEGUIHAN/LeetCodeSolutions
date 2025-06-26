package leetcode.stack;

import java.util.HashMap;
import java.util.Stack;

public class validBrackets {
    public static boolean isValid(String s) {

        // 一个栈 + 哈希表
        Stack<Character> stack = new Stack<>();
        // 右括号和左括号：一一映射
        HashMap<Character, Character> map = new HashMap();
        map.put('(',')');
        map.put('{','}');
        map.put('[',']');

        char[] charArray = s.toCharArray();
        if (charArray.length % 2 != 0){
            return false;
        }

        for (char c : charArray) {
            // 如果遍历的是左括号，则进栈
            if (c == '(' || c == '[' || c == '{'){
                stack.push(c);
            }
            // 如果遍历的是右括号，则：若栈为空则返回false，有元素则弹出栈顶元素，若不是对应的左括号则返回false
            if (c == ')' || c == ']' || c == '}'){
                if (stack.isEmpty() ||  map.get(stack.pop()) != c){
                    return false;
                }
            }
        }
        if (!stack.isEmpty()){
            return false;
        }
        // 正常遍历后，栈应该为空，返回true
        return true;





//        // 设计两个栈 + 哈希表
//        Stack<Character> stack1 = new Stack<>();
//        Stack<Character> stack2 = new Stack<>();
//
//        // 右括号和左括号：一一映射
//        HashMap<Character, Character> map = new HashMap();
//        map.put('(',')');
//        map.put('{','}');
//        map.put('[',']');
//
//        char[] charArray = s.toCharArray();
//        if (charArray.length %2 != 0){
//            return false;
//        }
//        for (char c : charArray) {
//            stack1.push(c);
//        }
//
//        // 如果1栈弹出来的是右括号，则放进栈2中。如果是左括号，那么应该弹出栈2的括号与其匹配。
//        while (!stack1.isEmpty()){
//            // 如果1栈弹出来的是右括号，则放进栈2中
//            Character pop1 = stack1.pop();
//            if (pop1 == ')' || pop1 == ']' || pop1 == '}'){
//                stack2.push( pop1 );
//            }
//            // 如果是左括号，那么应该弹出栈2的括号与其匹配。
//            if (pop1 == '(' || pop1 == '[' || pop1 == '{'){
//                if (stack2.isEmpty() ||  map.get(pop1) != stack2.pop()){
//                    return false;
//                }
//            }
//        }
//        if (!stack2.isEmpty() || !stack1.isEmpty()){
//            return false;
//        }
//        return true;
    }

    public static void main(String[] args) {
        boolean valid = isValid("))");
        System.out.println(valid);
    }
}
