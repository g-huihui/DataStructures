package top.gongyanhui.leetcode;

/**
 * @Author: Taurus
 * @Description: 231. 2 的幂
 * @Date: 2025-08-09 14:56
 */

public class M231 {

    public boolean isPowerOfTwo(int n) {
        if (n <= 0) {
            return false;
        }
        if (n == 1) {
            return true;
        }
        while (n > 2) {
            if ((n % 2) == 0) {
                n /= 2;
            } else {
                return false;
            }
        }
        return true;
    }
}
