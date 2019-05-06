package tests;

import api.EndPoints;
import appmanager.TestBase;
import appmanager.TestListener;
import dataprovider.DataProviderDocument;
import io.qameta.allure.Description;
import model.BaseModel;
import model.exception.ExceptionSimpleRecordModel;
import model.regular.RegularSimpleRecordModel;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import java.io.IOException;

import static io.qameta.allure.Allure.step;
import static org.testng.Assert.assertEquals;

@Listeners(TestListener.class)
public class DocumentTabSimpleTests extends TestBase {

    @Description("Document tab simple method positive")
    @Test(dataProvider = "validDocumentTabSimplePositive", dataProviderClass = DataProviderDocument.class, alwaysRun = true)
    public void testTabSimplePositive(RegularSimpleRecordModel tabExpected) throws IOException, IllegalAccessException, InstantiationException, ClassNotFoundException {
        step(String.format("Test case: %s", tabExpected.getTestCase()));

        app.setCheck("Clear variables");
        app.getDocumentAPI().clearVariables();

        app.setCheck("Send request");
        //Send request and get response

        if (!tabExpected.getId().equals("")) {
            tabExpected.addRowToBodyMap("id", tabExpected.getId());
        }


        BaseModel tabInFact = app.getDocumentAPI().documentTabSimpleOperation(
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

    @Description("Document tab simple method negative")
    @Test(dataProvider = "validDocumentTabSimpleNegative", dataProviderClass = DataProviderDocument.class, alwaysRun = false, enabled = false)
    public void testTabSimpleNegative(ExceptionSimpleRecordModel tabExpected) throws IOException, IllegalAccessException, InstantiationException, ClassNotFoundException {

        step(String.format("Test case: %s", tabExpected.getTestCase()));

        app.setCheck("Clear variables");
        app.getDocumentAPI().clearVariables();

        if (!tabExpected.getId().equals("")) {
            tabExpected.addRowToBodyMap("id", tabExpected.getId());
        }

        app.setCheck("Send request");
        //Send request and get response
        BaseModel tabInFact = app.getDocumentAPI().documentTabSimpleOperation(
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
