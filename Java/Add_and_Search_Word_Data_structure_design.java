
//Add and Search Word - Data structure design

/**
 * @author:wangzq
 * @email:wangzhenqing1008@163.com
 * @date:2015年06月23日17:21:44
 * @url:https://leetcode.com/problems/add-and-search-word-data-structure-design/
 */

public class Add_and_Search_Word_Data_structure_design {

    class TrieNode {
        // Initialize your data structure here.
        boolean isEnd;
        TrieNode children[];

        public TrieNode() {
            isEnd = false;
            children = new TrieNode[26];
        }
    }

    public class WordDictionary {

        private TrieNode root;

        public WordDictionary() {
            root = new TrieNode();
        }

        // Adds a word into the data structure.
        public void addWord(String word) {
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

        // Returns if the word is in the data structure. A word could
        // contain the dot character '.' to represent any one letter.
        public boolean search(String word) {
            return dfs(word, root, 0);
        }

        public boolean dfs(String word, TrieNode root, int start) {
            TrieNode children[] = root.children;
            int len = word.length();
            for (int i = start; i < len; i++) {
                char c = word.charAt(i);
                if (c == '.') {
                    for (int j = 0; j < 26; j++) {
                        if (children[j] != null) {
                            boolean flag = true;
                            if (i == len - 1) {
                                flag = children[j].isEnd;
                            } else {
                                flag = dfs(word, children[j], i + 1);
                            }
                            if (flag) {
                                return true;
                            }
                        }
                    }
                    return false;
                } else {
                    int num = c - 'a';
                    if (children[num] == null) {
                        return false;
                    }
                    if (i == len - 1) {
                        return children[num].isEnd;
                    } else {
                        children = children[num].children;
                    }
                }

            }
            return true;
        }
    }

// Your WordDictionary object will be instantiated and called as such:
// WordDictionary wordDictionary = new WordDictionary();
// wordDictionary.addWord("word");
// wordDictionary.search("pattern");
}