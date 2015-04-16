# !/usr/bin/env python
# -*- coding: utf-8 -*-
# Palindrome Number 245ms


"""
/**
 * @author:wangzq
 * @email:wangzhenqing1008@163.com
 * @date:2015年04月16日10:16:28
 * @url:https://leetcode.com/problems/palindrome-number/
 */
"""


class Solution:
    # @return a boolean
    def isPalindrome(self, x):
        xstr = str(x)
        xlen = len(xstr)
        if xlen == 1:
            return True
        i = 0
        j = xlen - 1
        while i <= j:
            if xstr[i] != xstr[j]:
                return False
            else:
                i += 1
                j -= 1
        return True


