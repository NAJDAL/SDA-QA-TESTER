package Clarusway.utilities;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;



// TestNG listener named  which implements the  interface. This listener is responsible for printing out messages at various points during the execution of TestNG tests.

//A breakdown of what each method does:

//onTestStart: Prints a message when a test starts.
//onTestSuccess: Prints a message when a test successfully completes.
//onTestFailure: Prints a message when a test fails.
//onTestSkipped: Prints a message when a test is skipped.
//onTestFailedButWithinSuccessPercentage: Invoked if a test fails but is within success percentage.
//onTestFailedWithTimeout: Prints a message when a test fails due to a timeout.
//onStart: Prints a message when test execution starts, including the start time.
//onFinish: Prints a message when test execution finishes, including the end time.
//This listener can be used to monitor the execution of TestNG tests and provide information about their progress and outcome. You can attach this listener to your TestNG test suite configuration to enable its functionality.

public class Listeners implements ITestListener {
    @Override
    public void onTestStart(ITestResult result) {
        // ITestListener.super.onTestStart(result);
        System.out.println(result.getName() + " test has started..");
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        // ITestListener.super.onTestSuccess(result);
        System.out.println(result.getName() + " test has successfully completed..");
    }

    @Override
    public void onTestFailure(ITestResult result) {
        //ITestListener.super.onTestFailure(result);
        System.out.println(result.getName() + " test has failed..");
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        // ITestListener.super.onTestSkipped(result);
        System.out.println(result.getName() + " test has been skipped..");
    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
        ITestListener.super.onTestFailedButWithinSuccessPercentage(result);
    }

    @Override
    public void onTestFailedWithTimeout(ITestResult result) {
        //ITestListener.super.onTestFailedWithTimeout(result);
        System.out.println(result.getName() + " test has failed due to timeout..");
    }

    @Override
    public void onStart(ITestContext context) {
        //ITestListener.super.onStart(context);
        System.out.println("-------------------");
        System.out.println("the moment test execution started..");
        System.out.println("start time: " + context.getStartDate().toString());
    }

    @Override
    public void onFinish(ITestContext context) {
        //ITestListener.super.onFinish(context);
        System.out.println("the moment test execution finished..");
        System.out.println("end time: " + context.getEndDate().toString());
        System.out.println("-------------------");
    }
}
