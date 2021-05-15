package aa.com.java8.stream;

import java.util.stream.Stream;
//Added in java 9
public class Stream_08_TakeWhile_DropWhile_Java9 {

	public static void main(String[] args) {

//--------TakeWhile------------------------------------------------------
/*  1. TakeWhile & Dropwhile is similar to filter in the sense that it expects a predicate and returns a new stream 
 2.  Retruns consisting only of the elements that match the given predicate. But there’s a catch. 
 3. In an ordered stream, it takes every till predicate holds true. When first mismatch , discard all there including that 
 */
		// 4 cases------------------
		
//------------------------- Ordered & Some elements matches------------------------
	      Stream.of(2, 4, 6, 8, 9, 10, 12)
	      .takeWhile(n -> n % 2 == 0)
	      .forEach(System.out::print);   //2 4 6 8
	      

	      Stream.of(1,2, 4, 6, 8, 9, 10, 12)
	      .takeWhile(n -> n % 2 == 0)
	      .forEach(System.out::print); // no result
	      
	      Stream.of(1,2, 4, 6, 8, 9, 10, 12)
	      .takeWhile(n -> n % 1 == 0)
	      .forEach(System.out::print); // 1
//---------DropWhile-----------------------------------------------------------
/*dropWhile is essentially the opposite of takeWhile. 
 *dropWhile drops everything till it matches 1st element and includes the remaining elements in the returned stream.	      
 */
	
	      Stream.of(2, 4, 6, 8, 9, 10, 12)
	      .dropWhile(n -> n % 2 == 0)
	      .forEach(System.out::println); //9,10,12  //first match 9
	  System.out.println("---------------------------");   
	  
	      Stream.of(2, 3, 4, 6, 8, 9, 10, 12)
	      .dropWhile(n -> n % 2 == 0)
	      .forEach(System.out::print);  //3, 4, 6, 8, 9, 10, 12 // first match 3
	      

//---------------------------Unordered streams & Some elements match--------------------------------------	      
/*Unordered streams
So far we’ve looked at how takeWhile and dropWhile behave with ordered streams. But what happens if the stream
is unordered? According to the docs, if some of the elements in the stream match the predicate (but not all)
then the operation is nondeterministic and an arbitrary subset of matching elements is returned or removed.
Meaning that you’ll get different results for each execution.

Set<Integer> numbers = Set.of(2, 4, 6, 3, 8);
numbers.stream()
    .takeWhile(n -> n % 2 == 0)
    .forEach(System.out::println);
// prints out a different subset of matching elements every time
// an empty set is also a subset
You can expect a similar behavior if you replace takeWhile with dropWhile.
*/	      
	      
//---------------------------All elements match--------------------------------------------
/*
 1. Regardless of whether the stream is ordered or unordered, if all elements match the given predicate then 
 takeWhile takes and dropWhile drops all elements. 
 2 . The result of takeWhile is the same as the input stream. On the other hand, when all elements match, the result of dropWhile will be an empty stream.	      
      Set<Integer> numbers = Set.of(2, 4, 6, 8);
      numbers.stream()
       .takeWhile(n -> n % 2 == 0)
       .forEach(System.out::println);
// always prints out 2, 4, 6, 8
 */
	      
	
//------------------- No elements match ----------------
	/*1. takeWhile will be an empty stream. Since no elements matched, there’s nothing to take. dropWhile, 
	  2. on the other hand, returns the input stream if there’s nothing to drop      
	 
	      Stream.of(2, 4, 6, 8)
             .dropWhile(n -> n % 2 != 0)
               .forEach(System.out::println);  //2 4 6 8
	  */    
	}

}
