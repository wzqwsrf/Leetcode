
// Substring with Concatenation of All Words

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * @author:wangzq
 * @email:wangzhenqing1008@163.com
 * @date:2015年04月21日23:25:55
 * @url:https://leetcode.com/problems/substring-with-concatenation-of-all-words/
 */

public class Substring_with_Concatenation_of_All_Words {
    public ArrayList<Integer> findSubstring(String S, String[] L) {
        ArrayList<Integer> list = new ArrayList<Integer>();
        int len = L.length;
        if (len == 0) {
            return list;
        }
        int wordLen = L[0].length();
        Map<String, Integer> wordsMap = new HashMap<String, Integer>();
        for (int i = 0; i < len; i++) {
            int num = 1;
            if (wordsMap.get(L[i]) != null) {
                num += wordsMap.get(L[i]);
            }
            wordsMap.put(L[i], num);
        }
        int slen = S.length();
        int max = slen - wordLen + 1;
        for (int i = 0; i < wordLen; i++) {
            Map<String, Integer> numMap = new HashMap<String, Integer>();
            int count = 0;
            int start = i;
            for (int end = start; end < max; end += wordLen) {
                String tempStr = S.substring(end, end + wordLen);
                if (!wordsMap.containsKey(tempStr)) {
                    numMap.clear();
                    count = 0;
                    start = end + wordLen;
                    continue;
                }
                int num = 1;
                if (numMap.containsKey(tempStr)) {
                    num += numMap.get(tempStr);
                }
                numMap.put(tempStr, num);
                if (num <= wordsMap.get(tempStr)) {
                    count++;
                } else {
                    while (numMap.get(tempStr) > wordsMap.get(tempStr)) {
                        tempStr = S.substring(start, start + wordLen);
                        numMap.put(tempStr, numMap.get(tempStr) - 1);
                        if (numMap.get(tempStr) < wordsMap.get(tempStr)) {
                            count--;
                        }
                        start += wordLen;
                    }
                }
                if (count == len) {
                    list.add(start);
                    tempStr = S.substring(start, start + wordLen);
                    numMap.put(tempStr, numMap.get(tempStr) - 1);
                    count--;
                    start += wordLen;
                }
            }
        }
        return list;
    }
}