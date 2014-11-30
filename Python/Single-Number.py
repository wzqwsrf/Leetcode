# !/usr/bin/env python
# -*- coding: utf-8 -*-
# Single Number 284ms

"""
/*
 * @author:wangzq
 * @email:wangzhenqing1008@163.com
 * @date:2014年07月17日16:17:44
 * @url:https://oj.leetcode.com/problems/single-number/
 * 整个数组异或，结果就是只出现一次的那个数字
 * 具体参考http://blog.csdn.net/u013027996/article/details/17642559
 */
"""


class Solution:
    # @param A, a list of integer
    # @return an integer
    def singleNumber(self, A):
        alen = len(A)
        result = A[0]
        for i in range(1, alen, 1):
            result ^= A[i]
        return result