package leetcode.greed;

import java.util.Arrays;

public class findContentChildren {
    public int findContentChildrenMethod(int[] g, int[] s) {

        //按照孩子胃口的大小排序，从小到大依次满足，且应选择可以满足且尺寸最小的饼干
        Arrays.sort(g);
        Arrays.sort(s);

        int count = 0;

        for (int i=0, j=0; i<g.length && j<s.length; i++, j++) {
            while (g[i]>s[j] && j<s.length-1){
                j++;
            }
            if (g[i]<=s[j]){
                count++;
            }
        }
        return count;
    }
}
