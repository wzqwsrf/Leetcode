#======================================
# Add Binary
'''
/*
 * @author:wangzq
 * @email:wangzhenqing1008@163.com
 * @date:2014年07月02日17:25:17
 * @url:https://oj.leetcode.com/problems/add-binary/
 * 1、二进制加法，最基本的还是将字符串转为字符数组，按位相加，注意进位问题。
 * 2、两个数相加的最大位数，是二者长度之中最大值或者最大值加1
 * 具体参考：http://blog.csdn.net/u013027996/article/details/36436901
 */
'''
class Solution:
    # @param a, a string
    # @param b, a string
    # @return a string
    def addBinary(self, a, b):
        len1 = len(a)
        len2 = len(b)
        if len1 > len2:
            maxLen = len1
        else:
            maxLen = len2
        list = [0 for i in range(maxLen + 1)]
        k = maxLen
        while len1 > 0 and len2 > 0:
            list[k] += int(a[len1-1]) + int(b[len2-1])
            if list[k] >= 2:
                list[k] -= 2
                list[k-1] += 1
            len1 -= 1
            len2 -= 1
            k -= 1
        while len1 > 0:
            list[k] += int(a[len1-1])
            if list[k] >= 2:
                list[k] -= 2
                list[k-1] += 1
            len1 -=1
            k -= 1
        while len2 > 0:
            list[k] += int(b[len2-1])
            if list[k] >= 2:
                list[k] -= 2
                list[k-1] += 1
            len2 -= 1
            k -= 1
        list = [str(e) for e in list]
        if list[0] == '0':
            return "".join(list[1:])
        else:
            return "".join(list)



#======================================
# Two Sum 172ms
'''
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
'''
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



#======================================
# Spiral Matrix 76ms
'''
/*
 * @author:wangzq
 * @email:wangzhenqing1008@163.com
 * @date:2014年07月02日18:56:01
 * @url:https://oj.leetcode.com/problems/spiral-matrix/
 * 1、设定边界值，startx，endx，starty，endy。
 * 2、左到右，上到下，右到左，下到上，直到while条件结束。
 * 具体参考http://blog.csdn.net/u013027996/article/details/36631355
 */
'''
class Solution:
    # @param matrix, a list of lists of integers
    # @return a list of integers
    def spiralOrder(self, matrix):
        list = []
        if matrix is None or len(matrix) == 0:
            return list
        m = len(matrix)
        n = len(matrix[0])
        startx = 0
        starty = 0
        endx = m - 1
        endy = n - 1
        while startx <= endx and starty <= endy:
            for i in range(starty, endy + 1):
                list.append(matrix[startx][i])
            for i in range(startx + 1, endx + 1):
                list.append(matrix[i][endy])
            if startx != endx:
                for i in range(endy - 1, starty - 1, -1):
                    list.append(matrix[endx][i])
            if starty != endy:
                for i in range(endx - 1, startx, -1):
                    list.append(matrix[i][starty])
            startx += 1
            endx -= 1
            starty += 1
            endy -= 1
        return list



#======================================
# Spiral Matrix II 208ms
'''
/*
 * @author:wangzq
 * @email:wangzhenqing1008@163.com
 * @date:2014年07月03日109:51:32
 * @url:https://oj.leetcode.com/problems/spiral-matrix-ii/
 * 和Spiral Matrix一样，但是这次不是打印矩阵的内容了，而是赋值，思路仍然一致。
 * 1、设定边界值，startx，endx，starty，endy。
 * 2、左到右，上到下，右到左，下到上，直到while条件结束。
 * 具体参考http://blog.csdn.net/u013027996/article/details/36638519
 */
'''
class Solution:
    # @return a list of lists of integer
    def generateMatrix(self, n):
        matrix = [[0 for col in range(n)] for row in range(n)]
        startx = 0
        starty = 0
        endx = n - 1
        endy = n - 1
        num = 1
        while startx <= endx and starty <= endy:
            for i in range(starty, endy + 1):
                matrix[startx][i] = num
                num += 1
            for i in range(startx + 1, endx + 1):
                matrix[i][endy] = num
                num += 1
            if startx != endx:
                for i in range(endy - 1, starty - 1, -1):
                    matrix[endx][i] = num
                    num += 1
            if starty != endy:
                for i in range(endx - 1, startx, -1):
                   matrix[i][starty] = num
                   num += 1
            startx += 1
            endx -= 1
            starty += 1
            endy -= 1
        return matrix



