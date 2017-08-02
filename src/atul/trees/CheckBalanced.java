package atul.trees;

import static atul.trees.BinarySearchTree.createMinimalisticBinaryTree;

/**
 * Created by agosain on 6/27/2017.
 */
public class CheckBalanced {
    public static boolean checkBalanced(TreeNode rootNode){
        if(rootNode==null)
            return true;
        if(getHeight(rootNode.left)-getHeight(rootNode.right)>1)
            return false;
        else return checkBalanced(rootNode.left)&&checkBalanced(rootNode.right);
    }

    public static int getHeight(TreeNode root){
        if(root==null)
            return -1;
        return Math.max(getHeight(root.left), getHeight(root.right))+1;
    }

    public static int checkHeight(TreeNode root){
        if(root==null)
            return -1;

        int leftHeight = checkHeight(root.left);
        int rightHeight = checkHeight(root.right);

        int heightDiff = leftHeight - rightHeight;
        if(Math.abs(heightDiff)>1){
            return Integer.MIN_VALUE;
        }else{
            return Math.max(leftHeight, rightHeight)+1;
        }
    }

    public static void main(String args[]){
        int[] nums = new int[]{1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,30,80,90,100,110};
        TreeNode tree = createMinimalisticBinaryTree(nums);
        System.out.println(checkBalanced(tree));
    }
}
