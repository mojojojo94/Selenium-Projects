
import org.junit.Test;
import junit.framework.Assert;

public class Sum {
	
	public static int c;
	
	public static int sum(int a, int b){
		c = a + b;
	return c;
	}
	
	@Test
	public void testSum(){
		int i = sum(10 , 20);
		Assert.assertEquals(i, 30);
	}
	
}
