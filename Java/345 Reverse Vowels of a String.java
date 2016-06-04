
// Reverse Vowels of a String

/**
 * @author:wangzq
 * @email:wangzhenqing1008@163.com
 * @date:2016-6-4 20:04:27
 * @url:https://leetcode.com/problems/reverse-vowels-of-a-string/
 */

public class Solution {
    public String reverseVowels(String s) {
        char array[] = new char[]{'a','e','i','o','u','A','E','I','O','U'};
        List<Character> list = new ArrayList<Character>();
        for(int i = 0; i < array.length; i++){
            list.add(array[i]);
        }
        char sArr[] = s.toCharArray();
        int i = 0;
        int j = s.length() - 1;
        while(i < j){
            if(!list.contains(sArr[i])){
                i++;
            }else if(!list.contains(sArr[j])){
                j--;
            }else{
                char c = sArr[i];
                sArr[i] = sArr[j];
                sArr[j] = c;
                i++;
                j--;
            }
        }
        return String.valueOf(sArr);
    }
}