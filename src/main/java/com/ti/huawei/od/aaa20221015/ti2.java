package com.ti.huawei.od.aaa20221015;

import java.util.Scanner;

/**
 * 屏幕 800X600
 */
public class ti2 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int x = in.nextInt();
        int y = in.nextInt();
        int t = in.nextInt();
        System.out.println(getXy(x,y,t));
    }

    static String getXy(int x,int y ,int t) {
        int xNew =  x+t;
        int yNew =  y+t;

        return xNew+" "+yNew;
    }
}
