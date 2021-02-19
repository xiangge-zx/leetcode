package com.leetcode.cn;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class leetcode1122 {
    public static void main(String[] args) {
        int[] arr1 = {2,3,1,3,2,4,6,7,9,2,19};
        int[] arr2 = {2,1,4,3,9,6};
        leetcode1122 lc  = new leetcode1122();
        int [] arr1Sort =  lc.relativeSortArray(arr1,arr2);
        List<Integer> arrList = Arrays.stream(arr1Sort).boxed().collect(Collectors.toList());
        System.out.println(arrList);

    }


    public int[] relativeSortArray(int[] arr1, int[] arr2) {
        Map<Integer,Integer> record = new HashMap<>(arr2.length);
        for(int i = 0;i<arr2.length;i++){
            record.put(arr2[i],i);
        }
        for(int i = 0;i<arr1.length;i++){
            for (int j = i+1;j<arr1.length;j++){
                if (!less(arr1[i],arr1[j],record)){
                    int temp = arr1[i];
                    arr1[i] = arr1[j];
                    arr1[j] = temp;
                }
            }
        }
        return  arr1;
    }
    // 通过构造比较函数来完成
    public static boolean less(int num1,int num2,Map<Integer,Integer> record){
        if(record.containsKey(num1)&& record.containsKey(num2)){
            return record.get(num1)<record.get(num2);
        }else if (record.containsKey(num1)){
            return true;
        }else if(record.containsKey(num2)){
            return false;
        }else {
            return num1<num2;
        }
    }

}
