package leetcode.exam;

import java.util.*;

// 自定义输入输出拿什么去接 10，20，30这种数组啊
// acm模式的调试：先输入！再调试！
// acm提交错误并没有 报错显示，也没有提升哪个样例失败。很恶心。直接就说通过率多少，答案错误。
public class pddexam4 {
    public static int costmax(List<Integer> goodList,List<Integer> costList, HashMap< Integer, Integer> costMap){
        int maxres = 0;

        for (int i = 0, j=0; i < goodList.size() && j < costList.size(); i++) {

            //商品价格 > 优惠卷卷面
            if (goodList.get(i) >= costList.get(j)){
                int pastMax = 0;
                while (j < costList.size() && goodList.get(i) >= costList.get(j)){
                    pastMax = Math.max(pastMax, costMap.get(costList.get(j)) );
                    j++;
                }
                maxres += pastMax;
            }

            //商品价格 < 优惠卷卷面
            if (j < costList.size() && goodList.get(i) < costList.get(j)){
//                i++;
            }
        }

        return maxres;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int goodNumber = sc.nextInt();
        int costNumber = sc.nextInt();

        List<Integer> goodList = new ArrayList<>();
        List<Integer> costList = new ArrayList<>();
        HashMap< Integer, Integer> costMap = new HashMap<>();

        while (goodNumber>0 && sc.hasNextInt()){
            goodList.add(sc.nextInt());
            goodNumber--;
        }
        while (costNumber>0 && sc.hasNextInt()){
            int key = sc.nextInt();
            int value = sc.nextInt();
            costMap.put(key, value);
            costNumber--;
        }
        goodList.sort(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1-o2;
            }
        });
        // 把优惠卷的面额也排序
        for (Integer i : costMap.keySet()) {
            costList.add(i);
        }
        costList.sort(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1-o2;
            }
        });

        System.out.println("商品总数："+goodList);
        System.out.println("优惠卷排序："+costList);
        System.out.println("优惠卷总数："+costMap);

        int costmax = costmax(goodList, costList, costMap);
        System.out.println("最优惠能多少："+costmax);

    }
}
