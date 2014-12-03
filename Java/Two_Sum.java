
// Two Sum 384ms

/**
 * @author:wangzq
 * @email:wangzhenqing1008@163.com
 * @date:2014年07月02日18:05:21
 * @url:https://oj.leetcode.com/problems/two-sum/
 * 1、借助Map，每次边检查边存数据。一直到找到结果为止。
 * 2、疑问，例如numbers = [2,2,3,7,6], target = 5
 * 用了两种方法，得出的结果一个为[1,3]，另一个为[2,3]，
 * 居然都AC了。
 * 具体参考：http://blog.csdn.net/u013027996/article/details/17660515
 */

import java.util.HashMap;
import java.util.Map;

public class Two_Sum {
    public int[] twoSum(int[] numbers, int target) {
        Map<Integer, Integer> numMap = new HashMap<Integer, Integer>();
        int len = numbers.length;
        int array[] = new int[2];
        for (int i = 0; i < len; i++) {
            if (numMap.containsKey(target - numbers[i])) {
                array[0] = numMap.get(target - numbers[i]) + 1;
                array[1] = i + 1;
            } else {
                numMap.put(numbers[i], i);
            }
        }
        return array;
    }
}