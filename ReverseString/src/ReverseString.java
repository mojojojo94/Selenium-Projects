import java.util.Arrays;
import java.util.Scanner;

public class ReverseString {
	public static void main(String[] args){
		
		String ogString;
		String revString = "";
		
		Scanner userInput = new Scanner(System.in);
		System.out.print("Enter a string to be reversed: ");
		ogString = userInput.nextLine();
		
		//1st way using just logic
		int len = ogString.length();
		
		for (int i = len - 1; i >= 0; i--){
			revString = revString + ogString.charAt(i);	
		}
		
		//2nd way using the standard Java API
		//StringBuffer sb = new StringBuffer(ogString);
		//revString = sb.reverse().toString();
		
		System.out.println("This is was your original string:  " + ogString);
	    System.out.println("This is the reversed string: " + revString);
		
	}
	

}
