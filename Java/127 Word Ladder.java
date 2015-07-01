
// Word Ladder

/**
 * @author:wangzq
 * @email:wangzhenqing1008@163.com
 * @date:2015年06月20日15:50:54
 * @url:https://leetcode.com/problems/word-ladder/
 */

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

public class Solution {
    public static int ladderLength(String start, String end,
                                   HashSet<String> dict) {
        if (dict == null || dict.isEmpty()) {
            return 0;
        }
        Queue<Node> strQueue = new LinkedList<Node>();
        HashSet<String> visitedSet = new HashSet<String>();
        strQueue.add(new Node(start, 0));
        visitedSet.add(start);
        int wordLen = start.length();
        while (!strQueue.isEmpty()) {
            Node node = strQueue.peek();
            strQueue.poll();
            for (int i = 0; i < wordLen; i++) {
                StringBuffer sb = new StringBuffer(node.word);
                for (char j = 'a'; j <= 'z'; j++) {
                    sb.setCharAt(i, j);
                    String tempWord = sb.toString();
                    if (dict.contains(tempWord) &&
                            !visitedSet.contains(tempWord)) {
                        if (tempWord.equals(end)) {
                            return node.len + 2;
                        } else {
                            strQueue.add(new Node(tempWord, node.len + 1));
                            visitedSet.add(tempWord);
                        }
                    }
                }
            }
        }
        return 0;
    }

    private static class Node {
        String word;
        int len;

        public Node(String word, int len) {
            super();
            this.word = word;
            this.len = len;
        }
    }
}