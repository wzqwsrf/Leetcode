
// Add Binary 444ms

/**
 * 题目：
 * Given two binary strings, return their sum (also a binary string).
   For example,
   a = "11"
   b = "1"
   Return "100".
 */

/**
 * @author:wangzq
 * @email:wangzhenqing1008@163.com
 * @date:2014年07月02日17:25:17
 * @url:https://oj.leetcode.com/problems/add-binary/
 * 1、二进制加法，最基本的还是将字符串转为字符数组，按位相加，注意进位问题。
 * 2、两个数相加的最大位数，是二者长度之中最大值或者最大值加1
 * 具体参考：http://blog.csdn.net/u013027996/article/details/36436901
 */

public class Add_Binary {
    public String addBinary(String a, String b) {
        if (a == null || b == null) {
            return "";
        }
        if ("".equals(a) || "".equals(b)) {
            return "";
        }
        if ("".equals(a.replaceAll("0", ""))
                && "".equals(b.replaceAll("0", ""))) {
            return "0";
        }
        int len1 = a.length();
        int len2 = b.length();
        char arrayA[] = a.toCharArray();
        char arrayB[] = b.toCharArray();
        int maxLen = Math.max(len1, len2);
        int array[] = new int[maxLen + 1];
        int k = maxLen;
        while (len1 > 0 && len2 > 0) {
            array[k] += arrayA[len1 - 1] - '0' + arrayB[len2 - 1] - '0';
            if (array[k] >= 2) {
                array[k] -= 2;
                array[k - 1] += 1;
            }
            k--;
            len1--;
            len2--;
        }
        while (len1 > 0) {
            array[k] += arrayA[len1 - 1] - '0';
            if (array[k] >= 2) {
                array[k] -= 2;
                array[k - 1] += 1;
            }
            len1--;
            k--;
        }
        while (len2 > 0) {
            array[k] += arrayB[len2 - 1] - '0';
            if (array[k] >= 2) {
                array[k] -= 2;
                array[k - 1] += 1;
            }
            len2--;
            k--;
        }
        StringBuffer sb = new StringBuffer();
        int i = 0;
        if (array[0] == 0) {
            i = 1;
        }
        for (; i < maxLen + 1; i++) {
            sb.append(array[i]);
        }
        return sb.toString();
    }
}

