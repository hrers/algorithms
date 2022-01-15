package leetcode.linklist;

import common.util.TreeNode;

/**
 * @Author: zhangjianwu
 * @Date: 2021/4/19 22:40
 * @Desc:
 **/
public class jzoffer55_1 {

    public int maxDepth(TreeNode root) {
        if(root==null){
            return 0;
        }
        int lhigh=maxDepth(root.left);
        int rhigh=maxDepth(root.right);
        return lhigh>rhigh?lhigh+1:rhigh+1;
    }
}
