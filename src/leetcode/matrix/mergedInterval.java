package leetcode.matrix;

//56. 合并区间

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class mergedInterval {
    public int[][] mergedIntervalMethod( int[][] intervals){
        // 根据区间左端点排序 Arrays.sort(intervals, new Comparator)回车
        Arrays.sort(intervals, new Comparator<int[]>() { // 每个要比较的对象！对象之间的前后/大小关系只由 return的结果为负数0正数 决定。
            // 既不是具体要比较的字段，也不是比较后的数据结构。
            @Override
            public int compare(int[] m, int[] n) { // 每个要比较的对象！
                // 下面才是具体要比较的字段
                return m[0] - n[0];
            }
        });

        // 创建一个新的结果数组
//        int[][] res = new int[intervals.length][];
        List<int[]> res = new ArrayList<int[]>();
        // 先放第一个元素进去res数组
        res.add(intervals[0]);

        //每次取出原数组的一个元素，与新数组的区间端点的比较。
        for (int i = 1; i < intervals.length; i++) {
            // 新区间的右端 >= 取出来的旧区间的左端 => 合并 => 【新区间的左端 ， max「新区间的右端， 旧区间的右端」】
            // => 新区间的右端 = max( 新区间的右端，旧区间的右端)
            if ( res.get(res.size()-1)[1] >= intervals[i][0]){   //合并
                res.get(res.size()-1)[1] = Math.max( res.get(res.size()-1)[1], intervals[i][1]);
            }else{
                res.add( intervals[i] );
            }
        }

        return res.toArray(new int[res.size()][]);
    }
}
