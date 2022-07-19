package com.aI;



import java.util.*;

public class TI_C {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(); // 等级
        int m = sc.nextInt(); // 物品
        List<Integer> ranks = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            ranks.add(sc.nextInt());
        }
        System.out.println(ZeroOnePack(n,m,ranks));
    }

    public static int ZeroOnePack(int N,int M,List<Integer> ranks){
        Collections.sort(ranks); // 排序
        for (int i = 0; i < M; i++) {
            if (N>=ranks.get(i)&&N<=100)
            {
                N++;
            }else{
                return N;
            }
        }
        return N;
    }
}
