package org.xjosiah.algorithm;

/**
 * 在古老的一维模式识别中,如何计算出连续子向量的最大和
 * 例如:{6,-3,-2,7,-15,1,2,2}, 连续子向量的最大和为8(从第0个开始,到第3个为止)。
 *
 * @author xjosiah
 * @since 2021/3/28
 */
public class _031_FindMaxSumInArray {
    private static final int[] origin = {6, -3, -2, 7, -15, 1, 2, 2};

    public static void main(String[] args) {
        System.out.println(findMaxSumInArray(origin));
        System.out.println(findMaxSumInArrayByDynamic(origin));
        System.out.println(updateFindMaxSumInArrayByDynamic(origin));
    }

    /**
     * 暴力解法：即把所有子数组都进行相加并比较求答案
     * 简化的核心：sum(a[i-j]) = sum(a[i-j-1)+a[j]
     *
     * @param array 源数组
     * @return 连续子向量的最大和
     */
    private static int findMaxSumInArray(int[] array) {
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < array.length; i++) {
            int sum = array[i];
            for (int j = i + 1; j < array.length; j++) {
                sum = sum + array[j];
                if (sum > max) max = sum;
            }
        }
        return max;
    }

    /**
     * 动态路径规划只需要一次循环
     * 主要公式为：
     * 1.当以第(i-1)个数字为结尾的子数组中所有数字的和f(i-1)小于0时，
     * 如果把这个负数和第i个数相加，得到的结果反而不第i个数本身还要小，
     * 所以这种情况下最大子数组和是第i个数本身。
     * <p>
     * 2.如果以第(i-1)个数字为结尾的子数组中所有数字的和f(i-1)大于0，
     * 与第i个数累加就得到了以第i个数结尾的子数组中所有数字的和
     *
     * @param array 源数组
     * @return 连续子向量最大和
     */
    private static int findMaxSumInArrayByDynamic(int[] array) {
        int max = Integer.MIN_VALUE;
        int sum = 0;
        for (int i = 0; i < array.length; i++) {
            if (i == 0 || sum < 0) sum = array[i];
            else sum = sum + array[i];
            max = Math.max(sum, max);
        }
        return max;
    }

    /**
     * 贪心算法：当前值的前连续子向量和小于0说明与当前值累加后总和反而减少，所以重新计算总和即可
     *
     * @param array 源数组
     * @return  连续子向量最大和
     */
    private static int updateFindMaxSumInArrayByDynamic(int[] array) {
        int max = Integer.MIN_VALUE;
        int sum = 0;
        for (int value : array) {
            if (sum <= 0) sum = value;
            else sum += value;
            max = Math.max(sum, max);
        }
        return max;
    }
}
