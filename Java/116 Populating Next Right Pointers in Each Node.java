
// Populating Next Right Pointers in Each Node

/**
 * @author:wangzq
 * @email:wangzhenqing1008@163.com
 * @date:2015-07-02 17:12:32
 * @url:https://leetcode.com/problems/populating-next-right-pointers-in-each-node/
 */

public class Solution {
    /**
     * Definition for binary tree with next pointer.
     * public class TreeLinkNode {
     *     int val;
     *     TreeLinkNode left, right, next;
     *     TreeLinkNode(int x) { val = x; }
     * }
     */
    public void connect(TreeLinkNode root) {
        if (root == null) {
            return;
        }
        List<TreeLinkNode> list = new ArrayList<TreeLinkNode>();
        list.add(root);
        createNextNode(list);
    }

    public void createNextNode(List<TreeLinkNode> list) {
        if (list.isEmpty() || list.size() == 0) {
            return;
        }
        int size = list.size();
        List<TreeLinkNode> tempList = new ArrayList<TreeLinkNode>();
        for (int i = 0; i < size; i++) {
            TreeLinkNode node = list.get(i);
            if (i == size - 1) {
                node.next = null;
            } else {
                node.next = list.get(i + 1);
            }
            if (node.left == null) {
                continue;
            }
            tempList.add(node.left);
            tempList.add(node.right);
        }
        createNextNode(tempList);
    }
}