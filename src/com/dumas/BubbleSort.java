package com.dumas;

import java.util.Arrays;

//冒泡排序基础版
public class BubbleSort {
    public static void sort(int arr[]){
        int tmp;
        for (int i = 0; i <arr.length ; i++) {
            for (int j = 0; j <arr.length-i-1 ; j++) {
                if (arr[j]>arr[j+1]) {
                    tmp = arr[j];
                    arr[j]=arr[j+1];
                    arr[j+1]=tmp;
                }
            }

        }
    }

//冒泡排序改进版-利用布尔变量isSorted作为标记。如果在本轮排序中，有元素交换，则说明排序无序；如果没有元素交换，说明数列已然有序，直接跳出大循环

    public static void sort2(int arr[]) {

        int tmp=0;
        for (int i = 0; i <arr.length ; i++) {
            boolean isSorted = true;
            for (int j = 0; j <arr.length-i-1 ; j++) {
                if (arr[j] > arr[j + 1]) {
                    tmp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = tmp;
                    isSorted = false;
                }
            }
            if (isSorted){
                break;
            }

        }

    }

//冒泡排序第三版-sortBorder就是无序数列的边界。每一轮排序过程中，sortBorder之后的元素就不需要比较了。

    public static void sort3(int array[]){
        int tmp = 0;
        //记录最后一次交换的位置
        int lastExchangeIndex = 0 ;
        //无序数列的边界，每次比较只需要比较到这里
        int sortBorder = array.length-1;
        for (int i = 0; i <array.length; i++) {
            //有序标记，每一轮的初始是true
            boolean isSorted = true;
            for (int j = 0; j <sortBorder ; j++) {
                if (array[j]>array[j+1]){
                    tmp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = tmp;
                    isSorted = false;
                    lastExchangeIndex = j;

                }
            }
            sortBorder = lastExchangeIndex;
            if (isSorted){
            break;
            }
        }

    }

    //鸡尾酒排序的原始实现。代码外层的大循环控制着所有排序回合，大循环内包含两个小循环。
    public static void cockTailSort(int array[]){

        int tmp = 0;
        for (int i = 0; i <array.length/2 ; i++) {
            //有序标记，每一轮的初始是true
            boolean isSorted = true;
            //奇数轮，从左向右比较
            for (int j = i; j <array.length-i-1 ; j++) {
                if (array[j]>array[j+1]) {
                    tmp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = tmp;
                    //有元素交换，所以不是有序，标记变为false
                    isSorted = false;
                }
            }
            if (isSorted){
                break;
            }
            //偶数轮之前，重新标记为true
            isSorted = true;
            // 偶数轮，从右向左比较
            for (int j = array.length-i-1; j>i ; j--) {

                if (array[j]<array[j-1]){
                    tmp = array[j];
                    array[j]=array[j-1];
                    array[j-1]=tmp;
                    //有元素交换，所以不是有序，标记变为false
                    isSorted = false;
                }
                
            }
            if (isSorted){
                break;
            }
        }

    }

    //鸡尾酒排序改良版-对于单向的冒泡排序，我们需要设置一个边界值，对于双向的鸡尾酒排序，我们需要设置两个边界值。

    public static void cockTailSort2(int array[]){
        int tmp = 0;
        //记录右侧最后一次交换的位置
        int lastRightExchangeIndex = 0;
        //记录左侧最后一次交换的位置
        int lastLeftExchangeIndex = 0;
        //无序数列的右边界，每次比较只需要比到这里位置
        int rightSortBorder = array.length-1;
        //无序数列的左边界，每次比较只需要比到这里位置
        int leftSortBorder = 0;
        for (int i = 0; i < array.length / 2; i++) {
            //有序标记，每一轮的初始是true
            boolean isSorted = true;
            //奇数轮，从左到右比较和交换
            for (int j = leftSortBorder; j <rightSortBorder; j++) {
                if (array[j]>array[j+1]){
                    tmp = array[j];
                    array[j] =  array[j+1];
                    array[j+1] = tmp;
                    //有元素交换，所以不是有序，标记变为false
                    isSorted = false;
                    lastRightExchangeIndex = j;
                }
            }
            rightSortBorder = lastRightExchangeIndex;
            if (isSorted){
                break;
            }
            //偶数轮之前，重新标记为true
            isSorted = true;
            //偶数轮，从右向左比较
            for (int j = rightSortBorder; j >leftSortBorder ; j--) {
                if (array[j]<array[j-1]){
                    tmp = array[j];
                    array[j] = array[j-1];
                    array[j-1] = tmp;
                    //有元素交换，所以不是有序，标记为false
                    isSorted = false;
                    lastLeftExchangeIndex=j;
                }
            }
            leftSortBorder = lastLeftExchangeIndex;
            if (isSorted){
                break;
            }
        }

    }

    public static void main(String[] args){

        int[] arr = new int[]{5,8,6,3,9,2,1,7};
        int[] arr2 = new int[]{9,2,6,0,9,2,1,6};
        int[] arr3 = new int[]{3,4,2,1,5,6,7,8};
        int[] arr4 = new int[]{2,3,4,5,6,7,8,1};
        int[] arr5 = new int[]{2,3,4,5,6,7,8,1};

        sort(arr);
        sort2(arr2);
        sort3(arr3);
        cockTailSort(arr4);
        cockTailSort2(arr5);

        System.out.println(Arrays.toString(arr));
        System.out.println(Arrays.toString(arr2));
        System.out.println(Arrays.toString(arr3));
        System.out.println(Arrays.toString(arr4));
        System.out.println(Arrays.toString(arr5));

    }
}

