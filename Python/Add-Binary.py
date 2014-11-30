# !/usr/bin/env python
# -*- coding: utf-8 -*-
# Add Binary

"""
/*
 * @author:wangzq
 * @email:wangzhenqing1008@163.com
 * @date:2014年07月02日17:25:17
 * @url:https://oj.leetcode.com/problems/add-binary/
 * 1、二进制加法，最基本的还是将字符串转为字符数组，按位相加，注意进位问题。
 * 2、两个数相加的最大位数，是二者长度之中最大值或者最大值加1
 * 具体参考：http://blog.csdn.net/u013027996/article/details/36436901
 */
"""


class Solution:
    # @param a, a string
    # @param b, a string
    # @return a string
    def addBinary(self, a, b):
        len1 = len(a)
        len2 = len(b)
        if len1 > len2:
            maxLen = len1
        else:
            maxLen = len2
        list = [0 for i in range(maxLen + 1)]
        k = maxLen
        while len1 > 0 and len2 > 0:
            list[k] += int(a[len1-1]) + int(b[len2-1])
            if list[k] >= 2:
                list[k] -= 2
                list[k-1] += 1
            len1 -= 1
            len2 -= 1
            k -= 1
        while len1 > 0:
            list[k] += int(a[len1-1])
            if list[k] >= 2:
                list[k] -= 2
                list[k-1] += 1
            len1 -=1
            k -= 1
        while len2 > 0:
            list[k] += int(b[len2-1])
            if list[k] >= 2:
                list[k] -= 2
                list[k-1] += 1
            len2 -= 1
            k -= 1
        list = [str(e) for e in list]
        if list[0] == '0':
            return "".join(list[1:])
        else:
            return "".join(list)
