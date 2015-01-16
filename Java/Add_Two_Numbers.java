
// Add Two Numbers 704ms

/**
 * You are given two linked lists representing two non-negative numbers.
 * The digits are stored in reverse order and each of their nodes
 * contain a single digit. Add the two numbers and return it as a linked list.
 Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
 Output: 7 -> 0 -> 8
 */

/**
 * @author:wangzq
 * @email:wangzhenqing1008@163.com
 * @date:2014年07月17日16:05:11
 * @url:https://oj.leetcode.com/problems/add-two-numbers/
 * 大数相加，按位求和，注意进位问题
 * 具体参考http://blog.csdn.net/u013027996/article/details/37908619
 */
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */

public class Add_Two_Numbers {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if (l1 == null && l2 == null) {
            return null;
        }
        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }
        ListNode node = new ListNode(0);
        ListNode point = node;
        int carry = 0;
        while (l1 != null && l2 != null) {
            int val = l1.val + l2.val;
            val += carry;
            carry = 0;
            if (val >= 10) {
                int temp = val;
                val %= 10;
                carry += temp / 10;
            }
            point.next = new ListNode(val);
            point = point.next;
            l1 = l1.next;
            l2 = l2.next;
        }
        while (l1 != null) {
            int val = l1.val + carry;
            carry = 0;
            if (val >= 10) {
                int temp = val;
                val %= 10;
                carry += temp / 10;
            }
            point.next = new ListNode(val);
            point = point.next;
            l1 = l1.next;
        }
        while (l2 != null) {
            int val = l2.val + carry;
            carry = 0;
            if (val >= 10) {
                int temp = val;
                val %= 10;
                carry += temp / 10;
            }
            point.next = new ListNode(val);
            point = point.next;
            l2 = l2.next;
        }
        if(carry != 0){
            point.next = new ListNode(carry);
            point = point.next;
        }
        return node.next;
    }

    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }
}
