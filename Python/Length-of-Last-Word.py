# !/usr/bin/env python
# -*- coding: utf-8 -*-
# Length of Last Word 172ms

"""
/*
* @author:wangzq
* @email:wangzhenqing1008@163.com
* @date:2014年10月10日17:41:43
* @url:https://oj.leetcode.com/problems/length-of-last-word/
* 字符串处理基本功
* 具体参考http://blog.csdn.net/u013027996/article/details/39965939
*/
"""


class Solution:
    # @param s, a string
    # @return an integer
    def lengthOfLastWord(self, s):
        s = s.strip()
        sArr = s.split(' ')
        word = sArr[len(sArr)-1].strip()
        return len(word)

