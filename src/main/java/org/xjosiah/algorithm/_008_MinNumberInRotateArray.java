package org.xjosiah.algorithm;

/**
 * 把一个数组最开始的若干个元素搬到数组的末尾，我们称之为数组的旋转。
 * 输入一个非递减序列的一个旋转，输出旋转数组的最小元素。
 * <p>
 * 解题核心：
 * 旋转之后的数组实际上可以划分为两个排序的子数组，
 * 而且前面的子数组的元素都大于或者等于后面子数组的元素。
 *
 * @author xjosiah
 * @since 2021/3/17
 */
public class _008_MinNumberInRotateArray {
    /**
     * 二分查找
     *
     * @param list 源数组
     * @return 最小值
     */
    static int finMinNum(int[] list) {
        int mid = 0;    //  0是为了处理数组从0位置旋转（即没有旋转）的情况
        int low = 0, high = list.length - 1;

        if (list.length == 0) {
            throw new IllegalArgumentException("数组为空，请重新检查输入的数组");
        }

        if (list.length == 1) return list[mid];

        //  :bug:「此处不能等于」否则list只有一个元素时会无限循环
        while (list[low] >= list[high]) {
            mid = (high + low) / 2;
            if (list[mid] >= list[low]) {
                low = mid;
            } else if (list[mid] <= list[high]) {
                high = mid;
            }
            if (high - low == 1) {
                break;
            }
            //  这一步是为了避免当输入的数组不符合规则时陷入无限循环，如[9,8,7,6,5]会一直不改变low and high
            if (mid == (high + low) / 2) throw new IllegalArgumentException("输入的数组不符合格式！");
        }

        //  mid实际上决定了何时结束，因为low & high无论何时都是在使用mid进行赋值的
        return list[mid];
    }
}
