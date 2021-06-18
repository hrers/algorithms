package leetcode.linklist;
import leetcode.common.TreeNode;

import java.util.*;

/**
 * @Author: zhangjianwu
 * @Date: 2021/4/19 9:13
 * @Desc:
 **/
public class lt102BinaryTreeLevelOrderTraversal   {


    public static void main(String[] args) {
        TreeNode root= new TreeNode(3);
        root.left=new TreeNode(9);
        root.right=new TreeNode(20);
        root.right.left=new TreeNode(15);
        root.right.right=new TreeNode(7);
        List<List<Integer>> lists = levelOrder(root);
        for (List<Integer> list : lists) {
            System.out.println(list);
        }
//        levelOrder(null);
    }

    public static List<List<Integer>> levelOrder(TreeNode root) {
        LinkedList<TreeNode> queue=new LinkedList<>();
        List<List<Integer>> resultList=new ArrayList<>();
        Map<TreeNode,Integer> map=new LinkedHashMap<>();
        map.put(root,1);
        queue.add(root);
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
            }else {
                return resultList;
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
        return resultList;
    }
}