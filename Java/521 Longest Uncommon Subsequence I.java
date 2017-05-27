
// 521. Longest Uncommon Subsequence I

/**
 * @author:wangzq
 * @email:wangzhenqing1008@163.com
 * @date:2017-5-27 18:55:29
 * @url:https://leetcode.com/problems/longest-uncommon-subsequence-i/#/description
 */

public class Solution {
    public int findLUSlength(String a, String b) {
        return a.equals(b) ? -1 : Math.max(a.length(), b.length());
    }
}