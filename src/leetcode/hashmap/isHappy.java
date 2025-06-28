package leetcode.hashmap;

import java.util.HashSet;
import java.util.Set;

public class isHappy {

    static Set<Integer> set = new HashSet<>();
    public static boolean isHappy(int n) {
        int n_new = newsum(n);
        if (n_new == 1){
            return true;
        }else if ( set.contains(n_new) ){
            return false;
        }else {
            set.add(n_new);
            return isHappy(n_new);
        }
    }

    public static int newsum(int n){
        int n_new = 0;
        while (n>0){
            n_new = n_new + (n%10)*(n%10);
            n = n/10;
        }
        return n_new;
    }

    public static void main(String[] args) {
        int n = 19;
        boolean happy = isHappy(n);
        System.out.println(happy);
    }
}
