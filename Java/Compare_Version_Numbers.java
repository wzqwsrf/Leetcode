
//Compare Version Numbers

/**
 * @author:wangzq
 * @email:wangzhenqing1008@163.com
 * @date:2015年05月29日17:08:47
 * @url:https://leetcode.com/problems/compare-version-numbers/
 */

public class Compare_Version_Numbers {
    public int compareVersion(String version1, String version2) {
        String vMsg1[] = version1.split("\\.");
        String vMsg2[] = version2.split("\\.");
        int len1 = vMsg1.length;
        int len2 = vMsg2.length;
        int k = 0;
        while (k < len1 || k < len2) {
            int v1 = k < len1 ? Integer.parseInt(vMsg1[k]) : 0;
            int v2 = k < len2 ? Integer.parseInt(vMsg2[k]) : 0;
            if (v1 == v2) {
                k++;
            } else {
                return v1 > v2 ? 1 : -1;
            }
        }
        return 0;
    }
}