# !/usr/bin/env python
# -*- coding: utf-8 -*-
# Summary Ranges

"""
/**
 * @author:wangzq
 * @email:wangzhenqing1008@163.com
 * @date:2015年06月26日10:02:40
 * @url:https://leetcode.com/problems/summary-ranges/
 */
"""


class Solution:
    # @param {integer[]} nums
    # @return {string[]}
    def summaryRanges(self, nums):
        ranges = []
        if nums:
            nlen = len(nums)
            i = 0
            while i < nlen:
                start = str(nums[i])
                end = ''
                while i < nlen - 1 and nums[i+1] == nums[i] + 1:
                    end = '->' + str(nums[i+1])
                    i += 1
                ranges.append(start + end)
                i += 1
        return ranges
