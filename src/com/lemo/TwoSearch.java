package com.lemo;

import java.util.Arrays;


/**
 * @program: javaWebDemo
 * @description 二分查找
 * @author: NiuBenQi
 * @create: 2020-01-11 09:01
 **/
public class TwoSearch {
    public static void main(String[] args) {
        // 声明一个数组
        int[] arr = {13, 35, 54, 71, 92, 34, 76, 88, 32};
        // 将数组内容有序排列
        Arrays.sort(arr);
        System.out.println(Arrays.toString(arr));
        System.out.println(myBinarySearch(arr, 71));
    }

    private static int myBinarySearch(int[] arr, int value) {
        int low = 0;
        int heigh = arr.length - 1;
        while (low <= heigh) {
            int mid = (low + heigh) / 2;
            if (value == arr[mid]) {
                return mid;
            } else if (value > arr[mid]) {
                low = mid + 1;
            } else if (value < arr[mid]) {
                heigh = mid - 1;
            }

        }
        // 未找到返回-1
        return -1;
    }


}
