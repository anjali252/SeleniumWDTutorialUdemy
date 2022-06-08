package listeners_TestNG;

import org.testng.ISuite;
import org.testng.ISuiteListener;

public class CustomListener3 implements ISuiteListener {

	@Override
	public void onFinish(ISuite arg0) {
		System.out.println("onFinish -> After suite gets completed");

	}

	@Override
	public void onStart(ISuite arg0) {
		System.out.println("onStart -> Before suite gets started");
	}

}
