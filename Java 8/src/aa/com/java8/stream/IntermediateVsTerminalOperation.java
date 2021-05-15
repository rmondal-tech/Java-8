package aa.com.java8.stream;

public class IntermediateVsTerminalOperation {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*
		 * 
1) The main difference between intermediate and terminal operations is that-
intermediate operations return a stream as a result and 
terminal operations return non-stream values like primitive or object or collection or may not return anything

2) Pipeline of operations may contain any number of intermediate operations, 
but there has to be only one terminal operation, that too at the end of pipeline.

3) Intermediate operations are lazily loaded. When you call intermediate operations, they are actually not executed.
They are just stored in the memory and executed when the terminal operation is called on the stream.

* Intermediate Operations :
-------------------------

map(), filter(), distinct(), sorted(), limit(), skip()

Terminal Operations :
-------------------

forEach(), toArray(), reduce(), collect(), min(), max(), count(),
anyMatch(), allMatch(), noneMatch(), findFirst(), findAny()

*/
	
	
	
	}

}
