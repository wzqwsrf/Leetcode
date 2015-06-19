
//Copy List with Random Pointer

import java.util.HashMap;

/**
 * @author:wangzq
 * @email:wangzhenqing1008@163.com
 * @date:2015年06月19日13:16:00
 * @url:https://leetcode.com/problems/copy-list-with-random-pointer/
 */


public class Copy_List_with_Random_Pointer {

    private HashMap<RandomListNode, RandomListNode> visitedMap;

    public RandomListNode copyRandomList(RandomListNode head) {
        if (head == null) {
            return null;
        }
        visitedMap = new HashMap<RandomListNode, RandomListNode>();
        RandomListNode ahead = new RandomListNode(0);
        RandomListNode p = ahead;
        RandomListNode newHead;
        while (head != null) {
            if (visitedMap.containsKey(head)) {
                newHead = visitedMap.get(head);
            } else {
                newHead = new RandomListNode(head.label);
                visitedMap.put(head, newHead);
            }
            if (head.random != null) {
                if (visitedMap.containsKey(head.random)) {
                    newHead.random = visitedMap.get(head.random);
                } else {
                    newHead.random = new RandomListNode(head.random.label);
                    visitedMap.put(newHead.random, head.random);
                }
            }
            p.next = newHead;
            p = newHead;
            head = head.next;
        }
        return ahead.next;
    }

    class RandomListNode {
        int label;
        RandomListNode next, random;

        RandomListNode(int x) {
            this.label = x;
        }
    }

}