
// 500. Keyboard Row

/**
 * @author:wangzq
 * @email:wangzhenqing1008@163.com
 * @date:2017-6-7 12:58:49
 * @url:https://leetcode.com/problems/keyboard-row/#/description
 */

public class Solution {
    public String[] findWords(String[] words) {
        int array[] = new int[26];
        char first[] = new char[]{'q', 'w', 'e', 'r', 't', 'y', 'u', 'i', 'o', 'p'};
        char second[] = new char[]{'a', 's', 'd', 'f', 'g', 'h', 'j', 'k', 'l'};
        char three[] = new char[]{'z', 'x', 'c', 'v', 'b', 'n', 'm'};
        for (int i = 0; i < first.length; i++) {
            array[first[i] - 'a'] = 1;
        }
        for (int i = 0; i < second.length; i++) {
            array[second[i] - 'a'] = 2;
        }
        for (int i = 0; i < three.length; i++) {
            array[three[i] - 'a'] = 3;
        }
        int len = words.length;
        List<String> list = new ArrayList<>();
        for (int i = 0; i < len; i++) {
            String word = words[i];
            int wlen = word.length();
            String tempWord = word.toLowerCase();
            int index = array[tempWord.charAt(0) - 'a'];
            boolean flag = true;
            for (int j = 1; j < wlen; j++) {
                if (array[tempWord.charAt(j) - 'a'] != index) {
                    flag = false;
                    break;
                }
            }
            if (flag) {
                list.add(word);
            }
        }
        int size = list.size();
        String resArr[] = new String[size];
        for (int i = 0; i < size; i++) {
            resArr[i] = list.get(i);
        }
        return resArr;
    }
}