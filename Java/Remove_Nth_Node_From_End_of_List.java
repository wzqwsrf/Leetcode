
// Remove Nth Node From End of List

/**
 * @author:wangzq
 * @email:wangzhenqing1008@163.com
 * @date:2015年04月19日22:11:03
 * @url:https://leetcode.com/problems/remove-nth-node-from-end-of-list/
 */

public class Remove_Nth_Node_From_End_of_List {

    public ListNode removeNthFromEnd(ListNode head, int n) {
        if (n == 0) {
            return head;
        }
        ListNode point = head;
        int allLen = 0;
        while (point != null) {
            point = point.next;
            allLen++;
        }
        if (allLen == n) {
            return head.next;
        }
        int num = 0;
        point = head;
        while (point != null && num != allLen - n - 1) {
            point = point.next;
            num++;
        }
        if (point.next != null) {
            ListNode tempNode = point.next.next;
            point.next = tempNode;
        }
        return head;
    }
}

class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
        next = null;
    }
}