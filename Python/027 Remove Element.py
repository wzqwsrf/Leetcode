# !/usr/bin/env python
# -*- coding: utf-8 -*-
# Remove Element 208ms

"""
/**
 * Given an array and a value,
 * remove all instances of that value in place and return the new length.
 * The order of elements can be changed.
 * It doesn't matter what you leave beyond the new length.
 */
"""

"""
/*
* @author:wangzq
* @email:wangzhenqing1008@163.com
* @date:2014年10月16日18:15:14
* @url:https://oj.leetcode.com/problems/remove-element/
* 扫描处理数组
* 具体参考http://blog.csdn.net/u013027996/article/details/40152421
*/
"""


class Solution:
    # @param    A       a list of integers
    # @param    elem    an integer, value need to be removed
    # @return an integer
    def removeElement(self, A, elem):
        a_len = len(A)
        start = 0
        for i in range(a_len):
            if A[i] != elem:
                A[start] = A[i]
                start += 1
        return start
