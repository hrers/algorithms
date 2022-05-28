package leetcode.tree.binarytree;

import common.util.BinaryTreeUtil;
import common.util.TreeNode;

import java.util.LinkedList;

/**
 * @Author: zhangjianwu
 * @Date: 2022/3/26 16:20
 * @Desc:
 **/
public class lt_100_SameTree {

    public static boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null && q == null) {
            return true;
        } else if (p == null || q == null) {
            return false;
        } else if (p.val != q.val) {
            return false;
        }
        return isSameTree(p.left, q.left) && isSameTree(p.right, q.right) && true;
    }
}
