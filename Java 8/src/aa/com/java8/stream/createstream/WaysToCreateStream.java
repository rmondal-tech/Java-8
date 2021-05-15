package aa.com.java8.stream.createstream;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;
//https://blog.indrek.io/articles/5-ways-to-create-a-stream-in-java-8/
/**
 * @author LENOVO
 *
 */
public class WaysToCreateStream {
	
//	1. Creating a Stream from a Collection
//	2. Creating a Stream from values
//	3. Creating a Stream from arrays
//	4. Creating a stream from functions
//	5. Creating a Stream from files



	public static void main(String[] args) {

//------------------  Creating a Stream from a Collection -----------------------------------     

//Creating a Stream from a Collection ////Non -Primitive elements

	/*Probably the most obvious method is to create a Stream from a Collection. This is the interface that lists,
	 *  sets, queues and the like implement. With the introduction of Java 8 and default methods, a method called
	 *   stream() was added to the Collection interface. It returns a sequential Stream with the collection as its
	 *    source. T
	 */
		List<Integer> list = new ArrayList<>();
		list.add(1);list.add(2);list.add(3);
          Stream<Integer> listToStream = list.stream();//java.util.stream.ReferencePipeline$Head@48cf768c

          System.out.println("listToStream- "+listToStream);
          
    
//------------------  Creating a Stream from values-----------------------------------     
          
 // Non -Primitive elements
          
          /*Instead of creating an array or a collection and then converting it into a Stream, 
           * it is possible to create a Stream directly using the static method of() in the Stream interface.
           */
          
          Stream<Integer> valuesToStream = Stream.of(1,2,3);
          System.out.println("valuesToStream- "+valuesToStream); //valuesToStream.min() cant be used as non primitives , needs a Comparator

         // Stream<String> stream = Stream.of("Lewis Carrol", "H.G. Wells", "Michael Ende");

          
          
//------------------  Creating a Stream from arrays-----------------------------------     
      
//  stream of primitive types int
         /* Arrays don’t have the same convenient methods that Collections have.
          * Therefore to create a stream from an array, you need to use the static
          *  method stream() in the Arrays class. 
          */
          int[] arrayName = {1,2,3};
          IntStream arrayToStream = Arrays.stream(arrayName);//static class
          System.out.println("arrayToStream- "+arrayToStream);

//          listToStream- java.util.stream.ReferencePipeline$Head@48cf768c
//          valuesToStream- java.util.stream.ReferencePipeline$Head@3b192d32 //ReferencePipeline - Boxed data tyeps like Integer
//          arrayToStream- java.util.stream.IntPipeline$Head@2a33fae0   // It deals with primitive int . IntPipeline vs ReferencePipeline

          System.out.println("arrayToStream- "+arrayToStream.min()); //OptionalInt[1]

          Stream<Integer> evenNumbers = Stream.iterate(0, n -> n + 2);

  
 //range ,rangeClosed
          IntStream.range(0, 10); //[0,1,2..,9] //exclusive last element
          IntStream.rangeClosed(0, 10);// [0,1,..,10]  //inclusive
  
          
          
//------------------  iterate: Creating a stream from functions-----------------------------------     
 
    //iterate     //if dont need all in the range , only a patterned items
 /*
  1 . accepts an initial element and a function which is applied to the previous element 
  to produce the next element
  2. produces an infinite Stream, so use limit is important
  */
          
          IntStream.iterate(0, x->x+2).limit(10).forEach(System.out::println); //10 items[0,2,..18]
          System.out.println("________________");

           //peak-Returns a stream consisting of the elements of this stream,

          IntStream.iterate(0, x->x+2).limit(10).peek(System.out::println).sum();//print elements before sum
   //collect in a List//boxed in imp else cant put in list a primitive nos
       List<Integer> collectInaList = IntStream.iterate(0, x->x+2).limit(10).boxed().collect(Collectors.toList());
          
   //Generate
          //Generate accepts a Supplier to generate an infinite Stream of unsorted elements. 
          
          Stream<Double> randomNumbers = Stream.generate(Math::random);

	}

}
