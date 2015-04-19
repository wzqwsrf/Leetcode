
// Generate Parentheses

import java.util.ArrayList;

/**
 * @author:wangzq
 * @email:wangzhenqing1008@163.com
 * @date:2015年04月19日22:15:17
 * @url:https://leetcode.com/problems/generate-parentheses/
 */

public class Generate_Parentheses {
    public ArrayList<String> generateParenthesis(int n) {
        ArrayList<String> list = new ArrayList<String>();
        if (n <= 0) {
            return list;
        }
        dfs(list, "", n, 0, 0);
        return list;
    }

    public void dfs(ArrayList<String> list, String sb, int n,
                    int leftNum, int rightNum) {
        if (leftNum == n) {
            for (int i = 0; i < n - rightNum; i++) {
                sb += ")";
            }
            list.add(sb);
            return;
        }
        dfs(list, sb + "(", n, leftNum + 1, rightNum);
        if (leftNum > rightNum) {
            dfs(list, sb + ")", n, leftNum, rightNum + 1);
        }
    }
}