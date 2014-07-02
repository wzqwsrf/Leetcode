// Add Binary 444ms
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