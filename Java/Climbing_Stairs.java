
// Climbing Stairs 336ms

/**
 * @author:wangzq
 * @email:wangzhenqing1008@163.com
 * @date:2014年07月22日12:04:23
 * @url:https://oj.leetcode.com/problems/climbing-stairs/
 * 跳台阶，斐波那契序列。注意long以及使用非递归
 * 具体参考http://blog.csdn.net/u013027996/article/details/38038747
 */

public class Climbing_Stairs {
    public int climbStairs(int n) {
        if (n == 1) {
            return 1;
        }
        int array[] = new int[n + 1];
        array[1] = 1;
        array[2] = 2;
        for (int i = 3; i < n + 1; i++) {
            array[i] = array[i - 1] + array[i - 2];
        }
        return array[n];
    }
}
