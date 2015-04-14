
//Reverse Integer 242ms

/**
 * @author:wangzq
 * @email:wangzhenqing1008@163.com
 * @date:2015年04月14日21:58:37
 * @url:https://leetcode.com/problems/reverse-integer/
 * 注意Int最大值
 * 具体参考
 */
public class Reverse_Integer {
    public static int reverse(int x) {
        int flag = x > 0 ? 1 : -1;
        int num = Math.abs(x);
        long result = 0;
        while (num > 0) {
            result = result * 10 + num % 10;
            num /= 10;
        }
        if (result > Integer.MAX_VALUE) {
            return 0;
        }
        return (int) result * flag;
    }
}
