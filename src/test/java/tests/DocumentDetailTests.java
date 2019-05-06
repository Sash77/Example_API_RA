package tests;

import appmanager.TestBase;
import appmanager.TestListener;
import dataprovider.DataProviderDocument;
import io.qameta.allure.Description;
import model.BaseModel;
import model.exception.ExceptionModel;
import model.exception.ExceptionSimpleSchemaModel;
import model.regular.RegularRawSchemaModel;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import java.io.IOException;

import static io.qameta.allure.Allure.step;
import static org.testng.Assert.assertEquals;

@Listeners(TestListener.class)
public class DocumentDetailTests extends TestBase {

    @Description("Document detail method positive")
    @Test(dataProvider = "validDocumentDetailPositive", dataProviderClass = DataProviderDocument.class, alwaysRun = true)
    public void testDetailPositive(RegularRawSchemaModel detailExpected) throws IOException, IllegalAccessException, InstantiationException, ClassNotFoundException {
        step(String.format("Test case: %s", detailExpected.getTestCase()));

        app.setCheck("Clear variables");
        app.getDocumentAPI().clearVariables();

        app.setCheck("Send request");
        //Send request and get response

        if (!detailExpected.getId().equals("")) {
            detailExpected.addRowToBodyMap("id", detailExpected.getId());
        }


        BaseModel detailInFact = app.getDocumentAPI().documentDetailOperation(
                app.getDocumentAPI().returnHeaderParams(detailExpected),
                app.getDocumentAPI().getBodyInHashMap(detailExpected.getBodyMap()));


        app.setCheck("Assert fact");
        //Assert result
        logTrace("Assert:" + detailInFact + "\r\n" + detailExpected);
        //we need this to see every test case in Allure report
        detailInFact.setTestCase(detailExpected.getTestCase());
        detailInFact.processResponce();

        assertEquals(detailInFact, detailExpected);

    }

    @Description("Document detail method negative")
    @Test(dataProvider = "validDocumentDetailNegative", dataProviderClass = DataProviderDocument.class, alwaysRun = false, enabled = false)
    public void testDetailNegative(ExceptionSimpleSchemaModel detailExpected) throws IOException, IllegalAccessException, InstantiationException, ClassNotFoundException {

        step(String.format("Test case: %s", detailExpected.getTestCase()));

        app.setCheck("Clear variables");
        app.getDocumentAPI().clearVariables();

        if (!detailExpected.getId().equals("")) {
            detailExpected.addRowToBodyMap("id", detailExpected.getId());
        }

        app.setCheck("Send request");
        //Send request and get response
        BaseModel detailInFact = app.getDocumentAPI().documentDetailOperation(
                app.getDocumentAPI().returnHeaderParams(detailExpected),
                app.getDocumentAPI().getBodyInHashMap(detailExpected.getBodyMap()));


        app.setCheck("Assert fact");
        //Assert result
        logTrace("Assert:" + detailInFact + "\r\n" + detailExpected);
        //we need this to see every test case in Allure report
        detailInFact.setTestCase(detailExpected.getTestCase());

        assertEquals(detailInFact, detailExpected);

    }

}
