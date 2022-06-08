package listeners_TestNG;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestNGMethod;
import org.testng.ITestResult;

public class CustomListener2 implements ITestListener {

	@Override
	public void onFinish(ITestContext arg0) {
		// before <test> tag of xml file
		System.out.println("onFinish -> Test Tag Name : " + arg0.getName());

	}

	@Override
	public void onStart(ITestContext arg0) {
		// before <test> tag of xml file
		System.out.println("onStart -> Test Tag Name : " + arg0.getName());
		ITestNGMethod methods[] = arg0.getAllTestMethods();
		System.out.println("These methods will be executed in this test tag");
		for (ITestNGMethod method : methods) {
			System.out.println(method.getMethodName());
		}

	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult arg0) {
		System.out.println("onTestFailedButWithinSuccessPercentage -> ");
	}

	@Override
	public void onTestFailure(ITestResult arg0) {
		// When test method passes
		System.out.println("onTestFailure -> Test Name : " + arg0.getName());
	}

	@Override
	public void onTestSkipped(ITestResult arg0) {
		// When test method gets skipped
		System.out.println("onTestSkipped -> Test Name : " + arg0.getName());

	}

	@Override
	public void onTestStart(ITestResult arg0) {
		// When test method starts
		System.out.println("onTestStart -> Test Name : 	" + arg0.getName());

	}

	@Override
	public void onTestSuccess(ITestResult arg0) {
		// When test method passes
		System.out.println("onTestSuccess -> Test Name : " + arg0.getName());

	}

}
