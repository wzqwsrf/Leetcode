
// 331. Verify Preorder Serialization of a Binary Tree

/**
 * @author:wangzq
 * @email:wangzhenqing1008@163.com
 * @date:2016-06-15 11:26:42
 * @url:https://leetcode.com/problems/verify-preorder-serialization-of-a-binary-tree/
 */

public class Solution {
    public boolean isValidSerialization(String preorder) {
        String nodes[] = preorder.split(",");
        Stack<String> stack = new Stack<String>();
        for (int i = 0; i < nodes.length; i++) {
            String currNode = nodes[i];
            while (currNode.equals("#")
                    && !stack.isEmpty()
                    && stack.peek().equals("#")) {
                stack.pop();
                if (stack.isEmpty()) {
                    return false;
                }
                stack.pop();
            }
            stack.push(currNode);
        }
        return stack.size() == 1 && stack.peek().equals("#");
    }
}

//解法二
public class Solution {
    public boolean isValidSerialization(String preorder) {
        String[] nodes = preorder.split(",");
        int diff = 1;
        for (String node : nodes) {
            if (--diff < 0) {
                return false;
            }
            if (!node.equals("#")) {
                diff += 2;
            }
        }
        return diff == 0;
    }
}