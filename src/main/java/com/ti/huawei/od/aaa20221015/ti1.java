package com.ti.huawei.od.aaa20221015;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 输入字符串s输出s中包含所有整数的最小和
 * 说明：
 * 字符串s只包含az,AZ,+,-，
 * 合法的整数包括正整数，一个或者多个0-9组成，如：0,2,3,002,102
 * 负整数，负号开头，数字部分由一个或者多个0-9组成，如-2,-012,-23,-00023
 * 输入描述：
 * 包含数字的字符串
 * 输出描述：
 * 所有整数的最小和
 * 示例
 * 输入：
 * bb1234aa
 * 输出：
 * 10
 * 输入：
 * bb12-34aa
 * 输出：
 * -31
 * 说明：
 * 1+2-(34)=-31
 */
public class ti1 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String str = in.nextLine();
        System.out.println(countNum2(str));
    }

    static int countNum(String str) {
        List<String> nums = new ArrayList<String>();
        int sum = 0;
        Pattern isNum = Pattern.compile("[0-9]");
        Pattern isNums = Pattern.compile("[0-9]+");
        Pattern isfuNum = Pattern.compile("[\\-]+[0-9]+");
        for (int i = 0; i < str.length(); i++) {
            String ch = str.substring(i, i + 1);
            if ("-".equals(ch)) {
                Matcher m2 = isfuNum.matcher(str.substring(i, str.length()));
                // 负数
                if (m2.find()) {
                    String fu = m2.group(0);
                    i = i + fu.length() - 1;
                    Matcher m = isNums.matcher(fu);
                    if (m.find()) {
                        nums.add("-"+m.group(0));
                    }else {
                        nums.add(fu);
                    }
                }
            } else {
                Matcher m = isNum.matcher(ch);
                while (m.find()) {
                    // 正数
                    nums.add(m.group(0));
                }
            }
        }
        for (String num : nums) {
            sum = sum + Integer.parseInt(num);
        }


            return sum;
    }


    /**
     * 网络上的方法
     *
     * @param line
     * @return
     */
    static int countNum2(String line) {

        char[] chars = (line + "+").toCharArray();

        boolean flag = false; // 定义一个标记,是否是‘-’后面的数字，如果是的话就把数字串起来最大
        StringBuilder sb = new StringBuilder(); // 用来拼接负数字符
        int sum_min = 0;
        for (char aChar : chars) {
            if (Character.isDigit(aChar)) { //判断是否为数字
                if (flag) {
                    sb.append(aChar); // 如果负数就先拼接
                } else {
                    sum_min += aChar - 48; // 其他符号后面的直接计算，才能得到最小正数
                }

                continue;
            }

            if (flag && sb.length() != 0) { // 把前面拼接好的字符串计算出来，并且置空
                sum_min -= Integer.parseInt(sb.toString());
                sb.setLength(0);
            }

            flag = aChar == '-'; // 遇到负号改变标记
        }
        return sum_min;
    }

}
