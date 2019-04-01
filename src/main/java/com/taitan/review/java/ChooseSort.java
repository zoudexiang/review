package com.taitan.review.java;

/**
 * @author 邹德翔
 * @date 2019/3/30 8:51
 *
 * 选择排序
 */
public class ChooseSort {

    public static void main(String[] args) {

        int[] arr = {23, 45, 123, 545, 65, 123, 43, 1, 43,23, 45, 123, 545, 65, 123, 43, 1, 43};

        for (int i = 0; i < arr.length - 1; i++) {

            int temp = i;

            for (int j = i; j < arr.length - 1; j++) {
                if (arr[temp] > arr[j + 1]) {
                    temp = j + 1;
                }
            }

            int t = arr[temp];
            arr[temp] = arr[i];
            arr[i] = t;
        }

        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }
    }
}
