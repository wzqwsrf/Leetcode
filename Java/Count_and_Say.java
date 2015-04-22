
// Count and Say

/**
 * @author:wangzq
 * @email:wangzhenqing1008@163.com
 * @date:2015年04月22日22:53:41
 * @url:https://leetcode.com/problems/count-and-say/
 */

public class Count_and_Say {
    public String countAndSay(int n) {
        String array[] = new String[n];
        array[0] = "1";
        for (int i = 1; i < n; i++) {
            char strArr[] = array[i - 1].toCharArray();
            int len = strArr.length;
            StringBuilder sb = new StringBuilder();
            int j = 0;
            while (j < len) {
                int k = j + 1;
                int count = 1;
                while (k < len && strArr[k] == strArr[j]) {
                    k++;
                    count++;
                }
                sb.append(count);
                sb.append(String.valueOf(strArr[j]));
                j = k;
            }
            array[i] = sb.toString();
        }
        return array[n - 1];
    }
}