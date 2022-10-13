package com.offer.array;

import java.util.HashMap;
import java.util.Map;

/*
前序遍历 根左右
中序遍历  左中右
后序遍历  左右根
*/
public class offer07 {
    public static void main(String[] args) {
        int[]preorder = {3,9,20,15,7};
        int[] inorder = {9,3,15,20,7};
        Solution solution  = new Solution();
        TreeNode bt =  solution.buildTree(preorder,inorder);
        System.out.println(bt.toString());

    }

}






class TreeNode {
     int val;
     TreeNode left;
     TreeNode right;
     TreeNode(int x) { val = x; }
 }


class Solution {
    private Map<Integer, Integer> indexMap;

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        int n = preorder.length;
        // 构造哈希映射
        indexMap  = new HashMap<Integer,Integer>();
        for (int i = 0; i < n; i++) {
            indexMap.put(inorder[i],i);
        };

        return myBuildTree(preorder, inorder, 0, n - 1, 0, n - 1);
    }

    public TreeNode myBuildTree(int[] preorder,int[] inorder,int preorder_left,int preorder_right, int inorder_left, int inorder_right){
        if(preorder_left>preorder_right){
            return null;
        }
        // 前序遍历中得第一个节点就是根节点
        int preorder_root = preorder_left;

        // 在中序遍历中定位根节点
        int inorder_root  = indexMap.get(preorder[preorder_root]);

        // 先把根节点建立出来
        TreeNode root = new TreeNode(preorder[preorder_root]);

        // 得到左子树种的节点数目
        int size_left_subtree = inorder_root - inorder_left;

        // 递归地构造左子树，并连接
        root.left = myBuildTree(preorder, inorder, preorder_left + 1, preorder_left + size_left_subtree, inorder_left, inorder_root - 1);
        // 递归地构造右子树，并连接到根节点
        // 先序遍历中「从 左边界+1+左子树节点数目 开始到 右边界」的元素就对应了中序遍历中「从 根节点定位+1 到 右边界」的元素
        root.right = myBuildTree(preorder, inorder, preorder_left + size_left_subtree + 1, preorder_right, inorder_root + 1, inorder_right);
        return root;



    }
}