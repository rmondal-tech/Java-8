package aa.com.java8.stream;

import java.util.function.Predicate;

import com.java8.stream.supporting.entity.Book;

public class Stream_06_Boolean_allMatch_noneMatch_anyMatch {
	public static void main(String[] args) {


		Book book=new Book();

		// allMatch, noneMatch, anyMatch
		//	Predicate<Course> reviewScoreGreaterThan95Predicate 
		//		= course -> course.getReviewScore() > 95;
		//
		//	Predicate<Course> reviewScoreGreaterThan90Predicate 
		//		= course -> course.getReviewScore() > 90;
		//		
		//	Predicate<Course> reviewScoreLessThan90Predicate 
		//		= course -> course.getReviewScore() < 90;
		
//Stream.allMatch(Predicate<? super Book> predicate)
//Returns:true if either all elements of the stream match the provided predicate or the stream is empty,otherwise false	
	
	Boolean yesOrNoForAll=	Book.bookList.stream().allMatch(bookElement->bookElement.getReleaseYear()>1950);
		
//Stream.anyMatch(Predicate<? super Book> predicate)-
// true if any elements of the stream match the provided predicate, otherwise false
	Boolean yesOrNoForAny=Book.bookList.stream().anyMatch(bookElement->bookElement.getReleaseYear()>1950);

		
//true if either no elements of the stream match theprovided predicate or the stream is empty, otherwise false
	Boolean yesOrNoForNone=Book.bookList.stream().noneMatch(bookElement->bookElement.getReleaseYear()>1950);

	System.out.println(yesOrNoForAll+ " \n"+yesOrNoForAny+"\n"+yesOrNoForNone);

	}
}