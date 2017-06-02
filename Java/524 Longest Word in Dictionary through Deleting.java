
// 524. Longest Word in Dictionary through Deleting

/**
 * @author:wangzq
 * @email:wangzhenqing1008@163.com
 * @date:2017-6-2 18:33:45
 * @url:https://leetcode.com/problems/longest-word-in-dictionary-through-deleting/#/description
 */

public class Solution {
    public String findLongestWord(String s, List<String> d) {
        Collections.sort(d, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                if (o1.length() == o2.length()) {
                    return o1.compareTo(o2);
                }
                return o2.length() - o1.length();
            }
        });
        int size = d.size();
        int len1 = s.length();
        for (int i = 0; i < size; i++) {
            String currStr = d.get(i);
            int len2 = currStr.length();
            if (len1 < len2) {
                continue;
            }
            int j = 0;
            int k = 0;
            while (j < len1 && k < len2) {
                if (s.charAt(j) == currStr.charAt(k)) {
                    k++;
                }
                j++;
            }
            if (k == len2) {
                return currStr;
            }
        }
        return "";
    }
}