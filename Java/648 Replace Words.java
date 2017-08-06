
// 648. Replace Words

/**
 * @author:wangzq
 * @email:wangzhenqing1008@163.com
 * @date:2017-08-06 11:21:41
 * @url:https://leetcode.com/problems/replace-words/description/
 */

public class Solution {
    public String replaceWords(List<String> dict, String sentence) {
        Collections.sort(dict, new Comparator<String>() {
            public int compare(String o1, String o2) {
                return o1.length() - o2.length();
            }
        });
        StringBuilder sb = new StringBuilder();
        String array[] = sentence.split(" ");
        int len = array.length;
        int visited[] = new int[len];
        for (String root : dict) {
            for (int i = 0; i < len; i++) {
                if (visited[i] == 0 && array[i].startsWith(root)) {
                    visited[i] = 1;
                    array[i] = root;
                }
            }
        }
        for (int i = 0; i < len; i++) {
            sb.append(array[i] + " ");
        }
        return sb.toString().trim();
    }
}