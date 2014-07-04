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
        
        