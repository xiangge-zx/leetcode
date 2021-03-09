package com.leetcode.cn;

/**
 * @author  xuan
 */
public class leetcode303 {
    private int[] data;

    public leetcode303(int[] nums) {
        data = nums;

    }

    public int sumRange(int i, int j) {
        int sum = 0;
        for(int k = i;k <= j ;k++)
        {
            sum += data[k];
        }
        return sum;

    }


}