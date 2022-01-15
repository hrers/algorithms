package leetcode.linklist;

import common.util.TreeNode;
import common.util.BinaryTreeUtil;

/**
 * @Author: zhangjianwu
 * @Date: 2021/4/19 15:41
 * @Desc:
 **/


public class lt110BalancedBinaryTree {
    public static void main(String[] args) {
        TreeNode root = BinaryTreeUtil.createBinaryTree();
        System.out.println(isBalanced(root));
    }
    public static   boolean isBalanced(TreeNode root) {
        return high(root)>=0;
    }
    public  static int high(TreeNode root){
        if(root==null){
            return 0;
        }
        int leftHigh= high(root.left);
        int rightHigh= high(root.right);
        if(leftHigh==-1||rightHigh==-1||Math.abs(leftHigh-rightHigh)>1){
            return -1;
        }
        return Math.max(leftHigh,rightHigh)+1;
    }
}
