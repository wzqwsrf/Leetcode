
// 646. Maximum Length of Pair Chain

/**
 * @author:wangzq
 * @email:wangzhenqing1008@163.com
 * @date:2017-08-05 18:21:26
 * @url:https://leetcode.com/problems/maximum-length-of-pair-chain/description/
 */

//sort pairs by the second one, from small to big.
//then foreach the array.
public class Solution {
    public int findLongestChain(int[][] pairs) {
        Arrays.sort(pairs, new Comparator<int[]>() {
            public int compare(int[] o1, int[] o2) {
                return o1[1] > o2[1] ? 1 : -1;
            }
        });
        int len = pairs.length;
        int max = 1;
        int first = pairs[0][1];
        for (int i = 1; i < len; i++) {
            if (first < pairs[i][0]) {
                max += 1;
                first = pairs[i][1];
            }
        }
        return max;
    }
}