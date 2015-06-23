
//Course Schedule

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @author:wangzq
 * @email:wangzhenqing1008@163.com
 * @date:2015年06月23日18:28:33
 * @url:https://leetcode.com/problems/course-schedule/
 */

public class Course_Schedule {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        if (prerequisites == null || prerequisites.length == 0) {
            return true;
        }
        ArrayList[] list = new ArrayList[numCourses];
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
        }
        for (int i = 0; i < numCourses; i++) {
            if (indegree[i] != 0) {
                return false;
            }
        }
        return true;
    }
}