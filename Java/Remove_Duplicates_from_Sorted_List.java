
//Remove Duplicates from Sorted List

/**
 * @author:wangzq
 * @email:wangzhenqing1008@163.com
 * @date:2015年05月28日17:14:11
 * @url:https://leetcode.com/problems/remove-duplicates-from-sorted-list/
 */

public class Remove_Duplicates_from_Sorted_List {

    public ListNode deleteDuplicates(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode node = new ListNode(head.val);
        ListNode point = node;
        int start = head.val;
        head = head.next;
        while (head != null) {
            if (head.val != start) {
                start = head.val;
                point.next = new ListNode(head.val);
                point = point.next;
            }
            head = head.next;
        }
        return node;
    }
}