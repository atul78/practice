import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Tries {

    public static void main(String[] args) {
        /*Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        for(int a0 = 0; a0 < n; a0++){
            String op = in.next();
            String contact = in.next();
        }*/

        TrieNode rootNode = new TrieNode();
        TrieNode.addWord(rootNode,"cars");
        TrieNode.addWord(rootNode, "cards");
        TrieNode.addWord(rootNode, "car");
        TrieNode.addWord(rootNode, "carrom");
        TrieNode.addWord(rootNode, "atul");
        TrieNode.addWord(rootNode, "cat");
        System.out.println(rootNode);
    }
}

class TrieNode{
    Map<Character, TrieNode> nodeMap = new HashMap<>();
    boolean isComplete;

    public static TrieNode addWord(TrieNode node, String word){
        Character c = word.charAt(0);
        TrieNode childNode = node.nodeMap.get(c);
        if(childNode==null) {
            childNode = new TrieNode();
            node.nodeMap.put(c, childNode);
        }
        if(word.length()==1){
            node.isComplete = true;
            return node;
        }

        addWord(childNode, word.substring(1,word.length()));
        return node;
    }

    /*
    public List<String> findWords(TrieNode node, String word){
        /*
        if(node.isComplete==true)
            return ;

        List<String> results = new ArrayList<>();
        Character c = word.charAt(0);
        if(node.nodeMap.containsKey(c))
            results.addAll(findWords(node.nodeMap.get(c), word.substring(1)));

     
        return null;
    }
    */
}
