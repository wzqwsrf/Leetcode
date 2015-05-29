
//Remove Linked List Elements

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @author:wangzq
 * @email:wangzhenqing1008@163.com
 * @date:2015年05月29日16:59:31
 * @url:https://leetcode.com/problems/remove-linked-list-elements/
 */

public class Remove_Linked_List_Elements {
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