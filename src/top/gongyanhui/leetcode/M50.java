package top.gongyanhui.leetcode;

/**
 * @author Gong Yanhui
 * @description 50. Pow(x, n)
 * @date 2022-06-12 18:03:45
 */
public class M50 {

    public double myPow(double x, int n) {
        return n >= 0 ? quickMul(x, n) : 1 / quickMul(x, -n);
    }

    public double quickMul(double x, int n) {
        if (n == 0) {
            return 1.0;
        }
        double half = quickMul(x, n / 2);
        return n % 2 == 0 ? half * half : x * half * half;
    }
}
