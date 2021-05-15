package aa.com.java8.stream;

import java.util.stream.LongStream;

public class Stream_Parallel {

	public static void main(String[] args)
	{

/*
Java Parallel Streams: 
----------------------
1. It is a feature of Java 8 and higher , meant for utilizing multiple cores of the processor.

2.Normally any java code has one stream of processing, where it is executed sequentially. 
  Whereas by using parallel streams, we can divide the code into multiple streams that
  executed in parallel on separate cores 

3. The final result is the combination of the individual outcomes. 

4. The order of execution, however, is not under our control.

When can be used ?
-----------------	
it is advisable to use parallel streams in cases whereno matter what is the order of execution,
the result is unaffected and the state of one element does not affect the other as well as the
source of the data also remains unaffected.	

Before Java 8 there was a big difference between parallel (or concurrent) code and sequential code.
It was also very hard to debug non-sequential code. Simply setting a breakpoint and going through 
the flow like you would normally do, would remove the parallel aspect, which is a problem if that
is what is causing the bug.
One of the advantages of streams is that the structure of the code stays the same: 
whether it's sequential or concurrent, it stays just as readable.

How to Create Parallel Stream:
------------------------------

1) .parallelStream() instead of  .stream() ,on a Collection
         The parallelStream() method of the Collection interface 
2) or  stream.parallel() , if you are not the creator of the stream).
             parallel() method of the BaseStream interface 
           
             */
             
             long time = System.currentTimeMillis();

//time:869
//System.out.println(LongStream.range(0,1000000000).sum());//499999999500000000

//time: 601
System.out.println(LongStream.range(0,1000000000).parallel().sum());

System.out.println(System.currentTimeMillis() - time);

	}
}
