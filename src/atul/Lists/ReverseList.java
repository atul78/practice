package atul.Lists;

public class ReverseList {

    public static void main(String args[]){
        List<String> list = new List<>();
        list.add("Atul").add("Deepika").add("Tanvi").add("Aashvi").add("dummy");
        System.out.println("List is "+list);
        list.removeNodefromLast();
        list.reverseList();
        System.out.println("reverse is "+list);
    }
}

class List<T>{
    ListNode<T> head = null;
    ListNode<T> tail = null;

    public void reverseList(){
        ListNode<T> curr, prev, next ;
        curr = head;
        tail = head;
        prev = null;
        next = head.next;

        while(curr!=null){
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        head = prev;
    }

    @Override
    public String toString(){
        if(head==null)
            return "";
        ListNode<T> pointer = head;
        StringBuffer str =new StringBuffer();
        while(pointer!=null){
            str.append(pointer.data+",");
            pointer = pointer.next;
        }

        return str.toString();
    }

    List<T> add(T data){
        if(head==null) {
            head = new ListNode<>(data);
            tail = head;
        }else{
            ListNode<T> newNode = new ListNode<>(data);
            newNode.previous = tail;
            tail.next = newNode;
            tail = newNode;
        }
        return this;
    }


    void removeNodefromLast(){
        if(tail==null)
            return;

        tail = tail.previous;
        if(tail!=null)
            tail.next = null;
    }
}
class ListNode<T>{
    T data;
    ListNode<T> next;
    ListNode<T> previous;

    ListNode(T data){
        this.data = data;
    }

    public String toString(){
        return data.toString();
    }

}
