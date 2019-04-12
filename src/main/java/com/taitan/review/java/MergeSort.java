package com.taitan.review.java;

/**
 * 归并排序 O(NlogN)  空间 O(N) 稳定
 */
public class MergeSort {
    public static void main(String[] args) {

        int[] data = {9, -16, 21, 23, -30, -49, 21, 30, 30};

        System.out.println("排序之前：\n" + java.util.Arrays.toString(data));

        mergeSort(data,0,data.length - 1);

        System.out.println("排序之后：\n" + java.util.Arrays.toString(data));
    }

    /**
     *  拆
     * @param data
     * @param fromIndex
     * @param toIndex
     */
    public static void mergeSort(int[] data,int fromIndex,int toIndex) {
        // 归并排序
        if (fromIndex < toIndex){
            int center = (fromIndex + toIndex) / 2;
            mergeSort(data, fromIndex, center);
            mergeSort(data, (center + 1), toIndex);
            merge(data, fromIndex, center, toIndex);
        }
    }

    /**
     * 和 ---> 将两个数组进行归并，归并前两个数组已经有序，归并后依然有序
     * @param data
     * @param left
     * @param center
     * @param right
     */
    private static void merge(int[] data, int left, int center, int right) {

        int leftArrLen = center - left + 1;
        int rightArrLen = right - center;
        
        int[] leftArr = new int[leftArrLen + 1];
        int[] rightArr = new int[rightArrLen + 1];

        for (int i = 0; i < leftArrLen; i++) {
            leftArr[i] = data[left + i];
        }

        for (int i = 0; i < rightArrLen; i++) {
            rightArr[i] = data[center + 1 + i];
        }

        leftArr[leftArrLen] = Integer.MAX_VALUE;
        rightArr[rightArrLen] = Integer.MAX_VALUE;

        int a = 0;
        int b = 0;

        for (int i = left; i <= right; i++) {

            if (leftArr[a] <= rightArr[b]){
                data[i] = leftArr[a];
                a++;
            }else {
                data[i] = rightArr[b];
                b++;
            }
        }
    }
}