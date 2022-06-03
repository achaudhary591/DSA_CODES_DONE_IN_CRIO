/*Problem Description
You have an array in which the ith element is the price of a given stock on day i.

Design an algorithm to find the maximum profit by buying a share on one day and selling it on another day. You may repeat this across the days (i.e., buy one and sell one share of the stock multiple times).

Note: You may not engage in multiple transactions at the same time (i.e., you must sell the stock before you buy again)*/

import java.io.*;
import java.util.*;

public class BestTimeToBuyAndSellStocks {
    // Implement your solution Here
    public int maxProfit(int[] prices) {

        int maxProfit = 0;

        for (int i = 1; i < prices.length; i++) {
            if (prices[i] > prices[i - 1]) {
                maxProfit += prices[i] - prices[i - 1];

            }
        }
        return maxProfit;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] prices = new int[scanner.nextInt()];
        for (int i = 0; i < prices.length; i++)
            prices[i] = scanner.nextInt();
        scanner.close();

        int result = new BestTimeToBuyAndSellStocks().maxProfit(prices);
        System.out.print(Integer.toString(result));
    }
}