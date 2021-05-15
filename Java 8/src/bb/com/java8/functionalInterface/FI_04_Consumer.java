package bb.com.java8.functionalInterface;

//Java Program to demonstrate
//Consumer's accept() method

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.function.Consumer;
public class FI_04_Consumer {
/*
 @FunctionalInterface
public interface Consumer<T> {

     * Performs this operation on the given argument.
    void accept(T t); //only abstract method
     default Consumer<T> andThen(Consumer<? super T> after)
 */
	public static void main(String[] args) {
		
//consumer.accept(input) //// Consumer to display a number	
        Consumer<Integer> display = a -> System.out.println(a);
        display.accept(10);
  
 // Consumer to multiply 2 to every integer of a list
  //multiline consumer / lambda      
        Consumer<List<Integer> > modifyConsumer = list ->
        {
            for (int i = 0; i < list.size(); i++) {
                list.set(i, 2 * list.get(i)); 
                }
            System.out.println(list);
        };
   
// list-->stream--> consume each element in stream
        Consumer<List<Integer> >
            dispListConsumer = list -> list.stream().forEach(a -> System.out.println(a + " "));
  
        List<Integer> list = new ArrayList<Integer>();
        list.add(2);
        list.add(1);
        list.add(3);
 
        dispListConsumer.accept(list);
        modifyConsumer.accept(list);

	}

}
