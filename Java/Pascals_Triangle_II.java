
// Pascal's Triangle II

/**
 * @author:wangzq
 * @email:wangzhenqing1008@163.com
 * @date:2014年07月04日18:59:41
 * @url:https://oj.leetcode.com/problems/pascals-triangle-ii/
 * 1、参照Pascal's Triangle，算出所有的list，直接get(rowIndex)
 * 2、如果是空间限制，只能声明k长度的list，依次计算。
 * 具体参考http://blog.csdn.net/u013027996/article/details/36905037
 */

import java.util.ArrayList;
import java.util.List;

public class Solution {

    public List<Integer> getRow(int rowIndex) {
        List<Integer> list = new ArrayList<Integer>();
        list.add(1);
        for (int i = 1; i < rowIndex + 1; i++) {
            int curNum = 1;
            for (int j = 1; j < i; j++) {
                int temp = curNum;
                curNum = list.get(j);
                list.set(j, curNum + temp);
            }
            list.add(1);
        }
        return list;
    }
}
