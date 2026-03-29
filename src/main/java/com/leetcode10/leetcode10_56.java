package com.leetcode10;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class leetcode10_56 {

    public static void main(String[] args) {
        int[][] intervals = new int[][]{{1, 3}, {8, 10}, {15, 18}, {2, 6}};

        int[][] result = intervals(intervals);
        for (int i = 0; i < result.length; i++) {
            System.out.println(result[i]);
        }

    }

    private static int[][] intervals(int[][] intervals) {
        // 排序让最小区间排到前面的
        Arrays.sort(intervals, Comparator.comparingInt(a -> a[0]));
        // 返回合并后的区间
        List<int[]> list = new ArrayList<>();
        for (int i = 0; i < intervals.length; i++) {
            if (list.isEmpty()) {
                list.add(intervals[i]);
            } else {
                int maxLast = list.get(list.size() - 1)[1];
                int from = intervals[i][0], to = intervals[i][1];
                if (maxLast >= from) {
                    // 相交则更新
                    int[] newMerge = new int[]{list.get(list.size() - 1)[0], Math.max(maxLast, to)};
                    list.set(list.size() - 1, newMerge);
                } else {
                    // 不想交则添加
                    list.add(intervals[i]);
                }
            }
        }
        return list.toArray(new int[list.size()][]);
    }


}
