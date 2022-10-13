package com.offer.array;

import java.util.HashMap;
import java.util.Map;

public class offer39 {
    public static void main(String[] args) {
        Solution39 solution39 = new Solution39();
        int[] nums = {1};
        int maxCount = solution39.majorityElement(nums);
        System.out.println(maxCount);
    }

}


class Solution39 {
    public int majorityElement(int[] nums) {
        Map<Integer, Integer> numMap = new HashMap<Integer, Integer>();
        for (int i = 0; i < nums.length; i++) {
            if (numMap.containsKey(nums[i])) {
                int count = numMap.get(nums[i]) + 1;
                if (count > nums.length / 2) {
                    return nums[i];
                }
                numMap.put(nums[i], count);
            } else {
                numMap.put(nums[i], 1);
            }
        }
        return nums[0];
    }
}