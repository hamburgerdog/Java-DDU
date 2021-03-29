package org.xjosiah.algorithm;

/**
 * 在数组中的两个数字，如果前面一个数字大于后面的数字，则这两个数字组成一个逆序对。
 * 输入一个数组，求出这个数组中的逆序对的总数
 * 例如：「 input ： 7 5 6 4 」 『 output ： 5 』
 *
 * @author xjosiah
 * @since 2021/3/29
 */
public class _036_InversePairs {
    private static final int[] origin = {7, 5, 4, 6, 3};

    public static void main(String[] args) {
        System.out.println(countInversePairByPopSort(origin));
    }

    /**
     * 逆序对的数量求解方式可以转换成排序过程中从整个数组进行排序后总共需要交换的次数
     * 即每交换一次说明存在一个逆序对，如7,5,6,4 -> 5,6,4,7 证明7有三个逆序对，而后的5、6同理
     *
     * @param array 源数组
     * @return 逆序对总数
     */
    private static int countInversePairByPopSort(int[] array) {
        int count = 0;
        boolean isSorted = false;
        for (int i = 0; i < array.length - 1; i++) {
            if (isSorted) break;
            isSorted = true;
            for (int j = 0; j < array.length - i - 1; j++) {
                if (array[j] > array[j + 1]) {
                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                    count++;
                    isSorted = false;
                }
            }
        }
        return count;
    }
}
