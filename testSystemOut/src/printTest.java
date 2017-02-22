/* Test System.out.println() and System.out.print() */
import org.junit.Assert.*;
import org.junit.Test;

public class printTest {
	public static void main(String[] args) {
		System.out.println("Hello, world!"); // Advance the cursor to the beginning of next line after printing
		System.out.println();                // Print a empty line
		System.out.print("Hello, world!");   // Cursor stayed after the printed string
		System.out.println("Hello,");
		System.out.print(" ");               // Print a space
		System.out.print("world!");
		System.out.println("Hello, world!");
		
	}
	
	@Test
	public void testPrint(){
		
	}
	

}
