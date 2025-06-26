package leetcode.greed;

public class greedMain {
    public static void main(String[] args) {
        int[] g = {1,2,3};
        int[] s = {1,1};

        findContentChildren fd = new findContentChildren();
        int result = fd.findContentChildrenMethod(g, s);
        System.out.println(result);
    }
}
