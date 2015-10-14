
// Word Pattern

/**
 * @author:wangzq
 * @email:wangzhenqing1008@163.com
 * @date:2015年10月14日10:36:35
 * @url:https://leetcode.com/problems/word-pattern/
 */

public class Solution {
    public boolean wordPattern(String pattern, String str) {
        String strArray[] = str.split(" ");
        int sLen = strArray.length;
        int len = pattern.length();
        if (len != sLen) {
            return false;
        }
        Map<Character, String> map = new HashMap<Character, String>();
        Set<String> set = new HashSet<String>();
        for (int i = 0; i < len; i++) {
            char c = pattern.charAt(i);
            if (map.containsKey(c)) {
                String aStr = map.get(c);
                if (!aStr.equals(strArray[i])) {
                    return false;
                }
            } else {
                if (set.contains(strArray[i])) {
                    return false;
                }
                map.put(c, strArray[i]);
                set.add(strArray[i]);
            }
        }
        return true;
    }
}