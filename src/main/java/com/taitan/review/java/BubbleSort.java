package com.taitan.review.java;

/**
 * @author 邹德翔
 * @date 2019/3/29 21:21
 *
 * 冒泡排序
 */
public class BubbleSort {

    public static void main(String[] args) {

        int[] arr = {23,45,123,545,65,123,43,1,43};

        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = 0; j < arr.length - i - 1; j++) {
                if (arr[j] >= arr[j+1]){
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                }
            }
        }

        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }
    }
}
