package com.aI;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TI_D {
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {

        int T = sc.nextInt(); // 几组数
        List<Integer> maxValue = new ArrayList<>();
        for (int i = 0; i < T; i++) {
            int N =sc.nextInt();
            maxValue.add(getMaxValue(N));
        }
        for (int i = 0; i < maxValue.size(); i++) {
            System.out.println(maxValue.get(i));
        }
    }

    // 获取这一轮的最大值
    public static int getMaxValue(int N){
        int[][] values = new int[N][N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                values[i][j] = sc.nextInt();
            }
        } // 把值放入二维数组
        int right = 0;
        int up  = 0;
        int MaxValue = values[right][up];
        while (right<N&&up<N&&((right!=(N-1))||(up!=(N-1)))){
            if(up==N-1){ // 到最后一行只能向右走
                MaxValue =MaxValue+values[up][right+1];
                right++;
            }
            else if(values[up][right+1]>values[up+1][right]){
                MaxValue =MaxValue+values[up][right+1];
                right++;
            }else{
                MaxValue =MaxValue+values[up+1][right];
                up++;
            }
        }
        return MaxValue;
    }
}
