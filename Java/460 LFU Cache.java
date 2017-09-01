
// 460. LFU Cache

/**
 * @author:wangzq
 * @email:wangzhenqing1008@163.com
 * @date:2017-9-1 15:02:01
 * @url:https://leetcode.com/problems/lfu-cache/description/
 */

class LFUCache {

    private Map<Integer, Integer> map;
    private Map<Integer, LinkedHashSet<Integer>> countMap;
    private Map<Integer, Integer> freMap;
    private int capacity;
    private int min;

    public LFUCache(int capacity) {
        this.map = new HashMap<Integer, Integer>();
        this.countMap = new HashMap<Integer, LinkedHashSet<Integer>>();
        this.freMap = new HashMap<Integer, Integer>();
        this.capacity = capacity;
        this.min = -1;
        this.countMap.put(1, new LinkedHashSet<Integer>());
    }

    public int get(int key) {
        if (!map.containsKey(key)) {
            return -1;
        }
        int value = map.get(key);
        int count = freMap.get(key);
        freMap.put(key, count + 1);
        countMap.get(count).remove(key);
        LinkedHashSet<Integer> set = new LinkedHashSet<>();
        if (countMap.get(count + 1) != null) {
            set = countMap.get(count + 1);
        }
        set.add(key);
        countMap.put(count + 1, set);
        if (count == min && countMap.get(count).size() == 0) {
            min++;
        }
        return value;
    }

    public void put(int key, int value) {
        if (capacity <= 0) {
            return;
        }
        if (map.containsKey(key)) {
            map.put(key, value);
            get(key);
            return;
        }
        if (map.size() >= capacity) {
            int rkey = countMap.get(min).iterator().next();
            countMap.get(min).remove(rkey);
            map.remove(rkey);
        }
        map.put(key, value);
        freMap.put(key, 1);
        countMap.get(1).add(key);
        min = 1;
    }
}

/**
 * Your LFUCache object will be instantiated and called as such:
 * LFUCache obj = new LFUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */