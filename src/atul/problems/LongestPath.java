package atul.problems;

import atul.trees.TreeNode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Diameter of binary tree problem
 * http://www.geeksforgeeks.org/diameter-of-a-binary-tree/
 * Created by agosain on 6/3/2017.
 */
public class LongestPath {
    public static List<List<Integer>> getLongestPath(TreeNode<Integer> root){
        // Get the maxDepth on left side. Store the nodes from root to maxDepth node
        List<Integer> leftList = maxDepth(root.left);
        // Get the maxDepth on right side. Store the nodes from root to maxDepth node
        List<Integer> rightList = maxDepth(root.right);
        // Join the two paths including one root node

        List<List<Integer>> returnList = new ArrayList<List<Integer>>();
        List<Integer> pathList = new ArrayList<Integer>();
        pathList.addAll(leftList);
        List<Integer> rootList = new ArrayList<Integer>();
        rootList.add(root.getData());
        pathList.addAll(rootList);
        Collections.reverse(rightList);
        pathList.addAll(rightList);
        returnList.add(pathList);
        return returnList;
    }

    public static List<Integer> maxDepth(TreeNode<Integer> rootNode){
        if(rootNode==null)
            return new ArrayList<Integer>();
        List<Integer> leftList = maxDepth(rootNode.left);
        leftList.add(rootNode.getData());
        List<Integer> rightList = maxDepth(rootNode.right);
        rightList.add(rootNode.getData());
        if(leftList.size()< rightList.size())
            return rightList;
        return leftList;
    }

    public static void main(String args[]){
        TreeNode<Integer> tree = new TreeNode<>(1);
        tree.left = new TreeNode<>(2);
        tree.right = new TreeNode<>(3);
        tree.left.left = new TreeNode<>(4);
        tree.left.right = new TreeNode(5);
        tree.left.right.left = new TreeNode(10);
        tree.left.right.right = new TreeNode(11);
        tree.right.left = new TreeNode(80);
        tree.right.right = new TreeNode(90);
        tree.right.right.left = new TreeNode(100);
        tree.right.right.right = new TreeNode(200);
        System.out.println(getLongestPath(tree));
    }
}
