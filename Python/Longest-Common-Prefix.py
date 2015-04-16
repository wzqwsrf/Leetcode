# !/usr/bin/env python
# -*- coding: utf-8 -*-
# Longest Common Prefix 53ms


"""
/**
 * @author:wangzq
 * @email:wangzhenqing1008@163.com
 * @date:2015年04月16日10:28:29
 * @url:https://leetcode.com/problems/longest-common-prefix/
 */
"""


class Solution:
    # @return a string
    def longestCommonPrefix(self, strs):
        if not strs:
            return ''
        minLen = len(strs[0])
        index = 0
        sLen = len(strs)
        for i in xrange(1, sLen):
            xLen = len(strs[i])
            if minLen > xLen:
                minLen = xLen
                index = i
        for x in strs:
            k = 0
            while k < minLen:
                if x[k] != strs[index][k]:
                    break
                k += 1
            if k < minLen:
                minLen = k
        return strs[index][:minLen]
