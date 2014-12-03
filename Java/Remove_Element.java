
//Remove Element 384ms

/**
 * @author:wangzq
 * @email:wangzhenqing1008@163.com
 * @date:2014年10月16日18:15:14
 * @url:https://oj.leetcode.com/problems/remove-element/
 * 扫描处理数组
 * 具体参考http://blog.csdn.net/u013027996/article/details/40152421
 */

public class Remove_Element {
    public int removeElement(int[] A, int elem) {
        int len = A.length;
        int start = 0;
        for (int i = 0; i < len; i++) {
            if (A[i] != elem) {
                A[start++] = A[i];
            }
        }
        return start;
    }
}

