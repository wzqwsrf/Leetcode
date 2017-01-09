
// 451. Sort Characters By Frequency

/**
 * @author:wangzq
 * @email:wangzhenqing1008@163.com
 * @date:2017-1-9 14:37:07
 * @url:https://leetcode.com/problems/sort-characters-by-frequency/
 */

public class Solution {
    public String frequencySort(String s) {
        int len = s.length();
        Map<Character, Integer> map = new HashMap<Character, Integer>();
        for (int i = 0; i < len; i++) {
            char c = s.charAt(i);
            Integer num = map.get(c);
            if (num != null) {
                num += 1;
            } else {
                num = 1;
            }
            map.put(c, num);
        }
        List<Character>[] array = new ArrayList[len + 1];
        for (Map.Entry<Character, Integer> entry : map.entrySet()) {
            Character key = entry.getKey();
            Integer value = entry.getValue();
            if (array[value] == null) {
                array[value] = new ArrayList<Character>();
            }
            array[value].add(key);
        }
        StringBuilder sb = new StringBuilder();
        for (int i = len; i >= 0; i--) {
            if (array[i] == null) {
                continue;
            }
            for (Character c : array[i]) {
                for (int j = 0; j < i; j++) {
                    sb.append(c);
                }
            }
        }
        return sb.toString();
    }
}