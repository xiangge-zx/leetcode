package com.leetcode.cn;

public class leetcode832 {
    public static void main(String[] args) {
//        int[][] matrix = {{1,2,3,4},{5,1,2,3},{9,5,1,2}};
        int[][] matrix =  {{1,1,0},{1,0,1},{0,0,0}};
        leetcode832 lt = new leetcode832();
        lt.flipAndInvertImage(matrix);
        int[][] result = lt.flipAndInvertImage(matrix);
        System.out.println(result);
    }
    public int[][] flipAndInvertImage(int[][] matrix) {
        int n = matrix.length;
        for(int i=0;i<n;i++){
            int left =0,right = n-1;
            while (left<right){
                if(matrix[i][left] == matrix[i][right]){
                    matrix[i][left] ^= 1;
                    matrix[i][right] ^=1;
                }
                left++;
                right--;
            }
            if(left == right){
                matrix[i][left] ^= 1;
            }
        }
        return  matrix;

    }
}
