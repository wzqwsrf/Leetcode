# !/usr/bin/env python
# -*- coding: utf-8 -*-
# Intersection of Two Linked Lists 768ms

"""
/**
 * Write a program to find the node at which the intersection of two singly linked lists begins.
 * For example, the following two linked lists:
 * A:      a1 → a2
 *               ↘
 *               c1 → c2 → c3
 *               ↗
 * B: b1 → b2 → b3
 * begin to intersect at node c1.
 * Notes:
 * If the two linked lists have no intersection at all, return null.
 * The linked lists must retain their original structure after the function returns.
 * You may assume there are no cycles anywhere in the entire linked structure.
 * Your code should preferably run in O(n) time and use only O(1) memory.
 * Credits:
 * Special thanks to @stellari for adding this problem and creating all test cases.
 */
"""

"""
/**
 * @author:wangzq
 * @email:wangzhenqing1008@163.com
 * @date:2015年02月13日16:36:22
 * @url:https://oj.leetcode.com/problems/intersection-of-two-linked-lists/
 * 链表的公共节点
 * 具体参考http://blog.csdn.net/u013027996/article/details/43795441
 */
"""

# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, x):
#         self.val = x
#         self.next = None


class Solution:
    # @param two ListNodes
    # @return the intersected ListNode
    def getIntersectionNode(self, headA, headB):
        len1 = 0
        p = headA
        while p:
            p = p.next
            len1 += 1

        len2 = 0
        p = headB
        while p:
            p = p.next
            len2 += 1

        k = 0
        if len1 > len2:
            while k < (len1 - len2):
                headA = headA.next
                k += 1
        else:
            while k < (len2 - len1):
                headB = headB.next
                k += 1
        while headA != headB:
            headA = headA.next
            headB = headB.next
        return headA