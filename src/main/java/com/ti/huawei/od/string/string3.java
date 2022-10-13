package com.ti.huawei.od.string;

import java.util.*;

/**
 * 字符串的处理和解压
 */
public class string3{
    public static void main(String[] args){
        Scanner input;
        int C, i;
        String[] strs;

        input = new Scanner(System.in);
        while(input.hasNext()){
            C = input.nextInt();
            strs = new String[C];
            for(i = 0; i < C; i++){
                strs[i] = input.next();
            }
            for(i = 0; i < C; i++){
                System.out.println(Solution(strs[i]));
            }
        }
    }

    private static String Solution(String str){
        StringBuilder ans;
        Stack<Integer> stack;
        int i, j, l;
        char c;

        ans = new StringBuilder();
        stack = new Stack<>();
        l = str.length();
        i = 0;
        while(i < l){
            c = str.charAt(i);
            if(c == '('){
                stack.push(ans.length());
                i++;
            }else if(c >= 'A' && c <= 'Z'){
                ans.append(c);
                i++;
            }else if(c >= '0' && c <= '9'){
                j = i;
                while(i < l && str.charAt(i) >= '0' && str.charAt(i) <= '9'){
                    i++;
                }
                ans.append(repeat(ans.substring(ans.length() - 1), Integer.parseInt(str.substring(j, i)) - 1));
            }else if( c == ')'){
                i++;
                j = i;
                while(i < l && str.charAt(i) >= '0' && str.charAt(i) <= '9'){
                    i++;
                }
                ans.append(repeat(ans.substring(stack.pop()), Integer.parseInt(str.substring(j, i)) - 1));
            }
        }
        return ans.toString();
    }

    private static String repeat(String str, int n){
        int i;
        StringBuilder ans;

        ans = new StringBuilder();
        for(i = 0; i < n; i++){
            ans.append(str);
        }
        return ans.toString();
    }
}