# !/usr/bin/env python
# -*- coding: utf-8 -*-
# Number of 1 Bits 60ms


"""
/**
 * @author:wangzq
 * @email:wangzhenqing1008@163.com
 * @date:2015年04月18日18:06:12
 * @url:https://leetcode.com/problems/number-of-1-bits/
 */
"""


class Solution:
    # @param n, an integer
    # @return an integer
    def hammingWeight(self, n):
        count = 0
        while n != 0:
            n &= n - 1
            count += 1
        return count

