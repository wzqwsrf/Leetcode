
// Repeated DNA Sequences 416ms

import java.util.*;

/**
 * @author:wangzq
 * @email:wangzhenqing1008@163.com
 * @date:2015年05月27日10:12:56
 * @url:https://leetcode.com/problems/repeated-dna-sequences/
 */

public class Repeated_DNA_Sequences {
    public class Solution {
        public List<String> findRepeatedDnaSequences(String s) {
            int len = s.length();
            List<String> list = new ArrayList<String>();
            Map<String, Integer> map = new HashMap<String, Integer>();
            for (int i = 0; i < len - 9; i++) {
                String tempS = s.substring(i, i + 10);
                int num = 1;
                if (map.containsKey(tempS)) {
                    num += map.get(tempS);
                }
                if (num > 1 && !list.contains(tempS)) {
                    list.add(tempS);
                }
                map.put(tempS, num);
            }
            return list;
        }
    }
}
