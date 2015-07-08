
// Number of Digit One

/**
 * @author:wangzq
 * @email:wangzhenqing1008@163.com
 * @date:2015年07月08日18:18:43
 * @url:https://leetcode.com/problems/number-of-digit-one/
 */

public class Solution {
    public int countDigitOne(int n) {
        if (n <= 0) {
            return 0;
        }
        int iCount = 0;
        long iFactor = 1;
        long iLowerNum = 0;
        int iCurrNum = 0;
        long iHigherNum = 0;
        while (n / iFactor != 0) {
            iLowerNum = n % iFactor;
            iCurrNum = (int) (n / iFactor) % 10;
            iHigherNum = n / (iFactor * 10);
            switch (iCurrNum) {
                case 0:
                    iCount += iHigherNum * iFactor;
                    break;
                case 1:
                    iCount += iHigherNum * iFactor + iLowerNum + 1;
                    break;
                default:
                    iCount += (iHigherNum + 1) * iFactor;
                    break;
            }
            iFactor *= 10;
        }
        return iCount;
    }
}