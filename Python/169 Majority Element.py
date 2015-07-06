# !/usr/bin/env python
# -*- coding: utf-8 -*-
# Majority Element 123ms

"""
/**
 * Majority Element
 * Total Accepted: 13126 Total Submissions: 38490 My Submissions Question Solution
 * Given an array of size n, find the majority element.
 * The majority element is the element that appears more than ⌊ n/2 ⌋ times.
 * You may assume that the array is non-empty and the majority element always exist in the array.
 * Credits:
 * Special thanks to @ts for adding this problem and creating all test cases.
 */
"""

"""
/*
 * @author:wangzq
 * @email:wangzhenqing1008@163.com
 * @date:2015年01月19日12:26:25
 * @url:https://oj.leetcode.com/problems/majority-element/
 * 方案很多，这里采取的是排序返回中位数
 * 具体参考：
 */
"""


class Solution:
    # @param num, a list of integers
    # @return an integer
    def majorityElement(self, num):
        nLen = len(num)
        num.sort()
        return num[nLen/2]