package com.od.string;

import java.util.*;

/**
 *      身高体重排序
 */
public class string2 {

    static class Stu{
        public int ind;
        public int h;
        public int m;
        Stu(int ind,int h,int m){
            this.ind=ind;
            this.h=h;
            this.m=m;
        }
    }

    public static void main(String[] args) {


        Scanner in = new Scanner(System.in);
        int n = Integer.parseInt(in.nextLine());
        String [] h = in.nextLine().split(" ");
        String [] m = in.nextLine().split(" ");
        List<Stu> list = new ArrayList<>(n);
        if (n==h.length&&n==m.length){
            for (int i = 1; i <=n ; i++) {
                list.add(new Stu(i,Integer.parseInt(h[i-1]),Integer.parseInt(m[i-1])));
            }
        }
        list.sort((a,b)->{
            int i=a.h-b.h;
            if (i==0){
                i=a.m-b.m;
            }
            return i ;
        });
        for (int i=0;i<list.size();i++) {
            System.out.print(list.get(i).ind);
            if (i!=list.size()-1){
                System.out.print(" ");
            }
        }
    }
}