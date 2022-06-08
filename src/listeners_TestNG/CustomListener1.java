package listeners_TestNG;

import org.testng.IInvokedMethod;
import org.testng.IInvokedMethodListener;
import org.testng.ITestResult;

public class CustomListener1 implements IInvokedMethodListener {

	@Override
	public void afterInvocation(IInvokedMethod arg0, ITestResult arg1) {
		// executes after every method on test class
		System.out.println(
				"afterInvocation " + arg1.getTestClass().getName() + "=>>" + arg0.getTestMethod().getMethodName());

	}

	@Override
	public void beforeInvocation(IInvokedMethod arg0, ITestResult arg1) {
		// executes before every method on test class
		System.out.println(
				"beforeInvocation " + arg1.getTestClass().getName() + "=>>" + arg0.getTestMethod().getMethodName());

	}

}
