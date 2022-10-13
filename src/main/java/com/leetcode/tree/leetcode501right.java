package com.leetcode.tree;

import java.util.ArrayList;
import java.util.List;

public class leetcode501right {
    public static void main(String[] args) {
        // 基础示例
//        TreeNode gen = new TreeNode(1);
//        gen.setLeft(null);
//        gen.setRight(new TreeNode(2,new TreeNode(2),null));

        // 错误示例
        TreeNode gen = new TreeNode(-57762);
        TreeNode left1 = new TreeNode(-76299,null,new TreeNode(-20028));
        gen.setLeft(left1);
        TreeNode right1 = new TreeNode(-37762);
        TreeNode right2 = new TreeNode(-24762,new TreeNode(-57762),new TreeNode(15000));
        gen.setRight(right1);
        right1.setRight(right2);
        int [] modeList =  findMode(gen);
        for (int i = 0; i < modeList.length; i++) {
            System.out.println(modeList[i]);
        }
    }

    static List<Integer> list = new ArrayList<>();
    
    public static int[] findMode(TreeNode root) {
        List<Integer> ans = new ArrayList<> ();
        int max = Integer.MIN_VALUE;
        inorder ( root );
        int[] ints = list.stream ().mapToInt ( Integer::intValue ).toArray ();

        int i =0;
        while (i<ints.length){
            int size = 1;
            while (i<ints.length-1&&ints[i]==ints[i+1]){
                size++;
                i++;
            }
            if(size>max){
                while (ans.size ()!=0){
                    ans.remove ( ans.size ()-1 );
                }
                ans.add ( ints[i] );
                max = size;
            }else if(size==max) ans.add ( ints[i] );
            i++;
        }
        return ans.stream ().mapToInt ( Integer::intValue ).toArray ();
    }

    public static void inorder(TreeNode root){
        if(root==null) return;
        inorder ( root.left );
        list.add ( root.val );
        inorder ( root.right );
    }


    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }

        public int getVal() {
            return val;
        }

        public void setVal(int val) {
            this.val = val;
        }

        public TreeNode getLeft() {
            return left;
        }

        public void setLeft(TreeNode left) {
            this.left = left;
        }

        public TreeNode getRight() {
            return right;
        }

        public void setRight(TreeNode right) {
            this.right = right;
        }
    }
}
