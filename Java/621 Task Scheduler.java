
// 621. Task Scheduler

/**
 * @author:wangzq
 * @email:wangzhenqing1008@163.com
 * @date:2017-6-20 19:07:30
 * @url:https://leetcode.com/problems/task-scheduler/#/description
 */

public class Solution {
    public int leastInterval(char[] tasks, int n) {
        int array[] = new int[26];
        int len = tasks.length;
        for (int i = 0; i < len; i++) {
            array[tasks[i] - 'A']++;
        }
        PriorityQueue<Integer> queue = new PriorityQueue<Integer>((a, b) -> b - a);
        for (int i = 0; i < 26; i++) {
            if (array[i] != 0) {
                queue.offer(array[i]);
            }
        }
        int count = 0;
        while (!queue.isEmpty()) {
            List<Integer> list = new ArrayList<>();
            int tempCount = 0;
            for (int i = 0; i <= n; i++) {
                if (!queue.isEmpty()) {
                    list.add(queue.poll());
                    tempCount++;
                }
            }
            for (Integer num : list) {
                if (num - 1 > 0) {
                    queue.offer(num - 1);
                }
            }
            tempCount = !queue.isEmpty() ? n + 1 : tempCount;
            count += tempCount;
        }
        return count;
    }
}