# !/usr/bin/env python
# -*- coding: utf-8 -*-
# Add Binary

"""
/*
 * @author:wangzq
 * @email:wangzhenqing1008@163.com
 * @date:2015年01月09日15:24:30
 * @url:https://oj.leetcode.com/problems/excel-sheet-column-number/
 * 将字符转为数字，就是26进制数字转换
 * 具体参考：
 */
"""


class Solution:
    # @param s, a string
    # @return an integer
    def titleToNumber(self, s):
        num = 0
        sLen = len(s)
        for i in range(sLen):
            num += pow(26, sLen - 1 - i) * (ord(s[i]) - ord('A') + 1)
        return num
