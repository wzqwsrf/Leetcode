
// 609. Find Duplicate File in System

/**
 * @author:wangzq
 * @email:wangzhenqing1008@163.com
 * @date:2017-6-6 17:44:21
 * @url:https://leetcode.com/problems/find-duplicate-file-in-system/#/description
 */

public class Solution {
    public List<List<String>> findDuplicate(String[] paths) {
        int len = paths.length;
        Map<String, List<String>> map = new HashMap<>();
        for (int i = 0; i < len; i++) {
            String path = paths[i];
            String array[] = path.split(" ");
            int alen = array.length;
            for (int j = 1; j < alen; j++) {
                String contentArr[] = array[j].split("\\(");
                String key = contentArr[1].replace(")", "");
                List<String> list = map.get(key);
                if (list == null) {
                    list = new ArrayList<String>();
                }
                list.add(array[0] + "/" + contentArr[0]);
                map.put(key, list);
            }
        }
        List<List<String>> resList = new ArrayList<>();
        Set<String> keySet = new HashSet<>(map.keySet());
        for (String key : keySet) {
            List<String> list = map.get(key);
            if (list.size() != 1) {
                resList.add(list);
            }
        }
        return resList;
    }
}