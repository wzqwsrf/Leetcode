# !/usr/bin/env python
# -*- coding: utf-8 -*-
# Jump Game II 252ms

"""
/**
 * Given an array of non-negative integers,
 * you are initially positioned at the first index of the array.
 * Each element in the array represents your maximum jump length at that position.
 * Your goal is to reach the last index in the minimum number of jumps.
 * For example:
 * Given array A = [2,3,1,1,4]
 * The minimum number of jumps to reach the last index is 2.
 * (Jump 1 step from index 0 to 1, then 3 steps to the last index.)
 */
"""

"""
/*
* @author:wangzq
* @email:wangzhenqing1008@163.com
* @date:2014年08月27日15:13:25
* @url:https://oj.leetcode.com/problems/jump-game-ii/
* 题目比较拗口，多读几遍，加强理解，求可达最短步数
* 具体参考http://blog.csdn.net/u013027996/article/details/38870915
*/
"""


class Solution:
    # @param A, a list of integers
    # @return an integer
    def jump(self, A):
        if not A:
            return 0
        n = len(A)
        maxReach = 0
        lastMaxReach = 0
        i = 0
        count = 0
        while i < n and i <= maxReach:
            if i > lastMaxReach:
                lastMaxReach = maxReach
                count += 1
            maxReach = max(i + A[i], maxReach)
            i += 1
        return count if maxReach >= n - 1 else 0