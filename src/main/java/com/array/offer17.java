package array;

import java.util.ArrayList;
import java.util.List;

/**
 * 输入数字 n，按顺序打印出从 1 到最大的 n 位十进制数。比如输入 3，则打印出 1、2、3 一直到最大的 3 位数 999。
 * <p>
 * Math.pow(n,count)用法
 * numbers.stream().mapToInt(Integer::intValue).toArray()  jdk8 新用法
 */
public class offer17 {
    public static void main(String[] args) {
        int n = 3;
        int[] numbers = printNumbers(n);
        System.out.println(numbers);
    }


    public static int[] printNumbers(int n) {
        List<Integer> numbers = new ArrayList();
        int max = 0;
        int count = 0;
        for (int i = 0; i < n; i++) {
            max = max + 9 * (int) Math.pow(10, count);
            count++;
        }
        for (int i = 1; i <= max; i++) {
            numbers.add(i);
        }


        // 转换
        int[] integerAry = numbers.stream().mapToInt(Integer::intValue).toArray();
        return integerAry;
    }
}
