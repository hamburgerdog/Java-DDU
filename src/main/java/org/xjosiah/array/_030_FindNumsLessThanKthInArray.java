package org.xjosiah.array;

import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * 输入n个整数，找出其中最小的K个数
 *
 * @author xjosiah
 * @since 2021/3/27
 */
public class _030_FindNumsLessThanKthInArray {
    private static final int[] originArray = {4, 5, 1, 6, 2, 7, 3, 8, 4};

    public static void main(String[] args) {
        System.out.println(findNumsLessThanKthByQuickSort(Arrays.copyOf(originArray, originArray.length), 6));
        System.out.println(updateFindNumsByQuickSort(Arrays.copyOf(originArray, originArray.length), 6));
        System.out.println(findNumsByMinHeap(Arrays.copyOf(originArray, originArray.length), 6));
    }

    /**
     * 使用java自带的优先队列（维系一个最小堆的方法）
     *
     * @param array 源数组
     * @param k     第K个
     * @return 包含前K个数的数组的字符串
     */
    private static String findNumsByMinHeap(int[] array, int k) {
        if (k > array.length) throw new RuntimeException("【ERROR】：K超过数组长度！");
        //  过滤重复数据
        array = Arrays.stream(array).distinct().toArray();
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        for (int i = 0; i < array.length; i++) {
            minHeap.add(array[i]);
        }
        //  注意，此处不能使用toArray方法，因为其返回的Array是无顺序的！！！！
        int[] result = new int[k];
        for (int i = 0; i < k; i++) result[i] = minHeap.poll();
        return Arrays.toString(result);
    }

    /**
     * 「快速排序的升级版」底层使用的依旧是快速排序 （有点类似最小堆）
     * 我们要找前k个排序好的数，可以先把源数组中前K个排序好，找出其中最大的一个数即第K个，
     * 把该数于后（n-k）个数进行比较，找到比其小的就交换位置，然后重复以上操作直到所有数据遍历完毕
     *
     * @param array 源数组
     * @param k     第K个数
     * @return 包含前K个数的数组的字符串
     */
    private static String updateFindNumsByQuickSort(int[] array, int k) {
        int[] sortKthArray = quickSortArray(array, 0, k - 1);
        int key = sortKthArray[k - 1];
        for (int i = k; i < sortKthArray.length; i++) {
            if (key > sortKthArray[i]) {
                sortKthArray[k - 1] = sortKthArray[i];
                sortKthArray[i] = key;
                quickSortArray(sortKthArray, 0, k - 1);
                key = sortKthArray[k - 1];
            }
        }
        return Arrays.toString(Arrays.copyOf(sortKthArray, k));
    }

    /**
     * 先将数组进行快速排序，然后最小K个数自然就是前K个数
     * 如果数组有重复元素也可以在此处过滤，最好是在排序前就过滤
     *
     * @param array 源数组
     * @param k     第K个数
     * @return 包含前K个数的数组的字符串
     */
    private static String findNumsLessThanKthByQuickSort(int[] array, int k) {
        int[] sortedArray = quickSortArray(array, 0, array.length - 1);
        return Arrays.toString(Arrays.copyOf(sortedArray, k));
    }

    /**
     * 递归快速排序
     *
     * @param array 源数组
     * @param low   最小下标，用于将数组分段
     * @param high  最大下标，用于将数组分段
     * @return 排序完的数组
     */
    private static int[] quickSortArray(int[] array, int low, int high) {
        if (low < high) {
            int keyIndex = sortArray(array, low, high);
            quickSortArray(array, low, keyIndex - 1);
            quickSortArray(array, keyIndex + 1, high);
        }
        return array;
    }

    /**
     * 进行快速排序中某段数组的排序
     *
     * @param array 源数组
     * @param i     当前数组分段的高下标
     * @param j     当前数组分段的低下标
     * @return 这个分段的中间位置（即分段排序完Key的下标，用于递归分段）
     */
    private static int sortArray(int[] array, int i, int j) {
        int key = array[i];
        while (i < j) {
            for (; j > i; j--) {
                if (array[j] < key) {
                    int temp = array[j];
                    array[j] = array[i];
                    array[i] = temp;
                    break;
                }
            }
            for (; i < j; i++) {
                if (array[i] > key) {
                    int temp = array[j];
                    array[j] = array[i];
                    array[i] = temp;
                    break;
                }
            }
        }
        array[i] = key;
        return i;
    }

}
