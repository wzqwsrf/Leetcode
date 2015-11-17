
// Bulls and Cows

/**
 * @author:wangzq
 * @email:wangzhenqing1008@163.com
 * @date:2015-11-17 17:53:54
 * @url:https://leetcode.com/problems/bulls-and-cows/
 */

public class Solution {
    public String getHint(String secret, String guess) {
        int len = secret.length();
        int num1 = 0;
        int num2 = 0;
        int array1[] = new int[10];
        int array2[] = new int[10];
        for (int i = 0; i < len; i++) {
            if (secret.charAt(i) == guess.charAt(i)) {
                num1++;
            } else {
                array1[secret.charAt(i) - '0']++;
                array2[guess.charAt(i) - '0']++;
            }
        }
        for (int i = 0; i < 10; i++) {
            num2 += Math.min(array1[i], array2[i]);
        }
        return num1 + "A" + num2 + "B";
    }
}

//解法二
public class Solution {
    public String getHint(String secret, String guess) {
        int len1 = secret.length();
        int len2 = guess.length();
        int num1 = 0;
        int num2 = 0;
        Map<Character, Integer> map = new HashMap<Character, Integer>();
        int visit[] = new int[len1];
        for (int i = 0; i < len1; i++) {
            if (secret.charAt(i) == guess.charAt(i)) {
                visit[i] = 1;
                num1++;
            } else {
                int num = 1;
                char c = secret.charAt(i);
                if (map.containsKey(c)) {
                    num += map.get(c);
                }
                map.put(c, num);
            }
        }
        for (int i = 0; i < len2; i++) {
            if (visit[i] == 0) {
                char c = guess.charAt(i);
                if (map.containsKey(c)) {
                    int num = map.get(c);
                    if (num >= 1) {
                        num2++;
                        map.put(c, num - 1);
                    }
                }
            }
        }
        return num1 + "A" + num2 + "B";
    }
}