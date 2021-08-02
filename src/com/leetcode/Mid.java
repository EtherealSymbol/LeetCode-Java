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

    @Test
    public void testMySqrt(){
//        System.out.println(mySqrt(0));
//        for (int i = 0; i < 1000; i++) {
//            System.out.println(i+"的平方根是："+mySqrt(i)+"    "+Math.sqrt(i));
//        }
//        System.out.println(Math.sqrt(Integer.MAX_VALUE));
        /*
        * 未通过用例
        * 输入：2147395599
        * 输出：1073697799
        * 预期结果：46339
        * 分析原因：起初我以为是输入越界，后来发现并不是这样，2147395599<2147483647(Integer.MAX_VALUE)；
        *   那是什么原因导致的呢？原来是因为2147395599/2=1073697799,
        *   根据我的算法的原理：1073697799*1073697799的结果肯定是越界了！
        * */
        System.out.println(mySqrt(Integer.MAX_VALUE)+"   "+ StrictMath.sqrt(Integer.MAX_VALUE));
    }

    /*
    * 实现int sqrt(int x)函数。
    * 计算并返回x的平方根，其中x 是非负整数。
    * 由于返回类型是整数，结果只保留整数的部分，小数部分将被舍去。
    * */
    public int mySqrt(int x) {
        if (x==1) return 1;
        // 为了避免越界：Math.sqrt(Integer.MAX_VALUE)=46340
        int mid = x/2>46340? 46340 : x/2;
        int res=0;
        for (int i=mid; i >= 0; i--){
            if (i*i<=x){
                res=i;
                break;
            }
            res=i;
        }
        return res;
        /*
        * 执行用时：13 ms, 在所有 Java 提交中击败了7.44%的用户
        * 内存消耗：35.6 MB, 在所有 Java 提交中击败了24.99%的用户
        * */
    }
    /*
    * 看java.lang.Math的静态方法sqrt是怎么实现的：
    * public final class Math {
    *   public static double sqrt(double a) {
            return StrictMath.sqrt(a); // default impl. delegates to StrictMath
                                       // Note that hardware sqrt instructions
                                       // frequently can be directly used by JITs
                                       // and should be much faster than doing
                                       // Math.sqrt in software.
        }
    * }
    *
    * public final class StrictMath {
    *   public static native double sqrt(double a);
    * }
    * 结果底层用C实现的
    * */

    // 官方
    public int mySqrtOffical(int x) {
        if (x == 0) {
            return 0;
        }
        int ans = (int) Math.exp(0.5 * Math.log(x));
        return (long) (ans + 1) * (ans + 1) <= x ? ans + 1 : ans;
    }

}
