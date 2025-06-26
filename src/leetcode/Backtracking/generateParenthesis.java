package leetcode.Backtracking;

// 22.括号生成

import java.util.ArrayList;
import java.util.List;

public class generateParenthesis {

    List<String> res = new ArrayList<>();

    public List<String> generateParenthesis(int n) {
        if (n <= 0) return res;
        getParenthesis2("", n, n);
        return res;
    }

    /**
     * 进入这个方法的前提条件是：剩余的右括号比左括号多或者相等,不可能小于
     * @param str 当前字符串
     * @param left 剩余可用左括号数量
     * @param right 剩余可用右括号数量
     */
    private void getParenthesis2(String str, int left, int right) {
        if (left == 0 && right == 0) {
            res.add(str);
            return;
        }

        if (right >= left) {
            // 剩余的右括号比左括号多或者相等的情况下,每次都可以添加左括号或者右括号,并根据添加的括号改变向下递归的left和right的值
            // 因为每次只有两种选择,有点像二叉树的展开
            if (left >= 1) getParenthesis2(str+"(", left-1, right);
            if (right >= 1) getParenthesis2(str+")", left, right-1);
        }
    }







//    List<String> res = new ArrayList<>();
//    public List<String> generateParenthesis(int n) {
//        if(n <= 0){
//            return res;
//        }
//        DFS("",n,n);
//        return res;
//    }
//
//    //剩余左右括号数相等，下一个只能用左括号
//    //剩余左括号小于右括号，下一个可以用左括号也可以用右括号
//    void DFS(String s, int left, int right){
//        //如果 剩余左右括号 为0，那么可以收获结果
//        if (left == 0 && right == 0){
//            res.add(s);
//            return;
//        }
//        if (left == right) {
//            DFS(s+"(", left-1, right);
//        } else if (left < right) {
//            if (left > 0){
//                DFS(s+"(", left-1, right);
//            }
//            DFS(s+")", left, right-1);
//        }
//    }



    public static void main(String[] args) {
        generateParenthesis ge = new generateParenthesis();
        List<String> strings = ge.generateParenthesis(3);
        System.out.println(strings);
    }
}
