/*
Problem Description
You are given an array of N non-negative integers where each represents the height of a line. N vertical lines are drawn at points marked 1 to n on the x axis as shown in the diagram. Find two lines, which together with the x axis forms a container, such that the container holds the most water. Assume the width of lines to be negligible.

Note: You may not slant the container and n is at least 2.
*/
import java.io.*;
import java.util.*;

class ContainerWithMostWater {

    // Complete the function implementation below
    public int maxArea(int[] height) {
        int maxarea = 0 ;
        int n = height.length;
    // initialize two pointers on the both sides 
        int leftIndex = 0;
        int rightIndex = n - 1;
        while (leftIndex < rightIndex) 
        {
            int minHeight = Math.min(height[leftIndex], height[rightIndex]);
            maxarea = Math.max(maxarea, (rightIndex - leftIndex)*minHeight);
            if(height[leftIndex] < height[rightIndex])
                leftIndex = leftIndex + 1;
            else
                rightIndex = rightIndex - 1;
        }
        
        return maxarea;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int height[] = new int[n];
        for(int i = 0 ; i < n ; i++) {
            height[i] = scanner.nextInt();
        }
        scanner.close();
        int result = new ContainerWithMostWater().maxArea(height);
        System.out.println(result);
    }
}