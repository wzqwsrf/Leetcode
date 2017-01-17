
// 378. Kth Smallest Element in a Sorted Matrix

/**
 * @author:wangzq
 * @email:wangzhenqing1008@163.com
 * @date:2017-1-17 18:45:27
 * @url:https://leetcode.com/problems/kth-smallest-element-in-a-sorted-matrix/
 */

public class Solution {
    public int kthSmallest(int[][] matrix, int k) {
        if (matrix == null || matrix.length == 0) {
            return 0;
        }
        int m = matrix.length;
        int n = matrix[0].length;
        PriorityQueue<Integer> queue = new PriorityQueue(k);
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (queue.size() < k) {
                    queue.add(matrix[i][j]);
                    continue;
                }
                int tempNum = queue.peek();
                if (tempNum > matrix[i][j]) {
                    queue.poll();
                    queue.add(matrix[i][j]);
                }
            }
        }
        return queue.peek();
    }
}