package atul;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by agosain on 4/4/2017.
 */
public class SetOStacks {
    List<Stack> list = new ArrayList<Stack>();
    Node top ;

    public void pushStack(Stack stack){

        list.add(stack);
        top = stack.top;
    }

    public void pop(){

    }
}
