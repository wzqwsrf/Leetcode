
// Insert Interval

/**
 * @author:wangzq
 * @email:wangzhenqing1008@163.com
 * @date:2015年05月12日17:54:18
 * @url:https://leetcode.com/problems/insert-interval/
 */

import java.util.ArrayList;

public class Solution {

    public ArrayList<Interval> insert(ArrayList<Interval> intervals,
                                      Interval newInterval) {
        ArrayList<Interval> list = new ArrayList<Interval>();
        if (intervals == null || intervals.size() == 0) {
            list.add(newInterval);
            return list;
        }
        int pos = searchInsert(intervals, newInterval.start);
        return merge(intervals, pos, newInterval);

    }

    public ArrayList<Interval> merge(ArrayList<Interval> intervals,
                                     int pos, Interval newInterval) {
        if (intervals == null) {
            return intervals;
        }
        int size = intervals.size();
        ArrayList<Interval> newList = new ArrayList<Interval>();
        if (pos == 0) {
            newList.add(newInterval);
            newList.addAll(intervals);
        } else if (pos == size) {
            newList.addAll(intervals);
            newList.add(newInterval);
        } else {
            int i = 0;
            while (i < size) {
                if (i == pos) {
                    newList.add(newInterval);
                }
                newList.add(intervals.get(i));
                i++;
            }
        }
        return merge(newList);
    }

    public ArrayList<Interval> merge(ArrayList<Interval> intervals) {
        int size = intervals.size();
        ArrayList<Interval> list = new ArrayList<Interval>();
        Interval interval = intervals.get(0);
        int start = interval.start;
        int end = interval.end;
        for (int i = 1; i < size; i++) {
            Interval intval = intervals.get(i);
            if (intval.start <= end) {
                int tempSize = list.size();
                if (tempSize > 0) {
                    list.remove(tempSize - 1);
                }
                start = Math.min(start, intval.start);
                end = Math.max(end, intval.end);
            } else {
                if (i == 1) {
                    list.add(new Interval(start, end));
                }
                start = intval.start;
                end = intval.end;
            }
            list.add(new Interval(start, end));
        }
        return list;
    }

    public int searchInsert(ArrayList<Interval> intervals, int target) {
        int size = intervals.size();
        if (target < intervals.get(0).start) {
            return 0;
        }
        if (target > intervals.get(size - 1).end) {
            return size;
        }
        int low = 0;
        int high = size - 1;
        int mid = 0;
        while (low <= high) {
            mid = (low + high) >> 1;
            if (intervals.get(mid).start > target) {
                high = mid - 1;
            } else if (intervals.get(mid).start < target) {
                low = mid + 1;
            } else {
                return mid;
            }
        }
        return low;
    }

    public class Interval {
        int start;
        int end;

        Interval() {
            start = 0;
            end = 0;
        }

        Interval(int s, int e) {
            start = s;
            end = e;
        }
    }
}

