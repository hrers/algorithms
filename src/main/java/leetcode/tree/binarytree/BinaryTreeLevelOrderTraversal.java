package leetcode.tree.binarytree;

import leetcode.common.BinaryTreeUtil;
import leetcode.common.TreeNode;
import org.junit.Test;

import java.util.List;

/**
 * @Author: zhangjianwu
 * @Date: 2021/4/18 23:35
 * @Desc:
 * Given the root of a binary tree, return the level order traversal of its nodes' values. (i.e., from left to right, level by level).
 **/
public class BinaryTreeLevelOrderTraversal {

    @Test
    public void  levelOrder() {
        TreeNode root= BinaryTreeUtil.createBinaryTree();
        BinaryTreeUtil.printBinnerTree_level_reverse(root);
    }

}
