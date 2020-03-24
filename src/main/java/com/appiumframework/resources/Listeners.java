package com.appiumframework.resources;





import java.io.IOException;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.appiumframework.Base;





public class Listeners implements ITestListener {
	
	
	
	
	public void onTestFailure(ITestResult result) {
		
		
		//System.out.println("The Test is Failed  "+result.getStatus());
		
		
				try {
					Base.captureScreenshot();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} 
				
				
		
		
		
		
		  //The name of this TestResult, typically identical to the name of the method.
		  //String TestName = result.getName();
		  
		// try {
			//Base.takeScreenShot(TestName);
		//} catch (IOException e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
	//	}
		 
	}

	@Override
	public void onTestStart(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub
		
	}
	

}
