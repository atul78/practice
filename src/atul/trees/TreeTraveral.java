package atul.trees;

import java.util.PriorityQueue;
import java.util.Queue;

/**
 * Created by agosain on 5/3/2017.
 */
public class TreeTraveral<T extends Comparable<T>> {
    public TreeNode rootNode ;

    public TreeNode addNode(TreeNode<T> node, T value){
        if(node == null) {
            rootNode = new TreeNode(value);
            return rootNode;
        }

        if(value.compareTo(node.getData())>0) {
            node.right = addNode(node.right, value);
        }
        
        if(value.compareTo(node.getData())<0) {
            node.left = addNode(node.left, value);
        }
        // Add to the height of the tree
        node.height = 1+ Math.max(getHeight(node.left), getHeight(node.right));
      
        // Determine if its unbalanced by measuring difference in height
        
        rootNode = node;
        return node;
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
  
  public int getHeight(){
    return getHeight(rootNode);
  }
  
  public int getHeight(TreeNode node){
    if(node==null)
      return 0;
    return 1+Math.max(getHeight(node.left), getHeight(node.right));
  }
  
  public static void main(String args[]){
        int[] numbers = new int[]{1,2,3,4,5,6,7,8,9,10};
        TreeTraveral tree = new TreeTraveral();
        TreeNode root = null;
        for(int number: numbers){
            root = tree.addNode(root, number);
        }
        
        System.out.println(tree.preOrder());

    }
}
