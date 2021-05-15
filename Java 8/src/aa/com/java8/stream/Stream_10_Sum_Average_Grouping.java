package aa.com.java8.stream;

import java.util.OptionalDouble;

import com.java8.stream.supporting.entity.Book;

public class Stream_10_Sum_Average_Grouping {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
Book book=new Book();

//Returns the sum of elements in this stream. 
//This is a special caseof a reductionand is equivalent to: return reduce(0, Integer::sum);

 int sumOfReleaseYrs = Book.bookList.stream()
   .mapToInt(x->x.getReleaseYear())//Returns an IntStream
   .sum();
 System.out.println(sumOfReleaseYrs); //11685
 
 OptionalDouble avgReleaseYr = Book.bookList.stream()
 .mapToInt(x->x.getReleaseYear())//Returns an IntStream
 .average();
 
 System.out.println(avgReleaseYr); //OptionalDouble[1947.5]
 
  long elementCount = Book.bookList.stream()
 .mapToInt(x->x.getReleaseYear())//Returns an IntStream
 .count();
  System.out.println(elementCount); //6
	}

}
