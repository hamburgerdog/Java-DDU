package org.xjosiah.array;

/**
 * 把一个数组最开始的若干个元素搬到数组的末尾，我们称之为数组的旋转。
 * 输入一个非递减序列的一个旋转，输出旋转数组的最小元素。
 *
 * 解题核心：
 * 旋转之后的数组实际上可以划分为两个排序的子数组，
 * 而且前面的子数组的元素都大于或者等于后面子数组的元素。
 *
 * @author xjosiah
 * @since 2021/3/17
 */
public class _008_MinNumberInRotateArray {
    //  数组{3,4,5,1,2}为{1,2,3,4,5}的一个旋转，该数组的最小值为1。
    private static int[] originList = {3,4,5,1,2};

    public static void main(String[] args) {
        System.out.println(finMinNum(originList));
    }

    /**
     * 二分查找
     * @param list
     * @return
     */
    private static int finMinNum(int[] list){
        int mid = 0;    //  0是为了处理数组从0位置旋转（即没有旋转）的情况
        int low = 0,high = originList.length-1;

        while (list[low] >= list[high]){
            mid = (high+low) / 2 ;
            if (list[mid] >= list[low]){
                low = mid;
            }else if (list[mid] <= list[high]){
                high = mid;
            }
            if (high-low == 1){
                break;
            }
        }

        //  mid实际上决定了何时结束，因为low & high无论何时都是在使用mid进行赋值的
        return list[mid];
    }
}
