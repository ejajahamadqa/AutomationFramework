package listeners;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class RetryTest implements IRetryAnalyzer {

    int count = 0;
    int max_Retry = 1;

    @Override
    public boolean retry(ITestResult iTestResult) {
        if(count<max_Retry) {
            count++;
            return true;
        }
        return false;
    }
}
