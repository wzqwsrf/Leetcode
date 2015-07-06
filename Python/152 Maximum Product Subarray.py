# !/usr/bin/env python
# -*- coding: utf-8 -*-
# Maximum Product Subarray 188ms

"""
/**
 * Find the contiguous subarray within an array
 * (containing at least one number) which has the largest product.
 * For example, given the array [2,3,-2,4],
 * the contiguous subarray [2,3] has the largest product = 6.
 */
"""

"""
/*
* @author:wangzq
* @email:wangzhenqing1008@163.com
* @date:2014年10月17日11:39:35
* @url:https://oj.leetcode.com/problems/maximum-product-subarray/
* 最大连续字数组乘积。
* 具体参考http://blog.csdn.net/u013027996/article/details/40183455
*/
"""


class Solution:
    # @param A, a list of integers
    # @return an integer
    def maxProduct(self, A):
        a_min = A[0]
        a_max = A[0]
        result = A[0]
        temp1 = 0
        temp2 = 0
        a_len = len(A)
        for i in range(1, a_len):
            temp1 = a_min * A[i]
            temp2 = a_max * A[i]
            a_min = min(min(temp1, temp2), A[i])
            a_max = max(max(temp1, temp2), A[i])
            result = a_max if a_max > result else result
        return result
