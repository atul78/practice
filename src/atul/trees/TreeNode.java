package atul.trees;

import atul.Node;

import java.util.Comparator;

/**
 * Created by agosain on 5/3/2017.
 */
public class TreeNode<T> extends Node<T> {
    public TreeNode<T> next;
    public TreeNode<T> left;

    public TreeNode<T> right;
    public TreeNode(T value){
        this.data = value;
    }
}
