package aa.com.java8.stream;

import java.util.List;

import com.java8.stream.supporting.entity.Book;

/*<Integer> Stream<Integer> java.util.stream.Stream.map(Function<? super Integer, ? extends Integer> mapper	

//Map(lambda)- Apply a function in the stream and return updated stream.transform
   one object into other by applying a function. changes individual items 
   Separately .unary
*/	
	
public class Stream_02_Map {
	public static void main(String[] args) {

		List<Integer> numbers = List.of(1, 2, 3, 4, 5, 6, 7, 8, 9);
		List<String> courses = List.of("Spring", "Spring Boot", "API" , "Microservices","AWS", "PCF","Azure", "Docker", "Kubernetes");
	
//1. dont print the numbers in stream, print their square. map x->x*x
		
		numbers.stream() // Convert to Stream
		//mapping - x -> x * x
		.map(number -> number * number)
		.forEach(System.out::println);// Method Reference//print stream elements
		  System.out.println("---------------------------------------");
		  

//2.Filter+Map- Filter only odd numbers and print their square
		numbers.stream()
       .filter(number->number%2==0)
		.map(number -> number * number)
		.forEach(System.out::println);
		  System.out.println("---------------------------------------");
		  
		
//3 Course Name and length for Spring courses
		courses.stream()
	       .filter(course->course.contains("Spring"))
			.map(course -> course+" "+course.length())
			.forEach(System.out::println);
		 System.out.println("---------------------------------------");
		 
		
//04 user a pojo class object in filter and map  
// 1. filter- all book above 1950  2. convert stream to String(name+year) from Book
	    Book book=new Book();	
	  //  List < Float > productPriceList =
	    		Book.bookList.stream()
	    		 .filter((x)->x.getReleaseYear()>1950)             //dont use book ,use x as its already used variable
	    		    .map((x) -> x.getBookName()+" "+x.getReleaseYear())
	    		
	    		        .forEach(System.out::println);
	    		
	    	
	}

}