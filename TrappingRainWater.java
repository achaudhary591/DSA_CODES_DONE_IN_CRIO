/*
Problem Description
Given n non-negative integers representing an elevation map where the width of each bar is 1, compute how much water it is able to trap after raining.
*/

import java.io.*;
import java.util.*;
class TrappingRainWater {
    public int trap(int[] height) {

        int n = height.length;

        if (n <= 2) {
            return 0;
        }
 
        int water = 0;

        int[] left = new int[n-1];
        left[0] = Integer.MIN_VALUE;

        for (int i = 1; i < n - 1; i++) {
            left[i] = Integer.max(left[i - 1], height[i - 1]);
        }
        int right = Integer.MIN_VALUE;

        for (int i = n - 2; i >= 1; i--)
        {
            right = Integer.max(right, height[i + 1]);
                        
            if (Integer.min(left[i], right) > height[i]) {
                water += Integer.min(left[i], right) - height[i];
            }
        }
        return water;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int height[] = new int[n];
        for(int i = 0 ; i < n ; i++) {
            height[i] = scanner.nextInt();
        }
        scanner.close();
        int result = new TrappingRainWater().trap(height);
        System.out.println(result);  
    }
}