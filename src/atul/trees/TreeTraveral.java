package atul.trees;

import java.util.PriorityQueue;
import java.util.Queue;

/**
 * Created by agosain on 5/3/2017.
 */
public class TreeTraveral {
    TreeNode rootNode ;

    public void addNode(int value){
        rootNode = addNode(rootNode, value);
    }

    public TreeNode addNode(TreeNode<Integer> rootNode, int value){
        if(rootNode == null) {
            rootNode = new TreeNode(value);
            return rootNode;
        }

        if(value>=rootNode.getData()) {
            rootNode.right = addNode(rootNode.right, value);
        }
        if(value<rootNode.getData()) {
            rootNode.left = addNode(rootNode.left, value);
        }

        return rootNode;
    }

    public void removeNode(TreeNode node){

    }

    public static void main(String args[]){
        int[] numbers = new int[]{1,2,3,4,5,6,7,8,9,10};
        TreeTraveral tree = new TreeTraveral();
        for(int number: numbers){
            tree.addNode(number);
        }

    }
}
