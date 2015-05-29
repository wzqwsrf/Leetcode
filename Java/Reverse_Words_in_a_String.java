
//Reverse Words in a String

/**
 * @author:wangzq
 * @email:wangzhenqing1008@163.com
 * @date:2015年05月29日17:12:17
 * @url:https://leetcode.com/problems/reverse-words-in-a-string/
 */

public class Reverse_Words_in_a_String {
    public String reverseWords(String s) {
        s = s.trim().replaceAll("[ ]+", " ");
        String sArr[] = s.split(java.util.regex.Pattern.quote(" "));
        StringBuffer sb = new StringBuffer();
        int len = sArr.length;
        for (int i = len - 1; i >= 0; i--) {
            sb.append(sArr[i] + " ");
        }
        return sb.toString().trim();
    }
}