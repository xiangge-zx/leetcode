package com.ti.huawei.od.aaa20221007;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ti1 {
    public static void main(String[] args) {
        int num = 0;
        List list = null;
        StringBuffer sb = null; // 拼接返回
        try {
            Scanner in = new Scanner(System.in);
            String a=null, b = null;
            num = 0;
            a = in.nextLine();
            b = in.nextLine();
            num = Integer.parseInt(a); // 需要加密的字段下标
            list = new ArrayList<>();
            String [] optString = b.split("_");
            for (int i = 0; i < optString.length; i++) { // 去除多余__
                if(!"".equals(optString[i])) {
                    list.add(optString[i]);
                }
            }
            list.set(num,"******");
            sb = new StringBuffer();
            for (int i = 0; i < list.size(); i++) {
                sb.append(list.get(i));
                if(i!= list.size()-1){
                    sb.append("_");
                }
            }
            System.out.println(sb);
        } catch (NumberFormatException e) {
            System.out.println("ERROR");
        }
    }
}