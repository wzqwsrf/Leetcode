# !/usr/bin/env python
# -*- coding: utf-8 -*-
# Permutations 79ms

"""
/**
 * 题目：
 * Given a collection of numbers that might contain duplicates,
 * return all possible unique permutations.
 * For example,
 * [1,1,2] have the following unique permutations:
 * [1,1,2], [1,2,1], and [2,1,1].
 */
"""
"""
/*
 * @author:wangzq
 * @email:wangzhenqing1008@163.com
 * @date:2015年02月04日11:50:25
 * @url:https://oj.leetcode.com/problems/permutations-ii/
 * 全排列，带有重复数据，经典算法
 * 具体参考：http://blog.csdn.net/u013027996/article/details/18734103
 */
"""

"""方法一，经典算法"""
class Solution:
    # @param num, a list of integer
    # @return a list of lists of integers
    def permuteUnique(self, num):
        num.sort()
        result = []
        result.append([x for x in num])
        nLen = len(num)
        while True:
            first = -1
            for i in xrange(nLen-2,-1,-1):
                if num[i] < num[i+1]:
                    first = i
                    break
            if first == -1:
                break
            for i in xrange(nLen-1,first,-1):
                if num[i] > num[first]:
                    num[i],num[first] = num[first],num[i]
                    break
            low = first + 1
            high = nLen - 1
            while low < high:
                num[low],num[high] = num[high],num[low]
                low += 1
                high -= 1
            result.append([x for x in num])
        return result


"""方法二1：DFS"""
class Solution:
    # @param num, a list of integer
    # @return a list of lists of integers
    def permuteUnique(self, num):
        num.sort()
        result = []
        nLen = len(num)
        visit = [0 for i in xrange(nLen)]
        self.dfs(result, [], num, visit, nLen)
        return result

    def dfs(self, result, newNum, num, visit, nLen):
        if len(newNum) == nLen:
            result.append([x for x in newNum])
            return
        usedList = []
        for i in xrange(nLen):
            if visit[i] == 0:
                if num[i] in usedList:
                    continue
                else:
                    usedList.append(num[i])
                visit[i] = 1
                newNum.append(num[i])
                self.dfs(result, newNum, num, visit, nLen)
                newNum.pop()
                visit[i] = 0
                while i < nLen - 1 and num[i] == num[i+1]:
                    i += 1

"""方法二2：DFS"""
class Solution:
    # @param num, a list of integer
    # @return a list of lists of integers
    def permuteUnique(self, num):
        result = []
        nLen = len(num)
        visit = [0 for i in xrange(nLen)]
        self.dfs(result, [], num, visit, nLen)
        return result

    def dfs(self, result, newNum, num, visit, nLen):
        if len(newNum) == nLen:
            result.append([x for x in newNum])
            return
        usedList = []
        for i in xrange(nLen):
            if visit[i] == 0:
                if num[i] in usedList:
                    continue
                else:
                    usedList.append(num[i])
                visit[i] = 1
                newNum.append(num[i])
                self.dfs(result, newNum, num, visit, nLen)
                newNum.pop()
                visit[i] = 0


