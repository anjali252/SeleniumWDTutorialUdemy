package dataproviders_testNG;

import org.testng.annotations.Test;

//we want to test something with different sets of data but we have only test method which test functionality test method should 
//focus functionality of test Then somehow we should be able to pass different kind of inputs to the same test method and we should
//be able to execute that test method with all those different set of input data if I take an example of WEB automation, I have a 
//login page, let's imagine, and I want to test the login functionality with different data set, one set is valid. I have a valid 
//username and password and this applies to rest case. So we have different multiple data sets. One is valid set where we have a 
//valid login and password. So my output should be I should be able to login and then for that valid set, I may have different kind
//of input

public class DataProviders {
//	@DataProvider(name = "input")
//	public Object[][] getData() {
//		return new Object[][] { { "Maruti Suzuki Alto", "800" }, { "Mercedes Benz", "A class" }, { "Audi", "3" } };
//
//	}

	@Test(dataProvider = "input", dataProviderClass = TestData.class)
	public void testMethod1(String input1, String input2) {
		System.out.println("INput 1 :" + input1);
		System.out.println("INput 2 :" + input2);
	}
}
