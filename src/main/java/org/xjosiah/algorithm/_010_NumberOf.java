package org.xjosiah.algorithm;

/**
 * 求整数转化为二进制后 1 的个数，负数用补码表示
 *
 * @author xjosiah
 * @since 2021/3/17
 */
public class _010_NumberOf {
    /**
     * 特殊技巧：
     * 把一个二进制数 与 该数减1的二进制数 进行与操作，可以从最低位开始
     * 依次朝着高位将1剔除出去，有多少个1就可以剔除多少次。负数直接用补
     * 码表示，剔除终止的标志就是操作数变成 0
     * <p>
     * 案例：
     * 1100 -> 1100 & 1011 = 1000
     * 1000 -> 1000 & 0111 = 0000
     * 因此，进行了两次操作，即 1100 有两个 1 。
     *
     * @param n 等待计算的源数
     * @return 源数中1的个数
     */
    static int numberOf(int n) {
        int res = 0;
        while (n != 0) {
            n = n & (n - 1);
            res += 1;
        }
        return res;
    }
}
