
// 455. Assign Cookies

/**
 * @author:wangzq
 * @email:wangzhenqing1008@163.com
 * @date:2017-8-21 22:10:14
 * @url:https://leetcode.com/problems/assign-cookies/description/
 */

class Solution {
    public int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);
        int len1 = g.length;
        int len2 = s.length;
        int i = 0;
        int j = 0;
        while (i < len1 && j < len2) {
            if (s[j] >= g[i]) {
                i++;
            }
            j++;
        }
        return i;
    }
}