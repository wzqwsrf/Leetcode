
// Length of Last Word

/**
 * @author:wangzq
 * @email:wangzhenqing1008@163.com
 * @date:2014年10月10日17:41:43
 * @url:https://oj.leetcode.com/problems/length-of-last-word/
 * 字符串处理基本功
 * 具体参考http://blog.csdn.net/u013027996/article/details/39965939
 */

public class Solution {

    public int lengthOfLastWord(String s) {
        s = s.trim();
        String sArr[] = s.split(" ");
        String word = sArr[sArr.length - 1].trim();
        return word.length();
    }
}