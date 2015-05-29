
//Max Points on a Line

import java.util.HashMap;
import java.util.Map;

/**
 * @author:wangzq
 * @email:wangzhenqing1008@163.com
 * @date:2015年05月29日17:14:23
 * @url:https://leetcode.com/problems/max-points-on-a-line/
 */

public class Max_Points_on_a_Line {
    public int maxPoints(Point[] points) {
        if (points == null || points.length == 0) {
            return 0;
        }
        int n = points.length;
        if (n == 1 || n == 2) {
            return n;
        }
        Point[] newPoints = new Point[n];
        int k = 0;
        Map<String, Integer> numMap = new HashMap<String, Integer>();
        for (int i = 0; i < n; i++) {
            int x = points[i].x;
            int y = points[i].y;
            String xy = x + "_" + y;
            int num = 1;
            if (numMap.containsKey(xy)) {
                num += numMap.get(xy);
            } else {
                newPoints[k] = new Point(x, y);
                k++;
            }
            numMap.put(xy, num);
        }
        n = k;
        int maxNum = 0;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                int tempNum = 0;
                tempNum += numMap.get(newPoints[i].x + "_" + newPoints[i].y)
                        + numMap.get(newPoints[j].x + "_" + newPoints[j].y);
                for (k = j + 1; k < n; k++) {
                    int num1 = (newPoints[k].y - newPoints[i].y) * (newPoints[j].x - newPoints[i].x);
                    int num2 = (newPoints[j].y - newPoints[i].y) * (newPoints[k].x - newPoints[i].x);
                    if (num1 == num2) {
                        tempNum += numMap.get(newPoints[k].x + "_" + newPoints[k].y);
                        ;
                    }
                }
                maxNum = Math.max(tempNum, maxNum);
            }
        }
        for (int value : numMap.values()) {
            maxNum = Math.max(value, maxNum);
        }
        return maxNum;
    }

    static class Point {
        int x;
        int y;

        Point() {
            x = 0;
            y = 0;
        }

        Point(int a, int b) {
            x = a;
            y = b;
        }
    }
}