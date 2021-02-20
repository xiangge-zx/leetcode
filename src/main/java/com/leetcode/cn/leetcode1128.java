package com.leetcode.cn;

import java.util.Arrays;

public class leetcode1128 {
    public static void main(String[] args) {
        int[][] dominoes = {{1,2},{2,1},{3,4},{5,6}};
        leetcode1128 lc = new leetcode1128();
        int num = lc.numEquivDominoPairs(dominoes);
        System.out.println(num);

    }
    public int numEquivDominoPairs(int[][] dominoes) {
        int ans = 0;
        //1 <= dominoes[i][j] <= 9，所以最大是99
        int[] cp = new int[100];
        for(int[] arr:dominoes){
            //排序，归为一种
            Arrays.sort(arr);
            //因为后加入的牌可以跟前面所有的牌组队，所以组队的数量就是之前所存在的牌的数量
            int i=cp[arr[0]*10+arr[1]]++;
            ans+=i;
        }
        return ans;
    }

}
