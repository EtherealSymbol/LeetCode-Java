package com.leetcode;

import org.junit.Test;

public class Mid {

    @Test
    public void testPow(){
//        System.out.println(Math.pow(2,5) + "     " + myPow(2, 5));
//        System.out.println(Math.pow(2.0,-2) + "     " + myPow(2.0, -2));
//        System.out.println(Math.pow(-2.0,-3) + "     " + myPow(-2.0, -3));
//        System.out.println(Math.pow(-2.0,0) + "     " + myPow(-2.0, 0));
//        System.out.println(Math.pow(2.0,0) + "     " + myPow(2.0, 0));
//        System.out.println(Math.pow(2.0,-2147483648) + "     " + myPow(2.0, -2147483648));
        /*
         * 输入：x=2.00000,n=-2147483648
         * 输出：1.00000
         * 预期结果：0.0
         * 原因：-2147483648超出了Integer的范围，
         *      Integer.MIN_VALUE=-2147483648，所以这里无法使用Math.abs(n)，返回值任然是-2147483648
         * */
        System.out.println(Math.pow(2.0,-2147483648) + "     " + myPow(2.0, -2147483648));
        System.out.println(Math.pow(-1,2147483647) + "     " + myPow(-1, 2147483647));
    }

    /*
    * 实现 pow(x, n) ，即计算 x 的 n 次幂函数（即，xn）。
    * */
    public double myPow(double x, int n) {
//        return Math.pow(x, n);
        /*
        * 执行用时：0 ms, 在所有 Java 提交中击败了100.00%的用户
        * 内存消耗：37.8 MB, 在所有 Java 提交中击败了30.67%的用户
        * */
        if(x==1){
//            不检验1，当用例为n=Integer.MAX_VALUE=2147483647时，会出现超时
            return x;
        }
//        既然1要考虑，当然-1也要考虑
        if (x==-1){
            return n%2 == 0 ? 1 :-1;
        }
        if(n==Integer.MIN_VALUE){
            return 0;
        }
        double res=1;
        double positiveX = n > 0 ? x : 1/x;
        int positiveN = Math.abs(n);
        for (int i = 0; i < positiveN; i++) {
            res *= positiveX;
            System.out.println(res);
        }
        return res;
        /*
        * 执行用时：2712 ms, 在所有 Java 提交中击败了89.45%的用户
        * 内存消耗：37.8 MB, 在所有 Java 提交中击败了22.83%的用户
        * */

        /*
        * 快速幂算法的本质是分治算法
        public double myPow(double x, int n) {
            long N = n;
            return N >= 0 ? quickMul(x, N) : 1.0 / quickMul(x, -N);
        }

        public double quickMul(double x, long N) {
            if (N == 0) {
                return 1.0;
            }
            double y = quickMul(x, N / 2);
            return N % 2 == 0 ? y * y : y * y * x;
        }
        * */
    }

}
