# !/usr/bin/env python
# -*- coding: utf-8 -*-

# Validate Binary Search Tree 308ms
"""
/*
 * @author:wangzq
 * @email:wangzhenqing1008@163.com
 * @date:2014年07月11日12:15:30
 * @url:https://oj.leetcode.com/problems/validate-binary-search-tree/
 * 1、二叉搜索树的基本判断，左孩子比根值小，右孩子比根值大。
 * 2、按照这个思路，默认的最大最小值是int的值范围。
 * 3、递归判断，每次判断左右孩子的值和最大最小值的比较。
 * 4、一直到根为空，递归结束。
 * 具体参考http://blog.csdn.net/u013027996/article/details/37692581
 */
"""
# Definition for a  binary tree node


class TreeNode:
    def __init__(self, x):
        self.val = x
        self.left = None
        self.right = None


class Solution:
    # @param root, a tree node
    # @return a boolean
    def isValidBST(self, root):
        max_val = 2 ** 31
        return self.dfs(root, -max_val, max_val)

    def dfs(self, root, min_val, max_val):
        if root is None:
            return True
        if root.val <= min_val or root.val >= max_val:
            return False
        return self.dfs(root.left, min_val, root.val) and self.dfs(root.right, root.val, max_val)
