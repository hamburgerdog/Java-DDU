package org.xjosiah.algorithm;

import java.util.ArrayList;

/**
 * 把只包含因子2、3和5的数称作丑数（Ugly Number）例如6、8都是丑数，但14不是，因为它包含因子7。
 * 习惯上我们把1当做是第一个丑数。
 * <p>
 * 求按从小到大的顺序的第N个丑数。
 *
 * @author xjosiah
 * @since 2021/3/28
 */
public class _034_UglyNum {
    private static final int N = 300;

    public static void main(String[] args) {
        System.out.println(findNthUglyNum(N));
    }

    /**
     * 丑数算法中最重要的一点是：排序生成！！必须按顺序插入丑数，才能避免漏算或者重复添加
     *
     * @param n 第N位
     * @return 从小到大排序的第N位丑数
     */
    private static int findNthUglyNum(int n) {
        ArrayList<Integer> list = new ArrayList<>();
        list.add(1);
        int index_2 = 0;
        int index_3 = 0;
        int index_5 = 0;
        for (int i = 0; i < n; i++) {
            int min = Math.min(Math.min(list.get(index_2) * 2, list.get(index_3) * 3), list.get(index_5) * 5);
            if (min == list.get(index_2) * 2) index_2++;
            if (min == list.get(index_3) * 3) index_3++;
            if (min == list.get(index_5) * 5) index_5++;
            list.add(min);
        }
        return list.get(n - 1);
    }
}
