# !/usr/bin/env python
# -*- coding: utf-8 -*-
# Permutations 79ms

"""
/**
 * 题目：
 * Given a collection of numbers, return all possible permutations.
 * For example,
 * [1,2,3] have the following permutations:
 * [1,2,3], [1,3,2], [2,1,3], [2,3,1], [3,1,2], and [3,2,1].
 */
"""

"""
/*
 * @author:wangzq
 * @email:wangzhenqing1008@163.com
 * @date:2015年02月04日09:55:46
 * @url:https://oj.leetcode.com/problems/permutations/
 * 全排列，经典算法
 * 具体参考：http://blog.csdn.net/u013027996/article/details/18734103
 */
"""

"""方法一，经典算法"""
class Solution:
    # @param num, a list of integer
    # @return a list of lists of integers
    def permute(self, num):
        num.sort()
        result = []
        nLen = len(num)
        visit = [0 for i in xrange(nLen)]
        self.dfs(result, [], visit, num, nLen)
        return result

    def dfs(self, result, newNum, visit, num, nLen):
        if len(newNum) == nLen:
            result.append([x for x in newNum])
            return
        for i in xrange(nLen):
            if visit[i] == 0:
                visit[i] = 1
                newNum.append(num[i])
                self.dfs(result, newNum, visit, num, nLen)
                newNum.pop()
                visit[i] = 0


"""方法二：DFS"""
class Solution:
    # @param num, a list of integer
    # @return a list of lists of integers
    def permute(self, num):
        num.sort()
        result = []
        result.append([x for x in num])
        nLen = len(num)
        while True:
            first = -1
            for i in xrange(nLen - 2, -1, -1):
                if num[i] < num[i + 1]:
                    first = i
                    break
            if first == -1:
                break
            for i in xrange(nLen - 1, first, -1):
                if num[i] > num[first]:
                    num[i], num[first] = num[first], num[i]
                    break
            low = first + 1
            high = nLen - 1
            while low < high:
                num[low], num[high] = num[high], num[low]
                low += 1
                high -= 1
            result.append([x for x in num])
        return result
