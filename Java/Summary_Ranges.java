
// Summary Ranges

import java.util.ArrayList;
import java.util.List;

/**
 * @author:wangzq
 * @email:wangzhenqing1008@163.com
 * @date:2015年06月26日10:02:40
 * @url:https://leetcode.com/problems/summary-ranges/
 */

public class Summary_Ranges {
    public List<String> summaryRanges(int[] nums) {
        List<String> list = new ArrayList<String>();
        if (nums == null || nums.length == 0) {
            return list;
        }
        int len = nums.length;
        for (int i = 0; i < len; i++) {
            String start = nums[i] + "";
            String end = "";
            while (i < len - 1 && nums[i + 1] == nums[i] + 1) {
                end = "->" + nums[i + 1];
                i++;
            }
            list.add(start + end);
        }
        return list;
    }
}

