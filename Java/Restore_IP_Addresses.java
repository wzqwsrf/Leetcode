
//Restore IP Addresses

import java.util.ArrayList;

/**
 * @author:wangzq
 * @email:wangzhenqing1008@163.com
 * @date:2015年05月28日17:23:40
 * @url:https://leetcode.com/problems/restore-ip-addresses/
 */

public class Restore_IP_Addresses {

    public ArrayList<String> restoreIpAddresses(String s) {
        ArrayList<String> list = new ArrayList<String>();
        dfs(list, s, new StringBuffer(), 0);
        return list;
    }

    private void dfs(ArrayList<String> list, String s,
                     StringBuffer sb, int num) {
        if (num == 4) {
            list.add(sb.toString());
            return;
        }
        int len = s.length();
        int min = Math.max(1, len - (3 - num) * 3);
        int max = Math.min(3, len - (3 - num));
        int end = min;
        while (end >= min && end <= max) {
            String news = s.substring(0, end);
            if (end != 1 && news.charAt(0) == '0') {
                break;
            }
            int tempNum = Integer.parseInt(news);
            if (tempNum >= 0 && tempNum < 256) {
                StringBuffer newsb = new StringBuffer(sb);
                if (!"".equals(newsb.toString())) {
                    newsb.append(".");
                }
                newsb.append(news);
                dfs(list, s.substring(end), newsb, num + 1);
            }
            end++;
        }
    }
}