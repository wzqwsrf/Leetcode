# !/usr/bin/env python
# -*- coding: utf-8 -*-
# Jump Game 312ms

"""
/*
* @author:wangzq
* @email:wangzhenqing1008@163.com
* @date:2014年08月27日15:11:42
* @url:https://oj.leetcode.com/problems/jump-game/
* 题目比较拗口，多读几遍，加强理解，求是否可达
* 具体参考http://blog.csdn.net/u013027996/article/details/38870915
*/
"""


class Solution:
    # @param A, a list of integers
    # @return a boolean
    def canJump(self, A):
        if not A:
            return False
        n = len(A)
        maxReach = 0
        i = 0
        while i < n and i <= maxReach:
            maxReach = max(i+A[i], maxReach)
            i += 1
            if maxReach >= n - 1:
                return True
        return False
