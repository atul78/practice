package atul.trees;

import atul.Node;
import atul.Queue;

import java.util.ArrayList;
import java.util.List;

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

    public static void bfs(TreeNode rootNode, Queue q, StringBuffer tree){
        if(rootNode==null)
            return;
        TreeNode node = (TreeNode)q.peek();
        if(node==null) {
            q.enqueue(rootNode);
            bfs(rootNode, q, tree);
            tree.append(rootNode.getData()+"\n");
        }

        if(node==null)
            return;
        node = (TreeNode)q.dequeue();
        tree.append(node.getData());
        q.enqueue(node.left);
        bfs(node.left, q, tree);
        q.enqueue(node.right);
        bfs(node.right, q, tree);
    }

    public static String bfs(TreeNode rootNode){
        Queue q = new Queue();
        StringBuffer tree = new StringBuffer();
        bfs(rootNode, q,tree);
        return tree.toString();
    }

    public static String preorder(TreeNode rootNode, String nodes){
        if(rootNode==null)
            return "";
        return rootNode.getData()+nodes+preorder(rootNode.left, nodes)+preorder(rootNode.right, nodes);
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
        System.out.println("Height is "+findMaxHeight(tree)+", "+findMinHeight(tree));
        System.out.println(findCommonAncestor(tree, 17,20));
    }
}
