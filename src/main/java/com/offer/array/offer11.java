package array;

public class offer11 {
    public static void main(String[] args) {
        int[]  nums= {3,4,5,1,2};
        int[]  nums1= {1,3,5};
        int[]  nums2= {2,2,2,0,1};
        int[]  nums3= {1,3,3};
        int min = minArray(nums3);
        System.out.println("最小数字为"+min);
    }

    /**
     * 倒序比较法
     *
     * @param numbers
     * @return
     */
/*    public static int minArray(int[] numbers) {
        for (int i = numbers.length-1; i> 0; i--) {
            if(numbers[i]<numbers[i-1]){
                return numbers[i];
            }
        }
        return numbers[0];
    }*/


    /**
     * 二分法
     *
     * @param numbers
     * @return
     */
    public static int minArray(int[] numbers) {
        int low = 0, high, pivot = 0;
        high = numbers.length - 1;
        while (low < high) {
            pivot = low + (high-low) / 2;
            if (numbers[pivot] < numbers[high]) {
                high = pivot;
            } else if (numbers[pivot] > numbers[high]) {
                low = pivot+1;
            } else {
                high=high-1;
            }
        }

        return numbers[low];
    }
}
