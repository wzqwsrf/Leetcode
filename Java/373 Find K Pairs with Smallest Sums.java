
// 373. Find K Pairs with Smallest Sums

/**
 * @author:wangzq
 * @email:wangzhenqing1008@163.com
 * @date:2017-1-17 18:43:06
 * @url:https://leetcode.com/problems/find-k-pairs-with-smallest-sums/
 */

public class Solution {
    public List<int[]> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        List<int[]> list = new ArrayList<>();
        if (nums1 == null || nums2 == null
                || nums1.length == 0 || nums2.length == 0) {
            return list;
        }
        int m = nums1.length;
        int n = nums2.length;
        PriorityQueue<Tuple> queue = new PriorityQueue<>();
        for (int j = 0; j <= n - 1; j++) {
            queue.offer(new Tuple(0, j, nums1[0] + nums2[j]));
        }
        for (int i = 0; i < Math.min(k, m * n); i++) {
            Tuple tuple = queue.poll();
            list.add(new int[]{nums1[tuple.x], nums2[tuple.y]});
            if (tuple.x == m - 1) {
                continue;
            }
            queue.offer(new Tuple(tuple.x + 1, tuple.y, nums1[tuple.x + 1] + nums2[tuple.y]));
        }
        return list;
    }

    public class Tuple implements Comparable<Tuple> {

        int x;
        int y;
        int val;

        public Tuple(int x, int y, int val) {
            this.x = x;
            this.y = y;
            this.val = val;
        }

        @Override
        public int compareTo(Tuple o) {
            return this.val - o.val;
        }
    }
}