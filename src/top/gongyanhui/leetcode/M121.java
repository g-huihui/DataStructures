package top.gongyanhui.leetcode;

/**
 * @author Gong Yanhui
 * @description 121. 买卖股票的最佳时机
 * @date 2022-06-15 14:31:33
 */
public class M121 {

    public int maxProfit(int[] prices) {
        int max = 0;                    //最大利润
        int min = Integer.MAX_VALUE;    //最小卖价
        for (int i = 0; i < prices.length; i++) {
            min = Math.min(min, prices[i]);
            max = Math.max(max, prices[i] - min);
        }
        return max;
    }
}