#======================================
# Multiply Strings 944ms
'''
/*
 * @author:wangzq
 * @email:wangzhenqing1008@163.com
 * @date:2014年07月04日10:26:44
 * @url:https://oj.leetcode.com/problems/multiply-strings/
 * 1、数学计算的基本思想转为代码实现。
 * 2、num1和num2按位相乘，累加。
 * 3、两数相乘最大位数，是len(num1)+len(num2)
 * 4、注意两者之中出现"000"这种情况的返回值
 * 5、比较考验基本功底，建议练习。
 * 具体参考http://blog.csdn.net/u013027996/article/details/36868975
 */
'''
class Solution:
    # @param num1, a string
    # @param num2, a string
    # @return a string
    def multiply(self, num1, num2):
        if int(num1) == 0 or int(num2) == 0:
            return '0'
        len1 = len(num1)
        len2 = len(num2)
        col = len1 + len2
        list = [0 for i in range(col)]
        list1 = [int(num1[i]) for i in range(len1)]
        list2 = [int(num2[i]) for i in range(len2)]
        k = col
        for i in range(len2-1, -1, -1):
            k -= 1
            tempCol = k
            tempList = [0 for l in range(col)]
            for j in range(len1-1, -1, -1):
                tempList[tempCol] += list1[j] * list2[i]
                if tempList[tempCol] >= 10 :
                    mod = tempList[tempCol] / 10
                    tempList[tempCol] %= 10
                    tempList[tempCol - 1] += mod
                tempCol -= 1
            list = self.addNum(tempList, list, col)
        if list[0] == 0:
            list = list[1:]
        list = [str(e) for e in list]
        return "".join(list)

    def addNum(self, tempList, list, col):
        for i in range(col-1, -1, -1):
            list[i] += tempList[i]
            if(list[i] >= 10):
                list[i] -= 10
                list[i-1] += 1
        return list



#======================================
# Pascal's Triangle 120ms
'''
/*
 * @author:wangzq
 * @email:wangzhenqing1008@163.com
 * @date:2014年07月04日18:57:25
 * @url:https://oj.leetcode.com/problems/pascals-triangle/
 * 1、numRows表示有几行，注意列表从0开始。
 * 2、每一行的列表是这样构成的，开头和结尾都是1，中间是前一个列表相邻两个数之和。
 * 具体参考http://blog.csdn.net/u013027996/article/details/36899443
 */
'''
class Solution:
    # @return a list of lists of integers
    def generate(self, numRows):
        list = []
        if numRows <= 0:
            return []
        list.append([1])
        for i in range(1, numRows):
            tempList = list[i-1]
            rowList = []
            rowList.append(1)
            for j in range(1,len(tempList)):
                rowList.append(tempList[j-1] + tempList[j])
            rowList.append(1)
            list.append(rowList)
        return list



#======================================
# Pascal's Triangle 152ms
'''
/*
 * @author:wangzq
 * @email:wangzhenqing1008@163.com
 * @date:2014年07月04日18:59:41
 * @url:https://oj.leetcode.com/problems/pascals-triangle-ii/
 * 1、参照Pascal's Triangle，算出所有的list，直接get(rowIndex)
 * 2、如果是空间限制，只能声明k长度的list，依次计算。
 * 具体参考http://blog.csdn.net/u013027996/article/details/36905037
 */
'''
class Solution:
    # @return a list of integers
    def getRow(self, rowIndex):
        list = [1]
        for i in range(1,rowIndex+1):
            curNum = 1
            for j in range(1, i):
                temp = curNum
                curNum = list[j]
                list[j] = temp + list[j]
            list.append(1)
        return list



#======================================
# Validate Binary Search Tree 308ms
'''
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
 '''
