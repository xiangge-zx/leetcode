package com.ti.huawei.od.dp;

import java.util.Scanner;

/**
 * 牛客网 华为机试 HJ32 密码截取
 *
 * 22/23 组用例通过
 */
public class HJ32 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String ch = in.nextLine();
        System.out.println(getMaxLenth(ch));
    }

    static int getMaxLenth(String ch) {
        char[] chars = ch.toCharArray();
        int charLength = chars.length, maxLenth = 0, length;
        int[][] theSame = new int[charLength][charLength];  // 辅助矩阵
        for (int i = 0; i < charLength; i++) {
            for (int j = 0; j < charLength; j++) {
                if (chars[i] == chars[charLength - j - 1]) theSame[i][j] = 1;
            }
        }
        for (int i = 0; i < charLength; i++) {
            for (int j = 0; j < charLength; j++) {
                if (theSame[i][j] == 1)
                {
                    length = depth(i, j, charLength, theSame, 1);
                    if (length > maxLenth) maxLenth = length;
                }

            }
        }
        return maxLenth;
    }


    static int depth(int i, int j, int charLength, int[][] theSame, int depth) {
        if (!(i + 1 < charLength) || !(j + 1 < charLength)) {
            return depth;
        } else {
            if (theSame[i + 1][j + 1] == 1) {
                depth++;
                depth = depth(i + 1, j + 1, charLength, theSame, depth);
            }
        }
        return depth;
    }
}
