# !/usr/bin/env python
# -*- coding: utf-8 -*-
# Largest Number 132ms

"""
/**
 * Given a list of non negative integers, arrange them such that they form the largest number.
 * For example, given [3, 30, 34, 5, 9], the largest formed number is 9534330.
 * Note: The result may be very large, so you need to return a string instead of an integer.
 * Credits:
 * Special thanks to @ts for adding this problem and creating all test cases.
 */
"""

"""
/*
 * @author:wangzq
 * @email:wangzhenqing1008@163.com
 * @date:2015年01月15日15:23:55
 * @url:https://oj.leetcode.com/problems/largest-number/
 * 其实就是排序，比较相邻两个字符拼接成字符串之后那个大
 * 具体参考：
 */
"""


class Solution:
    # @param num, a list of integers
    # @return a string
    def largestNumber(self, num):
        num = sorted(num, cmp=lambda x, y: cmp(str(y) + str(x), str(x) + str(y)))
        print num
        sb = ''
        for x in num:
            sb += str(x)
        if sb.replace('0', '') == '':
            return '0'
        return sb
