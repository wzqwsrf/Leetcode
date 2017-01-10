
// 445. Add Two Numbers II

/**
 * @author:wangzq
 * @email:wangzhenqing1008@163.com
 * @date:2017-1-10 19:40:22
 * @url:https://leetcode.com/problems/add-two-numbers-ii/
 */

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        Stack<Integer> stack1 = new Stack<>();
        Stack<Integer> stack2 = new Stack<>();
        while (l1 != null) {
            stack1.push(l1.val);
            l1 = l1.next;
        }
        while (l2 != null) {
            stack2.push(l2.val);
            l2 = l2.next;
        }
        int carry = 0;
        ListNode end = null;
        ListNode p = null;
        while (!stack1.isEmpty() || !stack2.isEmpty()) {
            if (!stack1.isEmpty()) {
                carry += stack1.pop();
            }
            if (!stack2.isEmpty()) {
                carry += stack2.pop();
            }
            end = new ListNode(carry % 10);
            end.next = p;
            p = end;
            carry /= 10;
        }
        if (carry != 0) {
            end = new ListNode(carry % 10);
            end.next = p;
        }
        return end;
    }
}