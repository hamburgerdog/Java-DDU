package org.xjosiah.algorithm;

/**
 * 请实现一个函数用来匹配包括'.'和'*'的正则表达式。
 * 模式中的字符'.'表示任意一个字符，而'*'表示它前面的字符可以出现任意次（包含0次）。
 * 在本题中，匹配是指字符串的所有字符匹配整个模式。
 * <p>
 * 例如，字符串"aaa"与模式"a.a"和"ab*ac*a"匹配，但是与"aa.a"和"ab*a"均不匹配
 * 样例输入 "a","ab*a"
 * 样例输出 false
 *
 * @author xjosiah
 * @since 2021/4/1
 */
public class _053_RegularExpressionMatching {
    public static void main(String[] args) {
        System.out.println(match("aaa", "ab*ab*b"));
        System.out.println(match("aaa", "ab*ab*a"));
        System.out.println(match("aaa", "ab*ac*a"));
        System.out.println(match("abcdefg", "ab*.d*e.f*g"));
        System.out.println(match("aaa", "a.a"));
        System.out.println(match("?", "."));
    }

    /**
     * 分割字符串后逐位判断
     *
     * @param s       待判断的字符串
     * @param regular 正则表达式
     * @return 符合与否
     */
    private static boolean match(String s, String regular) {
        String[] split = s.split("");
        String[] regularSplit = regular.split("");
        int index = 0;          //  待判断的字符串的下标
        int regularIndex = 0;   //  正则式的下标
        try {
            for (; index < split.length; index++) {
                //  如果为点则不需要判断字符，否则判断字符并且相等
                if (".".equals(regularSplit[regularIndex]) || split[index].equals(regularSplit[regularIndex])) {
                    regularIndex++;
                    //  这里处理的是 X* 的情况，因为已经符合了，后面的*无意义需要跳过，特殊情况：正则表达式中已经是最后一位跳过即可
                    if (regularIndex < regularSplit.length && "*".equals(regularSplit[regularIndex])) regularIndex++;
                    continue;
                }
                //  如果字符串判断不相等但后面是*说明可以跳过此次判断，注意不要移动待判断下标
                if ("*".equals(regularSplit[++regularIndex])) {
                    regularIndex++;
                    index--;
                    continue;
                }
                break;
            }
            //  最后一位不满足时，即使index满足情况，而regularIndex只有在正确时才会步进，所以也会得到即使处理
            return index == split.length && regularIndex == regularSplit.length;
        } catch (ArrayIndexOutOfBoundsException e) {
            return false;
        }
    }
}
