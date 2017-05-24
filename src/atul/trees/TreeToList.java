package atul.trees;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

/**
 * Created by agosain on 5/17/2017.
 */
public class TreeToList {
    public static void convertTreeToList(TreeNode<Integer> node, LinkedList<Integer> numbers){
        if(node==null)
            return ;
        numbers.add(node.getData());
        convertTreeToList(node.left, numbers);
        convertTreeToList(node.right, numbers);
    }

    public static TreeNode getTree(LinkedList<Integer> numbers){
        if(numbers.peek()==null)
            return null;
        int number = numbers.poll();
        TreeNode<Integer> node = new TreeNode(number);
        if((new Random()).nextBoolean())
            node.left = getTree(numbers);
        else
            node.right = getTree(numbers);
        return node;
    }

    public static void main(String args[]){
        LinkedList<Integer> numbers = new LinkedList<Integer>();
        numbers.add(10);
        numbers.add(1);
        numbers.add(3);
        numbers.add(5);
        numbers.add(6);
        numbers.add(100);
        numbers.add(199);
        numbers.add(20);
        numbers.add(12);
        TreeNode node = getTree(numbers);
        LinkedList converted = new LinkedList<>();
        convertTreeToList(node, converted);
        System.out.println(converted);
    }
}
