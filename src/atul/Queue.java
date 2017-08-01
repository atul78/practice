package atul;

/**
 * Created by agosain on 4/4/2017.
 */
public class Queue{
    Node first, last;
    public void enqueue(Node node){
        if(first == null) {
            first = node;
            last = node;
        }
        else{
            last.next = node;
            last = node;
        }
    }

    public Node dequeue(){
        if(first==null)
            return null;
        else{
            Node temp = first;
            first = first.next;
            return temp;
        }
    }

    public Node peek(){
        if(first==null)
            return null;
        return first;
    }

    public static void main(String[] args) {
        int[] datas = new int[]{1,2,3,4,6,5,5};
        Queue q = new Queue();
        for(int data:datas){
            q.enqueue(new Node(data));
        }

        System.out.println("Dequeuing now");
        Node node;
        while((node = q.dequeue())!=null){
            System.out.println(node);
        }
    }
}
