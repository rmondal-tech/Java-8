package bb.com.java8.functionalInterface;

import java.util.List;
import java.util.Random;
import java.util.function.BiConsumer;
import java.util.function.BiFunction;
import java.util.function.BiPredicate;
import java.util.function.BinaryOperator;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.IntBinaryOperator;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.function.UnaryOperator;

public class FI_06_All_Predefined_FI {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		List<Integer> numbers = List.of(12, 9, 13, 4, 6, 2, 4, 12, 15);

		//input of filter
		Predicate<Integer> isEvenPredicate = (Integer x) -> x % 2 == 0;

		//input of map
		Function<Integer, Integer> squareFunction = x -> x * x;
		
        //input of map- input int ,output string
	
		Function<Integer, String> stringOutpuFunction = x -> x + " ";
      //input of Consumer
	Consumer<Integer> sysoutConsumer = x -> System.out.println(x);

//operator is a type of function only
		BinaryOperator<Integer> sumBinaryOperator = (x, y) -> x + y;
		
//Supplier- No input > Return Something //T get();
		Supplier<Integer> randomIntegerSupplier = () -> {
			Random random = new Random();
			return random.nextInt(1000);
		};
		
	System.out.println(randomIntegerSupplier.get());

//Represents an operation on a single operand that produces a result of the 
//same type as its operand
	
		UnaryOperator<Integer> unaryOperator = x -> 3 * x;
		System.out.println(unaryOperator.apply(10));

//Takes 2 input and returns boolean
		BiPredicate<Integer, String> biPredicate = (number,str) -> {
			return number<10 && str.length()>5;
		};
		
		System.out.println(biPredicate.test(10, "in28minutes"));
		
//Takes 2 input and returns a output can be of diff type
	BiFunction<Integer, String, String> biFunction = (number,str) -> {
			return number + " " + str;
		};
		
		System.out.println(biFunction.apply(15, "in28minutes"));
//Takes 2 input and no result means no output , just runs the code		
		BiConsumer<Integer, String> biConsumer = (s1,s2) -> {
			System.out.println(s1);
			System.out.println(s2);
		};
		
		biConsumer.accept(25, "in28Minutes");
		
		BinaryOperator<Integer> sumBinaryOperator2 = (x, y) -> x + y;

//Like BinaryOperator<Integer> in purpose, but it works with primitive int etc		
		IntBinaryOperator intBinaryOperator = (x,y) -> x + y;
		
		//IntBinaryOperator
		//IntConsumer
		//IntFunction
		//IntPredicate
		//IntSupplier
		//IntToDoubleFunction
		//IntToLongFunction
		//IntUnaryOperator
		
		//Long, Double, Int
		

		//numbers.stream().filter(isEvenPredicate).map(squareFunction).forEach(sysoutConsumer);

		//int sum = numbers.stream().reduce(0, sumBinaryOperator);
	}
	}


