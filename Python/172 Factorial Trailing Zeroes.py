# !/usr/bin/env python
# -*- coding: utf-8 -*-
# Factorial Trailing Zeroes 93ms

"""
/**
 * Given an integer n, return the number of trailing zeroes in n!.
 * Note: Your solution should be in logarithmic time complexity.
 * Credits:
 * Special thanks to @ts for adding this problem and creating all test cases.
 */
"""

"""
/*
 * @author:wangzq
 * @email:wangzhenqing1008@163.com
 * @date:2015年01月09日15:12:37
 * @url:https://oj.leetcode.com/problems/factorial-trailing-zeroes/
 * 其实就是1到n中5的个数
 * 具体参考：
 */
"""


class Solution:
    # @return an integer
    def trailingZeroes(self, n):
        num = 0
        while n != 0:
            n /= 5
            num += n
        return num
