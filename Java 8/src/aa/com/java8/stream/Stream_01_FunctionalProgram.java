package aa.com.java8.stream;

import java.util.List;
//An ordered collection (also known as a sequence). The user of thisinterface has precise control over where in the list each element isinserted.
//The user can access elements by their integer index (position inthe list), and search for elements in the list
import java.util.stream.Stream;

public class Stream_01_FunctionalProgram {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		List<Integer> numbers = List.of(1, 2, 3, 4, 5, 6, 7, 8, 19);
		
//1 printing using Structural Program
		for(int number:numbers) {
		//	System.out.println(number);
		}
		
//Stream- A sequence of elements supporting sequential and parallel aggregate operations
//Returns a sequential Stream with this collection as its source. 
//2
	numbers.stream().
	//what to do 
	forEach(Stream_01_FunctionalProgram::print);//method reference- static method
		
//3		
	numbers.stream().forEach(System.out::println);//method reference
		
//filter(predicate)	-Filter-Stream<Integer> java.util.stream.Stream.filter(Predicate<? super Integer> predicate)
/*Filter- Returns a stream consisting of the elements of this stream that match the given
 predicate. This is an intermediateoperation.
Parameters:predicate a non-interfering, statelesspredicate to apply to each
element to determine if it should be includedReturns:the new stream
//Predicate-This is a functional interfacewhose functional method is test(Object).
          Represents a predicate (boolean-valued function) of one argument. 
*/	
//4
		numbers.stream()
		.filter(Stream_01_FunctionalProgram::isEven)
	.forEach(Stream_01_FunctionalProgram::print);

//5 Lambda-

		numbers.stream()
	//wt to do
		.filter(number->number%2==0)//one st in lambda is return st
    //wt to do		
		.forEach(Stream_01_FunctionalProgram::print);
		
		
List<String> courses = List.of("Spring", "Spring Boot", "API" , "Microservices","AWS", "PCF","Azure", "Docker", "Kubernetes");

//6 Lambda - Courses with Spring
 courses.stream()
.filter(course -> course.contains("Spring"))
.forEach(System.out::println);

	}

	private static void print(int number) {
		System.out.println(number);
		
	}


	private static boolean isEven(int number) {
         return number%2==0;		
	}

}
