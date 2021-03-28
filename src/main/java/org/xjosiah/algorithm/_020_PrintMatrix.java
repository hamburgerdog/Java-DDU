package org.xjosiah.algorithm;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * 输入一个矩阵，按照从外向里以顺时针的顺序依次打印出每一个数字，
 *
 * @author xjosiah
 * @since 2021/3/22
 */
public class _020_PrintMatrix {
    private static final int[][] matrix = {{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}, {13, 14, 15, 16}};
    private static final int[][] matrix1 = {{1, 2, 3, 4, 5, 6, 7, 8}, {9, 10, 11, 12, 13, 14, 15, 16}};

    public static void main(String[] args) {
        System.out.println("------------------------源矩阵------------------------");
        for (int[] ints : matrix) {
            System.out.println(Arrays.toString(ints));
        }
        ArrayList<Integer> resultArray = printMatrix(matrix);
        System.out.println("--------------------顺时针旋转输出为--------------------");
        System.out.println(Arrays.toString(resultArray.toArray()) + "\n\n");

        System.out.println("------------------------源矩阵------------------------");
        for (int[] ints : matrix1) {
            System.out.println(Arrays.toString(ints));
        }
        resultArray = printMatrix(matrix1);
        System.out.println("--------------------顺时针旋转输出为--------------------");
        System.out.println(Arrays.toString(resultArray.toArray()));
    }

    /**
     * 借助转向标志来进行右下左上（顺时针）遍历，每个方向都走当前行（列）length - 1次，
     * 然后记录步数，直到把所有数据所有元素遍历完
     * <p>
     * 以matrix为例：
     * 右三歩 [1,2,3] -> 下三歩[4,8,12] -> 左三步 -> [16,15,14] -> 上三步 [13,9,5]
     * 把上下左右的步长全部减一，继续遍历
     *
     * @param originMatrix   目的矩阵
     * @return  顺时针保存矩阵项的数组
     */
    private static ArrayList<Integer> printMatrix(int[][] originMatrix) {
        ArrayList<Integer> resultArray = new ArrayList<>();

        int row = originMatrix.length;
        int col = originMatrix[0].length;
        int matrixSize = row * col;

        int left = 0, right = col - 1, up = 0, down = row - 1;
        for (int count = 0; count < matrixSize; ) {
            //  顺时针逐个遍历
            for (int goRight = left; goRight < right; goRight++) {
                resultArray.add(originMatrix[up][goRight]);
                count++;
            }
            for (int goDown = up; goDown < down; goDown++) {
                resultArray.add(originMatrix[goDown][right]);
                count++;
            }
            for (int goLeft = right; goLeft > left; goLeft--) {
                resultArray.add(originMatrix[down][goLeft]);
                count++;
            }
            for (int goUp = down; goUp > up; goUp--) {
                resultArray.add(originMatrix[goUp][left]);
                count++;
            }
            left++;
            right--;
            up++;
            down--;
        }
        return resultArray;
    }
}
