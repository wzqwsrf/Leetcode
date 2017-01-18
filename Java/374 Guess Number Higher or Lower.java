
// 374. Guess Number Higher or Lower

/**
 * @author:wangzq
 * @email:wangzhenqing1008@163.com
 * @date:2017-1-18 13:21:46
 * @url:https://leetcode.com/problems/guess-number-higher-or-lower/
 */

/* The guess API is defined in the parent class GuessGame.
   @param num, your guess
   @return -1 if my number is lower, 1 if my number is higher, otherwise return 0
      int guess(int num); */

public class Solution extends GuessGame {
    public int guessNumber(int n) {
        int low = 1;
        int high = n;
        while (low < high) {
            int mid = (high - low) / 2 + low;
            int res = guess(mid);
            if (res == 0) {
                return mid;
            }
            if (res == 1) {
                low = mid + 1;
            } else {
                high = mid;
            }
        }
        return low;
    }
}