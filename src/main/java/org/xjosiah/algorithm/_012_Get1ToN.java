package org.xjosiah.algorithm;

/**
 * 给定一个数字N，打印从1到最大的N位数。
 * 如 n=1 则 1,2,3,4,5,6,7,8,9
 *
 * @author xjosiah
 * @since 2021/3/19
 */
public class _012_Get1ToN {
    public static void main(String[] args) {
        print1ToN(4);
    }

    /**
     * 字符串递归来解决大数据溢出的问题（全排列算法）
     * 参考文章：https://blog.csdn.net/qq_34980601/article/details/89918187
     * @param N 要从1输出的最大的位数
     */
    private static void print1ToN(int N) {
        if (N <= 0) {
            return;
        }
        int[] arr = new int[N];
        set0To9ToArray_index_(arr,0);
    }

    /**
     * 递归算法的核心
     * @param numInArray   存放当前排序的数字
     * @param index 具体指向arr中某一位
     */
    private static void set0To9ToArray_index_(int[] numInArray, int index){
        if (index == numInArray.length){
            printIntArray(numInArray);
            return;
        }

        for (int i = 0; i < 10; i++) {
            numInArray[index] = i;
            set0To9ToArray_index_(numInArray,index+1);
        }
    }

    /**
     * 输出arr
     * @param arr 用于转化成当前数字的数组可看成char[] -> String
     */
    private static void printIntArray(int[] arr) {
        boolean isRead = false;
        for (int value : arr) {
            if (value != 0)
                isRead = true;
            if (isRead)
                System.out.print(value);
        }
        System.out.println();
    }
}
