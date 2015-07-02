
// Clone Graph

/**
 * @author:wangzq
 * @email:wangzhenqing1008@163.com
 * @date:2015-07-02 16:29:06
 * @url:https://leetcode.com/problems/clone-graph/
 */

public class Solution {
    /**
     * Definition for undirected graph.
     * class UndirectedGraphNode {
     *     int label;
     *     ArrayList<UndirectedGraphNode> neighbors;
     *     UndirectedGraphNode(int x) { label = x; neighbors = new ArrayList<UndirectedGraphNode>(); }
     * };
     */
    private HashMap<UndirectedGraphNode, UndirectedGraphNode> visitedMap;

    public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
        if (node == null) {
            return null;
        }
        visitedMap = new HashMap<UndirectedGraphNode, UndirectedGraphNode>();
        UndirectedGraphNode cloneNode = new UndirectedGraphNode(node.label);
        visitedMap.put(node, cloneNode);
        dfs(node);
        return cloneNode;
    }

    private void dfs(UndirectedGraphNode node) {
        UndirectedGraphNode cloneNode = visitedMap.get(node);
        List<UndirectedGraphNode> neighbors = node.neighbors;
        int size = neighbors.size();
        for (int i = 0; i < size; i++) {
            UndirectedGraphNode curNode = neighbors.get(i);
            if (visitedMap.containsKey(curNode)) {
                cloneNode.neighbors.add(visitedMap.get(curNode));
            } else {
                UndirectedGraphNode tempNode = new UndirectedGraphNode(curNode.label);
                visitedMap.put(curNode, tempNode);
                cloneNode.neighbors.add(tempNode);
                if (node.neighbors.size() != 0) {
                    dfs(curNode);
                }
            }
        }
    }
}