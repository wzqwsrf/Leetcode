# !/usr/bin/env python
# -*- coding: utf-8 -*-
# Sudoku Solver 783ms

"""
/**
 * Write a program to solve a Sudoku puzzle by filling the empty cells.
 * Empty cells are indicated by the character '.'.
 * You may assume that there will be only one unique solution.
 * ...and its solution numbers marked in red.
 */
"""

"""
/**
 * @author:wangzq
 * @email:wangzhenqing1008@163.com
 * @date:2015年02月04日22:48:13
 * @url:https://oj.leetcode.com/problems/sudoku-solver/
 * 每个数填1到9，判断是否符合要求，回溯寻找结果
 * 具体参考http://blog.csdn.net/u013027996/article/details/43499949
 */
"""


class Solution:
    # @param board, a 9x9 2D array
    # Solve the Sudoku by modifying the input board in-place.
    # Do not return any value.
    def solveSudoku(self, board):
        num = []
        n = len(board)
        for i in xrange(n):
            for j in xrange(n):
                if board[i][j] == '.':
                    num.append(i * n + j)
        self.dfs(board, num, len(num), n, 0)
        print board

    def dfs(self, board, num, size, n, cur):
        if cur == size:
            return True
        index = num[cur]
        row = index / n
        col = index % n
        for i in xrange(1, 10):
            if self.isValidSudoku(board, row, col, chr(i + ord('0'))):
                temp = board[row]
                newTemp = ''
                for k in xrange(len(temp)):
                    if k == col:
                        newTemp += chr(i + ord('0'))
                    else:
                        newTemp += temp[k]
                board[row] = newTemp
                # board[row][col] = chr(i+ord('0'))
                if self.dfs(board, num, size, n, cur + 1):
                    return True
                board[row] = temp
        return False

    def isValidSudoku(self, board, row, col, value):
        for i in xrange(9):
            if board[i][col] == value:
                return False
        for j in xrange(9):
            if board[row][j] == value:
                return False

        rowStart = row / 3 * 3
        rowEnd = rowStart + 3
        colStart = col / 3 * 3
        colEnd = colStart + 3
        for i in xrange(rowStart, rowEnd):
            for j in xrange(colStart, colEnd):
                if board[i][j] == '.':
                    continue
                if board[i][j] == value:
                    return False
        return True

