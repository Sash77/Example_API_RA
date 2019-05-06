package tests;

import api.EndPoints;
import appmanager.TestBase;
import appmanager.TestListener;
import dataprovider.DataProviderDocument;
import io.qameta.allure.Description;
import model.BaseModel;
import model.exception.ExceptionRawRecordModel;
import model.regular.RegularRawRecordModel;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import java.io.IOException;

import static io.qameta.allure.Allure.step;
import static org.testng.Assert.assertEquals;

@Listeners(TestListener.class)
public class DocumentTabTests extends TestBase {

    @Description("Document tab method positive")
    @Test(dataProvider = "validDocumentTabPositive", dataProviderClass = DataProviderDocument.class, alwaysRun = true)
    public void testTabPositive(RegularRawRecordModel tabExpected) throws IOException, IllegalAccessException, InstantiationException, ClassNotFoundException {
        step(String.format("Test case: %s", tabExpected.getTestCase()));

        app.setCheck("Clear variables");
        app.getDocumentAPI().clearVariables();

        app.setCheck("Send request");
        //Send request and get response

        tabExpected.addRowToBodyMap("id",tabExpected.getId());


        BaseModel tabInFact = app.getDocumentAPI().documentTabOperation(
                app.getDocumentAPI().returnHeaderParams(tabExpected),
                app.getDocumentAPI().getBodyInHashMap(tabExpected.getBodyMap()));


        app.setCheck("Assert fact");
        //Assert result
        logTrace("Assert:" + tabInFact + "\r\n" + tabExpected);
        //we need this to see every test case in Allure report
        tabInFact.setTestCase(tabExpected.getTestCase());
        tabInFact.processResponce();

        assertEquals(tabInFact, tabExpected);

    }

    @Description("Document tab method negative")
    @Test(dataProvider = "validDocumentTabNegative", dataProviderClass = DataProviderDocument.class, alwaysRun = false, enabled = false)
    public void testTabNegative(ExceptionRawRecordModel tabExpected) throws IOException, IllegalAccessException, InstantiationException, ClassNotFoundException {

        step(String.format("Test case: %s", tabExpected.getTestCase()));

        app.setCheck("Clear variables");
        app.getDocumentAPI().clearVariables();

        app.setCheck("Send request");
        //Send request and get response
        BaseModel tabInFact = app.getDocumentAPI().documentTabOperation(
                app.getDocumentAPI().returnHeaderParams(tabExpected),
                app.getDocumentAPI().getBodyInHashMap(tabExpected.getBodyMap()));


        app.setCheck("Assert fact");
        //Assert result
        logTrace("Assert:" + tabInFact + "\r\n" + tabExpected);
        //we need this to see every test case in Allure report
        tabInFact.setTestCase(tabExpected.getTestCase());

        assertEquals(tabInFact, tabExpected);

    }

}
