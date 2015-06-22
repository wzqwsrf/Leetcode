
//Basic Calculator II

import java.util.*;

/**
 * @author:wangzq
 * @email:wangzhenqing1008@163.com
 * @date:2015年06月22日23:17:35
 * @url:https://leetcode.com/problems/basic-calculator-ii/
 */

public class Basic_Calculator_II {

    public int calculate(String s) {
        if (s == null || "".equals(s.trim())) {
            return 0;
        }
        s = s.replaceAll("\\s", "");
        List<Long> list1 = new ArrayList<Long>();
        List<Character> list2 = new ArrayList<Character>();
        int len = s.length();
        int i = 0;
        while (i < len) {
            char c = s.charAt(i);
            if (c >= '0' && c <= '9') {
                long array[] = getNum(s, i);
                list1.add(array[0]);
                i = (int) array[1];
            } else if (c == '+' || c == '-') {
                list2.add(c);
            } else if (c == '*' || c == '/') {
                int size = list1.size();
                long num1 = list1.get(size - 1);
                long array[] = getNum(s, i + 1);
                long num2 = array[0];
                i = (int) array[1];
                long num = c == '*' ? num1 * num2 : num1 / num2;
                list1.set(size - 1, num);
            }
            i++;
        }
        int size1 = list1.size();
        int size2 = list2.size();
        long preNum = list1.get(0);
        for (i = 0; i < size2; i++) {
            if (list2.get(i) == '+') {
                preNum += list1.get(i + 1);
            } else {
                preNum -= list1.get(i + 1);
            }
        }
        return (int) preNum;
    }

    private long[] getNum(String s, int curPos) {
        StringBuffer sb = new StringBuffer();
        int len = s.length();
        while (curPos < len && s.charAt(curPos) >= '0'
                && s.charAt(curPos) <= '9') {
            sb.append(s.charAt(curPos));
            curPos++;
        }
        String newStr = sb.toString();
        if (newStr.length() > 0) {
            return new long[]{Long.parseLong(newStr), curPos - 1};
        }
        return new long[]{0, curPos - 1};
    }
}