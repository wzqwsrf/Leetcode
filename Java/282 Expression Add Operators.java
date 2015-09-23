
// Expression Add Operators

/**
 * @author:wangzq
 * @email:wangzhenqing1008@163.com
 * @date:2015-09-23 18:33:49
 * @url:https://leetcode.com/problems/expression-add-operators/
 */

public class Solution {
    public List<String> addOperators(String num, int target) {
        List<String> list = new ArrayList<String>();
        dfs(list, num, "", 0, 0, 0, target);
        return list;
    }

    private void dfs(List<String> list, String num, String path,
                     int pos, long sum, long lastNum, int target) {
        int len = num.length();
        if (pos == len && sum == target) {
            list.add(path);
            return;
        }
        if (pos >= len) {
            return;
        }
        for (int i = pos; i < len; i++) {
            if (i != pos && num.charAt(pos) == '0') {
                break;
            }
            long curNum = Long.parseLong(num.substring(pos, i + 1));
            if (pos == 0) {
                dfs(list, num, path + "" + curNum, i + 1, curNum, curNum, target);
            } else {
                dfs(list, num, path + "+" + curNum, i + 1, sum + curNum, curNum, target);
                dfs(list, num, path + "-" + curNum, i + 1, sum - curNum, -curNum, target);
                dfs(list, num, path + "*" + curNum, i + 1, sum - lastNum + lastNum * curNum, lastNum * curNum, target);
            }
        }
    }
}