package leetcode.common;

import org.junit.Test;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class BinaryTreeUtil {
	public static void main(String[] args) {
		TreeNode root = createBinaryTree();
		//printBinnerTree_clasical(root);
        //printBinnerTree_level_reverse(root);
		printBinnerTree_level(root);
		int i = countDeep(root);
		System.out.println("deep="+i);
	}

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

	public static TreeNode createBinaryTree(){
		TreeNode root = new TreeNode(1);
		root.left=new TreeNode(2);
		TreeNode l11= new TreeNode(4);
		TreeNode l12= new TreeNode(5);
		root.left.left=l11;
		root.left.right=l12;
		TreeNode r11= new TreeNode(6);
		TreeNode r12= new TreeNode(7);
		root.right=new TreeNode(3);
		root.right.left=r11;
		root.right.right=r12;
		return root;
	}

	public static int countDeep(TreeNode root) {
		int deep=0;
		if(root != null) {
			int leftDeep= countDeep(root.left);
			int rightDeep= countDeep(root.right);
			deep=leftDeep>=rightDeep+1?leftDeep:rightDeep+1;
		}
		return deep;
	}

	@Test
	public void testCountBreadth(){
		TreeNode root = BinaryTreeUtil.createBinaryTree();
		int i = countBreadth(root);
		System.out.println("宽度为"+i);
	}
	//计算二叉树的宽度
	public static int countBreadth(TreeNode root){
		LinkedHashMap<TreeNode, Integer> map= new LinkedHashMap<>();
		LinkedList<TreeNode> queue = new LinkedList<>();
		map.put(root,1);
		queue.add(root);
		while (queue.size()!=0){
			TreeNode peek = queue.peek();
			if(peek!=null){
				if(peek.left!=null){
					queue.add(peek.left);
					map.put(peek.left,map.get(peek)+1);
				}
				if(peek.right!=null){
					queue.add(peek.right);
					map.put(peek.right,map.get(peek)+1);
				}
				queue.pop();
			}
		}
		//统计相同value的key的个数，将value作为另一个map的key
		HashMap<Integer,Integer> countMap=new HashMap<>();
		for (TreeNode treeNode : map.keySet()) {
			if(countMap.containsKey(map.get(treeNode))){
				countMap.put(map.get(treeNode),countMap.get(map.get(treeNode))+1);
			}else {
				countMap.put(map.get(treeNode),1);
			}
		}
		return (int) countMap.values().stream().sorted(Comparator.reverseOrder()).toArray()[0];
	}

	//经典递归打印二叉树
	public static void printBinnerTree_clasical(TreeNode root){
		System.out.println(root.val+" ");
	    if(root.left!=null){
			printBinnerTree_clasical(root.left);
		}
		if(root.right!=null){
			printBinnerTree_clasical(root.right);
		}
	}

	//层序遍历打印二叉树（自顶向下)
	public static void printBinnerTree_level(TreeNode root){
		LinkedList<TreeNode> queue=new LinkedList<>();
		List<List<Integer>> resultList=new ArrayList<>();
		Map<TreeNode,Integer> map=new LinkedHashMap<>();
		map.put(root,1);
		queue.add(root);
		/**
		 * 基本思路，将二叉树添加到队列中，使用LinkedHashMap 通过value判断是够属于同一层级,不能使用HashMap，不然同一层次中的元素位置就会乱了
 		 */
		while (queue.size()!=0){
			//todo 若peek==null?
			TreeNode peek = queue.peek();
			if(peek!=null){
				if(peek.left!=null){
					queue.add(peek.left);
					map.put(peek.left,map.get(peek)+1);
				}
				if(peek.right!=null){
					queue.add(peek.right);
					map.put(peek.right,map.get(peek)+1);
				}
				TreeNode pop = queue.pop();
			}
		}
		Object[] objects = map.values().stream().distinct().sorted().toArray();
		for (Object object : objects) {
			List<Integer> tempList=new ArrayList<>();
			for (TreeNode treeNode : map.keySet()) {
				if(map.get(treeNode)==(Integer) object){
					tempList.add(treeNode.val);
				}
			}
			resultList.add(tempList);
		}
		for (List<Integer> integers : resultList) {
			System.out.println(integers);
		}
	}

	//层序打印二叉树（字底向上）
	public static void printBinnerTree_level_reverse(TreeNode root){
		LinkedList<TreeNode> queue=new LinkedList<>();
		List<List<Integer>> resultList=new ArrayList<>();
		Map<TreeNode,Integer> map=new LinkedHashMap<>();
		map.put(root,1);
		queue.add(root);
		/**
		 * 基本思路，将二叉树添加到队列中，使用LinkedHashMap 通过value判断是够属于同一层级,不能使用HashMap，不然同一层次中的元素位置就会乱了
		 */
		while (queue.size()!=0){
			//todo 若peek==null?
			TreeNode peek = queue.peek();
			if(peek!=null){
				if(peek.left!=null){
					queue.add(peek.left);
					map.put(peek.left,map.get(peek)+1);
				}
				if(peek.right!=null){
					queue.add(peek.right);
					map.put(peek.right,map.get(peek)+1);
				}
				TreeNode pop = queue.pop();
			}
		}
		Stream<Integer> sorted = map.values().stream().distinct().sorted(Comparator.reverseOrder());
		List<Integer> collect = sorted.collect(Collectors.toList());
		Integer[] objects= collect.toArray(new Integer[collect.size()]);
		for (Object object : objects) {
			List<Integer> tempList=new ArrayList<>();
			for (TreeNode treeNode : map.keySet()) {
				if(map.get(treeNode)==(Integer) object){
					tempList.add(treeNode.val);
				}
			}
			resultList.add(tempList);
		}
		for (List<Integer> integers : resultList) {
			System.out.println(integers);
		}
	}

}
