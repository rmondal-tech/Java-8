package bb.com.java8.functionalInterface;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Stream;

public class FI_03_Function {

/*
 1. Represents a function that accepts one argument and produces a result.
 2. The argument and output can be a different type.
       @FunctionalInterface
       public interface Function<T, R> {
          R apply(T t);// only abstract method //changes to a diff output type
          andThen()  // chain of functions
          identity() //Returns a function that always returns its input argument.
       }
 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<String> numbersList = List.of("A","AA","AAA","AAAA"); 

//01 Length of strings- String->apply->Integer
		Function<? super String, ? extends Integer> mapper_sizeFunction = x->x.length();
		numbersList.stream()
		.map(mapper_sizeFunction).forEach(System.out::println);
	System.out.println("Ex 02 ----------------------");	
	
		
//02 output function.apply(input)
//like we apply function on a Stream, and apply method is called for all individual items
//in the stream . Here we are using apply() directly on the single elements	
	int sizeOfString=mapper_sizeFunction.apply("AAAAAAAAAA"); //returnd int as per fun def
	  System.out.println(sizeOfString); 
	System.out.println("Ex 03 ----------------------");	
	
	
//03 function.andThen() --chain of function
	  Function<String, Integer> funcGetLength = x -> x.length();

      Function<Integer, Integer> funcMulBy2 = x -> x * 2;

      int sizeOfString_mul2= funcGetLength.andThen(funcMulBy2).apply("AAAAAAAAAA");
      System.out.println(sizeOfString_mul2); 
  	   System.out.println("Ex 04 ----------------------");	
  	   
 
//04 List -> Map  //individual list entry is key, length is value
  	//	Map<String, Integer> ListToMap_map = (Map<String, Integer>) 
  		 Map<String, Integer> result  = new HashMap<String, Integer>();

  		 Function<String, Integer> valueToKeyMapper = x -> x.length();

  		 numbersList.stream().forEach( x -> {
  			result.put(x, x.length());
   		} );
  		
  	   System.out.println(result);
  	   System.out.println("Ex 05 ----------------------");
  	   
  	   
 //05 	List to Map --use apply   
         Map<String, Integer> map = convertListToMap1(numbersList, x -> x.length());
	   System.out.println(map);
  	
  		
	}

	/*
	 * private static <R, T> Map<String, Integer> convertListToMap(List<String>
	 * numbersList, Function<T, R> func) { // TODO Auto-generated method stub return
	 * null; }
	 */
	  public static <T, R> Map<T, R> convertListToMap1(List<T> list, Function<T, R> func) {

	        Map<T, R> result = new HashMap<>();
	        for (T t : list) {
	            result.put(t, func.apply(t));
	        }
	        return result;

	    }
}
