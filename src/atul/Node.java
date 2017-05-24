package atul;

/**
 * Created by agosain on 5/19/2017.
 */
public class Node<T> {
    protected Node<T> next;
    protected T data;

    public Node(){
        this.data = null;
    }

    public Node(T data) {
        this.data = data;
    }

    public T getData(){
        return data;
    }
    public String toString(){
        return ""+this.data;
    }

}
