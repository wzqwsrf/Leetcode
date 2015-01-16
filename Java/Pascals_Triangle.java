
//Pascal's Triangle 364ms

/**
 * Given numRows, generate the first numRows of Pascal's triangle.
 * For example, given numRows = 5,
 * Return
 [
     [1],
    [1,1],
   [1,2,1],
  [1,3,3,1],
 [1,4,6,4,1]
 ]
 */

/**
 * @author:wangzq
 * @email:wangzhenqing1008@163.com
 * @date:2014年07月04日18:57:25
 * @url:https://oj.leetcode.com/problems/pascals-triangle/
 * 1、numRows表示有几行，注意列表从0开始。
 * 2、每一行的列表是这样构成的，开头和结尾都是1，中间是前一个列表相邻两个数之和。
 * 具体参考http://blog.csdn.net/u013027996/article/details/36899443
 */

import java.util.ArrayList;

public class Pascals_Triangle {
    public ArrayList<ArrayList<Integer>> generate(int numRows) {
        ArrayList<ArrayList<Integer>> list = new ArrayList<ArrayList<Integer>>();
        if (numRows <= 0) {
            return list;
        }
        ArrayList<Integer> firstList = new ArrayList<Integer>();
        firstList.add(1);
        list.add(firstList);
        for (int i = 1; i < numRows; i++) {
            ArrayList<Integer> secList = new ArrayList<Integer>();
            ArrayList<Integer> tempList = list.get(i - 1);
            int size = tempList.size();
            secList.add(1);
            for (int j = 1; j < size; j++) {
                secList.add(tempList.get(j - 1) + tempList.get(j));
            }
            secList.add(1);
            list.add(secList);
        }
        return list;
    }
}
