
//Word Search II

import java.util.ArrayList;
import java.util.List;

/**
 * @author:wangzq
 * @email:wangzhenqing1008@163.com
 * @date:2015年06月23日14:12:57
 * @url:https://leetcode.com/problems/word-search-ii/
 */

public class Word_Search_II {
    private int m, n;
    private int visit[][];
    private Trie trie;
    private List<String> list;

    public List<String> findWords(char[][] board, String[] words) {
        list = new ArrayList<String>();
        if (words == null || words.length == 0) {
            return list;
        }
        trie = new Trie();
        for (String word : words) {
            trie.insert(word);
        }
        m = board.length;
        n = board[0].length;
        visit = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                dfs(board, i, j, 0, "");
            }
        }
        return list;
    }

    private void dfs(char board[][], int startx, int starty,
                     int k, String res) {
        if (startx < 0 || startx >= m
                || starty < 0 || starty >= n
                || visit[startx][starty] == 1) {
            return;
        }
        res += board[startx][starty];
        if (!trie.startsWith(res)) {
            return;
        }
        if (trie.search(res) && !list.contains(res)) {
            list.add(res);
        }
        visit[startx][starty] = 1;
        dfs(board, startx - 1, starty, k + 1, res);
        dfs(board, startx + 1, starty, k + 1, res);
        dfs(board, startx, starty - 1, k + 1, res);
        dfs(board, startx, starty + 1, k + 1, res);
        visit[startx][starty] = 0;
    }
}

class TrieNode {
    // Initialize your data structure here.
    boolean isEnd;
    TrieNode children[];

    public TrieNode() {
        isEnd = false;
        children = new TrieNode[26];
    }
}

class Trie {
    private TrieNode root;

    public Trie() {
        root = new TrieNode();
    }

    // Inserts a word into the trie.
    public void insert(String word) {
        if (search(word)) {
            return;
        }
        TrieNode children[] = root.children;
        int len = word.length();
        for (int i = 0; i < len; i++) {
            char c = word.charAt(i);
            int num = c - 'a';
            if (children == null) {
                children = new TrieNode[26];
            }
            if (children[num] == null) {
                children[num] = new TrieNode();
            }
            if (i == len - 1) {
                children[num].isEnd = true;
            }
            children = children[num].children;
        }
    }

    // Returns if the word is in the trie.
    public boolean search(String word) {
        TrieNode children[] = root.children;
        int len = word.length();
        for (int i = 0; i < len; i++) {
            int num = word.charAt(i) - 'a';
            if (children[num] == null) {
                return false;
            }
            if (i == len - 1) {
                return children[num].isEnd;
            } else {
                children = children[num].children;
            }
        }
        return true;
    }

    // Returns if there is any word in the trie
    // that starts with the given prefix.
    public boolean startsWith(String prefix) {
        TrieNode children[] = root.children;
        int len = prefix.length();
        for (int i = 0; i < len; i++) {
            int num = prefix.charAt(i) - 'a';
            if (children[num] == null) {
                return false;
            }
            children = children[num].children;
        }
        return true;
    }
}
