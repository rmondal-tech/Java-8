package aa.com.java8.stream;

import java.util.Arrays;
import java.util.List;
/*
Reduce-Performs a reduction on the elements of this stream.Combine them into one result
Integer java.util.stream.Stream.reduce(Integer identity, BinaryOperator<Integer> accumulator)
//binary operation ie accumulator ie 2 operand x+y,x*y
 
T reduce(T identity, BinaryOperator<T> accumulator) Where,
 1. identity is initial value of type T and
 2.  accumulator is a function for combining two values.

Many times, we need to perform operations where a stream reduces to single
resultant value, for example, maximum, minimum, sum, product, etc.
Reducing is the repeated process of combining all elements.
*/
public class Stream_03_Reduce {
	public static void main(String[] args) {

		List<Integer> numbers = List.of(10, 5, 12, 8);
		List<String> letters = Arrays.asList("a", "b", "c", "d", "e");

		
//Combine them into one result => One Value
//1 sum of numbers		//method reference
		int sum1=numbers.stream()
				.reduce(0, Stream_03_Reduce::sum);
		
//2 same with lambda expression without method
	int sum2=numbers.stream()
				.reduce(0,(aggregate_or_resultTillNow,nextNumber)->aggregate_or_resultTillNow + nextNumber );

//3 use sum method of Integer class	//method reference
	int sum3=numbers.stream()
			.reduce(0, Integer::sum);
	
	System.out.println(sum1);
	System.out.println(sum2);
	System.out.println(sum3);
	
//3  reduce() operation on streams holding other types of elements-
    //combining to a single string
	String result = letters
	  .stream()
	  .reduce("", (partialString, element) -> partialString + element);
	
//4	assertThat(result).isEqualTo("abcde");
	System.out.println(result);

//5 same using method reference
	String result2 = letters.stream().reduce("", String::concat);
	//assertThat(result2).isEqualTo("abcde")
	System.out.println(result2);

	
//6 joining the uppercase elements of the letters array:	
	String result3 = letters
			  .stream()
			  .reduce(
			    "", (partialString, element) -> partialString.toUpperCase() + element.toUpperCase());
		//	assertThat(result).isEqualTo("ABCDE");
	System.out.println(result3);

//8 Max no in list
	
	int maxNo=numbers.stream()
			.reduce(0, (x,y)->x>y?x:y); //always return greater among two
	System.out.println(maxNo);
	
// 9 Max - in case negative no in list ,starting value 0 will not work ,need lowest value
	 numbers.stream()
	     .reduce(Integer.MIN_VALUE, (x,y)->x>y?x:y);

// 8 Min no in list	 
	int minNo= numbers.stream()
     .reduce(Integer.MAX_VALUE, (x,y)->x>y?y:x);
	System.out.println(minNo);
	
// 10 sum of suqare-1st square of individuals-->map 2nd aggregator operation-->reduce
	   numbers.stream()
	      .map(x->x*x)//10*10, 5*5, 12*12, 8*8
	         .reduce(0, Integer::sum);

//11 sum of square of only the odd nos in the list	   
	  int z= numbers.stream()
	            .filter(x->x%2==1)
	      .map(x->x*x)//10*10, 5*5, 12*12, 8*8
	         .reduce(0, Integer::sum);
	  System.out.println(z);
	}
//	0 10   initialValue,1st no
//	10 5   resultTillNow,nextNumber
//	15 12  resultTillNow,nextNumber
//	27 8   resultTillNow,nextNumber
//	0 10
//	10 5
//	15 12
//	27 8
//	35

	private static int sum(int aggregate_or_resultTillNow, int nextNumber) {
		System.out.println(aggregate_or_resultTillNow + " " + nextNumber);
		return aggregate_or_resultTillNow + nextNumber;
	}

}