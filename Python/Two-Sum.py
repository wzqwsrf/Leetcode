# !/usr/bin/env python
# -*- coding: utf-8 -*-

# Two Sum 172ms
"""
/*
 * @author:wangzq
 * @email:wangzhenqing1008@163.com
 * @date:2014年07月02日18:05:21
 * @url:https://oj.leetcode.com/problems/two-sum/
 * 1、借助Map，每次边检查边存数据。一直到找到结果为止。
 * 2、疑问，例如numbers = [2,2,3,7,6], target = 5
 * 用了两种方法，得出的结果一个为[1,3]，另一个为[2,3]，
 * 居然都AC了。
 * 具体参考：http://blog.csdn.net/u013027996/article/details/17660515
 */
"""


class Solution:
    # @return a tuple, (index1, index2)
    def twoSum(self, num, target):
        numMap = {}
        alen = len(num)
        array = [0, 0]
        for i in range(alen):
            if numMap.get(target - num[i]) != None:
                array[0] = numMap.get(target - num[i]) + 1
                array[1] = i + 1;
            else:
                numMap[num[i]] = i
        return array

