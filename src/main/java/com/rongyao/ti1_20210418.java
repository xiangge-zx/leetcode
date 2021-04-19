package com.rongyao;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ti1_20210418 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        Map<String,String> strMap = new HashMap<>();
        int cow = in.nextInt();
        String[] keyValue = new String[2];
        // 获取赋值语句
        while ((cow--)!=0) {
            keyValue = in.nextLine().split("=");
            strMap.put(keyValue[0],keyValue[1]);
        }
        System.out.println(getValue(strMap,keyValue));
    }

    // 替换值
    public static String getValue(Map<String,String> map,String[] cokeyValuew){
        String strValue = null; // 返回值
        strValue  = map.get(cokeyValuew[0]);
        Pattern p = Pattern.compile("(\\$\\{.*?\\})");

        return  strValue;
    }

}


