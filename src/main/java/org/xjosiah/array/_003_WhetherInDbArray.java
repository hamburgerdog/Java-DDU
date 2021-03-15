package org.xjosiah.array;

/**
 * @author xjosiah
 * @since 2021-03-03
 */
public class _003_WhetherInDbArray {

    private static int[][] arrays = {{1, 2, 8, 9}, {2, 4, 9, 12}, {4, 7, 10, 13}, {6, 8, 11, 15}};

    /**
     * 在一个二维数组中，每一行按从左到右递增，每一列按从上到下递增，
     * 请完成一个函数输入一个整数，判断数据中是否含有该整数
     * arrays[x][y] =>
     * {1, 2, 8,  9 }
     * {2, 4, 9,  12}
     * {4, 7, 10, 13}
     * {6, 8, 11, 15}
     */
    private static boolean whetherInArrays(int value) {
        //  右上角落起始 即 9
        int x = 0;
        int y = 3;
        while (x >= 0 && y >= 0) {
            if (arrays[x][y] != value) {
                if (arrays[x][y] > value) {
                    y--;
                } else {
                    x++;
                }
            } else {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println(whetherInArrays(5));
    }
}
