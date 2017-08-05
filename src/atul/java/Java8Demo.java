package atul.java;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

/**
 * Created by agosain on 6/14/17.
 */
public class Java8Demo {
    public static void main(String args[]){
        //(params) -> expression
        //(params) -> statement
        //(params) -> { statements }
        new Thread( () -> System.out.println("In Java8, Lambda expression rocks !!") ).start();

        Comparator<Integer> comparator = (Integer o1, Integer o2) -> {
            System.out.println("blah");
            return o1>o2 ? 1:-1;
        };
        Comparator<Integer> comparator2 = (Integer o1, Integer o2) -> o1>o2 ? 1:-1;

        List features = Arrays.asList("Lambdas", "Default Method", "Stream API", "Date and Time API");
        features.forEach(n -> System.out.println(n));

        List<String> names = Arrays.asList("Atul", "Deepika", "Tanvi", "Aashvi");
        filter(names, (str)-> str.startsWith("A"));

        filter(names, (str)->true);

        filter(names, (str)-> str.length()>4);

        String allNames = names.stream().map(name->name.toUpperCase()).collect(Collectors.joining(","));
        System.out.println(allNames);
    }

    public static void filter(List<String> names, Predicate<String> condition){
        for(String name : names){
            if(condition.test(name))
                System.out.println("Name is "+name);
        }
    }
}
