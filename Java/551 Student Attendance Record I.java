
// 551. Student Attendance Record I

/**
 * @author:wangzq
 * @email:wangzhenqing1008@163.com
 * @date:2017-6-6 18:01:09
 * @url:https://leetcode.com/problems/student-attendance-record-i/#/description
 */

public class Solution {
    public boolean checkRecord(String s) {
        int len = s.length();
        int anum = 0;
        for (int i = 0; i < len; i++) {
            if (s.charAt(i) == 'A') {
                anum++;
            }
            if (anum > 1) {
                return false;
            }
            int lnum = 0;
            while (i < len && s.charAt(i) == 'L') {
                lnum++;
                i++;
            }
            if (lnum != 0) {
                i--;
            }
            if (lnum > 2) {
                return false;
            }
        }
        return true;
    }
}