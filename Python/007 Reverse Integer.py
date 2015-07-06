# !/usr/bin/env python
# -*- coding: utf-8 -*-
# Reverse Integer 52ms


"""
/*
 * @author:wangzq
 * @email:wangzhenqing1008@163.com
 * @date:2015年04月14日22:48:05
 * @url:https://leetcode.com/problems/reverse-integer/
 * 注意int最大值
 * 具体参考
 */
"""


class Solution:
    # @return an integer
    def reverse(self, x):
        flag = 1 if x > 0 else -1
        num = abs(x)
        result = 0
        while num > 0:
            result = result * 10 + num % 10
            num /= 10
        if result > 2147483647:
            return 0
        return flag * result
