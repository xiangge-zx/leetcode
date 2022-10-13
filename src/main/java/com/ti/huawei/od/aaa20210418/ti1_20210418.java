package com.ti.huawei.od.aaa20210418;

import java.util.Scanner;

public class ti1_20210418 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int max = 0; // 最大团队数量
        int peopleNum =  in.nextInt();
        int[] peopleSkill = new int[peopleNum];
        for (int i = 0; i < peopleNum; i++) {
            peopleSkill[i]  = in.nextInt();
        }
        int minSkill = in.nextInt();
        // 数组排序
        int temp;
        for (int i = 0; i <peopleSkill.length ; i++) {
            for (int j = 0; j < peopleSkill.length-i-1; j++) {
                if(peopleSkill[i+j]>peopleSkill[i+j+1])
                {
                    temp =  peopleSkill[i+j];
                    peopleSkill[i+j] = peopleSkill[i+j+1];
                    peopleSkill[i+j+1] = temp;
                }
            }
        }

        // 从小到大 从高能力到低能力,个人能力大于最小值就没必要再组合
        int left = 0; // 最小数组计数器
        for (int i = peopleSkill.length - 1; i >= 0; i--) {
            if(peopleSkill[i]>=minSkill){
                max++;
            }else{
                for ( ; left < i; left++) {
                    if(peopleSkill[i]+peopleSkill[left]>=minSkill){
                        left++;
                        max++;
                    }
                }
            }
        }
        System.out.println(max);
    }
}
