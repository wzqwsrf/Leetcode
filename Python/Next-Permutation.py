# !/usr/bin/env python
# -*- coding: utf-8 -*-
# Next Permutation 92ms

"""
/**
 * 题目：
 * Implement next permutation, which rearranges numbers into the lexicographically next greater permutation of numbers.
 * If such arrangement is not possible,
 * it must rearrange it as the lowest possible order (ie, sorted in ascending order).
 * The replacement must be in-place, do not allocate extra memory.
 * Here are some examples.
 * Inputs are in the left-hand column and its corresponding outputs are in the right-hand column.
 1,2,3 → 1,3,2
 3,2,1 → 1,2,3
 1,1,5 → 1,5,1
 */
"""

"""
/*
 * @author:wangzq
 * @email:wangzhenqing1008@163.com
 * @date:2015年02月03日10:17:11
 * @url:https://oj.leetcode.com/problems/next-permutation/
 * 全排列，经典算法
 * 具体参考：http://blog.csdn.net/u013027996/article/details/18732185
 */
"""


class Solution:
    # @param num, a list of integer
    # @return a list of integer
    def nextPermutation(self, num):
        nLen = len(num)
        first = -1
        for i in xrange(nLen - 2, -1, -1):
            if num[i] < num[i + 1]:
                first = i
                break
        if first == -1:
            num.sort()
            return num
        else:
            for i in xrange(nLen - 1, first, -1):
                if num[i] > num[first]:
                    num[i], num[first] = num[first], num[i]
                    break
            low = first + 1
            high = nLen - 1
            while low < high:
                num[low], num[high] = num[high], num[low]
                low += 1
                high -= 1
            return num
