package org.xjosiah.algorithm;

/**
 * 对于一个给定的字符序列S，请你把其循环左移K位后的序列输出。
 *
 * @author xjosiah
 * @since 2021/3/30
 */
public class _042_StrMoveLeft {
    private static final int MOVE_STEP = 30;
    private static final String STRING = "XYZdefabc";

    public static void main(String[] args) {
        System.out.println(moveBySimple(MOVE_STEP));
        System.out.println(moveByDoubleStr(MOVE_STEP));
    }

    /**
     * 自旋转 即 将左移K位则在第K-1位截断字符，将两个子字符调换位置即可
     *
     * @param step 步长
     * @return 左移结果
     */
    private static String moveBySimple(int step) {
        step %= STRING.length();
        return STRING.substring(step) + STRING.substring(0, step);
    }

    /**
     * 叠加截断 即 将字符串叠加成长字符串组，位移第K位就是要去长字符串第K位起的长等于原字符串长的子字符串
     *
     * @param step 步长
     * @return 左移结果
     */
    private static String moveByDoubleStr(int step) {
        String s = STRING + STRING.substring(0, STRING.length() - 1);
        step %= STRING.length();
        return s.substring(step, step + STRING.length());
    }
}
