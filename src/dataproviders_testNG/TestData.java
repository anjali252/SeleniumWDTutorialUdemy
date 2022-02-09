package dataproviders_testNG;

import org.testng.annotations.DataProvider;

//But now let's imagine that you have a lot of test methods inside this test class. So if you have a lot of test methods that's like 
//maybe 30 and then you have data provider methods all in the same class, it becomes a little big and huge and it's kind of difficult
//to manage and organize So sometimes it's a good idea to put all the data providers, all the methods which provides us the data Into
//a completely separate class. And then we can read the data from there. So what it does, it it separates out the actual test methods 
//and the test data. It is a little easier to handle, also manage and organize as well. So we can simply do that. 

public class TestData {
	@DataProvider(name = "input")
	public Object[][] getData() {
		return new Object[][] { { "Maruti Suzuki Alto", "800" }, { "Mercedes Benz", "A class" }, { "Audi", "3" } };

	}
}
