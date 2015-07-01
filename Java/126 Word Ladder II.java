
// Word Ladder II

/**
 * @author:wangzq
 * @email:wangzhenqing1008@163.com
 * @date:2015年06月20日15:52:44
 * @url:https://leetcode.com/problems/word-ladder-ii/
 */

import java.util.*;

public class Solution {

    private ArrayList<ArrayList<String>> list = new ArrayList<ArrayList<String>>();

    private Map<String, List<String>> map = new HashMap<String, List<String>>();

    public ArrayList<ArrayList<String>> findLadders(String start,
                                                    String end,
                                                    HashSet<String> dict) {

        if (dict == null || dict.isEmpty()) {
            return list;
        }

        Queue<String> strQueue = new LinkedList<String>();
        strQueue.add(start);
        Map<String, Integer> levelMap = new HashMap<String, Integer>();
        levelMap.put(start, 0);
        int wordLen = start.length();
        boolean found = false;
        while (!strQueue.isEmpty() && !found) {
            int size = strQueue.size();
            while (size > 0) {
                size--;
                String newWord = strQueue.poll();
                int len = levelMap.get(newWord);
                for (int i = 0; i < wordLen; i++) {
                    StringBuilder sb = new StringBuilder(newWord);
                    for (char j = 'a'; j <= 'z'; j++) {
                        sb.setCharAt(i, j);
                        String tempWord = sb.toString();
                        if (tempWord.equals(end)) {
                            found = true;
                            constructMap(tempWord, newWord);
                        } else if (!found && dict.contains(tempWord)) {
                            if (!levelMap.containsKey(tempWord)) {
                                levelMap.put(tempWord, len + 1);
                                strQueue.add(tempWord);
                                constructMap(tempWord, newWord);
                            } else if (levelMap.containsKey(tempWord)
                                    && levelMap.get(tempWord) == len + 1) {
                                constructMap(tempWord, newWord);
                            }

                        }
                    }
                }
            }
        }
        if (map.size() == 0) {
            return list;
        }
        List<String> path = new ArrayList<String>();
        path.add(end);
        dfs(end, path);
        return list;
    }

    private void constructMap(String curWord, String lastWord) {
        List<String> preList = map.get(curWord);
        if (preList == null) {
            preList = new ArrayList<String>();
        }
        if (!preList.contains(lastWord)) {
            preList.add(lastWord);
        }
        map.put(curWord, preList);
    }

    private void dfs(String end, List<String> path) {
        List<String> preList = map.get(end);
        if (preList == null) {
            ArrayList<String> newList = new ArrayList<String>();
            for (int i = path.size() - 1; i >= 0; i--) {
                newList.add(path.get(i));
            }
            list.add(newList);
        } else {
            for (String s : preList) {
                path.add(s);
                dfs(s, path);
                path.remove(s);
            }
        }
    }
}