
// Same Tree

/**
 * @author:wangzq
 * @email:wangzhenqing1008@163.com
 * @date:2015年05月28日17:24:53
 * @url:https://leetcode.com/problems/same-tree/
 */

import java.util.ArrayList;

public class Solution {

    public boolean isSameTree(TreeNode p, TreeNode q) {
        if(p != null && q != null){
            if(p.val != q.val){
                return false;
            }
            boolean lFlag = isSameTree(p.left,q.left);
            boolean rFlag = isSameTree(p.right,q.right);
            if(!lFlag || !rFlag){
                return false;
            }
        }
        if((p != null && q == null) || (p == null && q != null)){
            return false;
        }
        return true;
    }
}