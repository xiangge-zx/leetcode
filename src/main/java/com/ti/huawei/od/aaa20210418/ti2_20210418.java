package com.ti.huawei.od.aaa20210418;

import java.util.ArrayList;
import java.util.Scanner;

public class ti2_20210418 {
    public static void main(String[] args) {
        int opt1=0 ,opt2=0; //先后操作
        int num=0; // 总数
        int copy=0; // 粘贴板
        ArrayList<Integer> optArr = new ArrayList();
        // 自动结束输入
        Scanner in = new Scanner(System.in);
        String line = in.nextLine();
        Scanner in2 = new Scanner(line);
        while(in2.hasNextInt()){
            optArr.add(in2.nextInt());
        }
        int totalOpt = optArr.size();
        int i = -1;
        while (i++!=totalOpt-1) {//
            if(opt1==0){ // 首次输入，初始化两个操作记录
                opt1 = optArr.get(i);
                opt2 = opt1;
            }else{
                opt1 =opt2; // 前一次操作覆盖
                opt2 = optArr.get(i);
            }
            // 分别处理每次操作
            if(opt2 == 1){ // a
                if(opt1==5){
                    num = 1; // 全部字母删除
                }
                num++;
            }
            else if(opt2 == 2){ // ctrl+c
                if(opt1==5){
                    copy = num;
                    num = 0;
                }
            }
            else if(opt2 == 3){ // ctrl+x
                if(opt1==5){
                    copy = num;
                }
            }
            else if(opt2 == 4){ // ctrl+v
                num=num +copy;
            }
            else if(opt2 == 5){ // ctrl+a
            }
            else {
                System.out.println("error opt!");
            }
        }
        System.out.println(num);
    }
}
