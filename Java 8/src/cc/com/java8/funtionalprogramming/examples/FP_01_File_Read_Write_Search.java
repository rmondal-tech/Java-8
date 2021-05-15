package cc.com.java8.funtionalprogramming.examples;

import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class FP_01_File_Read_Write_Search {
/*
 * File IO with Streams:
 ----------------------
Java 8 added some static methods to Files helper class as part of the Stream API,
 namely - Files.lines, Files.list, Files.walk, and Files.find.
All of these methods do IO operations and can throw IOException, which is a checked exception that the caller must catch or propagate appropriately.
 */
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

//  Files.lines->Stream<String>) - Read all lines from a file as a Stream. 
		Files.lines(Paths.get("file.txt")) //File is in root of project
		.forEach(System.out::println);
		System.out.println("02-----------------------------");
		//Path filePath = Paths.get("c:/temp", "file.txt");

//02 want to gather all the unique words from a file;
		
	

//		AAAA
//		BBBB
//		CCC
//		CCCC
//		DDDD
//		EEEE
//		FFFF
//		GGGG
		Files.lines(Path.of("./file.txt"))
		.map(str -> str.split(" "))
		.flatMap(Arrays::stream)
		.distinct()
		.sorted()
		.forEach(System.out::println);
		System.out.println("03-----------------------------");
		
//03Listing a directory with Files.list-- all folders in root		
//		.\.settings
//		.\bin 
//		.\src
		Files.list(Paths.get(".")) // only direct sub directory is considered
		.filter(Files::isDirectory) //only dir
		.forEach(System.out::println);
		System.out.println("04-----------------------------");
		
//04 Traversing a directory structure in depth with Files.walk
/*
 * The Files.list is quite a helpful method. However, if we want to collect some information
 *  from nested files and folders under a directory, we need a more powerful utility. 
 *  The Files.walk method can traverse down a given folder for a specified depth and 
 *  return a stream of paths, which can be lazily processed to retrieve sought data.		
 */
		
//File name -file length
    Files.walk(Path.of("./"), 2)//.forEach(System.out::println);////Traverse for depth 3
    //The toFile() method of java.nio.file.Path interface used to return a java.io.File object representing this path object
    .map((p) -> p.getFileName().toString()+" "+p.toFile().length()) //Map to file size/length (long)
    .forEach(System.out::println);
    
    long sumOfFileSize = Files.walk(Path.of("./"), 2)
    		.filter(Files::isRegularFile)
    .mapToLong(p->p.toFile().length())
    .sum();
    System.out.println("sumOfFileSize-"+sumOfFileSize);
    System.out.println("05-----------------------------");
    

//05  Finding files with Files.find	// Files.find(Path start, int maxDepth, BiPredicate<Path, BasicFileAttributes> matcher, FileVisitOption... options) 
    try(Stream<Path> paths = Files.find(Path.of("./"), 3,
    		(p, a) -> { //Bi-Predicate 
    			return a.isRegularFile() &&
    				//	a.size() >1056  a.size() >1kb
    					a.size() >1 &&  //Regular file with size >.1kb  1KB=1024
    					p.toString().endsWith(".txt"); //.txt file
    		})) {

    	paths.forEach((p) -> System.out.println(p));

    } catch (IOException e) {
    	e.printStackTrace();
    	//...
    }
    System.out.println("06"
    		+ "-----------------------------");
    
 // Java program to write content to file using Java 8 APIs is –

 //way1
 //Get the file reference
  Path path = Paths.get("c:/temp/output.txt");
   
  //Use try-with-resource to get auto-closeable writer instance
  try (BufferedWriter writer = Files.newBufferedWriter(path)) 
  {
      writer.write("Hello World !!");
  }
  
//  2. Write to file using Files.write()
 // Using Files.write() method is also pretty much clean code.

  String content = "Hello World !!";
   
  Files.write(Paths.get("c:/temp/output.txt"), content.getBytes());
    
	}
}
