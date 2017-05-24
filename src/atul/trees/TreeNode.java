package atul.trees;

import atul.Node;

/**
 * Created by agosain on 5/3/2017.
 */
public class TreeNode<T> extends Node<T>{
    public TreeNode<T> left;
    public TreeNode<T> right;
    public TreeNode(T value){
        this.data = value;
    }
}
