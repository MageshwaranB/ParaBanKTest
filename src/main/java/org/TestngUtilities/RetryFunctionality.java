package org.TestngUtilities;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class RetryFunctionality implements IRetryAnalyzer {
    int count=0;
    @Override
    public boolean retry(ITestResult result) {
        if(count==0){
            count++;
            return true;
        }
        return false;
    }
}
