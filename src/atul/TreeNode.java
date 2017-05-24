package atul;

/**
 * Created by agosain on 4/4/2017.
 */
public class TreeNode<T> {
    TreeNode leftNode;
    TreeNode rightNode;
    T data;
    public TreeNode(T data){
        this.data = data;
    }


    public static void main(String args[]){
        TreeNode<Integer> rootNode = new TreeNode<>(20);

    }
}

class Tree<T>{
    TreeNode root;
    public void insert(TreeNode node){
        if(root==null)
            root = node;

//        if(node < root.leftNode)
    }
}