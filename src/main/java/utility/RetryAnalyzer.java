package utility;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

import org.testng.IAnnotationTransformer;
import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;
import org.testng.annotations.ITestAnnotation;

public class RetryAnalyzer implements IRetryAnalyzer, IAnnotationTransformer
{

	int count = 1;
	int retryMaxLimit = 0;

	@Override
	public void transform(ITestAnnotation annotation, Class testclass, Constructor testconstructor, Method testmethod)
	{
		annotation.setRetryAnalyzer(RetryAnalyzer.class);
	}

	@Override
	public boolean retry(ITestResult result)
	{
		if (count <= retryMaxLimit)
		{
			count++;
			return true;
		}
		return false;
	}
}