# Definition for a  binary tree node
# class TreeNode:
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution:
    # @param root, a tree node
    # @return a boolean
    def isValidBST(self, root):
        max_val = 2**31
        return self.dfs(root, -max_val, max_val)

    def dfs(self, root, min_val, max_val):
        if root is None:
            return True
        if root.val <= min_val or root.val >= max_val:
            return False
        return self.dfs(root.left, min_val, root.val) and self.dfs(root.right, root.val, max_val)



#======================================
# Merge Two Sorted Lists 240ms
'''
/*
 * @author:wangzq
 * @email:wangzhenqing1008@163.com
 * @date:2014年07月15日10:27:52
 * @url:https://oj.leetcode.com/problems/merge-two-sorted-lists/
 * 归并排序，考察基本功。
 * 赋值的时候可以new一个节点，也可以将一个链表赋值给另外一个，后者相对慢一些。
 * 具体参考http://blog.csdn.net/u013027996/article/details/37810407
 */
'''
# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, x):
#         self.val = x
#         self.next = None

class Solution:
    # @param two ListNodes
    # @return a ListNode
    def mergeTwoLists(self, l1, l2):
        node = ListNode(0)
        point = node
        while l1 is not None and l2 is not None:
            if l1.val > l2.val:
                point.next = l2
                l2 = l2.next
            else:
                point.next = l1
                l1 = l1.next
            point = point.next
        if l1 is not None:
            point.next = l1
        if l2 is not None:
            point.next = l2
        return node.next



#======================================
# Merge k Sorted Lists 1116ms
'''
/*
 * @author:wangzq
 * @email:wangzhenqing1008@163.com
 * @date:2014年07月16日15:12:03
 * @url:https://oj.leetcode.com/problems/merge-k-sorted-lists/
 * 1、参考Merge Two Sorted Lists，依次归并，每个节点都至少需要扫描一次，很耗时间。
 * 2、参考地址LeetCode:Merge k Sorted Lists，分析的很详细。
 * 具体参考http://blog.csdn.net/u013027996/article/details/37878255
 */
'''
# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, x):
#         self.val = x
#         self.next = None

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



#======================================
#Add Two Numbers 568ms
'''
/*
 * @author:wangzq
 * @email:wangzhenqing1008@163.com
 * @date:2014年07月17日16:05:11
 * @url:https://oj.leetcode.com/problems/add-two-numbers/
 * 大数相加，按位求和，注意进位问题
 * 具体参考http://blog.csdn.net/u013027996/article/details/37908619
 */
 '''
# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, x):
#         self.val = x
#         self.next = None

class Solution:
    # @return a ListNode
    def addTwoNumbers(self, l1, l2):
        if l1 is None and l2 is None:
            return None
        node = ListNode(0)
        point = node
        carry = 0

        while l1 is not None and l2 is not None:
            val = l1.val + l2.val
            val += carry
            carry = 0
            if val >= 10:
                temp = val
                val %= 10
                carry += temp / 10
            point.next = ListNode(val)
            point = point.next
            l1 = l1.next
            l2 = l2.next

        while l1 is not None:
            val = l1.val + carry
            carry = 0
            if val >= 10:
                temp = val
                val %= 10
                carry += temp / 10
            point.next = ListNode(val)
            point = point.next
            l1 = l1.next

        while l2 is not None:
            val = l2.val + carry
            carry = 0
            if val >= 10:
                temp = val
                val %= 10
                carry += temp / 10
            point.next = ListNode(val)
            point = point.next
            l2 = l2.next

        if carry != 0:
            point.next = ListNode(carry)
            point = point.next
        return node.next



#======================================
# Single Number 284ms
'''
/*
 * @author:wangzq
 * @email:wangzhenqing1008@163.com
 * @date:2014年07月17日16:17:44
 * @url:https://oj.leetcode.com/problems/single-number/
 * 整个数组异或，结果就是只出现一次的那个数字
 * 具体参考http://blog.csdn.net/u013027996/article/details/17642559
 */
'''
class Solution:
    # @param A, a list of integer
    # @return an integer
    def singleNumber(self, A):
        alen = len(A)
        result = A[0]
        for i in range(1, alen, 1):
            result ^= A[i]
        return result



