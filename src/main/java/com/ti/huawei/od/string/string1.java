package com.ti.huawei.od.string;


import java.util.*;

/**
 * JZ61 扑克牌顺子
 * https://www.nowcoder.com/practice/762836f4d43d43ca9deb273b3de8e1f4?tpId=13&tqId=11198&ru=/exam/oj
 */
public class string1 {
    public static void main(String[] args) {
        int[] input = {6, 0, 2, 0, 4};
        System.out.println(IsContinuous(input));

    }


    public static boolean IsContinuous(int[] numbers) {
        int king=0,min,max;
        // 将数组排序
        Arrays.sort(numbers);
        for (int i = 0; i < numbers.length-1; i++) {
            if(numbers[i]==0)king++;
            else if (numbers[i]==numbers[i+1])return false;
        }
        max = numbers[4];
        min = numbers[king];
        return numbers[4]-numbers[king]<5;
    }
}
