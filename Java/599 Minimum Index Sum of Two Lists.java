
// 599. Minimum Index Sum of Two Lists

/**
 * @author:wangzq
 * @email:wangzhenqing1008@163.com
 * @date:2017-6-2 22:43:11
 * @url:https://leetcode.com/problems/minimum-index-sum-of-two-lists/#/description
 */

public class Solution {
    public String[] findRestaurant(String[] list1, String[] list2) {
        Map<String, Integer> map = new HashMap<String, Integer>();
        int len1 = list1.length;
        int len2 = list2.length;
        for (int i = 0; i < len2; i++) {
            map.put(list2[i], i);
        }
        List<String> list = new ArrayList<String>();
        int minIndexSum = len1 + len2;
        for (int i = 0; i < len1; i++) {
            if (map.containsKey(list1[i])) {
                int indexSum = i + map.get(list1[i]);
                if (indexSum < minIndexSum) {
                    list.clear();
                    list.add(list1[i]);
                    minIndexSum = indexSum;
                } else if (indexSum == minIndexSum) {
                    list.add(list1[i]);
                }
            }
        }
        return list.toArray(new String[list.size()]);
    }
}