
// 670. Maximum Swap

/**
 * @author:wangzq
 * @email:wangzhenqing1008@163.com
 * @date:2017-9-4 15:16:36
 * @url:https://leetcode.com/problems/maximum-swap/description/
 */

class Solution {
    public int maximumSwap(int num) {
        List<Integer> list = new ArrayList<>();
        int sum = num;
        while (num > 0) {
            list.add(num % 10);
            num /= 10;
        }
        int size = list.size();
        int array[] = new int[size];
        for (int i = size - 1; i >= 0; i--) {
            array[size - i - 1] = list.get(i);
        }
        int i = 0;
        while (i < size && array[i] == 9) {
            i++;
        }
        for (; i < size; i++) {
            int index = i;
            for (int j = i + 1; j < size; j++) {
                if (array[j] >= array[index] && array[j] != array[i]) {
                    index = j;
                }
            }
            if (index != i) {
                return getNum(array, i, index);
            }
        }
        return sum;
    }

    private int getNum(int[] array, int currIndex, int index) {
        int temp = array[currIndex];
        array[currIndex] = array[index];
        array[index] = temp;
        int sum = 0;
        for (int i = 0; i < array.length; i++) {
            sum = sum * 10 + array[i];
        }
        return sum;
    }
}

//solution 2
class Solution {
    public int maximumSwap(int num) {
        char array[] = String.valueOf(num).toCharArray();
        int len = array.length;
        int bucket[] = new int[10];
        for (int i = 0; i < len; i++) {
            bucket[array[i] - '0'] = i;
        }
        for (int i = 0; i < len; i++) {
            for (int j = 9; j > (array[i] - '0'); j--) {
                if (bucket[j] > i) {
                    char temp = array[i];
                    array[i] = array[bucket[j]];
                    array[bucket[j]] = temp;
                    return Integer.valueOf(new String(array));
                }
            }
        }
        return num;
    }
}