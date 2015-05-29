
//Linked List Cycle

import java.util.ArrayList;
import java.util.Stack;

/**
 * @author:wangzq
 * @email:wangzhenqing1008@163.com
 * @date:2015年05月29日17:18:09
 * @url:https://leetcode.com/problems/linked-list-cycle/
 */

public class Linked_List_Cycle {
    public boolean hasCycle(ListNode head) {
        if(head == null){
            return false;
        }
        ListNode p = head;
        ListNode q = head;
        while(p.next != null && p.next.next != null){
            p = p.next.next;
            q = q.next;
            if(p == q){
                return true;
            }
        }
        return false;
    }
}