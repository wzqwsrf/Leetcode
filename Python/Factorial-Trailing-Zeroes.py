# !/usr/bin/env python
# -*- coding: utf-8 -*-
# Add Binary

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
