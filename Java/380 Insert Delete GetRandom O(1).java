
// 380. Insert Delete GetRandom O(1)

/**
 * @author:wangzq
 * @email:wangzhenqing1008@163.com
 * @date:2017-8-22 19:44:24
 * @url:https://leetcode.com/problems/insert-delete-getrandom-o1/description/
 */

class RandomizedSet {

    private List<Integer> list;
    private Map<Integer, Integer> map;
    private Random random;
    private int size;

    /**
     * Initialize your data structure here.
     */
    public RandomizedSet() {
        this.list = new ArrayList<Integer>();
        this.map = new HashMap<Integer, Integer>();
        this.random = new Random();
        this.size = 0;
    }

    /**
     * Inserts a value to the set.
     * Returns true if the set did not already contain the specified element.
     */
    public boolean insert(int val) {
        if (map.containsKey(val)) {
            return false;
        }
        map.put(val, size);
        list.add(size, val);
        size++;
        return true;
    }

    /**
     * Removes a value from the set. Returns true if the set contained the specified element.
     */
    public boolean remove(int val) {
        if (map.containsKey(val)) {
            int index = map.get(val);
            int lastNum = list.get(size - 1);
            list.set(index, lastNum);
            map.put(lastNum, index);
            map.remove(val);
            size--;
            return true;
        }
        return false;
    }

    /**
     * Get a random element from the set.
     */
    public int getRandom() {
        return list.get(random.nextInt(size));
    }
}

/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */