
// Integer to English Words

/**
 * @author:wangzq
 * @email:wangzhenqing1008@163.com
 * @date:2015-09-01 11:20:43
 * @url:https://leetcode.com/problems/integer-to-english-words/
 */

public class Solution {
    public String numberToWords(int num) {
        if (num == 0) {
            return "Zero";
        }
        String result = actualNumberToWords(num % 1000);
        String highArray[] = new String[]{"Thousand ", "Million ", "Billion "};
        int len = highArray.length;
        for (int i = 0; i < len; i++) {
            num /= 1000;
            if (num > 0 && num % 1000 > 0) {
                result = actualNumberToWords(num % 1000) + highArray[i] + result;
            }
        }
        return result.trim();
    }

    private String actualNumberToWords(int num) {
        String[] array1 = new String[]{"Zero", "One", "Two", "Three", "Four",
                "Five", "Six", "Seven", "Eight", "Nine"};
        String[] array2 = new String[]{"Ten", "Eleven", "Twelve", "Thirteen", "Fourteen",
                "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen"};
        String[] array3 = new String[]{"", "", "Twenty", "Thirty", "Forty", "Fifty",
                "Sixty", "Seventy", "Eighty", "Ninety"};
        String result = "";
        if (num >= 100) {
            result = array1[num / 100] + " Hundred ";
        }
        num %= 100;

        if (num >= 10 && num < 20) {
            result = result + array2[num % 10] + " ";
        } else {
            if (num >= 20) {
                result = result + array3[num / 10] + " ";
            }
            num %= 10;
            if (num > 0) {
                result = result + array1[num] + " ";
            }
        }
        return result;
    }
}

