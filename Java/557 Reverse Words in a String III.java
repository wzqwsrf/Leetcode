
// 557. Reverse Words in a String III

/**
 * @author:wangzq
 * @email:wangzhenqing1008@163.com
 * @date:2017-6-6 18:02:02
 * @url:https://leetcode.com/problems/reverse-words-in-a-string-iii/#/description
 */

public class Solution {
    public String reverseWords(String s) {
        int len = s.length();
        StringBuffer sb = new StringBuffer();
        String array[] = s.split(" ");
        int num = array.length;
        for (int i = 0; i < num; i++) {
            StringBuffer currSb = new StringBuffer(array[i]);
            sb.append(currSb.reverse().toString());
            sb.append(" ");
        }
        return sb.toString().trim();
    }
}