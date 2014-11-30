# !/usr/bin/env python
# -*- coding: utf-8 -*-
# Pascal's Triangle II 152ms

"""
/*
 * @author:wangzq
 * @email:wangzhenqing1008@163.com
 * @date:2014年07月04日18:59:41
 * @url:https://oj.leetcode.com/problems/pascals-triangle-ii/
 * 1、参照Pascal's Triangle，算出所有的list，直接get(rowIndex)
 * 2、如果是空间限制，只能声明k长度的list，依次计算。
 * 具体参考http://blog.csdn.net/u013027996/article/details/36905037
 */
"""


class Solution:
    # @return a list of integers
    def getRow(self, rowIndex):
        list = [1]
        for i in range(1,rowIndex+1):
            curNum = 1
            for j in range(1, i):
                temp = curNum
                curNum = list[j]
                list[j] = temp + list[j]
            list.append(1)
        return list

