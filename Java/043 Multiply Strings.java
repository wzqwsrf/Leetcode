
// Multiply Strings

/**
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

public class Solution {

    public String multiply(String num1, String num2) {
        if ("".equals(num1.replace("0", ""))
                || "".equals(num2.replace("0", ""))) {
            return "0";
        }
        int len1 = num1.length();
        int len2 = num2.length();
        char arrayA[];
        char arrayB[];
        arrayA = num1.toCharArray();
        arrayB = num2.toCharArray();
        int column = len1 + len2;
        int array[] = new int[column];
        int k = column;
        for (int i = len2 - 1; i >= 0; i--) {
            k--;
            int tempCol = k;
            int tempArr[] = new int[column];
            int num = arrayB[i] - '0';
            for (int j = len1 - 1; j >= 0; j--) {
                tempArr[tempCol] += (arrayA[j] - '0') * num;
                if (tempArr[tempCol] >= 10) {
                    int mod = tempArr[tempCol] / 10;
                    tempArr[tempCol] %= 10;
                    tempArr[tempCol - 1] += mod;
                }
                tempCol--;
            }
            array = addNum(tempArr, array, column);
        }
        StringBuffer sb = new StringBuffer();
        int i = 0;
        if (array[0] == 0) {
            i = 1;
        }
        for (; i < column; i++) {
            sb.append(array[i]);
        }
        return sb.toString();
    }

    public int[] addNum(int tempArr[], int array[], int column) {
        for (int i = column - 1; i >= 0; i--) {
            array[i] += tempArr[i];
            if (array[i] >= 10) {
                array[i] -= 10;
                array[i - 1] += 1;
            }
        }
        return array;
    }
}
