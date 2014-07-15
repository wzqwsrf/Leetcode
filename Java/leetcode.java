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

//Multiply Strings 476ms
/*
 * @author:wangzq
 * @email:wangzhenqing1008@163.com
 * @date:2014年07月04日10:26:44
 * @url:https://oj.leetcode.com/problems/multiply-strings/
 * 1、数学计算的基本思想转为代码实现。
 * 2、num1和num2按位相乘，累加。
 * 3、两数相乘最大位数，是len(num1)+len(num2)
 * 4、注意两者之中出现"000"这种情况的返回值
 * 5、比较考验基本功底，建议练习。
 * 具体参考http://blog.csdn.net/u013027996/article/details/36868975
 */
public class Solution {
    public String multiply(String num1, String num2) {
		if ("".equals(num1.replace("0", ""))
				|| "".equals(num2.replace("0", ""))) {
			return "0";
		}
		int len1 = num1.length();
		int len2 = num2.length();
		char arrayA[];
		char arrayB[];
		arrayA = num1.toCharArray();
		arrayB = num2.toCharArray();
		int column = len1 + len2;
		int array[] = new int[column];
		int k = column;
		for (int i = len2 - 1; i >= 0; i--) {
			k--;
			int tempCol = k;
			int tempArr[] = new int[column];
			int num = arrayB[i] - '0';
			for (int j = len1 - 1; j >= 0; j--) {
				tempArr[tempCol] += (arrayA[j] - '0') * num;
				if (tempArr[tempCol] >= 10) {
					int mod = tempArr[tempCol] / 10;
					tempArr[tempCol] %= 10;
					tempArr[tempCol - 1] += mod;
				}
				tempCol--;
			}
			array = addNum(tempArr, array, column);
		}
		StringBuffer sb = new StringBuffer();
		int i = 0;
		if (array[0] == 0) {
			i = 1;
		}
		for (; i < column; i++) {
			sb.append(array[i]);
		}
		return sb.toString();
	}

	public int[] addNum(int tempArr[], int array[], int column) {
		for (int i = column - 1; i >= 0; i--) {
			array[i] += tempArr[i];
			if (array[i] >= 10) {
				array[i] -= 10;
				array[i - 1] += 1;
			}
		}
		return array;
	}
}

//Pascal's Triangle 364ms
/*
 * @author:wangzq
 * @email:wangzhenqing1008@163.com
 * @date:2014年07月04日18:57:25
 * @url:https://oj.leetcode.com/problems/pascals-triangle/
 * 1、numRows表示有几行，注意列表从0开始。
 * 2、每一行的列表是这样构成的，开头和结尾都是1，中间是前一个列表相邻两个数之和。
 * 具体参考http://blog.csdn.net/u013027996/article/details/36899443
 */
public class Solution {
    public ArrayList<ArrayList<Integer>> generate(int numRows) {
        ArrayList<ArrayList<Integer>> list = new ArrayList<ArrayList<Integer>>();
        if(numRows <= 0){
            return list;
        }
        ArrayList<Integer> firstList = new ArrayList<Integer>();
        firstList.add(1);
        list.add(firstList);
        for(int i = 1; i < numRows; i++){
            ArrayList<Integer> secList = new ArrayList<Integer>();
            ArrayList<Integer> tempList = list.get(i-1);
            int size = tempList.size();
            secList.add(1);
            for(int j = 1; j < size; j++){
                secList.add(tempList.get(j-1) + tempList.get(j));
            }
            secList.add(1);
            list.add(secList);
        }
        return list;
    }
}

//Pascal's Triangle 392ms
/*
 * @author:wangzq
 * @email:wangzhenqing1008@163.com
 * @date:2014年07月04日18:59:41
 * @url:https://oj.leetcode.com/problems/pascals-triangle-ii/
 * 1、参照Pascal's Triangle，算出所有的list，直接get(rowIndex)
 * 2、如果是空间限制，只能声明k长度的list，依次计算。
 * 具体参考http://blog.csdn.net/u013027996/article/details/36905037
 */
 public class Solution {
    public List<Integer> getRow(int rowIndex) {
		List<Integer> list = new ArrayList<Integer>();
		list.add(1);
		for (int i = 1; i < rowIndex + 1; i++) {
			int curNum = 1;
			for (int j = 1; j < i; j++) {
				int temp = curNum;
				curNum = list.get(j);
				list.set(j, curNum + temp);
			}
			list.add(1);
		}
		return list;
	}
}

//Validate Binary Search Tree 416ms
/*
 * @author:wangzq
 * @email:wangzhenqing1008@163.com
 * @date:2014年07月11日12:15:30
 * @url:https://oj.leetcode.com/problems/validate-binary-search-tree/
 * 1、二叉搜索树的基本判断，左孩子比根值小，右孩子比根值大。
 * 2、按照这个思路，默认的最大最小值是int的值范围。
 * 3、递归判断，每次判断左右孩子的值和最大最小值的比较。
 * 4、一直到根为空，递归结束。
 * 具体参考http://blog.csdn.net/u013027996/article/details/37692581
 */
/*
 * Definition for binary tree
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
    public boolean isValidBST(TreeNode root) {
        return dfs(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }
    public boolean dfs(TreeNode root, int min, int max){
        if(root == null){
            return true;
        }
        if(root.val <= min || root.val >= max){
            return false;
        }
        return dfs(root.left, min, root.val) && dfs(root.right, root.val, max);
    }
}

//Merge Two Sorted Lists 576ms
/*
 * @author:wangzq
 * @email:wangzhenqing1008@163.com
 * @date:2014年07月15日10:27:52
 * @url:https://oj.leetcode.com/problems/merge-two-sorted-lists/
 * 归并排序，考察基本功。
 * 赋值的时候可以new一个节点，也可以将一个链表赋值给另外一个，后者相对慢一些。
 * 具体参考http://blog.csdn.net/u013027996/article/details/37810407
 */
/*
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
	public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
		ListNode node = new ListNode(0);
		ListNode point = node;
		while (l1 != null && l2 != null) {
			if (l1.val > l2.val) {
				point.next = l2;
				point = point.next;
				l2 = l2.next;
			} else {
				point.next = l1;
				point = point.next;
				l1 = l1.next;
			}
		}
		if (l1 != null) {
			point.next = l1;
		}
		if (l2 != null) {
			point.next = l2;
		}
		return node.next;
	}
}
