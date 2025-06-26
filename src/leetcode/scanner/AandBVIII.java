package leetcode.scanner;

import java.util.Scanner;

public class AandBVIII {
        public static void main(String[] args){
            Scanner sc = new Scanner(System.in);
            while(sc.hasNext()){
                int N = sc.nextInt();
                // 每组有n⾏数据
                while(N-- > 0){
                    int M = sc.nextInt();
                    int sum = 0;
                    // 每⾏有m个数据
                    while(M-- > 0){
                        sum += sc.nextInt();
                    }
                    System.out.println(sum);
                    if(N > 0) System.out.println();
                }
            }
        }
    }
