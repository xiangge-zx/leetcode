package com.offer.array;

public class offer21 {
    public static void main(String[] args) {
        int []nums  = {1,2,3,4};
        Solution21 solution = new Solution21();
        int[] result = solution.exchange(nums);
        System.out.println(result);
    }
}


class Solution21 {
    public int[] exchange(int[] nums) {
        int left = 0;
        int right = nums.length-1;
        int temp;
        while (left<right){
            while (left<right&&(nums[left]%2==1))left++;
            while (left<right&&(nums[right]%2==0))right--;
            temp = nums[left];
            nums[left] = nums[right];
            nums[right] = temp;
        }
        return nums;
    }
}
