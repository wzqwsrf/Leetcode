
// 383. Ransom Note

/**
 * @author:wangzq
 * @email:wangzhenqing1008@163.com
 * @date:2017-1-12 10:57:43
 * @url:https://leetcode.com/problems/ransom-note/
 */

public class Solution {
    public boolean canConstruct(String ransomNote, String magazine) {
        if (ransomNote.equals(magazine)) {
            return true;
        }
        if (magazine == null || "".equals(magazine)) {
            return false;
        }
        int array[] = new int[26];
        for (int i = 0; i < magazine.length(); i++) {
            char c = magazine.charAt(i);
            array[c - 'a']++;
        }
        for (int i = 0; i < ransomNote.length(); i++) {
            char c = ransomNote.charAt(i);
            if (array[c - 'a'] == 0) {
                return false;
            }
            array[c - 'a']--;
        }
        return true;
    }
}