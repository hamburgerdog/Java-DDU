package org.xjosiah.algorithm;

/**
 * 写一个函数，求两个整数之和，要求在函数体内不得使用+、-、*、/四则运算符号。
 *
 * @author xjosiah
 * @since 2021/3/31
 */
public class _047_ImitateAdd {
    public static void main(String[] args) {
        System.out.println(addByBitControl(10201, 15));
    }

    /**
     * 用位操作模拟加法，异或得出不进位的加的结果，与操作得出每次需进的位
     *
     * @param a 加数1
     * @param b 加数2
     * @return 和
     */
    private static int addByBitControl(int a, int b) {
        int xor = a ^ b;
        int result = xor;
        int overFlowBits = a & b;
        while (overFlowBits != 0) {
            result = xor ^ (overFlowBits << 1);
            overFlowBits = xor & (overFlowBits << 1);
            xor = result;
        }
        return result;
    }
}
