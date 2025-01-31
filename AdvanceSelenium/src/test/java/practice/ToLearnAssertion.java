package practice;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class ToLearnAssertion {
	
	@Test
	public void sample() {
		System.out.println("step1");
		System.out.println("step2");
		//validation//hard assert
		//assert.assertequal(false,true);
		//soft assert
		SoftAssert sa=new SoftAssert();
		sa.assertEquals(false, true);
		System.out.println("step3");
		System.out.println("step4");
		sa.assertAll();
	
	}

}
