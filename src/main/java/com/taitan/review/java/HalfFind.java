package com.taitan.review.java;

/**
 * @author 邹德翔
 * @date 2019/3/29 20:48
 *
 * 二分查找 / 折半查找
 */
public class HalfFind {

    public static void main(String[] args) {

        int[] arr = {2,5,12,24,35,44,64,75,78,87,88,89,90};

        System.out.println(findValue(arr,0,arr.length,78));
    }

    public static int findValue(int[] arr,int from,int to,int key){

        int middle = (from + to) / 2;
        int temp = arr[middle];

        if (temp > key){
            to = middle - 1;
        }else if (temp < key){
            from = middle + 1;
        }else
            return middle;
        return findValue(arr,from,to,key);
    }
}
