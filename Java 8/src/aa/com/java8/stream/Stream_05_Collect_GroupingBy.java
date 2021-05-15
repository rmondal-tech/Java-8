package aa.com.java8.stream;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import com.java8.stream.supporting.entity.*;

/*import static java.util.stream.Collectors.*;
or just single import collectors of your choice:

import static java.util.stream.Collectors.toList;
import static java.util.stream.Collectors.toMap;
import static java.util.stream.Collectors.toSet;
*/


/*
//Collect - 
  1. collecting a stream into a collection like list //opposite of stream()
  2.are used at the final step of processing a Stream.
  3. power of Collectors for parallel processing
  
  */


public class Stream_05_Collect_GroupingBy {
	public static void main(String[] args) {
	
//01 List to a diff List  //covert elements to square and store in a list		
		List<Integer> numbers = List.of(1, 2, 3, 4, 5, 6, 7, 8, 19);
		
		List<Integer> list=numbers.stream().map(x->x*x)
				 .collect(Collectors.toList());//toMap(),toSet()
		  
		System.out.println(list.toString());
		System.out.println("---------------------------------------");
		
		
//02 transforming a List into a Map.
		
	      Book book=new Book();		
		
		Map<String, String> bookMap = Book.bookList.stream().collect(
				  Collectors.toMap(Book::getBookId, Book::getBookName));
		
		  System.out.println("---------------------------------------");
		  

//03  transforming a List into a Map. Value is whole book object
		
/*java.util.function.Function<T, R>
Represents a function that accepts one argument and produces a result. 

Type Parameters:
<T> the type of the input to the function
<R> the type of the result of the function
Function.identity()- returns input object
*/
		Map<String, Book> bookMap1 = Book.bookList.stream().collect(
				  Collectors.toMap(Book::getBookId, Function.identity()));
		
		System.out.println(bookMap);
		
//{100=Book [bookName=Book A, releaseYear=1954, bookId=100], 200=Book [bookName=Book B, releaseYear=1963, bookId=200], 300=Book [bookName=Book C, releaseYear=1910, bookId=300]}

		System.out.println(bookMap1);
		  System.out.println(bookMap1.size());
		  
//________________________groupingBy_____________________________________________
		  
//03 Group duplicate keys into a single key map(bcz list can have same id values)
/*
 Collectors.groupingBy(Function)
 -----------------------
 where map keys are duplicate the we can use Collectors.groupingBy()
 to collect elements to map in Map<keyObj, List<Element>> format.
 Here for each map key, we will store all elements in a list as map value.
 Map<String, List<Employee>> employeesMap = employeeList.stream()
             .collect(Collectors.groupingBy(Employee::getName));
         
Map<String, List<Book>> BookMapUsingGroupingBy = bookList.stream()
            .collect(Collectors.groupingBy(Book::getBookId));	
*/

//01  Book group by release year
//{1905=[Book [bookName=Book E, releaseYear=1905, bookId=500]], 1954=[Book [bookName=Book A, releaseYear=1954, bookId=100], Book [bookName=Book D, releaseYear=1954, bookId=400]], 1990=[Book [bookName=Book D, releaseYear=1990, bookId=400]], 1910=[Book [bookName=Book C, releaseYear=1910, bookId=300]], 1963=[Book [bookName=Book B, releaseYear=1963, bookId=200], Book [bookName=Book B, releaseYear=1963, bookId=250]]}	  
		  book.bookList.add(new Book("Book D",1954,"400"));
  Map<Integer, List<Book>> BookMapUsingGroupingBy =  Book.bookList.stream()
          .collect(Collectors.groupingBy(Book::getReleaseYear)); //Returns a Collector implementing a "group by" operation oninput elements of type T, grouping elements according to aclassification function, and returning the results in a Map. 
  System.out.println("BookMapUsingGroupingBy Book object by Release yr "+BookMapUsingGroupingBy);
 
  
//02 Book Name group by release year 
  // {1905=[Book E], 1954=[Book A, Book D], 1990=[Book D], 1910=[Book C], 1963=[Book B, Book B]}
  
  Map<Integer, List<String>> onlyBookNameNotBookObjectByReleaseYr = Book.bookList.stream()
  .collect(Collectors.groupingBy(Book::getReleaseYear,Collectors.mapping(Book::getBookName, Collectors.toList()))); //Returns a Collector implementing a "group by" operation oninput elements of type T, grouping elements according to aclassification function, and returning the results in a Map. 
  System.out.println("only BookName ,Not BookObject- ByReleaseYr "+onlyBookNameNotBookObjectByReleaseYr);
  
 // 03 (without printing entire object), count of book by release year
  // {1905=1, 1954=2, 1990=1, 1910=1, 1963=2}
 Map<Integer, Long> countOfBookByReleaseYr = Book.bookList.stream()
  .collect(Collectors.groupingBy(Book::getReleaseYear,Collectors.counting())); //Returns a Collector implementing a "group by" operation oninput elements of type T, grouping elements according to aclassification function, and returning the results in a Map. 
System.out.println("countOfBookByReleaseYr "+countOfBookByReleaseYr);

// 04-  only one object in that category with  max value BookId
//bookOfMaxIdByReleaseYr {1905=Optional[Book [bookName=Book E, releaseYear=1905, bookId=500]], 1954=Optional[Book [bookName=Book D, releaseYear=1954, bookId=400]], 1990=Optional[Book [bookName=Book D, releaseYear=1990, bookId=400]], 1910=Optional[Book [bookName=Book C, releaseYear=1910, bookId=300]], 1963=Optional[Book [bookName=Book B, releaseYear=1963, bookId=250]]}
// means in 1905 many books can be released but we need the book with max bookID ie 500
Map<Integer, Optional<Book>> bookOfMaxIdByReleaseYr = Book.bookList.stream()
.collect(Collectors.groupingBy(Book::getReleaseYear,Collectors.maxBy(Comparator.comparing(Book::getBookId)))); //Returns a Collector implementing a "group by" operation oninput elements of type T, grouping elements according to aclassification function, and returning the results in a Map. 
System.out.println("bookOfMaxIdByReleaseYr "+bookOfMaxIdByReleaseYr);



	}
}
