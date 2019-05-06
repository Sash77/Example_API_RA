package tests;

import appmanager.TestBase;
import appmanager.TestListener;
import dataprovider.DataProviderDocument;
import io.qameta.allure.Description;
import model.BaseModel;
import model.exception.ExceptionModel;
import model.exception.ExceptionSimpleSchemaModel;
import model.regular.RegularSimpleSchemaModel;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import java.io.IOException;

import static io.qameta.allure.Allure.step;
import static org.testng.Assert.assertEquals;

@Listeners(TestListener.class)
public class DocumentDetailSimpleTests extends TestBase {

    @Description("Document detail simple method positive")
    @Test(dataProvider = "validDocumentDetailSimplePositive", dataProviderClass = DataProviderDocument.class, alwaysRun = true)
    public void testDetailSimplePositive(RegularSimpleSchemaModel detailSimpleExpected) throws IOException, IllegalAccessException, InstantiationException, ClassNotFoundException {
        step(String.format("Test case: %s", detailSimpleExpected.getTestCase()));

        app.setCheck("Clear variables");
        app.getDocumentAPI().clearVariables();

        app.setCheck("Send request");
        //Send request and get response

        if (!detailSimpleExpected.getId().equals("")) {
            detailSimpleExpected.addRowToBodyMap("id", detailSimpleExpected.getId());
        }

        BaseModel detailSimpleInFact = app.getDocumentAPI().documentDetailSimpleOperation(
                app.getDocumentAPI().returnHeaderParams(detailSimpleExpected),
                app.getDocumentAPI().getBodyInHashMap(detailSimpleExpected.getBodyMap()));


        app.setCheck("Assert fact");
        //Assert result
        logTrace("Assert:" + detailSimpleInFact + "\r\n" + detailSimpleExpected);
        //we need this to see every test case in Allure report
        detailSimpleInFact.setTestCase(detailSimpleExpected.getTestCase());
        detailSimpleInFact.processResponce();

        assertEquals(detailSimpleInFact, detailSimpleExpected);

    }

    @Description("Document detail simple method negative")
    @Test(dataProvider = "validDocumentDetailSimpleNegative", dataProviderClass = DataProviderDocument.class, alwaysRun = true)
    public void testDetailSimpleNegative(ExceptionSimpleSchemaModel detailSimpleExpected) throws IOException, IllegalAccessException, InstantiationException, ClassNotFoundException {

        step(String.format("Test case: %s", detailSimpleExpected.getTestCase()));

        app.setCheck("Clear variables");
        app.getDocumentAPI().clearVariables();

        if (!detailSimpleExpected.getId().equals("")) {
            detailSimpleExpected.addRowToBodyMap("id", detailSimpleExpected.getId());
        }

        app.setCheck("Send request");
        //Send request and get response
        BaseModel detailSimpleInFact = app.getDocumentAPI().documentDetailSimpleOperation(
                app.getDocumentAPI().returnHeaderParams(detailSimpleExpected),
                app.getDocumentAPI().getBodyInHashMap(detailSimpleExpected.getBodyMap()));


        app.setCheck("Assert fact");
        //Assert result
        logTrace("Assert:" + detailSimpleInFact + "\r\n" + detailSimpleExpected);
        //we need this to see every test case in Allure report
        detailSimpleInFact.setTestCase(detailSimpleExpected.getTestCase());

        assertEquals(detailSimpleInFact, detailSimpleExpected);

    }

}