#======================================
# Climbing Stairs 120ms
'''
/*
 * @author:wangzq
 * @email:wangzhenqing1008@163.com
 * @date:2014年07月22日12:04:23
 * @url:https://oj.leetcode.com/problems/climbing-stairs/
 * 跳台阶，斐波那契序列。注意long以及使用非递归
 * 具体参考http://blog.csdn.net/u013027996/article/details/38038747
 */
 '''
class Solution:
    # @param n, an integer
    # @return an integer
    def climbStairs(self, n):
        if n == 1:
            return 1
        array = [0 for i in range(n+1)]
        array[1] = 1
        array[2] = 2
        for i in range(3, n+1):
            array[i] = array[i-1] + array[i-2]
        return array[n]



#======================================
# Maximum Subarray 300ms
'''
/*
 * @author:wangzq
 * @email:wangzhenqing1008@163.com
 * @date:2014年08月08日19:00:34
 * @url:https://oj.leetcode.com/problems/maximum-subarray/
 * 最大连续子数组和，非常经典
 * 具体参考http://blog.csdn.net/u013027996/article/details/38423167
 */
 '''
class Solution:
    # @param A, a list of integers
    # @return an integer
    def maxSubArray(self, A):
        if A is None or len(A) == 0:
            return 0
        a_len = len(A)
        maxSum = A[0]
        tempSum = 0
        for i in range(a_len):
            if tempSum < 0:
                tempSum = A[i]
            else:
                tempSum += A[i]
            if tempSum > maxSum:
                maxSum = tempSum
        return maxSum



#======================================
#Jump Game 312ms
'''
/*
* @author:wangzq
* @email:wangzhenqing1008@163.com
* @date:2014年08月27日15:11:42
* @url:https://oj.leetcode.com/problems/jump-game/
* 题目比较拗口，多读几遍，加强理解，求是否可达
* 具体参考http://blog.csdn.net/u013027996/article/details/38870915
*/
'''
class Solution:
    # @param A, a list of integers
    # @return a boolean
    def canJump(self, A):
        if not A:
            return False
        n = len(A)
        maxReach = 0
        i = 0
        while i < n and i <= maxReach:
            maxReach = max(i+A[i], maxReach)
            i += 1
            if maxReach >= n - 1:
                return True
        return False



#======================================
#Jump Game II 252ms
'''
/*
* @author:wangzq
* @email:wangzhenqing1008@163.com
* @date:2014年08月27日15:13:25
* @url:https://oj.leetcode.com/problems/jump-game-ii/
* 题目比较拗口，多读几遍，加强理解，求可达最短步数
* 具体参考http://blog.csdn.net/u013027996/article/details/38870915
*/
'''
class Solution:
    # @param A, a list of integers
    # @return an integer
    def jump(self, A):
        if not A:
            return 0
        n = len(A)
        maxReach = 0
        lastMaxReach = 0
        i = 0
        count = 0
        while i < n and i <= maxReach:
            if i > lastMaxReach:
                lastMaxReach = maxReach
                count += 1
            maxReach = max(i + A[i], maxReach)
            i += 1
        return count if maxReach >= n - 1 else 0



#======================================
#Length of Last Word 172ms
'''
/*
* @author:wangzq
* @email:wangzhenqing1008@163.com
* @date:2014年10月10日17:41:43
* @url:https://oj.leetcode.com/problems/length-of-last-word/
* 字符串处理基本功
* 具体参考http://blog.csdn.net/u013027996/article/details/39965939
*/
'''
class Solution:
    # @param s, a string
    # @return an integer
    def lengthOfLastWord(self, s):
        s = s.strip()
        sArr = s.split(' ')
        word = sArr[len(sArr)-1].strip()
        return len(word)



#======================================
#Remove Element 208ms
'''
/*
* @author:wangzq
* @email:wangzhenqing1008@163.com
* @date:2014年10月16日18:15:14
* @url:https://oj.leetcode.com/problems/remove-element/
* 扫描处理数组
* 具体参考http://blog.csdn.net/u013027996/article/details/40152421
*/
'''
class Solution:
    # @param    A       a list of integers
    # @param    elem    an integer, value need to be removed
    # @return an integer
    def removeElement(self, A, elem):
        a_len = len(A)
        start = 0
        for i in range(a_len):
            if A[i] != elem:
                A[start] = A[i]
                start += 1
        return start