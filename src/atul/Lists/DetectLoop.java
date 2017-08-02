package atul.Lists;

/**
 * Created by agosain on 4/24/2017.
 */
public class DetectLoop {
/*

      public class Solution {
        public ListNode detectCycle(ListNode a) {
            ListNode p1 = a;
            ListNode p2 = a;
            boolean found = false;
            while(a!=null) {
                p1 = a.next;
                if(p1!=null && (p2 = a.next.next)!=null){
                    found = p1 == p2;
                }

                if(b == c)
                    return b;
                return null;
            }

            return null;
        }
    }
*/

    public ListNode createLoopList(int[] numbers, int loopStarting){
        ListNode rootNode = new ListNode(0);
        ListNode currentNode = rootNode;
        ListNode loopNode = null;
        for(int i=0;i<numbers.length;i++){
            ListNode node = new ListNode(numbers[i]);
            currentNode.next = node;
            if(loopStarting!=-1 && i==loopStarting)
                loopNode = node;
            currentNode = node;
        }
        currentNode.next = loopNode;

        // Display the list
/*
        ListNode node = rootNode;
        while(node != null && (node = node.next)!=null){
            System.out.println(node.val);
        }
*/

        return rootNode;
    }

    public static boolean detectLoop(ListNode node){
        ListNode first = node;
        ListNode second = node.next;
        while(first!=null && second!=null && first!=second){
            first = first.next;
            second = second.next.next;
        }
        if(first==second)
            return true;
        return false;
    }

    public static void main(String args[]){
        int[] numbers = new int[]{1,2,3,4,5,6,7,14,13,44,4555,13456};
        int loopStarting = 4;
        ListNode rootNode = new DetectLoop().createLoopList(numbers, loopStarting);

        // Now that the loop is created. Lets see if im able to find it
        boolean looped = DetectLoop.detectLoop(rootNode);
        System.out.println(looped);
    }

}
