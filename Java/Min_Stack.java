
//Min Stack 298ms

/**
 * Min Stack
 * Total Accepted: 15688 Total Submissions: 101910 My Submissions Question Solution
 * Design a stack that supports push, pop, top,
 * and retrieving the minimum element in constant time.
 * push(x) -- Push element x onto stack.
 * pop() -- Removes the element on top of the stack.
 * top() -- Get the top element.
 * getMin() -- Retrieve the minimum element in the stack.
 */

/**
 * @author:wangzq
 * @email:wangzhenqing1008@163.com
 * @date:2015年01月23日19:05:58
 * @url:https://oj.leetcode.com/problems/min-stack/
 * 每次把最小数保存在minStack中，pop的时候判断是否和当前栈顶元素相等。
 * 具体参考
 */

class MinStack {
    Stack<Integer> stack = new Stack<Integer>();
    Stack<Integer> minStack = new Stack<Integer>();

    public void push(int x) {
        if(minStack.isEmpty() || x <= minStack.peek()){
            minStack.push(x);
        }
        stack.push(x);
    }

    public void pop() {
        int x = stack.pop();
        if(x == minStack.peek()){
            minStack.pop();
        }
    }

    public int top() {
        return stack.peek();
    }

    public int getMin() {
        return minStack.peek();
    }
}

