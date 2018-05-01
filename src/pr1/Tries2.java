package pr1;

import atul.Stack;
import java.util.ArrayList;
import java.util.List;
import sun.text.normalizer.Trie;

/**
 * Created by agosain on 4/30/18.
 */
public
class Tries2 {
  static class TrieNode{
    TrieNode[] children = new TrieNode[26];
    boolean isEndOfWord;
    TrieNode(){
      isEndOfWord = false;
      for(int i=0;i<children.length;i++)
        children[i] = null;
    }
  }
  
  static TrieNode root;
  
  static void insert(String key){
    TrieNode pCrawl = root;
    for(int i=0;i<key.length();i++){
      int index = key.charAt(i)-'a';
      if(pCrawl.children[index]==null)
        pCrawl.children[index] = new TrieNode();
      
      pCrawl = pCrawl.children[index];
    }
    
    pCrawl.isEndOfWord = true;
  }
  
  static boolean search(String key){
    TrieNode pCrawl = root;
    for(int i=0;i<key.length();i++){
      int index = key.charAt(i)-'a';
      if(pCrawl.children[index]==null)
        return false;
      pCrawl = pCrawl.children[index];
    }
    
    return pCrawl!=null && pCrawl.isEndOfWord ;
  }
  
  static List<String> getAll(TrieNode node){
    Stack<TrieNode> stack = new Stack<>();
    
  }
  
  static List<String> prefix(String prefix){
    TrieNode crawler = root;
    List<String> nodes = new ArrayList<>();
    String word="";
    for(char c : prefix.toCharArray()){
      TrieNode matching  = crawler.children[c-'a'];
      if(matching == null)
        return nodes;
      word+=c;
      if(matching.isEndOfWord)
        nodes.add(word);
      
      crawler = matching;
    }
    
    return getAllNodes(crawler,"");
    
  }
  
  static List<String> getAllNodes(TrieNode node, String str){
    if(node==null){
      List<String> list  = new ArrayList<String>();
      list.add(str);
      return list;
    }
    
    List<String> allNodes = new ArrayList<>();
    for(int i=0;i<node.children.length;i++){
      TrieNode n = node.children[i];
      if(n!=null){
        char c = (char)('a'+i);
        allNodes.addAll(getAllNodes(n,str+c));
      }
    }
    
    return allNodes;
  }
  
  public static void main(String args[]){
    String keys[] = {"the","a","there","answer","any","by","bye","their"};
    String output[] = {"Not present in trie","Present in trie"};
    
    root = new TrieNode();
    for(String key : keys){
      insert(key);
    }
  
    for(String key : keys) {
      System.out.println("Searching the " +key+":"+search(key));
    }
  
    System.out.println("Prefix for the are"+prefix("the"));
  }
}
