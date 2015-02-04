# !/usr/bin/env python
# -*- coding: utf-8 -*-
# Valid Sudoku 92ms

"""
/**
 * Determine if a Sudoku is valid, according to: Sudoku Puzzles - The Rules.
 * The Sudoku board could be partially filled, where empty cells are filled with the character '.'.
 * A partially filled sudoku which is valid.
 * Note:
 * A valid Sudoku board (partially filled) is not necessarily solvable.
 * Only the filled cells need to be validated.
 */
"""

"""
/**
 * @author:wangzq
 * @email:wangzhenqing1008@163.com
 * @date:2015年02月04日18:21:32
 * @url:https://oj.leetcode.com/problems/valid-sudoku/
 * 判断行和列以及每个小格子是否有重复数据
 * 具体参考http://blog.csdn.net/u013027996/article/details/43489683
 */
"""


class Solution:
    # @param board, a 9x9 2D array
    # @return a boolean
    def isValidSudoku(self, board):
        n = len(board)
        for i in xrange(n):
            for j in xrange(n):
                if board[i][j] == '.':
                    continue
                for k in range(n):
                    if k != i and board[k][j] == board[i][j]:
                        return False
                    if k != j and board[i][k] == board[i][j]:
                        return False
                rowStart = i / 3 * 3;
                rowEnd = rowStart + 3
                colStart = j / 3 * 3
                colEnd = colStart + 3
                for k in xrange(rowStart, rowEnd, 1):
                    for l in xrange(colStart, colEnd, 1):
                        if k == i and l == j:
                            continue
                        if board[k][l] == board[i][j]:
                            return False
        return True

