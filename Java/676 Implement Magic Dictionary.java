
// 676. Implement Magic Dictionary

/**
 * @author:wangzq
 * @email:wangzhenqing1008@163.com
 * @date:2017-9-12 16:01:10
 * @url:https://leetcode.com/problems/implement-magic-dictionary/description/
 */

class MagicDictionary {
    private List<String> list;

    /**
     * Initialize your data structure here.
     */
    public MagicDictionary() {
        list = new ArrayList<>();
    }

    /**
     * Build a dictionary through a list of words
     */
    public void buildDict(String[] dict) {
        for (String word : dict) {
            if (!list.contains(word)) {
                list.add(word);
            }
        }
    }

    /**
     * Returns if there is any word in the trie that equals
     * to the given word after modifying exactly one character
     */
    public boolean search(String word) {
        int len = word.length();
        for (String currWord : list) {
            if (currWord.length() == len) {
                int count = 0;
                for (int i = 0; i < len; i++) {
                    if (count > 1) {
                        break;
                    }
                    if (currWord.charAt(i) != word.charAt(i)) {
                        count++;
                    }
                }
                if (count == 1) {
                    return true;
                }
            }
        }
        return false;
    }
}

/**
 * Your MagicDictionary object will be instantiated and called as such:
 * MagicDictionary obj = new MagicDictionary();
 * obj.buildDict(dict);
 * boolean param_2 = obj.search(word);
 */