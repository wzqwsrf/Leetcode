
// Anagrams

/**
 * @author:wangzq
 * @email:wangzhenqing1008@163.com
 * @date:2015年04月22日23:02:33
 * @url:https://leetcode.com/problems/anagrams/
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Solution {

    public ArrayList<String> anagrams(String[] strs) {
        ArrayList<String> list = new ArrayList<String>();
        int len = strs.length;
        Map<String, Integer> wordMap = new HashMap<String, Integer>();
        int visit[] = new int[len];
        for (int i = 0; i < len; i++) {
            char array[] = strs[i].toCharArray();
            Arrays.sort(array);
            String newStr = new String(array);
            Integer index;
            if ((index = wordMap.get(newStr)) != null) {
                if (visit[index] == 0) {
                    list.add(strs[index]);
                    visit[index] = 1;
                }
                list.add(strs[i]);
            } else {
                wordMap.put(newStr, i);
            }
        }
        return list;
    }
}