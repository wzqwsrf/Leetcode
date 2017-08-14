
// 658. Find K Closest Elements

/**
 * @author:wangzq
 * @email:wangzhenqing1008@163.com
 * @date:2017-8-14 23:29:43
 * @url:https://leetcode.com/problems/find-k-closest-elements/description/
 */

public class Solution {
    public List<Integer> findClosestElements(List<Integer> arr, int k, int x) {
        List<Integer> list = new ArrayList<Integer>();
        int size = arr.size();
        int index = getIndex(arr, x);
        int l = index - 1;
        int r = index;
        while (k > 0 && (l >= 0 || r < size)) {
            if (l >= 0 && r < size) {
                int num1 = arr.get(r) - x;
                int num2 = x - arr.get(l);
                if (num1 < num2) {
                    list.add(arr.get(r));
                    r++;
                } else {
                    list.add(arr.get(l));
                    l--;
                }
                k--;
                continue;
            }
            if (l >= 0) {
                list.add(arr.get(l));
                l--;
                k--;
                continue;
            }
            if (r < size) {
                list.add(arr.get(r));
                r++;
                k--;
            }
        }
        Collections.sort(list);
        return list;
    }

    private int getIndex(List<Integer> arr, int x) {
        int l = 0;
        int r = arr.size() - 1;
        while (l < r) {
            int mid = (l + r) >> 1;
            if (arr.get(mid) == x) {
                return mid;
            }
            if (arr.get(mid) > x) {
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        return l;
    }
}