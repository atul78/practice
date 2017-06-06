package atul.problems;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by agosain on 5/26/2017.
 */
public class DialPad {
    Map<String, String[]> dialMap;
    DialPad(){
        dialMap = new HashMap<String, String[]>();
        dialMap.put("1",new String[]{"a","b","c"});
        dialMap.put("2",new String[]{"d","e","f"});
        dialMap.put("3", new String[]{"g","h","i"});
    }

//    List<String> getStringI(List<String> letters){
//        List<String> list = new ArrayList<>();
//        for(String number : letters){
//            for(String s1 : dialMap.get(number)){
//
//            }
//        }
//    }

    List<String> getString(List<String> numbers)
    {
        List<String> list = new ArrayList<String>();

        if(numbers.size()==0) {
            list.add("");
            return list;
        }

        String number = numbers.remove(0);
        String[] chars = dialMap.get(number);
        List<String> words = getString(numbers);
        for(String c: chars){

            for(String word : words){
                list.add(c+word);
            }
        }
        return list;
    }

    public static void main(String args[]){
        List<String> list = new ArrayList<String>();
        list.add("1");
        list.add("2");
        list.add("3");
        DialPad dialPad = new DialPad();
        System.out.println(dialPad.getString(list));
    }

}
