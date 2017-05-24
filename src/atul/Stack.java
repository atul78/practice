package atul;

/**
 * Created by agosain on 4/4/2017.
 */
public class Stack<T> {
    Node<T> top;
    Node<T> pop(){
        if(top!=null){
            Node temp = top;
            top = top.next;
            return temp;
        }else
            return null;
    }

    void push(Node<T> node){
        if(top==null)
            top = node;
        else{
            node.next = top;
            top = node;
        }
    }

    public static void main(String args[]){
        String[] datas = new String[]{"1","2","3","6"};
        int count = 0;
        Stack stack = new Stack();
        while(count != datas.length ){
            Node node = new Node(datas[count++]);
            stack.push(node);
        }
        System.out.println("Stack is popping now");
        Node node = null;
        while((node = stack.pop())!=null){
            System.out.println(node);
        }
    }
}


