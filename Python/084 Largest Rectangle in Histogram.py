# !/usr/bin/env python
# -*- coding: utf-8 -*-
# Largest Rectangle in Histogram 128ms

"""
/**
 * Given n non-negative integers representing the histogram's bar height where the width of each bar is 1,
 * find the area of largest rectangle in the histogram.
 * Above is a histogram where width of each bar is 1, given height = [2,1,5,6,2,3].
 * The largest rectangle is shown in the shaded area, which has area = 10 unit.
 * For example,
 * Given height = [2,1,5,6,2,3],
 * return 10.
 */
"""

"""
/*
 * @author:wangzq
 * @email:wangzhenqing1008@163.com
 * @date:2015年01月28日09:58:19
 * @url:https://oj.leetcode.com/problems/largest-rectangle-in-histogram/
 * 栈的使用
 * 具体参考：http://blog.csdn.net/u013027996/article/details/43198421
 */
"""


class Solution:
    # @param height, a list of integer
    # @return an integer
    def largestRectangleArea(self, height):
        height.append(0)
        hLen = len(height)
        stack = []
        maxArea = 0
        i = 0
        while i < hLen:
            if not stack or height[stack[-1]] <= height[i]:
                stack.append(i)
                i += 1
            else:
                start = stack.pop()
                width = i if not stack else i - 1 - stack[-1]
                maxArea = max(maxArea, height[start] * width)
        return maxArea


