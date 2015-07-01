
// Gray Code

/**
 * @author:wangzq
 * @email:wangzhenqing1008@163.com
 * @date:2015年05月28日17:20:07
 * @url:https://leetcode.com/problems/gray-code/
 */

import java.util.ArrayList;

public class Solution {

    public ArrayList<Integer> grayCode(int n) {
        ArrayList<Integer> list = new ArrayList<Integer>();
        if (n < 0) {
            return list;
        }
        list.add(0);
        if (n > 0) {
            list.add(1);
        }
        int mark = 1;
        for (int i = 2; i <= n; i++) {
            mark *= 2;
            int size = list.size();
            for (int j = size - 1; j >= 0; j--) {
                int value = list.get(j);
                value |= mark;
                list.add(value);
            }
        }
        return list;
    }
}