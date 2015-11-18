
// Find Median from Data Stream

/**
 * @author:wangzq
 * @email:wangzhenqing1008@163.com
 * @date:2015-11-18 14:25:50
 * @url:https://leetcode.com/problems/find-median-from-data-stream/
 */

class MedianFinder {

    PriorityQueue<Integer> max = new PriorityQueue(1000,
            Collections.reverseOrder());
    PriorityQueue<Integer> min = new PriorityQueue<Integer>();

    // Adds a number into the data structure.
    public void addNum(int num) {
        max.offer(num);
        min.offer(max.poll());
        if (max.size() < min.size()){
            max.offer(min.poll());
        }
    }

    // Returns the median of current data stream
    public double findMedian() {
        if (max.size() == min.size()) {
            return (double) (max.peek() + min.peek()) / 2.0;
        }
        return (double) max.peek();
    }
};

// Your MedianFinder object will be instantiated and called as such:
// MedianFinder mf = new MedianFinder();
// mf.addNum(1);
// mf.findMedian();