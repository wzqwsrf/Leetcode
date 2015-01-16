
//Length of Last Word 380ms

/**
 * Given a string s consists of upper/lower-case alphabets and empty space characters ' ',
 * return the length of last word in the string.
 * If the last word does not exist, return 0.
 * Note: A word is defined as a character sequence consists of non-space characters only.
 * For example,
 * Given s = "Hello World",
 * return 5.
 */

/**
 * @author:wangzq
 * @email:wangzhenqing1008@163.com
 * @date:2014年10月10日17:41:43
 * @url:https://oj.leetcode.com/problems/length-of-last-word/
 * 字符串处理基本功
 * 具体参考http://blog.csdn.net/u013027996/article/details/39965939
 */

public class Length_of_Last_Word {
    public int lengthOfLastWord(String s) {
        s = s.trim();
        String sArr[] = s.split(" ");
        String word = sArr[sArr.length - 1].trim();
        return word.length();
    }
}