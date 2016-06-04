
// Reverse String

/**
 * @author:wangzq
 * @email:wangzhenqing1008@163.com
 * @date:2016-6-4 20:03:43
 * @url:https://leetcode.com/problems/power-of-four/
 */

public class Solution {
    public String reverseString(String s) {
        char array[] = s.toCharArray();
        int i = 0;
        int j = s.length() - 1;
        while(i < j){
            char c = array[i];
            array[i] = array[j];
            array[j] = c;
            i++;
            j--;
        }
        return String.valueOf(array);
    }
}