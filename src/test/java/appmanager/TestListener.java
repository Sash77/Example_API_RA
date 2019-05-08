package appmanager;

import io.qameta.allure.Allure;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class TestListener implements ITestListener {
    @Override
    public void onTestStart(ITestResult result) {

    }

    @Override
    public void onTestSuccess(ITestResult result) {

    }

    @Override
    public void onTestFailure(ITestResult result) {

        ApplicationManager app = (ApplicationManager) result.getTestContext().getAttribute("app");
        Allure.addAttachment(app.getCheck(), app.getMessageToLog());
        app.logError(app.getCheck());

    }

    @Override
    public void onTestSkipped(ITestResult result) {

        ApplicationManager app = (ApplicationManager) result.getTestContext().getAttribute("app");
        Allure.addAttachment(app.getCheck(), app.getMessageToLog());
        app.logError(app.getCheck());

    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {

    }

    @Override
    public void onStart(ITestContext context) {

    }

    @Override
    public void onFinish(ITestContext context) {

    }
}
