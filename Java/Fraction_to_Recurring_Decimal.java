
// Fraction to Recurring Decimal

/**
 * @author:wangzq
 * @email:wangzhenqing1008@163.com
 * @date:2015年05月28日16:31:40
 * @url:https://leetcode.com/problems/fraction-to-recurring-decimal/
 */

import java.util.HashMap;
import java.util.Map;

public class Solution {

    public String fractionToDecimal(int numerator, int denominator) {
        if (numerator == 0) {
            return "0";
        }
        if (denominator == 0) {
            return "";
        }
        long newnumerator = (long) numerator;
        long newdenominator = (long) denominator;
        String prefix = newnumerator < 0 ^ newdenominator < 0 ? "-" : "";
        newnumerator = Math.abs(newnumerator);
        newdenominator = Math.abs(newdenominator);
        String result = newnumerator / newdenominator + "";
        long decimal = newnumerator % newdenominator;
        if (decimal == 0) {
            return prefix + result;
        }
        result += ".";
        int pos = result.length();
        Map<Long, Integer> map = new HashMap<Long, Integer>();
        while (decimal != 0) {
            decimal *= 10;
            long tempNum1 = decimal / newdenominator;
            long tempNum2 = decimal % newdenominator;
            if (map.containsKey(decimal)) {
                int newPos = map.get(decimal);
                result = result.substring(0, newPos) +
                        "(" + result.substring(newPos) + ")";
                break;
            }
            result += tempNum1 + "";
            map.put(decimal, pos);
            pos++;
            decimal = tempNum2;
        }
        return prefix + result;
    }
}