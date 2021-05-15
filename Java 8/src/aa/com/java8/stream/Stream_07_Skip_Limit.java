package aa.com.java8.stream;

import java.util.Comparator;
import java.util.stream.Stream;

import com.java8.stream.supporting.entity.Book;

public class Stream_07_Skip_Limit {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
      Book book=new Book();
      
 //01 Stream.Skip(n)- returns stream after discarding the first n elements of the stream
      //return after first 3 element
      Book.bookList.stream().skip(3).forEach(System.out::println);
      System.out.println("ex02_______________________________________");

 
//02 Stream.limit(n)- returns stream with first n elements of the stream
      //limit it to 3 - return first 3
      Book.bookList.stream().limit(3).forEach(System.out::println);
      System.out.println("ex03_______________________________________");
      
//03 limit on sorted stream
      Book.bookList.stream().sorted(Comparator.comparing(Book::getReleaseYear)).limit(4).forEach(System.out::println);
      System.out.println("ex04_______________________________________");

      
//04 
//             Book [bookName=Book A, releaseYear=1954, bookId=100]
//    		  Book [bookName=Book B, releaseYear=1963, bookId=200]
//    		  Book [bookName=Book B, releaseYear=1963, bookId=200]
//    		  Book [bookName=Book C, releaseYear=1910, bookId=300]
//    		  Book [bookName=Book D, releaseYear=1990, bookId=400]
//    		  Book [bookName=Book E, releaseYear=1905, bookId=500]
      Book.bookList.stream().forEach(System.out::println);
     
      
	}

}
