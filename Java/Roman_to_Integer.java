
// Roman to Integer 278ms


/**
 * @author:wangzq
 * @email:wangzhenqing1008@163.com
 * @date:2015年04月16日10:26:40
 * @url:https://leetcode.com/problems/roman-to-integer/
 */

public class Roman_to_Integer {
    public int numMap[];

    public int romanToInt(String s) {
        initMap();
        if (s == null || "".equals(s)) {
            return 0;
        }
        int len = s.length();
        int allNum = 0;
        allNum += numMap[s.charAt(0)];
        for (int i = 1; i < len; i++) {
            allNum += numMap[s.charAt(i)];
            if (numMap[s.charAt(i)] > numMap[s.charAt(i - 1)]) {
                allNum -= 2 * numMap[s.charAt(i - 1)];
            }
        }
        return allNum;
    }

    public void initMap() {
        numMap = new int[100];
        numMap['I'] = 1;
        numMap['V'] = 5;
        numMap['X'] = 10;
        numMap['L'] = 50;
        numMap['C'] = 100;
        numMap['D'] = 500;
        numMap['M'] = 1000;
    }
}

