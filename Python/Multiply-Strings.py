# !/usr/bin/env python
# -*- coding: utf-8 -*-
# Multiply Strings 944ms

"""
/**
 * Given two numbers represented as strings,
 * return multiplication of the numbers as a string.
 * Note: The numbers can be arbitrarily large and are non-negative.
 */
"""

"""
/*
 * @author:wangzq
 * @email:wangzhenqing1008@163.com
 * @date:2014年07月04日10:26:44
 * @url:https://oj.leetcode.com/problems/multiply-strings/
 * 1、数学计算的基本思想转为代码实现。
 * 2、num1和num2按位相乘，累加。
 * 3、两数相乘最大位数，是len(num1)+len(num2)
 * 4、注意两者之中出现"000"这种情况的返回值
 * 5、比较考验基本功底，建议练习。
 * 具体参考http://blog.csdn.net/u013027996/article/details/36868975
 */
"""


class Solution:
    # @param num1, a string
    # @param num2, a string
    # @return a string
    def multiply(self, num1, num2):
        if int(num1) == 0 or int(num2) == 0:
            return '0'
        len1 = len(num1)
        len2 = len(num2)
        col = len1 + len2
        list = [0 for i in range(col)]
        list1 = [int(num1[i]) for i in range(len1)]
        list2 = [int(num2[i]) for i in range(len2)]
        k = col
        for i in range(len2-1, -1, -1):
            k -= 1
            tempCol = k
            tempList = [0 for l in range(col)]
            for j in range(len1-1, -1, -1):
                tempList[tempCol] += list1[j] * list2[i]
                if tempList[tempCol] >= 10 :
                    mod = tempList[tempCol] / 10
                    tempList[tempCol] %= 10
                    tempList[tempCol - 1] += mod
                tempCol -= 1
            list = self.addNum(tempList, list, col)
        if list[0] == 0:
            list = list[1:]
        list = [str(e) for e in list]
        return "".join(list)

    def addNum(self, tempList, list, col):
        for i in range(col-1, -1, -1):
            list[i] += tempList[i]
            if(list[i] >= 10):
                list[i] -= 10
                list[i-1] += 1
        return list
