package leetcode.common;
import java.util.Scanner;

import javax.swing.text.html.HTMLDocument.HTMLReader.PreAction;

import leetcode.common.TreeNode;

public class BiTree {

	public static TreeNode createBiTree(TreeNode note) {
		Scanner scan = new Scanner(System.in);
		int num = scan.nextInt();
		if(num==-999) {
			note=null;
			return note;
		}else {
			note=new TreeNode(num);
			note.left=createBiTree(note.left);
			note.right=createBiTree(note.right);
			return note;
		}
	}
	public static int preOrderAllFirst(TreeNode root) {
		int deep=0;
		if(root != null) {
			int leftDeep=preOrderAllFirst(root.left);
			int rightDeep=preOrderAllFirst(root.right);
			deep=leftDeep>=rightDeep+1?leftDeep:rightDeep+1;
		}
		return deep;
	}


}
