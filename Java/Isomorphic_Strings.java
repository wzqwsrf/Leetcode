
//Isomorphic Strings

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @author:wangzq
 * @email:wangzhenqing1008@163.com
 * @date:2015年05月29日16:58:13
 * @url:https://leetcode.com/problems/isomorphic-strings/
 */

public class Isomorphic_Strings {
    public boolean isIsomorphic(String s, String t) {
        int len = s.length();
        Map<Character, Character> stMap = new HashMap<Character, Character>();
        Set<Character> set = new HashSet<Character>();
        for (int i = 0; i < len; i++) {
            if (!stMap.containsKey(s.charAt(i))) {
                if (set.contains(t.charAt(i))) {
                    return false;
                }
                stMap.put(s.charAt(i), t.charAt(i));
                set.add(t.charAt(i));
            } else {
                char newt = stMap.get(s.charAt(i));
                if (newt != t.charAt(i)) {
                    return false;
                }
            }
        }
        return true;
    }
}