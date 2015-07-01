
// Course Schedule II

/**
 * @author:wangzq
 * @email:wangzhenqing1008@163.com
 * @date:2015年06月23日23:33:54
 * @url:https://leetcode.com/problems/course-schedule-ii/
 */

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        int array[] = new int[numCourses];
        ArrayList<Integer>[] list = new ArrayList[numCourses];
        int m = prerequisites.length;
        int indegree[] = new int[numCourses];
        for (int i = 0; i < m; i++) {
            if (list[prerequisites[i][1]] == null) {
                list[prerequisites[i][1]] = new ArrayList<Integer>();
            }
            list[prerequisites[i][1]].add(prerequisites[i][0]);
            indegree[prerequisites[i][0]]++;
        }
        Queue<Integer> queue = new LinkedList<Integer>();
        for (int i = 0; i < numCourses; i++) {
            if (indegree[i] == 0) {
                queue.offer(i);
            }
        }
        int count = 0;
        while (!queue.isEmpty()) {
            int num = queue.poll();
            if (list[num] != null) {
                for (int node : (ArrayList<Integer>) list[num]) {
                    indegree[node]--;
                    if (indegree[node] == 0) {
                        queue.offer(node);
                    }
                }
            }
            array[count++] = num;
        }
        if (count == numCourses) {
            return array;
        }
        return new int[0];
    }
}