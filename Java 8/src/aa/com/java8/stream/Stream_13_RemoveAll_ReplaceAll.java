package aa.com.java8.stream;

import com.java8.stream.supporting.entity.Book;

public class Stream_13_RemoveAll_ReplaceAll {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

//List.replaceAll-Replaces each element of this list with the result of applying the 
// operator to that element ex id(100)=id_100 ,lower case
		
		Book book=new Book();
		Book.bookList.replaceAll(x->{
			x.setBookId("id_"+x.getBookId());
			x.setBookName(x.getBookName().toLowerCase());
			System.out.println(x);

				return x;
				}
		);
		
//		Collection. removeIf(Predicate<? super E> filter)
//		------------------------------------------------------
//		It removes all the elements from the List which satisfies the given Predicate.	
		
		boolean isRemoved=Book.bookList.removeIf(x->x.getReleaseYear()<1985);// returns T/F
		System.out.println(isRemoved);	     //true
		   
		 Book.bookList.forEach(System.out::println);// Book [bookName=book d, releaseYear=1990, bookId=id_400]

		   
		   
	}

}
