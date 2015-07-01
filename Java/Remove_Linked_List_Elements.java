
// Remove Linked List Elements

/**
 * @author:wangzq
 * @email:wangzhenqing1008@163.com
 * @date:2015年05月29日16:59:31
 * @url:https://leetcode.com/problems/remove-linked-list-elements/
 */

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Solution {

    public ListNode removeElements(ListNode head, int val) {
        while (head != null && head.val == val) {
            head = head.next;
        }
        ListNode p = head;
        while (p != null) {
            while (p.next != null && p.next.val == val) {
                p.next = p.next.next;
            }
            p = p.next;
        }
        return head;
    }
}