// Add Binary 444ms
/*
 * @author:wangzq
 * @email:wangzhenqing1008@163.com
 * @date:2014年07月02日17:25:17
 * @url:https://oj.leetcode.com/problems/add-binary/
 * 1、二进制加法，最基本的还是将字符串转为字符数组，按位相加，注意进位问题。
 * 2、两个数相加的最大位数，是二者长度之中最大值或者最大值加1
 * 具体参考：http://blog.csdn.net/u013027996/article/details/36436901
 */
class Solution {
	public String addBinary(String a, String b) {
		if (a == null || b == null) {
			return "";
		}
		if ("".equals(a) || "".equals(b)) {
			return "";
		}
		if ("".equals(a.replaceAll("0", ""))
				&& "".equals(b.replaceAll("0", ""))) {
			return "0";
		}
		int len1 = a.length();
		int len2 = b.length();
		char arrayA[] = a.toCharArray();
		char arrayB[] = b.toCharArray();
		int maxLen = Math.max(len1, len2);
		int array[] = new int[maxLen + 1];
		int k = maxLen;
		while (len1 > 0 && len2 > 0) {
			array[k] += arrayA[len1 - 1] - '0' + arrayB[len2 - 1] - '0';
			if (array[k] >= 2) {
				array[k] -= 2;
				array[k - 1] += 1;
			}
			k--;
			len1--;
			len2--;
		}
		while (len1 > 0) {
			array[k] += arrayA[len1 - 1] - '0';
			if (array[k] >= 2) {
				array[k] -= 2;
				array[k - 1] += 1;
			}
			len1--;
			k--;
		}
		while (len2 > 0) {
			array[k] += arrayB[len2 - 1] - '0';
			if (array[k] >= 2) {
				array[k] -= 2;
				array[k - 1] += 1;
			}
			len2--;
			k--;
		}
		StringBuffer sb = new StringBuffer();
		int i = 0;
		if (array[0] == 0) {
			i = 1;
		}
		for (; i < maxLen + 1; i++) {
			sb.append(array[i]);
		}
		return sb.toString();
	}
}

// Two Sum 384ms
/*
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
public class Solution {
    public int[] twoSum(int[] numbers, int target) {
        Map<Integer, Integer> numMap = new HashMap<Integer, Integer>();
        int len = numbers.length;
        int array[] = new int[2];
        for(int i = 0; i < len; i++){
            if(numMap.containsKey(target - numbers[i])){
                array[0] = numMap.get(target - numbers[i]) + 1;
                array[1] = i + 1;
            }else{
                numMap.put(numbers[i], i);
            }
        }
        return array;
    }
}

// Spiral Matrix 340ms
/*
 * @author:wangzq
 * @email:wangzhenqing1008@163.com
 * @date:2014年07月02日18:56:01
 * @url:https://oj.leetcode.com/problems/spiral-matrix/
 * 1、设定边界值，startx，endx，starty，endy。
 * 2、左到右，上到下，右到左，下到上，直到while条件结束。
 * 具体参考http://blog.csdn.net/u013027996/article/details/36631355
 */
public class Solution {
    public ArrayList<Integer> spiralOrder(int[][] matrix) {
		ArrayList<Integer> allList = new ArrayList<Integer>();
		if (matrix == null || matrix.length == 0) {
			return allList;
		}
		allList = printfMatrix(matrix);
		return allList;
	}

	public ArrayList<Integer> printfMatrix(int[][] matrix) {
		ArrayList<Integer> allList = new ArrayList<Integer>();
		int m = matrix.length;
		int n = matrix[0].length;
		int startx = 0;
		int starty = 0;
		int endx = m - 1;
		int endy = n - 1;
		while (startx <= endx && starty <= endy) {
			for (int i = starty; i <= endy; i++) {
				allList.add(matrix[startx][i]);
			}
			for (int i = startx+1; i <= endx; i++) {
				allList.add(matrix[i][endy]);
			}
			if (startx != endx) {
				for (int i = endy-1; i >= starty; i--) {
					allList.add(matrix[endx][i]);
				}
			}
			if (starty != endy) {
				for (int i = endx-1; i > startx; i--) {
					allList.add(matrix[i][starty]);
				}
			}
			startx++;
			endx--;
			starty++;
			endy--;
		}
		return allList;
	}
}

//Spiral Matrix II 348ms
/*
 * @author:wangzq
 * @email:wangzhenqing1008@163.com
 * @date:2014年07月03日109:51:32
 * @url:https://oj.leetcode.com/problems/spiral-matrix-ii/
 * 和Spiral Matrix一样，但是这次不是打印矩阵的内容了，而是赋值，思路仍然一致。
 * 1、设定边界值，startx，endx，starty，endy。
 * 2、左到右，上到下，右到左，下到上，直到while条件结束。
 * 具体参考http://blog.csdn.net/u013027996/article/details/36638519
 */
public class Solution {
    public int[][] generateMatrix(int n) {
		int [][]matrix = new int[n][n];
		int startx = 0;
		int starty = 0;
		int endx = n - 1;
		int endy = n - 1;
		int num = 1;
		while (startx <= endx && starty <= endy) {
			for (int i = starty; i <= endy; i++) {
				matrix[startx][i] = num;
				num++;
			}
			for (int i = startx+1; i <= endx; i++) {
				matrix[i][endy] = num;
				num++;
			}
			if (startx != endx) {
				for (int i = endy-1; i >= starty; i--) {
					matrix[endx][i] = num;
					num++;
				}
			}
			if (starty != endy) {
				for (int i = endx-1; i > startx; i--) {
					matrix[i][starty] = num;
					num++;
				}
			}
			startx++;
			endx--;
			starty++;
			endy--;
		}
		return matrix;
	}
}
