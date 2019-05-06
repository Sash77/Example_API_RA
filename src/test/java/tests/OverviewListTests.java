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
public class OverviewListTests extends TestBase {

    @Description("Overview list method positive")
    @Test(dataProvider = "validOverviewListPositive", dataProviderClass = DataProviderDocument.class, alwaysRun = true)
    public void testOverviewListPositive(RegularRawSchemaModel listExpected) throws IOException, IllegalAccessException, InstantiationException, ClassNotFoundException {
        step(String.format("Test case: %s", listExpected.getTestCase()));

        app.setCheck("Clear variables");
        app.getDocumentAPI().clearVariables();

        app.setCheck("Send request");
        //Send request and get response

        BaseModel listInFact = app.getDocumentAPI().overviewListOperation(
                app.getDocumentAPI().returnHeaderParams(listExpected),
                app.getDocumentAPI().getBodyInHashMap(listExpected.getBodyMap()));


        app.setCheck("Assert fact");
        //Assert result
        logTrace("Assert:" + listInFact + "\r\n" + listExpected);
        //we need this to see every test case in Allure report
        listInFact.setTestCase(listExpected.getTestCase());
        listInFact.processResponce();

        assertEquals(listInFact, listExpected);

    }

    @Description("Overview list method negative")
    @Test(dataProvider = "validOverviewListNegative", dataProviderClass = DataProviderDocument.class, alwaysRun = false, enabled = false)
    public void testOverviewListNegative(ExceptionRawSchemaModel listExpected) throws IOException, IllegalAccessException, InstantiationException, ClassNotFoundException {

        step(String.format("Test case: %s", listExpected.getTestCase()));

        app.setCheck("Clear variables");
        app.getDocumentAPI().clearVariables();

        app.setCheck("Send request");
        //Send request and get response
        BaseModel listInFact = app.getDocumentAPI().overviewListOperation(
                app.getDocumentAPI().returnHeaderParams(listExpected),
                app.getDocumentAPI().getBodyInHashMap(listExpected.getBodyMap()));


        app.setCheck("Assert fact");
        //Assert result
        logTrace("Assert:" + listInFact + "\r\n" + listExpected);
        //we need this to see every test case in Allure report
        listInFact.setTestCase(listExpected.getTestCase());

        assertEquals(listInFact, listExpected);

    }

}
