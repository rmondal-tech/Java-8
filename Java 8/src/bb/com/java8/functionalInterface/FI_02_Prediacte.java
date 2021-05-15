package bb.com.java8.functionalInterface;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class FI_02_Prediacte {

	public static void main(String[] args) {
/*
//Predicate- (boolean-valued function) of one argument.functional interface, which accepts an argument 
 and returns a boolean.it used to apply in a filter for a collection of objects.filter() accepts predicate as argument.
//boolean test(T t)- Evaluates this predicate on the given argument t
 * 
//@FunctionalInterface
	public interface Predicate<T> {		
      //all other are default 
          boolean test(T t);
           negate(),not()
  */

//01 example in earlier class 01
		
//02 Multiple Filter - 
		List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

        // multiple filters
        List<Integer> collect1 = list.stream()
                .filter(x -> x > 5 && x < 8).collect(Collectors.toList());

        System.out.println(collect1);
        System.out.println("03----------------------");
        
        
 //03 Multiple Filter - with Predicate.and( method)	
        Predicate<Integer> noGreaterThan5 = x -> x > 5;
        Predicate<Integer> noLessThan8 = x -> x < 8;
        Predicate<Integer> noGreterThan8 = x -> x > 8;
        Predicate<Integer> noLessThan3 = x -> x < 3;

        List<Integer> collect2 = list.stream()
                .filter(noGreaterThan5.and(noLessThan8))
                .collect(Collectors.toList());

        System.out.println(collect2);
        System.out.println("04----------------------");
        
//04 Predicate.or() method      
        List<Integer> collect3 = list.stream()
                .filter(noGreterThan8.or(noLessThan3))
                .collect(Collectors.toList());
        System.out.println(collect3);
        System.out.println("05----------------------");

//05 Predicate.negate() method(!)
//Find all elements not start with ‘A’.
        List<Integer> collect4 = list.stream()
                .filter(noGreterThan8.negate())
                .collect(Collectors.toList());
        System.out.println(collect4);
        
	}

}
