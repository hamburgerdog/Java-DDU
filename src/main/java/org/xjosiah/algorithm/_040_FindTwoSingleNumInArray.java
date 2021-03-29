package org.xjosiah.algorithm;

import java.util.ArrayList;

/**
 * 一个整型数组里除了两个数字之外，其他的数字都出现了两次。请写程序找出这两个只出现一次的数字
 * 「input : 2 4 3 6 3 2 5 5」 『output: 4 6 』
 *
 * @author xjosiah
 * @since 2021/3/29
 */
public class _040_FindTwoSingleNumInArray {
    private static final int[] origin = {2, 4, 3, 6, 3, 2, 5, 5,};

    public static void main(String[] args) {
        System.out.println(findSingleNum(origin));
    }

    /**
     * 该题主要考察为「异或操作可以消除重复的数据」
     * 异或计算的核心为，如果两个数相同，在异或下都会为0，而0和任何数异或都会等于该数本身；
     * 如果两个数不同，则两数进行异或后，有差异的位上都会为1，至少会有一个1，
     * 『为了保证异或结果中只存有一个1我们可以将其取补码然后进行与操作』（这步是核心操作）得到结果后
     * 按题目设定数组中只有两个数是不重复的，我们可以按这个不同的位将数组分成两个，即两个不重复的数会被分到两个数组中去，
     * 把剩余的两个数组再进行一次异或过滤出了我们想要的数据
     *
     * @param array 源数组
     * @return  反映函数运行结果的字符串，包含错误信息
     */
    private static String findSingleNum(int[] array) {
        if (array.length < 4) {
            throw new IllegalArgumentException("数组太小不能满足比较的情况");
        }

        int xor = 0;
        for (int value : array) {
            xor ^= value;
        }
        if (xor == 0) return "找不到满足题设的数字";

        xor &= -xor;    //  与补码异或，保证只剩下最低有效位

        ArrayList<Integer> list1 = new ArrayList<>();
        ArrayList<Integer> list0 = new ArrayList<>();
        for (int value : array) {
            if ((value & xor) == 0) {
                list0.add(value);
                continue;
            }
            list1.add(value);
        }

        int num0 = 0, num1 = 0;
        for (Integer i : list0) {
            num0 ^= i;
        }
        for (Integer i : list1) {
            num1 ^= i;
        }
        return "找到两个数字满足情况 -> num0:" + num0 + "\tnum1:" + num1;
    }
}
