
// Largest Rectangle in Histogram

/**
 * @author:wangzq
 * @email:wangzhenqing1008@163.com
 * @date:2015年01月28日09:48:30
 * @url:https://oj.leetcode.com/problems/largest-rectangle-in-histogram/
 * 栈的使用
 * 具体参考：http://blog.csdn.net/u013027996/article/details/43198421
 */

import java.util.Stack;

public class Solution {

    public int largestRectangleArea(int[] height) {
        if(height == null || height.length == 0){
            return 0;
        }
        int len = height.length;
        Stack<Integer> stack = new Stack<Integer>();
        int area = 0;
        for(int i = 0; i <= len; i++){
            int h = i == len ? 0 : height[i];
            if(stack.isEmpty() || height[stack.peek()] <= h){
                stack.push(i);
                continue;
            }
            int start = stack.pop();
            int width = stack.empty() ? i : i - 1 - stack.peek() ;
            area = Math.max(area, height[start] * width);
            i--;
        }
        return area;
    }
}

