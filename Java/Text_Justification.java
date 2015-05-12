
// Text Justification 444ms

import java.util.ArrayList;

/**
 * @author:wangzq
 * @email:wangzhenqing1008@163.com
 * @date:2015年05月12日18:01:17
 * @url:https://leetcode.com/problems/text-justification/
 */

public class Text_Justification {

    private int len;

    public ArrayList<String> fullJustify(String[] words, int L) {
        ArrayList<String> list = new ArrayList<String>();
        len = words.length;
        int numArr[] = new int[len];
        for (int i = 0; i < len; i++) {
            numArr[i] = words[i].length();
        }
        dfs(list, words, numArr, 0, L);
        int size = list.size();
        String lastLine = list.get(size - 1);
        list.remove(size - 1);
        lastLine = lastLine.trim().replaceAll("[ ]+", " ");
        int len = lastLine.length();
        while (len < L) {
            lastLine += " ";
            len++;
        }
        list.add(lastLine);
        return list;
    }

    private void dfs(ArrayList<String> list, String[] words, int[] numArr,
                     int start, int l) {
        if (start >= len) {
            return;
        }
        int tempLen = 0;
        int i = start;
        while (i < len && tempLen < l) {
            tempLen += numArr[i];
            tempLen += 1;
            i++;
        }
        if (i != start) {
            i--;
        }
        if (tempLen > l + 1) {
            tempLen -= numArr[i];
            tempLen -= 1;
            i -= 1;
        }
        int wordNum = i - start + 1;
        StringBuilder sb = new StringBuilder();
        if (tempLen == 0) {
            sb.append(words[start]);
            for (int j = 0; j < l; j++) {
                sb.append(" ");
            }
        } else {
            tempLen -= wordNum;
            int leftNum = l - tempLen;
            if (wordNum == 1) {
                sb.append(words[start]);
                for (int j = 0; j < leftNum; j++) {
                    sb.append(" ");
                }
            } else {
                int num1 = leftNum / (wordNum - 1);
                int num2 = leftNum % (wordNum - 1);
                for (int j = start; j < i; j++) {
                    sb.append(words[j]);
                    int k = 0;
                    while (k < num1) {
                        sb.append(" ");
                        k++;
                    }
                    if (num2 > 0) {
                        sb.append(" ");
                        num2--;
                    }
                }
                sb.append(words[i]);
            }
        }
        list.add(sb.toString());
        dfs(list, words, numArr, i + 1, l);
    }
}