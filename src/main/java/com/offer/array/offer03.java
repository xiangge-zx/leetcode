package com.offer.array;


import java.util.HashSet;
import java.util.Set;

public class offer03 {
    public static void main(String[] args) {
        int[]  nums= {2, 3, 1, 0, 2, 5, 3};
        int repeatNum = findRepeatNumber(nums);
        System.out.println(repeatNum);
    }

    /**
     * @param nums
     *
     *
     * @return
     */
    public static int findRepeatNumber(int[] nums) {
        Set findRepeat =new  HashSet();
        int repeatNum = -1;
        findRepeat.add(nums[0]);
        for (int i = 1; i < nums.length; i++) {
            if(!findRepeat.add(nums[i]))
            {return nums[i];}
        }
        return repeatNum;
    }
}
