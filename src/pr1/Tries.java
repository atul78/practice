package pr1;

import java.util.*;

public class Tries {
    TrieNode root;

    public static void main(String args[]){
        Tries tries = new Tries();
        tries.addWord("Atul").addWord("Ambitious").addWord("Aryan");
        tries.addWord("Deep").addWord("Deepika").addWord("Deepavali");
        tries.addWord("Tanvi").addWord("Tanveer").addWord("Tan");

        System.out.println(tries.findWordsStartingWith("Te"));

    }

    public String toString(){
        return root.toString();
    }

    public Tries(){
        root = new TrieNode(true);
    }

    public Tries addWord(String word){
        char[] chars = word.toCharArray();
        TrieNode currentNode = root;
        for(char c: chars){
            if(currentNode.children==null)
                currentNode.children = new HashMap<Character, TrieNode>();

            c = Character.toLowerCase(c);
            TrieNode node = currentNode.children.get(c);
            if(node!=null) {
                currentNode = node;
                continue;
            }

            TrieNode newNode = new TrieNode(c);
            currentNode.children.put(c, newNode);
            currentNode = newNode;
        }
        currentNode.isEndOfWord = true;
        return this;
    }

    List<String> findWordsStartingWith(String searchWord){
        TrieNode currentNode = root;
        List<String> matchingWords = new ArrayList<>();
        String wordMatched = "";
        for(Character c : searchWord.toCharArray()){
            c = Character.toLowerCase(c);
            if(currentNode.isRoot && currentNode.children==null)
                return null;
            currentNode = currentNode.children!=null ? currentNode.children.get(c) : null;

            // Check if any of the child elements match with next character in search word.
            // if yes, that becomes currentNode
            if(currentNode!=null)
                wordMatched+=c;

            if(currentNode==null || wordMatched.equalsIgnoreCase(searchWord)){
                matchingWords.addAll(currentNode.getAllWords(currentNode,""));
                break;
            }
        }

        return matchingWords;
    }
}

class TrieNode{
    char data;
    boolean isRoot;
    boolean isEndOfWord;

    Map<Character, TrieNode> children;
    Set<String> completeWords = new HashSet<>();

    public TrieNode(Character data){
        this.data = data;
        isRoot = false;
    }

    public TrieNode(boolean isRootNode){
        this.isRoot = isRootNode;
    }


/*
    public String toString(){
        return this.getAllWords(this, "").toString();
    }
*/


    public Set<String> getAllWords(TrieNode currentNode, String incompleteWord){
        if(currentNode==null)
            return completeWords;

        String word = incompleteWord+currentNode.data;

        if(currentNode.isEndOfWord){
           completeWords.add(word);
        }

        if(currentNode.children == null)
            return completeWords;

        for(TrieNode childNode : currentNode.children.values()){
            completeWords.addAll(currentNode.getAllWords(childNode, word));
        }

        return completeWords;
    }
}
