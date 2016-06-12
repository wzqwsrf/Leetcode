
// 332. Reconstruct Itinerary

/**
 * @author:wangzq
 * @email:wangzhenqing1008@163.com
 * @date:2016-06-12 15:21:57
 * @url:https://leetcode.com/problems/reconstruct-itinerary/
 */

public class Solution {
    public List<String> findItinerary(String[][] tickets) {
        List<String> list = new ArrayList<String>();
        if (tickets == null || tickets.length == 0) {
            return list;
        }
        Map<String, List<String>> keyMap = new HashMap<String, List<String>>();
        int m = tickets.length;
        for (int i = 0; i < m; i++) {
            List<String> valueList = new ArrayList<String>();
            if (keyMap.containsKey(tickets[i][0])) {
                valueList = keyMap.get(tickets[i][0]);
            }
            valueList.add(tickets[i][1]);
            keyMap.put(tickets[i][0], valueList);
        }
        for (List valueList : keyMap.values()) {
            Collections.sort(valueList);
        }
        String from = "JFK";
        list.add(from);
        dfs(list, keyMap, from, m);
        return list;

    }

    private boolean dfs(List<String> list, Map<String, List<String>> keyMap,
                        String from, int m) {
        if (list.size() == m + 1) {
            return true;
        }
        List<String> valueList = keyMap.get(from);
        if (valueList == null) {
            return false;
        }
        Collections.sort(valueList);
        for (int i = 0; i < valueList.size(); i++) {
            String to = keyMap.get(from).remove(i);
            list.add(to);
            boolean flag = dfs(list, keyMap, to, m);
            if (flag) {
                return true;
            }
            list.remove(list.size() - 1);
            keyMap.get(from).add(i, to);
        }
        return false;
    }
}