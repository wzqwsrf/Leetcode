
// 640. Solve the Equation

/**
 * @author:wangzq
 * @email:wangzhenqing1008@163.com
 * @date:2017-7-14 18:58:40
 * @url:https://leetcode.com/problems/solve-the-equation/#/description
 */

public class Solution {
    public String solveEquation(String equation) {
        int len = equation.length();
        int xnum = 0;
        int num = 0;
        int index = equation.indexOf("=");
        for (int i = 0; i < len; i++) {
            if (equation.charAt(i) == '=') {
                continue;
            }
            int flag1 = i < index ? 1 : -1;
            int prefix = i == 0 ? i : i - 1;
            int flag2 = equation.charAt(prefix) == '-' ? -1 : 1;
            StringBuilder sb = new StringBuilder();
            while (i < len && equation.charAt(i) != '+'
                    && equation.charAt(i) != '-'
                    && equation.charAt(i) != '=') {
                sb.append(equation.charAt(i));
                i++;
            }
            String tempStr = sb.toString();
            if (tempStr.length() == 0) {
                continue;
            }
            if (tempStr.contains("x")) {
                if (tempStr.replace("x", "").equals("")) {
                    tempStr += "1";
                }
                xnum += flag1 * flag2 * Integer.parseInt(tempStr.replace("x", ""));
            } else {
                num += -flag1 * flag2 * Integer.parseInt(tempStr);
            }
        }
        if (xnum == 0) {
            return num == 0 ? "Infinite solutions" : "No solution";
        }
        return "x=" + String.valueOf(num / xnum);
    }
}