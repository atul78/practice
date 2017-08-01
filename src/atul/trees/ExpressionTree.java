package atul.trees;

import java.util.Stack;

/**
 * Created by agosain on 6/10/2017.
 */
public class ExpressionTree<T> {
    public String toString(ExprNode<T> node){
        String buffer = "";
        if(node==null)
            return "";
        if(node.left !=null) buffer += "(";
        buffer += toString(node.left);
        buffer += node.toString();
        buffer += toString(node.right);
        if(node.right!=null) buffer += ")";
        return buffer;
    }

    public int eval(String expression){
        int result = 0;
        Stack<Character> stack1 = new Stack();
        Stack<Character> stack2 = new Stack();
        char[] chars = expression.toCharArray();
        for(char c : chars){
            stack1.push(c);
        }

        // Pop all the elements and evaluate them
        while(!stack1.isEmpty()){
            char c = stack1.pop();
            switch(c){
                case '(':
                    stack2.pop();
                    break;
                case ')':
                    stack2.push(c);
                    break;
                //case ''
            }
            while(c==')')
                stack1.pop();
        }
        return result;
    }

    public int eval(ExprNode<T> node){
        int result = 0;
        if(node.getType()== ExprNode.TYPE.OPERATOR){
            int leftResult = eval(node.left);
            int rightResult = eval(node.right);
            switch((String)node.getData()) {
                case "+":
                    result = leftResult+rightResult;
                    break;
                case "*":
                    result = leftResult*rightResult;
                    break;
                case "-":
                    result = leftResult - rightResult;
                    break;
                case "/":
                    result = leftResult / rightResult;
                    break;
            }
        }else{
            return Integer.parseInt((String)node.getData());
        }

        return result;
    }

    public static void main(String args[]){
        ExprNode node = new ExprNode("+", ExprNode.TYPE.OPERATOR);
        node.left = new ExprNode("*", ExprNode.TYPE.OPERATOR);
        node.left.left = new ExprNode("2", ExprNode.TYPE.NUMBER);
        node.left.right = new ExprNode("3", ExprNode.TYPE.NUMBER);
        node.right = new ExprNode("/", ExprNode.TYPE.OPERATOR);
        node.right.left = new ExprNode("36", ExprNode.TYPE.NUMBER);
        node.right.right = new ExprNode("6", ExprNode.TYPE.NUMBER);

        System.out.println(new ExpressionTree<String>().toString(node));
        System.out.println(new ExpressionTree<String>().eval(node));

    }
}

class ExprNode<T>{
    private TreeNode<T> treeNode;
    private TYPE type;
    public ExprNode<T> left;
    public ExprNode<T> right;

    public enum TYPE {
        OPERATOR,
        NUMBER
    };

    public String toString(){
        return treeNode.getData().toString();
    }

    public void addLeft(ExprNode<T> node, TYPE type){
        left = new ExprNode<T>(node.getData(), type);
    }
    public void addRight(ExprNode<T> node, TYPE type){
        right = new ExprNode<T>(node.getData(), type);
    }
    public ExprNode(T data, TYPE type){
        treeNode = new TreeNode<T>(data);
        this.type = type;
    }

    public T getData(){
        return treeNode.getData();
    }
    public TYPE getType(){
        return type;
    }
}
