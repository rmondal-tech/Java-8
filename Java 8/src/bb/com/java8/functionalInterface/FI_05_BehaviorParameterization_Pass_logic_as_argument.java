package bb.com.java8.functionalInterface;

import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class FI_05_BehaviorParameterization_Pass_logic_as_argument {

	// pass logic/lambda expression as argument in a method
	//also its possible to return a lambda function. see later

	@SuppressWarnings("unused")
	public static void main(String[] args) {
		
		List<Integer> numbers = List.of(12, 9, 13, 4, 6, 2, 4, 12, 15);
		
// pass logic/lambda expression as argument in a method
		filterAndPrint(numbers, x -> x%2==0);

		filterAndPrint(numbers, x -> x%2!=0);
		
		filterAndPrint(numbers, x -> x%3==0);
		
		Function<Integer, Integer> mappingFunction = x -> x*x;
		
		List<Integer> squaredNumbers =  mapAndCreateNewList(numbers, mappingFunction);
		
		List<Integer> cubedNumbers =  mapAndCreateNewList(numbers, x -> x*x*x);
		
		List<Integer> doubledNumbers =  mapAndCreateNewList(numbers, x -> x + x);
		
		System.out.println(doubledNumbers);
		
	}

	private static List<Integer> mapAndCreateNewList(List<Integer> numbers,
			Function<Integer, Integer> mappingFunction) {
		return numbers.stream()
				.map(mappingFunction)
				.collect(Collectors.toList());
	}

// This will accept a logic or lambda expression as argument
	private static void filterAndPrint(List<Integer> numbers, Predicate<? super Integer> predicate) {
		numbers.stream()
		.filter(predicate)
		.forEach(System.out::println);
	}
}

