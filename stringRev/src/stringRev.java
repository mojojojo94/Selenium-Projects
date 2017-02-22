import static org.junit.Assert.*;
import org.junit.Test;
import junit.framework.Assert;

public class stringRev {
	
	public String ReverseString(String sValue)
	{
		int i;
		String s = sValue;
		String reverse="";
		char[] ca = s.toCharArray();
		for(i=ca.length-1;i>=0;i--)
		{
			System.out.print(ca[i]);
			reverse=reverse+ca[i];
		}
		return reverse;
	}
	@Test
	public void testReverseString()
	{
		String x = ReverseString("123");
		assertEquals("321", x);
	}

}
