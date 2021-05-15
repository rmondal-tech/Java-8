package bb.com.java8.functionalInterface;
import java.util.List;
import java.util.function.BiFunction;
import java.util.function.BinaryOperator;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.stream.Stream;

public class FI_01_Predicate_Function_Consumer_BinaryOperator {
	
			
		/*
		 
		 boolean isEven(int x) {
		 	return x%2==0;
		 }
		 
		 int squared(int x) {
		 	return x * x;
		 }
		  
		 */

		@SuppressWarnings("unused")
		public static void main(String[] args) {
			
			List<Integer> numbers = List.of(1,2,3,4,5,6);
			
//01 square of even nos
//in short syntax and then look into what exactly happening in backend			
			numbers.stream()
			.filter(x -> x%2==0) //only even nos
			.map(x -> x * x)     // convert to square
			.forEach(System.out::println);

System.out.println("---------------------------------------");


//02 square of even nos -extracting Lambdas
Predicate<Integer> isEvenPredicate = x -> x%2==0;
Function<Integer, Integer> squareFunction = x -> x * x;
Consumer<Integer> sysoutConsumer = System.out::println;

  numbers.stream()
    .filter(isEvenPredicate)    // Predicate
      .map(squareFunction)     // Function
  .forEach(sysoutConsumer);   //Consumer

  System.out.println("---------------------------------------");


//03 square of even nos - Demo implementations of Provided Functional Interfaces

//Predicate<T>-Represents a predicate (boolean-valued function) of one argument. 
		
			Predicate<Integer> isEvenPredicate2 = new Predicate<Integer>() {
				@Override
				public boolean test(Integer x) {
					return x%2==0;
				}
				
			};

			
//Function<T, R>-Represents a function that accepts one argument and produces a result. 
//BiFunction<T, U, R>-Represents a function that accepts two arguments and produces a result.			
			
			Function<Integer, Integer> squareFunction2 = new Function<Integer, Integer>() {
				@Override
				public Integer apply(Integer x) {
					return x*x;
				}
				
			};
			
			
//one input --> no return , only perform operation silently			
			Consumer<Integer> sysoutConsumer2 = new Consumer<Integer>() {
				public void accept(Integer x) {
					System.out.println(x);
				}
			};
			
			numbers.stream()
				.filter(isEvenPredicate2)
				.map(squareFunction2)
				.forEach(sysoutConsumer2);

/*BinaryOperator- Represents an operation upon two operands of the same type, producing a resultof the same type as
 * the operands. This is a specialization of BiFunction for the case where the operands and 
 * the result are all of the same type. 
	//	@FunctionalInterface
	//	public interface BinaryOperator<T> extends BiFunction<T,T,T>			
*/
			BinaryOperator<Integer> sumBinaryOperator = Integer::sum;
			//BinaryOperator<Integer> sumBinaryOperator = (x,y) => x + y;
			
			
			BinaryOperator<Integer> sumBinaryOperator2 = new BinaryOperator<Integer>() {
				@Override
				public Integer apply(Integer a, Integer b) {
					// TODO Auto-generated method stub
					return a + b;
				}
				
			};
			
			
			int sum = numbers.stream()
				.reduce(0, sumBinaryOperator);
		}
	}
	

