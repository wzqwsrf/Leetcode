
// 522. Longest Uncommon Subsequence II

/**
 * @author:wangzq
 * @email:wangzhenqing1008@163.com
 * @date:2017-5-27 18:54:24
 * @url:https://leetcode.com/problems/longest-uncommon-subsequence-ii/#/description
 */

public class Solution {
    private Set<String> set;

    public int findLUSlength(String[] strs) {
        set = new HashSet<String>();
        Map<String, Integer> map = new HashMap<String, Integer>();
        int len = strs.length;
        for (int i = 0; i < len; i++) {
            Integer num = map.get(strs[i]);
            if (num == null) {
                num = 1;
            } else {
                num += 1;
                set.add(strs[i]);
            }
            map.put(strs[i], num);
        }
        int maxLen = -1;
        for (int i = 0; i < len; i++) {
            Integer num = map.get(strs[i]);
            if (num == 1) {
                if (isSubseq(strs[i])) {
                    continue;
                }
                int curLen = strs[i].length();
                maxLen = maxLen > curLen ? maxLen : curLen;
            }
        }
        return maxLen;
    }

    private boolean isSubseq(String curStr) {
        boolean flag = false;
        int len1 = curStr.length();
        for (String str : set) {
            int j = 0;
            int k = 0;
            int len2 = str.length();
            if (len1 > len2) {
                return flag;
            }
            while (j < len2 && k < len1) {
                if (curStr.charAt(k) == str.charAt(j)) {
                    k++;
                }
                j++;
            }
            if (k == len1) {
                flag = true;
                break;
            }
        }
        return flag;
    }
}