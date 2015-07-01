
// Min Stack

/**
 * @author:wangzq
 * @email:wangzhenqing1008@163.com
 * @date:2015年01月23日19:05:58
 * @url:https://oj.leetcode.com/problems/min-stack/
 * 每次把最小数保存在minStack中，pop的时候判断是否和当前栈顶元素相等。
 * 具体参考http://blog.csdn.net/u013027996/article/details/43090751
 */

class Solution {

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

