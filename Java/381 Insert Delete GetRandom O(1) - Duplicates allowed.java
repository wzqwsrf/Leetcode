
// 381. Insert Delete GetRandom O(1) - Duplicates allowed

/**
 * @author:wangzq
 * @email:wangzhenqing1008@163.com
 * @date:2017-8-22 19:44:24
 * @url:https://leetcode.com/problems/insert-delete-getrandom-o1-duplicates-allowed/description/
 */

class RandomizedCollection {

    private List<Integer> list;
    private Map<Integer, List<Integer>> map;
    private Random random;
    private int size;

    /**
     * Initialize your data structure here.
     */
    public RandomizedCollection() {
        this.list = new ArrayList<Integer>();
        this.map = new HashMap<Integer, List<Integer>>();
        this.random = new Random();
        this.size = 0;
    }

    /**
     * Inserts a value to the collection.
     * Returns true if the collection did not already contain the specified element.
     */
    public boolean insert(int val) {
        boolean flag = map.containsKey(val);
        List<Integer> indexList = map.get(val);
        if (indexList == null) {
            indexList = new ArrayList<Integer>();
        }
        indexList.add(size);
        map.put(val, indexList);
        list.add(size, val);
        size++;
        return !flag;
    }

    /**
     * Removes a value from the collection. Returns true if the collection contained the specified element.
     */
    public boolean remove(int val) {
        if (map.containsKey(val)) {
            int lastNum = list.get(size - 1);
            List<Integer> indexList = map.get(val);
            int index = indexList.get(0);
            list.set(index, lastNum);
            List<Integer> lastList = map.get(lastNum);
            lastList.remove((Integer) (size - 1));
            lastList.add(index);
            map.put(lastNum, lastList);
            if (indexList.size() == 1) {
                map.remove(val);
            } else {
                map.get(val).remove((Integer) index);
            }
            size--;
            return true;
        }
        return false;
    }

    /**
     * Get a random element from the collection.
     */
    public int getRandom() {
        return list.get(random.nextInt(size));
    }
}

/**
 * Your RandomizedCollection object will be instantiated and called as such:
 * RandomizedCollection obj = new RandomizedCollection();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */