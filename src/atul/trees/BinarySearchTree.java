package atul.trees;

import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Stack;

/**
 * Created by agosain on 5/3/2017.
 */
public class BinarySearchTree {
    public static TreeNode createMinimalisticBinaryTree(int arr[]){
        return addToTree(arr, 0, arr.length-1);
    }

    public static String inorder(TreeNode rootNode, String nodes){
        if(rootNode==null)
            return "";
        return nodes+inorder(rootNode.left, nodes)+rootNode.getData()+inorder(rootNode.right, nodes);
    }

    public static String bfs(TreeNode rootNode){
        if(rootNode==null)
            return "";
        Queue<TreeNode> q = new LinkedList<>();
        StringBuffer tree = new StringBuffer();
        q.add(rootNode);
        while(q.peek()!=null){
            TreeNode node = q.poll();
            q.add(node.left);
            q.add(node.right);
            tree.append(node.toString()+",");
        }
        return tree.toString();
    }

    public static String preorder(TreeNode rootNode, String nodes){
        if(rootNode==null)
            return "";
        return rootNode.getData()+nodes+preorder(rootNode.left, nodes)+preorder(rootNode.right, nodes);
    }

    public static String preStack(TreeNode rootNode){
        if(rootNode==null)
            return "";
        Stack<TreeNode> stack = new Stack();
        stack.push(rootNode);
        StringBuffer tree = new StringBuffer();
        while(!stack.isEmpty()){
            TreeNode node = stack.pop();
            tree.append(node.toString()+",");
            if(node.right!=null) stack.push(node.right);
            if(node.left!=null) stack.push(node.left);
        }
        return tree.toString();
    }

    public static String postorder(TreeNode rootNode, String nodes){
        if(rootNode==null)
            return "";
        return nodes+postorder(rootNode.left, nodes)+postorder(rootNode.right, nodes)+rootNode.getData();
    }

    public static TreeNode addToTree(int[] numbers, int start, int end){
        if(end<start)
            return null;

        int mid = (start+end)/2;
        TreeNode node = new TreeNode(numbers[mid]);
        node.left = addToTree(numbers, start, mid-1);
        node.right = addToTree(numbers, mid+1, end);
        return node;
    }

    public static int findMaxHeight(TreeNode node){
        if(node==null)
            return 0;
        return Math.max(1+findMaxHeight(node.left), 1+findMaxHeight(node.right));
    }

    public static int findMinHeight(TreeNode node){
        if(node==null)
            return 0;
        return Math.min(1+findMinHeight(node.left), 1+findMinHeight(node.right));
    }

    public static TreeNode findCommonAncestor(TreeNode<Integer> rootNode, int node1, int node2){
        if(findNode(rootNode.left, node1) && findNode(rootNode.left, node2))
            return findCommonAncestor(rootNode.left, node1, node2);
        if(findNode(rootNode.right, node1) && findNode(rootNode.right, node2))
            return findCommonAncestor(rootNode.right, node1, node2);

        return rootNode;
    }

    public static boolean findNode(TreeNode<Integer> rootNode, int node){
        if(rootNode==null)
            return false;
        if(rootNode.getData()==node)
            return true;
        return findNode(rootNode.left, node) || findNode(rootNode.right, node);
    }

    public static void main(String args[]){
        int[] nums = new int[]{1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20};
        TreeNode tree = createMinimalisticBinaryTree(nums);
        System.out.println("Inorder:"+BinarySearchTree.inorder(tree, ""));
        System.out.println("BFS:"+bfs(tree));
        System.out.println("DFS iterative inorder:"+preStack(tree));
        System.out.println("Height is "+findMaxHeight(tree)+", "+findMinHeight(tree));
        System.out.println(findCommonAncestor(tree, 17,20));
    }
}
