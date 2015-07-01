
// Implement Trie (Prefix Tree)

/**
 * @author:wangzq
 * @email:wangzhenqing1008@163.com
 * @date:2015年06月23日11:34:48
 * @url:https://leetcode.com/problems/implement-trie-prefix-tree/
 */

public class Solution {

    class TrieNode {
        // Initialize your data structure here.
        boolean isEnd;
        TrieNode children[];

        public TrieNode() {
            isEnd = false;
            children = new TrieNode[26];
        }
    }

    public class Trie {
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

// Your Trie object will be instantiated and called as such:
// Trie trie = new Trie();
// trie.insert("somestring");
// trie.search("key");
}