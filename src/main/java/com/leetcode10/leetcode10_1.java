package com.leetcode10;

import java.util.HashMap;

public class leetcode10_1 {

    public static void main(String[] args) {
        int[] nums = {1, 3, 4, 6, 7, 2, 8, 9, 10, 5};
        int target = 9;
        int[] result = twoSum(nums, target);
        for (int i : result) {
            System.out.print(i);
            System.out.print(" ");
        }
    }

    public static int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if(map.containsKey(target - nums[i])){
                return new int[]{map.get(target - nums[i]),i};
            }
            map.put(nums[i],i);
        }
        throw new IllegalArgumentException("No two sum solution");
    }



    /**
     * 暴力解
     * **/
//    public static int[] twoSum(int[] nums, int target) {
//        Integer idx_a = null, idx_b = null;
//        for (int i = 0; i < nums.length; i++) {
//            Boolean isTarget = false;
//            for (int j = 0; j < nums.length; j++) {
//                if (i == j) {
//                    continue;
//                }
//                if (nums[i] + nums[j] == target) {
//                    idx_a = i;
//                    idx_b = j;
//                    isTarget = true;
//                    break;
//                }
//            }
//            if (isTarget) {
//                break;
//            }
//        }
//
//        int[] result = new int[2];
//        if (idx_a != null && idx_b != null) {
//            result[0] = idx_a.intValue();
//            result[1] = idx_b.intValue();
//        }
//        return result;
//    }
}
