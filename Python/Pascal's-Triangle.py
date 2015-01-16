# !/usr/bin/env python
# -*- coding: utf-8 -*-
# Pascal's Triangle 120ms

"""
/**
 * Given numRows, generate the first numRows of Pascal's triangle.
 * For example, given numRows = 5,
 * Return
 [
     [1],
    [1,1],
   [1,2,1],
  [1,3,3,1],
 [1,4,6,4,1]
 ]
 */
"""

"""
/*
 * @author:wangzq
 * @email:wangzhenqing1008@163.com
 * @date:2014年07月04日18:57:25
 * @url:https://oj.leetcode.com/problems/pascals-triangle/
 * 1、numRows表示有几行，注意列表从0开始。
 * 2、每一行的列表是这样构成的，开头和结尾都是1，中间是前一个列表相邻两个数之和。
 * 具体参考http://blog.csdn.net/u013027996/article/details/36899443
 */
"""


class Solution:
    # @return a list of lists of integers
    def generate(self, numRows):
        list = []
        if numRows <= 0:
            return []
        list.append([1])
        for i in range(1, numRows):
            tempList = list[i-1]
            rowList = []
            rowList.append(1)
            for j in range(1,len(tempList)):
                rowList.append(tempList[j-1] + tempList[j])
            rowList.append(1)
            list.append(rowList)
        return list
