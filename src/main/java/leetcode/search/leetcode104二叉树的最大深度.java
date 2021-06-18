package leetcode.search;

import leetcode.common.BinaryTreeUtil;
import leetcode.common.TreeNode;

/**
 * Definition for a binary tree node.
 */

public class leetcode104二叉树的最大深度{
	public static void main(String[] args) {
		Integer[] a= {3,9,20,null,null,15,7};
		BinaryTreeUtil treeUtil = new BinaryTreeUtil();
		TreeNode root = null;
		TreeNode create = treeUtil.createBiTree(root);
		int deep= treeUtil.countDeep(create);
		System.out.println(deep);
	}
	public static int maxDepth(TreeNode root) {
		return 0;

	}
}
