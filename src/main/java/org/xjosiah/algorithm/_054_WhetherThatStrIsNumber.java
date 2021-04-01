package org.xjosiah.algorithm;

/**
 * 请实现一个函数用来判断字符串是否表示数值（包括整数和小数）。
 * <p>
 * 例如， 字符串"+100","5e2","-123","3.1416"和"-1E-16"都表示数值。
 * 但是"12e","1a3.14","1.2.3","+-5"和"12e+4.3"都不是。
 *
 * @author xjosiah
 * @since 2021/4/1
 */
public class _054_WhetherThatStrIsNumber {
    public static void main(String[] args) {
        runTest();
    }

    /**
     * 使用正则表达式直接判断
     *
     * @param input 代输入的字符串
     * @return 是否符合科学计数法的表示
     */
    private static boolean matchByRegular(String input) {
        return input.matches("^[+-]?[\\d]+([.][\\d]*)?([Ee][+-]?[\\d]+)?$");
    }

    /**
     * 模拟正则表达式的比较法
     *
     * @param input 待比较字符串
     * @return 是否符合科学计数法的表示
     */
    private static boolean match(String input) {
        //  过滤eE
        input = input.toUpperCase();
        String[] split = input.split("E");
        if (split.length > 2) return false;
        //  小数点位
        boolean hasSpot = false;
        boolean beforeE = false;
        for (String s : split) {
            beforeE = !beforeE;

            //  处理-+
            if (s.startsWith("-") || s.startsWith("+")) s = s.substring(1);

            String[] strings = s.split("");
            for (String string : strings) {
                //  如果是数字跳过即可
                if (string.matches("^\\d$")) {
                    continue;
                }
                //  如果是点则看是否已经有小数点（不能有两个），再比较当前是否在E后
                if (".".equals(string) && !hasSpot && beforeE) {
                    hasSpot = true;
                    continue;
                }
                return false;
            }
        }
        return true;
    }

    private static void runTest(){
        System.out.println(matchByRegular("1.123.412"));
        System.out.println(matchByRegular("-1.123412"));
        System.out.println(matchByRegular("-1.123412E-123"));
        System.out.println(matchByRegular("-1.123412e-123"));
        System.out.println(matchByRegular("-1.123412E-123a123"));
        System.out.println(matchByRegular("1.123412E123123"));
        System.out.println(matchByRegular("1.123412e123.123"));
        System.out.println(matchByRegular("1.1234a12E123"));
        System.out.println(matchByRegular("1.1234.12e123"));
        System.out.println(matchByRegular("1123412e-123"));
        System.out.println(matchByRegular("1123412e-123."));
        System.out.println("----------------------------------");
        System.out.println(match("1.123.412"));
        System.out.println(match("-1.123412"));
        System.out.println(match("-1.123412E-123"));
        System.out.println(match("-1.123412e-123"));
        System.out.println(match("-1.123412E-123a123"));
        System.out.println(match("1.123412E123123"));
        System.out.println(match("1.123412e123.123"));
        System.out.println(match("1.1234a12E123"));
        System.out.println(match("1.1234.12e123"));
        System.out.println(match("1123412e-123"));
        System.out.println(match("1123412e-123."));

    }
}