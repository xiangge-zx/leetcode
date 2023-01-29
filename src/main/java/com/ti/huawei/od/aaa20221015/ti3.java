package com.ti.huawei.od.aaa20221015;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


/**
 * https://leetcode.cn/problems/fraction-to-recurring-decimal/
 * https://leetcode.cn/problems/largest-number/
 * https://leetcode.cn/problems/longest-valid-parentheses/comments/
 * https://leetcode.cn/problems/longest-common-subsequence/
 * https://leetcode.cn/problems/qJnOS7/
 * https://leetcode.cn/problems/longest-palindromic-substring/
 */
public class ti3 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String str = in.nextLine();
        System.out.println(getMaxlong(str));
    }

    static int getMaxlong(String str) {
        Pattern isNum = Pattern.compile("[0-9]");
        Pattern isAbc = Pattern.compile("[a-zA-z]");
        // 1.得到最长的合法公式的下标
        int length = 0, maxLength = 0, start = 0;
        int theMaxStrat = 0; // 记录目前长的下标
        for (int i = 0; i < str.length(); i++) {
            String ch = str.substring(i, i + 1);
            Matcher m = isNum.matcher(ch);
            Matcher mabc = isAbc.matcher(ch);
            if (mabc.find()) {
                if (length > maxLength) {
                    theMaxStrat = start;
                    maxLength = length;
                    length = 0; // 长度归零
                }
                continue;
            }
            if (length == 0) {
                // a.开头是数字或者-符号就是合法公式的开头，要记录开头下标和长度
                if (m.find() || "-".equals(ch)) {
                    length = 1;
                    start = i;
                }
            } else {
                String next = null;

                if (i != 0) { // 如果不是开头第一个
                    next = str.substring(i - 1, i);
                }
                // b.出现连续的+-或者字母,归零合法字符串的长度
                // 上个字符为+ 或者是 -,如果下个字符不为数字则不是合法字符，且上个字符也不能纳入长度计算
                if (("+".equals(next) || "-".equals(next)) && !m.find()) {
                    length--;
                    if (length > maxLength) {
                        theMaxStrat = start;
                        maxLength = length;
                        length = 0; // 长度归零
                    }
                } else {
                    length++;
                }
            }
            if (i == str.length() - 1) {
                if (length > maxLength) {
                theMaxStrat = start;
                maxLength = length;
                length = 0; // 长度归零
                }
            }
        }
        System.out.println(maxLength); // 最长
        System.out.println(theMaxStrat); // 下标

        Pattern isNums = Pattern.compile("[0-9]+");
        //        Pattern isAddNum = Pattern.compile("\\+[0-9]+");
        Pattern isfuNum = Pattern.compile("\\-[0-9]+");
        // 2.计算得到合法的数值
        List<String> nums = new ArrayList<String>();
        int sum = 0;
        String maxLongStr = str.substring(theMaxStrat, theMaxStrat+maxLength);
        for (int i = 0; i < maxLongStr.length(); i++) {
            String ch = maxLongStr.substring(i, i + 1);
            if("+".equals(ch)){
                continue;
            }
            if ("-".equals(ch)) {
                Matcher m2 = isfuNum.matcher(maxLongStr.substring(i, maxLongStr.length()));
                // 负数
                if (m2.find()) {
                    String fu = m2.group(0);
                    i = i + fu.length() - 1;
                    nums.add(fu);
                }
            } else {
                Matcher m = isNums.matcher(maxLongStr.substring(i, maxLongStr.length()));
                if (m.find()) {
                    String fu = m.group(0);
                    i = i + fu.length() - 1;
                    nums.add(fu);
                }
            }
        }
        for (String num : nums) {
            sum = sum + Integer.parseInt(num);
        }


        return sum;
    }

}