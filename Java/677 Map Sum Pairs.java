
// 677. Map Sum Pairs

/**
 * @author:wangzq
 * @email:wangzhenqing1008@163.com
 * @date:2017-9-20 18:35:28
 * @url:https://leetcode.com/problems/map-sum-pairs/description/
 */

class MapSum {

    private Map<String, Integer> map;

    /**
     * Initialize your data structure here.
     */
    public MapSum() {
        map = new HashMap<String, Integer>();
    }

    public void insert(String key, int val) {
        map.put(key, val);
    }

    public int sum(String prefix) {
        int ans = 0;
        for (String key : map.keySet()) {
            if (key.indexOf(prefix) == 0) {
                ans += map.get(key);
            }
        }
        return ans;
    }
}

/**
 * Your MapSum object will be instantiated and called as such:
 * MapSum obj = new MapSum();
 * obj.insert(key,val);
 * int param_2 = obj.sum(prefix);
 */