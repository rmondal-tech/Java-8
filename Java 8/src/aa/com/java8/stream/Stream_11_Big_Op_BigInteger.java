package aa.com.java8.stream;

import java.math.BigInteger;
import java.util.stream.IntStream;
import java.util.stream.LongStream;

public class Stream_11_Big_Op_BigInteger {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

// Factorial(50)=1*2*..*50		
		int facorial1=IntStream.rangeClosed(1, 50).reduce(1, (x,y)->x*y);  // 0 //int cant handel
       System.out.println(facorial1);
       
   	long facorial2=LongStream.rangeClosed(1, 50).reduce(1L, (x,y)->x*y);  //-(ve-)3258495067890909184 Long cant handel f(50)
    System.out.println(facorial2);
    
  	long facorial3=LongStream.rangeClosed(1, 20).reduce(1L, (x,y)->x*y);  //2432902008176640000 // low cantorial can be handeled like 20
    System.out.println(facorial3);
    
   	 BigInteger facorial4 = LongStream.rangeClosed(1, 50).mapToObj(BigInteger::valueOf).reduce(BigInteger.ONE, BigInteger::multiply);  //-(ve-)3258495067890909184 Long cant handel f(50)
    System.out.println(facorial4); //30414093201713378043612608166064768844377641568960512000000000000
  
	}

}
