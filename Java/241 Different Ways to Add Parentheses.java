
// Different Ways to Add Parentheses

/**
 * @author:wangzq
 * @email:wangzhenqing1008@163.com
 * @date:2015-07-28 16:40:06
 * @url:https://leetcode.com/problems/different-ways-to-add-parentheses/
 */

public class Solution {
    public List<Integer> diffWaysToCompute(String input) {
        List<Integer> list = new ArrayList<Integer>();
        if (input == null || "".equals(input)) {
            return list;
        }
        if (!input.contains("+") && !input.contains("-") && !input.contains("*")) {
            list.add(Integer.parseInt(input));
            return list;
        }
        int len = input.length();
        for (int i = 0; i < len; i++) {
            char c = input.charAt(i);
            if (c == '+' || c == '-' || c == '*') {
                List<Integer> list1 = diffWaysToCompute(input.substring(0, i));
                List<Integer> list2 = diffWaysToCompute(input.substring(i + 1));
                for (int num1 : list1) {
                    for (int num2 : list2) {
                        int num = 0;
                        if (c == '+') {
                            num = num1 + num2;
                        } else if (c == '-') {
                            num = num1 - num2;
                        } else if (c == '*') {
                            num = num1 * num2;
                        }
                        list.add(num);
                    }
                }
            }
        }
        return list;
    }
}