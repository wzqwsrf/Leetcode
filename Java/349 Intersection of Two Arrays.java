
// Intersection of Two Arrays

/**
 * @author:wangzq
 * @email:wangzhenqing1008@163.com
 * @date:2016-6-4 20:05:01
 * @url:https://leetcode.com/problems/intersection-of-two-arrays/
 */

public class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        if(nums1.length == 0 || nums2.length == 0){
            return new int[]{};
        }
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        Set<Integer> set = new HashSet<Integer>();
        int i = 0;
        int j = 0;
        while(i < nums1.length && j < nums2.length){
            if(nums1[i] < nums2[j]){
                i++;
            }else if(nums1[i] > nums2[j]){
                j++;
            }else{
                set.add(nums1[i]);
                i++;
                j++;
            }
        }
        int nums[] = new int[set.size()];
        i = 0;
        Iterator<Integer> iterator = set.iterator();
        while(iterator.hasNext()){
            nums[i] = iterator.next();
            i++;
        }
        return nums;
    }
}