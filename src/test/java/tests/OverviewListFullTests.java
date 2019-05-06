package tests;

import api.EndPoints;
import appmanager.TestBase;
import appmanager.TestListener;
import dataprovider.DataProviderDocument;
import io.qameta.allure.Description;
import model.BaseModel;
import model.exception.ExceptionRawSchemaModel;
import model.regular.RegularRawSchemaModel;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import java.io.IOException;

import static io.qameta.allure.Allure.step;
import static org.testng.Assert.assertEquals;

@Listeners(TestListener.class)
public class OverviewListFullTests extends TestBase {

    @Description("Overview list full method positive")
    @Test(dataProvider = "validOverviewListFullPositive", dataProviderClass = DataProviderDocument.class, alwaysRun = true)
    public void testOverviewListFullPositive(RegularRawSchemaModel fullExpected) throws IOException, IllegalAccessException, InstantiationException, ClassNotFoundException {
        step(String.format("Test case: %s", fullExpected.getTestCase()));

        app.setCheck("Clear variables");
        app.getDocumentAPI().clearVariables();

        app.setCheck("Send request");
        //Send request and get response

        BaseModel fullInFact = app.getDocumentAPI().overviewListFullOperation(
                app.getDocumentAPI().returnHeaderParams(fullExpected),
                app.getDocumentAPI().getBodyInHashMap(fullExpected.getBodyMap()));


        app.setCheck("Assert fact");
        //Assert result
        logTrace("Assert:" + fullInFact + "\r\n" + fullExpected);
        //we need this to see every test case in Allure report
        fullInFact.setTestCase(fullExpected.getTestCase());
        fullInFact.processResponce();

        assertEquals(fullInFact, fullExpected);

    }

    @Description("Overview list full method negative")
    @Test(dataProvider = "validOverviewListFullNegative", dataProviderClass = DataProviderDocument.class, alwaysRun = false, enabled = false)
    public void testOverviewListFullNegative(ExceptionRawSchemaModel fullExpected) throws IOException, IllegalAccessException, InstantiationException, ClassNotFoundException {

        step(String.format("Test case: %s", fullExpected.getTestCase()));

        app.setCheck("Clear variables");
        app.getDocumentAPI().clearVariables();

        app.setCheck("Send request");
        //Send request and get response
        BaseModel fullInFact = app.getDocumentAPI().overviewListFullOperation(
                app.getDocumentAPI().returnHeaderParams(fullExpected),
                app.getDocumentAPI().getBodyInHashMap(fullExpected.getBodyMap()));


        app.setCheck("Assert fact");
        //Assert result
        logTrace("Assert:" + fullInFact + "\r\n" + fullExpected);
        //we need this to see every test case in Allure report
        fullInFact.setTestCase(fullExpected.getTestCase());

        assertEquals(fullInFact, fullExpected);

    }

}
