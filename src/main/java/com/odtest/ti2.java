package com.odtest;

import java.util.Stack;
import java.util.Scanner;

public class ti2 {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        String a = in.nextLine();
        int maxLength = 0,length=0;
        char [] ch = a.toCharArray();
        Stack<Character> stack = new Stack<>();
        boolean isRightString = false;
        for (int i = 0; i < ch.length; i++) {
            if(ch[i]=='('||ch[i]=='['||ch[i]=='{'){
                char ch1 = ch[i];
                stack.push(ch1);
                length++;
                if(length>maxLength)maxLength++;
            }else if (ch[i]==')'){
                if (!serarch(length, stack, '(')) break;
            }else if (ch[i]==']'){
                if (!serarch(length, stack, '[')) break;
            }else if (ch[i]=='}'){
                if (!serarch(length, stack, '{')) break;
            }
            if(i== ch.length-1)isRightString=true; // 遍历完成所有字符
    }
        if (isRightString){
            System.out.println(maxLength);
        }else {
            System.out.println(0);
        }

    }

    private static boolean  serarch(int length, Stack<Character> stack, char c) {
        boolean isRightString = true;
        if (stack.search(c) != -1) {
            stack.pop();
            length--;
        }else {
            isRightString =false;
        }
        return isRightString;
    }
}
