# !/usr/bin/env python
# -*- coding: utf-8 -*-
# Longest Substring Without Repeating Characters 208ms

"""
/**
 * Given a string, find the length of the longest substring without repeating characters.
 * For example, the longest substring without repeating letters for "abcabcbb" is "abc",
 * which the length is 3. For "bbbbb" the longest substring is "b", with the length of 1.
 * Hide Tags Hash Table Two Pointers String
 */
"""

"""
/**
 * @author:wangzq
 * @email:wangzhenqing1008@163.com
 * @date:2015年02月07日15:12:29
 * @url:https://oj.leetcode.com/problems/longest-substring-without-repeating-characters/
 * 每次查找记录字符是否出现。切忌暴力搜索
 * 具体参考http://blog.csdn.net/u013027996/article/details/43603377
 */
"""


class Solution:
    # @return an integer
    def lengthOfLongestSubstring(self, s):
        if not s:
            return 0
        sLen = len(s)
        sDict = {}
        start = 0
        maxLen = 0
        sDict[s[0]] = 0
        k = 1
        while k < sLen:
            if s[k] in sDict:
                tempLen = k - start
                maxLen = maxLen if maxLen > tempLen else tempLen
                start = sDict[s[k]] + 1
                k = start + 1
                sDict = {}
                sDict[s[start]] = start
            else:
                sDict[s[k]] = k
                k += 1
        tempLen = sLen - start
        maxLen = maxLen if maxLen > tempLen else tempLen
        return maxLen
