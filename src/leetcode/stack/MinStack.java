package leetcode.stack;

import java.util.Stack;

public class MinStack {
    Stack<Integer> stack;
    Stack<Integer> minstack;

    MinStack(){
        stack = new Stack<>();
        minstack = new Stack<>();
    }

    void push(int val){
        stack.push(val);
        if (minstack.isEmpty() || val <= minstack.peek()){
            minstack.push(val);
        }
    }

    void pop(){
        int x = stack.pop();
        if(x == minstack.peek()){
            minstack.pop();
        }
    }

    int top(){
        return stack.peek();
    }

    int getMin(){
        return minstack.peek();
    }

    public static void main(String[] args) {
        MinStack mS = new MinStack();
        mS.push(-2);
        mS.push(0);
        mS.push(-3);

        int min = mS.getMin();
        System.out.println(min);

        mS.pop();
        int min1 = mS.getMin();
        System.out.println(min1);

    }

}
