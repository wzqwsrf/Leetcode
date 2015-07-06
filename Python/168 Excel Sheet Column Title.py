# !/usr/bin/env python
# -*- coding: utf-8 -*-
# Excel Sheet Column Title 57ms

"""
/**
 * Given a positive integer, return its corresponding column title as
 * appear in an Excel sheet.
 For example:
 1 -> A
 2 -> B
 3 -> C
 ...
 26 -> Z
 27 -> AA
 28 -> AB
 Credits:
 Special thanks to @ifanchu for adding this problem and creating all test cases.
 */
"""

"""
/*
 * @author:wangzq
 * @email:wangzhenqing1008@163.com
 * @date:2015年01月09日15:26:59
 * @url:https://oj.leetcode.com/problems/excel-sheet-column-title/
 * 数字转为26进制，注意，当低位为0时，需要从高位借1
 * 具体参考：
 */
"""


class Solution:
    # @return a string
    def convertToTitle(self, num):
        s = ''
        last = 0
        while num != 0:
            temp = num % 26
            num /= 26
            temp += last
            if num == 0 and temp == 0:
                break
            if temp <= 0:
                s += chr(temp + 25 + ord('A'))
                last = -1
            else:
                s += chr(temp - 1 + ord('A'))
                last = 0
        return s[::-1]
