# !/usr/bin/env python
# -*- coding: utf-8 -*-
# Spiral Matrix 76ms

"""
/*
 * @author:wangzq
 * @email:wangzhenqing1008@163.com
 * @date:2014年07月02日18:56:01
 * @url:https://oj.leetcode.com/problems/spiral-matrix/
 * 1、设定边界值，startx，endx，starty，endy。
 * 2、左到右，上到下，右到左，下到上，直到while条件结束。
 * 具体参考http://blog.csdn.net/u013027996/article/details/36631355
 */
"""


class Solution:
    # @param matrix, a list of lists of integers
    # @return a list of integers
    def spiralOrder(self, matrix):
        list = []
        if matrix is None or len(matrix) == 0:
            return list
        m = len(matrix)
        n = len(matrix[0])
        startx = 0
        starty = 0
        endx = m - 1
        endy = n - 1
        while startx <= endx and starty <= endy:
            for i in range(starty, endy + 1):
                list.append(matrix[startx][i])
            for i in range(startx + 1, endx + 1):
                list.append(matrix[i][endy])
            if startx != endx:
                for i in range(endy - 1, starty - 1, -1):
                    list.append(matrix[endx][i])
            if starty != endy:
                for i in range(endx - 1, startx, -1):
                    list.append(matrix[i][starty])
            startx += 1
            endx -= 1
            starty += 1
            endy -= 1
        return list