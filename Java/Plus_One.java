
// Plus One 368ms

/**
 * @author:wangzq
 * @email:wangzhenqing1008@163.com
 * @date:2015年05月12日18:01:17
 * @url:https://leetcode.com/problems/plus-one/
 */

public class Plus_One {

    public int[] plusOne(int[] digits) {
        int len = digits.length;
        int addNum[] = new int[len + 1];
        addNum[len] = 1;
        for (int i = len - 1; i >= 0; i--) {
            addNum[i + 1] += digits[i];
            if (addNum[i + 1] >= 10) {
                addNum[i + 1] -= 10;
                addNum[i] += 1;
            }
        }
        if (addNum[0] == 0) {
            System.arraycopy(addNum, 1, digits, 0, len);
            return digits;
        } else {
            return addNum;
        }
    }
}