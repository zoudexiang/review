package com.taitan.review.java;

/**
 * @author 邹德翔
 * @date 2019/4/10 16:10
 *
 * 快排
 */
public class QuickSort {

    public static void main(String[] args) {

        int[] data = {9, -16, 21, 23, -30, -49, 21, 30, 30};

        System.out.println("排序之前：\n" + java.util.Arrays.toString(data));

        quickSort(data,0,data.length - 1);

        System.out.println("排序之后：\n" + java.util.Arrays.toString(data));
    }

    public static void quickSort(int[] arr, int left, int right) {

        if(left < right){
            int q = partition(arr, left, right);
            quickSort(arr, left, (q - 1));
            quickSort(arr, (q + 1), right);
        }
    }

    private static void swap(int array[],int i,int j){

        int temp;
        temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

    public static int partition(int[] arr, int p, int r) {
        int x = arr[r];
        int i = p - 1;
        for (int j=p; j<r; j++) {
            if (arr[j] <= x) {
                i = i + 1;
                swap(arr, i, j);
            }
        }
        swap(arr, i+1, r);
        return i+1;
    }
}
