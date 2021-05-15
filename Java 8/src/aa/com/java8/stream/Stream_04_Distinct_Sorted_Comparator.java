package aa.com.java8.stream;

import java.util.Comparator;
import java.util.List;

import com.java8.stream.supporting.entity.Book;
/*
 
Stream<Integer> java.util.stream.Stream.distinct()
   Returns a stream consisting of the distinct elements (according to 
   Object.equals(Object)) of this stream. 
   
Stream.Sort()-->Natural Order by default
Stream.sorted(comparator/ie Lambda)--sort based on comparator

 */
public class Stream_04_Distinct_Sorted_Comparator {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<Integer> numbers = List.of(10,1, 2, 3, 3, 4, 4, 5, 6, 7, 8, 9);
		List<String> courses = List.of("Spring", "Spring Boot", "API" , "Microservices","AWS", "PCF","Azure", "Docker", "Kubernetes");

//01 distinct numbers in stream		
		numbers.stream().distinct()
		         .forEach(System.out::println);
		  System.out.println("---------------------------------------");

//02 sorted
		numbers.stream().sorted()
        .forEach(System.out::println);
		  System.out.println("---------------------------------------");
		
//03 sort Strings-- by default is natural order		
		courses.stream().sorted()
                          .forEach(System.out::println);
		  System.out.println("---------------------------------------");

//04 sort Strings-  user Comparator--- sort(Comparator)
	/*Comparators can be passed to a sort method (such as Collections.
	 * sort or Arrays.sort) to allow precise control over the sort order. 
	 */	
	 	courses.stream().sorted(Comparator.naturalOrder())
	                              .forEach(System.out::println);
	 	  System.out.println("---------------------------------------");
	 	
//05 Comparator calss -Sort string reverse order 
	 	courses.stream().sorted(Comparator.reverseOrder())
        .forEach(System.out::println);
	 	  System.out.println("---------------------------------------");
	 	
//06 Comparator(lambda)-Sort String- based on string length
	 	//05 Sort string reverse order 
	 	courses.stream().sorted(Comparator.comparing(x->x.length())).forEach(System.out::println);
	 	  System.out.println("---------------------------------------");

//07 sort string - based on last char	 	
		courses.stream().
		sorted((str1, str2) -> 
		Character.compare(str1.charAt(str1.length() - 1),str2.charAt(str2.length() - 1)))
        . forEach(System.out::println);
		  System.out.println("---------------------------------------");
	
//08 sort Book list based on year of release
		Book book=new Book();
		   Book.bookList.stream()
				  .sorted(Comparator.comparingLong(Book::getReleaseYear)).forEach(System.out::println);
		   
		     //       .sorted((o1, o2) -> (o1 - o2.getSalary())).collect(Collectors.toList());
		    //.out.println(bookSortedList1);
		   System.out.println("---------------------------------------");
		   
		   
 //08 sort Book list based on year of release
		   
		   Book.bookList.stream()
				  .sorted((o1, o2) -> (o1.getReleaseYear() - o2.getReleaseYear())).forEach(System.out::println); 

		   
//Reversed order
			   Comparator<Book> comparator_reversed_order = Comparator.comparingLong(Book::getReleaseYear).reversed();
			Book.bookList.stream()
					  .sorted(comparator_reversed_order).forEach(System.out::println); 
//		Book book=new Book();
			   Book.bookList.stream()
				  .sorted(Comparator.comparingLong(Book::getReleaseYear)).forEach(System.out::println);
	
//	If this Comparator considers two elements equal, i.e. compare(a, b) == 0, other is used to determine the order. 
//comparator1.thenComparing(comparator2)
			   
	}

}
