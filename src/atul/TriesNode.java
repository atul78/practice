package atul;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by agosain on 7/31/2017.
 */
public class TriesNode {
    Map<String, List<String>> map = new HashMap<>();

    void addWord(String word){
        for(int i=1;i<word.length()+1;i++){
            String subStr = word.substring(0,i);
            if(map.get(subStr)==null) {
                List<String> list = new ArrayList<>();
                list.add(word);
                map.put(subStr, list);
            }else{
                List list = map.get(subStr);
                list.add(word);
                map.put(subStr, list);
            }
        }
    }

    int findWord(String word){
        List list = null;
        if((list = map.get(word))!=null){
            return list.size();
        }
        return 0;

    }

    public static void main(String args[]){
        String[] strs = {"car","cars","cards","atul"};
        TriesNode tries = new TriesNode();
        for(String str : strs){
            tries.addWord(str);
        }

        System.out.println(tries.findWord("car"));
    }
}
