
// 352. Data Stream as Disjoint Intervals

/**
 * @author:wangzq
 * @email:wangzhenqing1008@163.com
 * @date:2017-08-20 00:33:31
 * @url:https://leetcode.com/problems/data-stream-as-disjoint-intervals/description/
 */

/**
 * Definition for an interval.
 * public class Interval {
 *     int start;
 *     int end;
 *     Interval() { start = 0; end = 0; }
 *     Interval(int s, int e) { start = s; end = e; }
 * }
 */
class SummaryRanges {

    List<Interval> list;

    /**
     * Initialize your data structure here.
     */
    public SummaryRanges() {
        list = new ArrayList<Interval>();
    }

    public void addNum(int val) {
        int size = list.size();
        if (size == 0) {
            list.add(new Interval(val, val));
            return;
        }
        boolean flag = false;
        int end = Integer.MIN_VALUE;
        for (int i = 0; i < size; i++) {
            Interval interval = list.get(i);
            if (val >= interval.start && val <= interval.end) {
                flag = true;
                break;
            }
            if (end + 1 == val && val + 1 == interval.start) {
                list.get(i).start = list.get(i - 1).start;
                list.remove(i - 1);
                flag = true;
                break;
            }
            if (end + 1 == val) {
                list.get(i - 1).end = val;
                flag = true;
                break;
            }
            if (val + 1 == interval.start) {
                list.get(i).start = val;
                flag = true;
                break;
            }
            if (val > end && val < interval.start) {
                list.add(i, new Interval(val, val));
                flag = true;
                break;
            }
            end = interval.end;
        }
        if (!flag) {
            Interval interval = list.get(size - 1);
            if (val == interval.end + 1) {
                list.get(size - 1).end = val;
            } else {
                list.add(new Interval(val, val));
            }
        }
    }

    public List<Interval> getIntervals() {
        return list;
    }
}

/**
 * Your SummaryRanges object will be instantiated and called as such:
 * SummaryRanges obj = new SummaryRanges();
 * obj.addNum(val);
 * List<Interval> param_2 = obj.getIntervals();
 */