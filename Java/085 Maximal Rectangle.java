
// Maximal Rectangle

/**
 * @author:wangzq
 * @email:wangzhenqing1008@163.com
 * @date:2015年05月28日17:15:58
 * @url:https://leetcode.com/problems/maximal-rectangle/
 */

import java.util.Stack;

public class Solution {

    public int maximalRectangle(char[][] matrix) {
        if (matrix == null || matrix.length == 0) {
            return 0;
        }
        int m = matrix.length;
        int n = matrix[0].length;
        int height[][] = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == '0') {
                    height[i][j] = 0;
                } else {
                    height[i][j] = i == 0 ? 1 : height[i - 1][j] + 1;
                }
            }
        }
        int maxArea = 0;
        for (int i = 0; i < m; i++) {
            int area = largestRectangleArea(height[i]);
            maxArea = area > maxArea ? area : maxArea;
        }
        return maxArea;
    }

    public int largestRectangleArea(int[] height) {
        if (height == null || height.length == 0) {
            return 0;
        }
        int len = height.length;
        Stack<Integer> stack = new Stack<Integer>();
        int area = 0;
        for (int i = 0; i <= len; i++) {
            int h = i == len ? 0 : height[i];
            if (stack.isEmpty() || height[stack.peek()] <= h) {
                stack.push(i);
                continue;
            }
            int start = stack.pop();
            int width = stack.empty() ? i : i - stack.peek() - 1;
            area = Math.max(area, height[start] * width);
            i--;
        }
        return area;
    }
}