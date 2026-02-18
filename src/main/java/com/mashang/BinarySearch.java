package com.mashang;

import java.util.ArrayList;
import java.util.List;

public class BinarySearch {


    public static void main(String[] args) {
        // 二分查找
        int[] arr = {1,3,5,7,9,11};
        int key = 3;
        //int position = recursionBinarySearch(arr,key,0,arr.length - 1);

        int position = binarySearch(arr, key ,0,arr.length-1);

        if(position == -1){
            System.out.println("查找的是"+key+",序列中没有该数！");
        }else{
            System.out.println("查找的是"+key+",找到位置为："+position);
        }



    }

    public static  int  binarySearch(int[] arr,int key ,int low,int high){
        if (key < arr[low] || key > arr[high] || low > high){
            return -1;
        }
        int mid = (low+high)/2;
        if(arr[mid] > key){
            return binarySearch(arr,key,low,mid-1);
        }else if(arr[mid] < key){
            return binarySearch(arr,key,mid+1,high);
        }else {
            return mid;
        }

    }
}
