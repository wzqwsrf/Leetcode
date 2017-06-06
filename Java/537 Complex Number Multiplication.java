
// 537. Complex Number Multiplication

/**
 * @author:wangzq
 * @email:wangzhenqing1008@163.com
 * @date:2017-6-6 17:55:44
 * @url:https://leetcode.com/problems/complex-number-multiplication/#/description
 */

public class Solution {
    public String complexNumberMultiply(String a, String b) {
        String arrayA[] = a.split("\\+");
        String arrayB[] = b.split("\\+");
        int a1, b1, a2, b2;
        a1 = Integer.parseInt(arrayA[0]);
        a2 = Integer.parseInt(arrayA[1].replace("i", ""));
        b1 = Integer.parseInt(arrayB[0]);
        b2 = Integer.parseInt(arrayB[1].replace("i", ""));
        int ares = a1 * b1 + a2 * b2 * -1;
        int bres = a1 * b2 + a2 * b1;
        return ares + "+" + String.valueOf(bres) + "i";
    }
}