package leetcode.stack;


import java.util.Stack;

// LCR 125.用栈实现队列
public class ImplementQueuesWithStacks {

    private Stack<Integer> pushstack;
    private Stack<Integer> popstack;

    public ImplementQueuesWithStacks() {
        pushstack = new Stack<>();
        popstack = new Stack<>();

    }

    public void appendTail(int value) {
        // 判断 存栈是否为空。
        // 若为空：再判断取栈：若取栈有值，则把取栈的东西全部搬回来 存栈后再存值。 若且取栈也为空，说明刚刚开始则可以支持存入。
        // 若不为空，直接存。
        if (pushstack.isEmpty()){
            if (popstack.isEmpty()){
                pushstack.push(value);
            }else {
                int tempSize = popstack.size();
                for (int i = 0; i < tempSize; i++) {
                    pushstack.push( popstack.pop() );
                }
                pushstack.push(value);
            }
        }else{
            pushstack.push(value);
        }
    }

    public int deleteHead() {
        // 判断 取栈是否为空。
        // 若为空：再判断存栈：若存栈有值，则把存栈的东西全部搬回来 取栈 后再弹出值。 若且存栈也为空，说明刚刚没有，返回-1.
        // 若不为空，直接弹出值。
        if (popstack.isEmpty()){
            if (pushstack.isEmpty()){
                return -1;
            }else {
                int tempSize = pushstack.size();
                for (int i = 0; i < tempSize; i++) {
                    popstack.push( pushstack.pop() );
                }
                return popstack.pop();
            }
        }else {
            return popstack.pop();
        }
    }
}
