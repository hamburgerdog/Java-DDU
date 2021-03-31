package org.xjosiah.algorithm;

/**
 * 将一个字符串转换成一个整数，要求不能使用字符串转换整数的库函数。
 * 数值为0或者字符串不是一个合法的数值则返回0
 *
 * @author xjosiah
 * @since 2021/3/31
 */
public class _049_StringToInteger {
    public static void main(String[] args) {
        System.out.println(getIntegerInString("-12345") - 1);
        System.out.println(getIntegerInString("12345") - 1);
    }

    /**
     * 逐字符处理法
     *
     * @param s 待转换的字符串
     * @return 转换的长整型结果，失败返回0
     */
    private static long getIntegerInString(String s) {
        boolean isNegative = s.startsWith("-");
        if (isNegative) s = s.substring(1);
        //  保证只有数字
        if (s.matches(".*[^\\d]+.*")) return 0;

        String[] split = s.split("");
        long result = 0;
        for (int i = 0; i < split.length; i++) {
            result += string2int(split[i]) * (Math.pow(10, split.length - i - 1));
        }
        return isNegative ? -result : result;
    }

    /**
     * 单个字符转化器
     *
     * @param s 整型字符
     * @return 字符代表的整数
     */
    private static int string2int(String s) {
        switch (s) {
            case "0":
                return 0;
            case "1":
                return 1;
            case "2":
                return 2;
            case "3":
                return 3;
            case "4":
                return 4;
            case "5":
                return 5;
            case "6":
                return 6;
            case "7":
                return 7;
            case "8":
                return 8;
            case "9":
                return 9;
        }
        throw new IllegalArgumentException("参数无法转换成数字");
    }
}
