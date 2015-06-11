
//Implement Stack using Queues

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author:wangzq
 * @email:wangzhenqing1008@163.com
 * @date:2015年06月11日14:18:21
 * @url:https://leetcode.com/problems/implement-stack-using-queues/
 */

public class Implement_Stack_using_Queues {

    class MyStack {

        Queue<Integer> queue1 = new LinkedList<Integer>();
        Queue<Integer> queue2 = new LinkedList<Integer>();

        // Push element x onto stack.
        public void push(int x) {
            while (!queue1.isEmpty()) {
                int num = queue1.poll();
                queue2.add(num);
            }
            queue1.add(x);
        }

        // Removes the element on top of the stack.
        public void pop() {
            if (!queue1.isEmpty()) {
                while (queue1.size() != 1) {
                    queue2.add(queue1.poll());
                }
                queue1.poll();
            } else {
                while (queue2.size() != 1) {
                    int num = queue2.poll();
                    queue1.add(num);
                }
                queue2.poll();
            }
        }

        // Get the top element.
        public int top() {
            if (!queue1.isEmpty()) {
                while (queue1.size() != 1) {
                    queue2.add(queue1.poll());
                }
                return queue1.peek();
            } else {
                while (queue2.size() != 1) {
                    int num = queue2.poll();
                    queue1.add(num);
                }
                int num = queue2.poll();
                queue1.add(num);
                return num;
            }
        }

        // Return whether the stack is empty.
        public boolean empty() {
            return queue1.isEmpty() && queue2.isEmpty();
        }
    }
}