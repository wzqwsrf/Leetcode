
// Letter Combinations of a Phone Number

import java.util.ArrayList;

/**
 * @author:wangzq
 * @email:wangzhenqing1008@163.com
 * @date:2015年04月19日22:07:43
 * @url:https://leetcode.com/problems/letter-combinations-of-a-phone-number/
 */

public class Letter_Combinations_of_a_Phone_Number {
    public String array[] = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};

    public ArrayList<String> letterCombinations(String digits) {
        ArrayList<String> list = new ArrayList<String>();
        if (digits == null) {
            return list;
        }
        char numArr[] = digits.toCharArray();
        int len = digits.length();
        StringBuffer sb = new StringBuffer();
        dfs(list, sb, 0, numArr, len);
        return list;
    }

    public void dfs(ArrayList<String> list, StringBuffer sb,
                    int tempLen, char numArr[], int len) {
        if (tempLen == len) {
            list.add(sb.toString());
            return;
        }
        if (numArr[tempLen] >= '0' && numArr[tempLen] <= '9') {
            String tempStr = array[numArr[tempLen] - '0'];
            int strLen = tempStr.length();
            for (int i = 0; i < strLen; i++) {
                StringBuffer newsb = new StringBuffer(sb);
                newsb.append(String.valueOf(tempStr.charAt(i)));
                dfs(list, newsb, tempLen + 1, numArr, len);
            }
        } else {
            StringBuffer newsb = new StringBuffer(sb);
            newsb.append(String.valueOf(numArr[tempLen]));
            dfs(list, newsb, tempLen + 1, numArr, len);
        }
    }
}