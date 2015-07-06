# !/usr/bin/env python
# -*- coding: utf-8 -*-
# Spiral Matrix II 348ms

"""
/**
 * Given an integer n, generate a square matrix filled with elements from 1 to n2 in spiral order.
 * For example,
 Given n = 3,
 You should return the following matrix:
 [
 [ 1, 2, 3 ],
 [ 8, 9, 4 ],
 [ 7, 6, 5 ]
 ]
 */
"""

"""
/*
 * @author:wangzq
 * @email:wangzhenqing1008@163.com
 * @date:2014年07月02日18:56:01
 * @url:https://oj.leetcode.com/problems/spiral-matrix-ii/
 * 和Spiral Matrix一样，但是这次不是打印矩阵的内容了，而是赋值，思路仍然一致。
 * 1、设定边界值，startx，endx，starty，endy。
 * 2、左到右，上到下，右到左，下到上，直到while条件结束。
 * 具体参考http://blog.csdn.net/u013027996/article/details/36638519
 */
"""


class Solution:
    # @return a list of lists of integer
    def generateMatrix(self, n):
        matrix = [[0 for col in range(n)] for row in range(n)]
        startx = 0
        starty = 0
        endx = n - 1
        endy = n - 1
        num = 1
        while startx <= endx and starty <= endy:
            for i in range(starty, endy + 1):
                matrix[startx][i] = num
                num += 1
            for i in range(startx + 1, endx + 1):
                matrix[i][endy] = num
                num += 1
            if startx != endx:
                for i in range(endy - 1, starty - 1, -1):
                    matrix[endx][i] = num
                    num += 1
            if starty != endy:
                for i in range(endx - 1, startx, -1):
                   matrix[i][starty] = num
                   num += 1
            startx += 1
            endx -= 1
            starty += 1
            endy -= 1
        return matrix