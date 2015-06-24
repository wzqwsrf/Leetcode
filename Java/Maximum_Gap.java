
// Maximum Gap

import java.util.Arrays;

/**
 * @author:wangzq
 * @email:wangzhenqing1008@163.com
 * @date:2015年06月24日15:51:32
 * @url:https://leetcode.com/problems/maximum-gap/
 */

public class Maximum_Gap {
    public int maximumGap1(int[] nums) {
        if (nums == null || nums.length < 2) {
            return 0;
        }
        int len = nums.length;
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < len; i++) {
            min = Math.min(nums[i], min);
            max = Math.max(nums[i], max);
        }
        int gap = (int) Math.ceil((double) (max - min) / (len - 1));
        int bucketNum = (max - min) / gap + 1;
        int bucketMax[] = new int[bucketNum];
        int bucketMin[] = new int[bucketNum];
        Arrays.fill(bucketMax, Integer.MIN_VALUE);
        Arrays.fill(bucketMin, Integer.MAX_VALUE);
        for (int i = 0; i < len; i++) {
            int bucketPos = (nums[i] - min) / gap;
            bucketMax[bucketPos] = Math.max(bucketMax[bucketPos], nums[i]);
            bucketMin[bucketPos] = Math.min(bucketMin[bucketPos], nums[i]);
        }
        int maxGap = 0;
        int previous = min;
        for (int i = 0; i < bucketNum; i++) {
            if (bucketMax[i] == Integer.MIN_VALUE ||
                    bucketMin[i] == Integer.MAX_VALUE) {
                continue;
            }
            maxGap = Math.max(maxGap, bucketMin[i] - previous);
            previous = bucketMax[i];
        }
        return maxGap;
    }

    public int maximumGap2(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        Arrays.sort(nums);
        int gap = 0;
        int len = nums.length;
        for (int i = 0; i < len - 1; i++) {
            gap = Math.max(nums[i + 1] - nums[i], gap);
        }
        return gap;
    }
}

