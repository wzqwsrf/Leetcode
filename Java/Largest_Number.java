
// Largest Number 273 ms

/**
 * Given a list of non negative integers, arrange them such that they form the largest number.
 * For example, given [3, 30, 34, 5, 9], the largest formed number is 9534330.
 * Note: The result may be very large, so you need to return a string instead of an integer.
 * Credits:
 * Special thanks to @ts for adding this problem and creating all test cases.
 */

/**
 * @author:wangzq
 * @email:wangzhenqing1008@163.com
 * @date:2015年01月15日15:19:16
 * @url:https://oj.leetcode.com/problems/largest-number/
 * 其实就是排序，比较相邻两个字符拼接成字符串之后那个大
 * 具体参考：
 */

public class Largest_Number {
    public String largestNumber(int[] num) {
        int len = num.length;
        String array[] = new String[len];
        for (int i = 0; i < len; i++) {
            array[i] = String.valueOf(num[i]);
        }
        Arrays.sort(array, new MySort());
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < len; i++) {
            sb.append(array[i]);
        }
        String result = sb.toString();
        if ("".equals(result.replace("0",""))) {
            return "0";
        }
        return sb.toString();
    }

    public class MySort implements Comparator<String> {
        @Override
        public int compare(String o1, String o2) {
            return (o2 + o1).compareTo(o1 + o2);
        }
    }
}

