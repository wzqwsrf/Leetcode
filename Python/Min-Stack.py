# !/usr/bin/env python
# -*- coding: utf-8 -*-
# Min Stack 232ms

"""
/**
 * Min Stack
 * Total Accepted: 15688 Total Submissions: 101910 My Submissions Question Solution
 * Design a stack that supports push, pop, top,
 * and retrieving the minimum element in constant time.
 * push(x) -- Push element x onto stack.
 * pop() -- Removes the element on top of the stack.
 * top() -- Get the top element.
 * getMin() -- Retrieve the minimum element in the stack.
 */
"""

"""
/*
 * @author:wangzq
 * @email:wangzhenqing1008@163.com
 * @date:2015年01月23日19:09:48
 * @url:https://oj.leetcode.com/problems/min-stack/
 * 每次把最小数保存在minStack中，pop的时候判断是否和当前栈顶元素相等。
 * 具体参考：http://blog.csdn.net/u013027996/article/details/43090751
 */
"""


class MinStack:
    stack = []
    minStack = []

    def __init__(self):
        self.stack = []
        self.minStack = []

    # @param x, an integer
    # @return an integer
    def push(self, x):
        if not self.minStack or x <= self.minStack[len(self.minStack) - 1]:
            self.minStack.append(x)
        self.stack.append(x)

    # @return nothing
    def pop(self):
        x = self.stack.pop()
        if x == self.minStack[len(self.minStack) - 1]:
            self.minStack.pop()

    # @return an integer
    def top(self):
        return self.stack[len(self.stack) - 1]

    # @return an integer
    def getMin(self):
        return self.minStack[len(self.minStack) - 1]


