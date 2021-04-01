package org.xjosiah.algorithm;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * 给定一个数组A[0,1,...,n-1],请构建一个数组B[0,1,...,n-1],其中B中的元素B[i]=A[0]A[1]...*A[i-1]A[i+1]...*A[n-1]。
 * 不能使用除法。
 * input [1, 2, 3, 4, 5]
 * output [120, 60, 40, 30, 24]
 *
 * @author xjosiah
 * @since 2021/4/1
 */
public class _052_CreateMulitArray {
    private static List<Integer> A = IntStream.range(1, 6).boxed().collect(Collectors.toList());
    private static List<Integer> B = new ArrayList<>();

    public static void main(String[] args) {
        System.out.println(A.toString());
        createArrayBFromA(A, B);
        System.out.println(B.toString());
    }

    private static void createArrayBFromA(List<Integer> a, List<Integer> b) {
        for (int i = 0; i < a.size(); i++) {
            int temp = i;
            b.add(a.stream().filter(it -> !it.equals(a.get(temp))).reduce(1, (it1, it2) -> it1 * it2));
        }
    }
}
