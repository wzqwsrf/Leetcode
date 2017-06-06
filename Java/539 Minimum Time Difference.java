
// 539. Minimum Time Difference

/**
 * @author:wangzq
 * @email:wangzhenqing1008@163.com
 * @date:2017-6-6 17:57:33
 * @url:https://leetcode.com/problems/minimum-time-difference/#/description
 */

public class Solution {
    public int findMinDifference(List<String> timePoints) {
        int size = timePoints.size();
        List<Integer> minutesList = new ArrayList<>();
        int minMinutes = 1440;
        for (int i = 0; i < size; i++) {
            String currPoint = timePoints.get(i);
            if (currPoint.equals("00:00")) {
                currPoint = "24:00";
            }
            String timePoint[] = currPoint.split(":");
            int minutes = 60 * Integer.parseInt(timePoint[0]) + Integer.parseInt(timePoint[1]);
            minutesList.add(minutes);
        }
        Collections.sort(minutesList);
        for (int i = 0; i < size; i++) {
            int minutes = 0;
            if (i == size - 1) {
                int minutes1 = minutesList.get(0);
                int minutes2 = minutesList.get(i);
                minutes = 1440 - minutes2 + minutes1;
            } else {
                minutes = minutesList.get(i + 1) - minutesList.get(i);
            }
            minMinutes = minMinutes > minutes ? minutes : minMinutes;
        }
        return minMinutes;
    }
}