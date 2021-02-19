package com.leetcode.cn;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class leetcode1103 {
    // 主函数
    public static void main(String[] args) {
        leetcode1103 lc = new leetcode1103();
        int candies = 60;
        int num_people = 4;
        int [] people = lc.distributeCandies(candies,num_people);
        // 转换为List格式才能print打印
        List<Integer> people_list = Arrays.stream(people).boxed().collect(Collectors.toList());
        System.out.println(people_list);
        System.out.println("ddd");

    }
    // 题目中的方法
    public int[] distributeCandies(int candies, int num_people) {
        int[] people= new int[num_people];
        int cycle = 0;
        while (candies>0){
        for(int i = 1;i<num_people+1;i++){
            if (candies-(i+cycle*num_people)>0){
                people[i-1]+=(i+cycle*num_people);
                candies = candies-(i+cycle*num_people);
            }else {
                people[i-1]+=candies;
                candies = 0;
                return people;
            }
        }
            cycle++;
        }
        return people;
    }
}
