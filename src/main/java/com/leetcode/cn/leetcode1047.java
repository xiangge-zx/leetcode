package com.leetcode.cn;

public class leetcode1047 {
    public static void main(String[] args) {

    }
    public String removeDuplicates(String s){
        StringBuffer stack = new StringBuffer();
        int top = -1;
        for(int i=0;i<s.length();++i){
            char ch =s.charAt(i);
            if(top>=0&&stack.charAt(top)==ch){
                stack.deleteCharAt(top);
                --top;
            }else {
                stack.append(ch);
                ++top;
            }
        }
        return stack.toString();
    }
}
