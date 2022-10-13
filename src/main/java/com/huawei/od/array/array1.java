package com.huawei.od.array;

import java.util.*;

public class array1 {

    public static void main(String[] args) {
        array1 ht = new array1();
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int m = scanner.nextInt();

            int ary[] = new int[m];
            for (int i = 0; i < ary.length; i++) {
                ary[i] = scanner.nextInt();
            }
            int n = scanner.nextInt();
            int resAry = ht.solve(ary, n);
            System.out.println(resAry);
        }
    }

    private int solve(int[] ary, int n) {
        int res = -1;
        Set<Integer> set = new HashSet<>();
        for (int a : ary) {
            set.add(a);
        }
        int sz = set.size();
        if (2 * n > sz) {
            return res;
        }

        int count = 0;
        for (Integer s : set) {
            ary[count++] = s;
        }
        Arrays.sort(ary, 0, count);
        res = 0;
        for (int i = 0; i < n; i++) {
            res += ary[i] + ary[count - 1 - i];
        }
        return res;
    }
}
