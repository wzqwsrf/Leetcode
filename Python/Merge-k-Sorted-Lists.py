# !/usr/bin/env python
# -*- coding: utf-8 -*-
# Merge k Sorted Lists 1116ms

"""
/**
 * Merge k sorted linked lists and return it as one sorted list.
 * Analyze and describe its complexity.
 */

"""

"""
/*
 * @author:wangzq
 * @email:wangzhenqing1008@163.com
 * @date:2014年07月16日15:12:03
 * @url:https://oj.leetcode.com/problems/merge-k-sorted-lists/
 * 1、参考Merge Two Sorted Lists，依次归并，每个节点都至少需要扫描一次，很耗时间。
 * 2、参考地址LeetCode:Merge k Sorted Lists，分析的很详细。
 * 具体参考http://blog.csdn.net/u013027996/article/details/37878255
 */
"""


# Definition for singly-linked list.
class ListNode:
    def __init__(self, x):
        self.val = x
        self.next = None


class Solution:
    # @param a list of ListNode
    # @return a ListNode
    def mergeKLists(self, lists):
        if lists is None or len(lists) == 0:
            return None
        n = len(lists)
        while n > 1:
            k = (n + 1) / 2
            for i in range(n/2):
                lists[i] = self.mergeTwoLists(lists[i], lists[i+k])
            n = k
        return lists[0]

    def mergeTwoLists(self, l1, l2):
        node = ListNode(0)
        point = node
        while l1 is not None and l2 is not None:
            if l1.val > l2.val:
                point.next = ListNode(l2.val)
                l2 = l2.next
            else:
                point.next = ListNode(l1.val)
                l1 = l1.next
            point = point.next
        while l1 is not None:
            point.next = ListNode(l1.val)
            point = point.next
            l1 = l1.next
        while l2 is not None:
            point.next = ListNode(l2.val)
            point = point.next
            l2 = l2.next
        return node.next
