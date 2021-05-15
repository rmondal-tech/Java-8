package aa.com.java8.stream;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

import com.java8.stream.supporting.entity.Book;

public class Stream_09_Max_Min_FindFirst_FindAny {
 /*
    count() - This method returns the count of elements of a stream.

	findAny() - This method returns an java.util.Optional  describing some element of the stream, or an empty java.util.Optional if the stream is empty.

	findFirst() - This method  returns an java.util.Optional describing the first element of this stream, or an empty java.util.Optional if the stream is empty.
Optional<T> max(Comparator<? super T> comparator);
	max() - This method  returns the maximum element of a stream according to the provided Comparator.

	min() -  This method  returns the minimum element of a stream according to the provided Comparator.
	
	*/
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		  Book book=new Book();
		  List<Integer> numbers = new ArrayList<>();
		    numbers.add(1);
		    numbers.add(2);
		    numbers.add(3);
		    numbers.add(3);
		    numbers.add(4);
		    numbers.add(5);

		    // Count
		    long count = numbers.stream().count();
		    System.out.println("Count : " + count);

		    // Find Any
		    Integer findEle = numbers.stream()
		        .findAny()  //Min : Optional[1]- returns Optional<Integer> a Optional of element type. optional - value or empty 
		        .get();  //If a value is present, returns the value, otherwise throws NoSuchElementException.
		    System.out.println("FindAny : " + findEle);
		    
		    Integer findEle1 = numbers.stream()
			        .findAny()  //Min : Optional[1]- returns Optional<Integer> a Optional of element type. optional - value or empty 
			       .orElse(10000);  //If cant find , return 10000 
			    System.out.println("FindAny1  : " + findEle1);

		    // Find First
		    Integer findFirstEle = numbers.stream()
		        .findFirst() //first element of this stream,or an empty Optional if the stream is empty
		        .get();
		    System.out.println("FindFirst : " + findFirstEle);

		    // Max
		    Integer max = numbers.stream()
		        .max((a, b) -> a - b) //0r .max(Comparator.comparing(Integer::valueOf))
		        .get();
		    System.out.println("Max : " + max);

//use of optional		    
		    // Min
		   Optional<Integer> min = numbers.stream()
		        .min((a, b) -> a - b);
		       // .get();  // without this return a Optional[1], not 1

		    System.out.println("Min : " + min); 
		    
		    
		System.out.println(
				Book.bookList.stream()
		      .min(Comparator.comparing(Book::getBookId)));
		
		System.out.println(
				Book.bookList.stream()
		      .max(Comparator.comparing(Book::getBookId)));
		    
	}

}
