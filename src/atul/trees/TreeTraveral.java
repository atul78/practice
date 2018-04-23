package atul.trees;

import java.util.PriorityQueue;
import java.util.Queue;

/**
 * Created by agosain on 5/3/2017.
 */
public class TreeTraveral<T extends Comparable<T>> {
    TreeNode rootNode ;

    public void addNode(T value){
        rootNode = addNode(rootNode, value);
    }

    public TreeNode addNode(TreeNode<T> rootNode, T value){
        if(rootNode == null) {
            rootNode = new TreeNode(value);
            return rootNode;
        }

        if(value.compareTo(rootNode.getData())>0) {
            rootNode.right = addNode(rootNode.right, value);
        }
        
        if(value.compareTo(rootNode.getData())<0) {
            rootNode.left = addNode(rootNode.left, value);
        }

        return rootNode;
    }

    public void removeNode(TreeNode node){

    }
    
    public String preOrder(){
      return this.preOrder(rootNode);
    }
    
    // Trying to print the tree shape
    public String printTree(TreeNode<T> node){
      if(node==null)
        return "";
      
      T value = node.getData();
      String leftTree = preOrder(node.left);
      String rightTree = preOrder(node.right);
      
      return preOrder(node.left)+node.getData()+preOrder(node.right);
    }
  
  public String preOrder(TreeNode<T> node){
    if(node==null)
      return "";
    
    return preOrder(node.left)+node.getData()+preOrder(node.right);
  }
  
  public static void main(String args[]){
        int[] numbers = new int[]{1,2,3,4,5,6,7,8,9,10};
        TreeTraveral tree = new TreeTraveral();
        TreeNode root = null;
        for(int number: numbers){
            tree.addNode(number);
        }
      
        System.out.println(tree.preOrder());

    }
}
