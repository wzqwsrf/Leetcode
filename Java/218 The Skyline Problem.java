
// The Skyline Problem

/**
 * @author:wangzq
 * @email:wangzhenqing1008@163.com
 * @date:2015年06月18日14:40:12
 * @url:https://leetcode.com/problems/the-skyline-problem/
 */

import java.util.*;

public class Solution {

    public List<int[]> getSkyline(int[][] buildings) {
        List<int[]> list = new ArrayList<int[]>();
        if (buildings == null || buildings.length == 0) {
            return list;
        }
        List<Edge> edgeList = new ArrayList<Edge>();
        int m = buildings.length;
        for (int i = 0; i < m; i++) {
            Edge start = new Edge(buildings[i][0], buildings[i][2], true);
            edgeList.add(start);
            Edge end = new Edge(buildings[i][1], buildings[i][2], false);
            edgeList.add(end);
        }
        Collections.sort(edgeList);
        Queue<Integer> queue = new PriorityQueue<Integer>(m, Collections.reverseOrder());
        for (Edge edge : edgeList) {
            if (edge.isStart) {
                if (queue.isEmpty() || edge.height > queue.peek()) {
                    list.add(new int[]{edge.pos, edge.height});
                }
                queue.offer(edge.height);
            } else {
                queue.remove(edge.height);
                if (queue.isEmpty() || edge.height > queue.peek()) {
                    list.add(queue.isEmpty() ? new int[]{edge.pos, 0} :
                            new int[]{edge.pos, queue.peek()});
                }
            }
        }
        return list;
    }

    class Edge implements Comparable<Edge> {
        int pos;
        int height;
        boolean isStart;

        public Edge(int pos, int height, boolean isStart) {
            this.pos = pos;
            this.height = height;
            this.isStart = isStart;
        }

        @Override
        public int compareTo(Edge o) {
            if (this.pos != o.pos) {
                return this.pos - o.pos;
            }
            //位置相同 都是left
            if (this.isStart && o.isStart) {
                return o.height - this.height;
            }
            //位置相同 都是right
            if (!this.isStart && !o.isStart) {
                return this.height - o.height;
            }

            return this.isStart ? -1 : 1;
        }
    }
}