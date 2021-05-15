package aa.com.java8.stream;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Stream_12_FlatMap {
/*
  if there is a Stream of List of <<Data Type>> before flattening, then on applying flatMap(),
   Stream of <<Data Type>> is returned after flattening.
   [ [2, 3, 5], [7, 11, 13], [17, 19, 23] ] --->[ 2, 3, 5, 7, 11, 13, 17, 19, 23 ] 

   2) map() is used for transformation only, but flatMap() is used for both transformation and flattening.

 */
	
	public static void main(String[] args)
    {
		

        // Creating a List of Strings
        List<String> list = Arrays.asList("Geeks", "GFG",
                                 "GeeksforGeeks", "gfg");
  
//Returns a stream consisting of the results of replacing each element of this stream 
//with the contents of a mapped stream produced by applying the provided mapping function to each element
        list.stream().
        flatMap(str -> Stream.of(str.charAt(2))).
                         forEach(System.out::println);
        
//02
        List<String> list1 = Arrays.asList("Albus", "Harry", "Ron", "Hermione");
        List<String> list2 = Arrays.asList("Bridget", "Cedric", "Nymphadora");
        List<String> list3 = Arrays.asList("Luna", "Garrick", "Filius");
     
        List<List<String>> listOfLists = new ArrayList<List<String>>(); 
        listOfLists.add(list1);
        listOfLists.add(list2);
        listOfLists.add(list3);
   
        
        List<String> flatMapList = listOfLists.stream().flatMap(hList -> hList.stream()).collect(Collectors.toList()); 
        System.out.println(flatMapList);  
        
    }
}
