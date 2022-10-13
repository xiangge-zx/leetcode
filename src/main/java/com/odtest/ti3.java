package com.odtest;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class ti3 {

    public static void main(String[] args) {
        int type = 7; // 牌型 默认其他
        Scanner sc = new Scanner(System.in);
        // 用两维数组来处理 ,二维数组排序
        String[][] paiArray = new String[2][5];
        for (int j = 0; j < 5; j++) {
            for (int i = 0; i < 2; i++) {
                paiArray[i][j] = sc.next();
            }
        }

        // 数组大小分离
        int[] valueArray = new int[5];
        for (int i = 0; i < 5; i++) {
            String value = paiArray[0][i];
            int valueInt;
            if (value.equals("A")) valueInt = 1;
            else if (value.equals("J")) valueInt = 11;
            else if (value.equals("Q")) valueInt = 12;
            else if (value.equals("K")) valueInt = 13;
            else valueInt = Integer.parseInt(value);
            valueArray[i] = valueInt;
        }
        Arrays.sort(valueArray);

        // 判断是否为牌型6 三条
        int theMoreNum =theMoreNum(valueArray);
        if(theMoreNum==3)  type =6;

        // 判断是否为牌型5 顺子
        if(valueArray[4]-valueArray[0]==4) type =5;


        // 判断是否为牌型4 同花



        // 判断是否为牌型3 葫芦



        // 判断是否为牌型2 四条
        if(theMoreNum==4)  type =2;



        // 判断是否为牌型1 同花顺



        System.out.println(type);
    }

    private static int theMoreNum(int[] valueArray) {
        Map<Integer, Integer> nums = new HashMap();
        int moreNum = 1;
        for (int i = 0; i < valueArray.length; i++) {
            if (nums.get(valueArray[i])==null) {
                nums.put(valueArray[i], 1);
            } else {
                int count = nums.get(valueArray[i]);
                if (count + 1 > moreNum) moreNum++;
                nums.put(valueArray[i], count + 1);
            }
        }
        return  moreNum;

    }


}
