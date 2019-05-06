package tests;

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
public class DocumentLineTests extends TestBase {

    @Description("Document line method positive")
    @Test(dataProvider = "validDocumentLinePositive", dataProviderClass = DataProviderDocument.class, alwaysRun = true)
    public void testLinePositive(RegularRawRecordModel lineExpected) throws IOException, IllegalAccessException, InstantiationException, ClassNotFoundException {
        step(String.format("Test case: %s", lineExpected.getTestCase()));

        app.setCheck("Clear variables");
        app.getDocumentAPI().clearVariables();

        app.setCheck("Send request");
        //Send request and get response

        if (!lineExpected.getId().equals("")) {
            lineExpected.addRowToBodyMap("id", lineExpected.getId());
        }


        BaseModel lineInFact = app.getDocumentAPI().documentLineOperation(
                app.getDocumentAPI().returnHeaderParams(lineExpected),
                app.getDocumentAPI().getBodyInHashMap(lineExpected.getBodyMap()));


        app.setCheck("Assert fact");
        //Assert result
        logTrace("Assert:" + lineInFact + "\r\n" + lineExpected);
        //we need this to see every test case in Allure report
        lineInFact.setTestCase(lineExpected.getTestCase());
        lineInFact.processResponce();

        assertEquals(lineInFact, lineExpected);

    }

    @Description("Document line method negative")
    @Test(dataProvider = "validDocumentLineNegative", dataProviderClass = DataProviderDocument.class, alwaysRun = false, enabled = false)
    public void testLineNegative(ExceptionRawRecordModel lineExpected) throws IOException, IllegalAccessException, InstantiationException, ClassNotFoundException {

        step(String.format("Test case: %s", lineExpected.getTestCase()));

        app.setCheck("Clear variables");
        app.getDocumentAPI().clearVariables();

        if (!lineExpected.getId().equals("")) {
            lineExpected.addRowToBodyMap("id", lineExpected.getId());
        }

        app.setCheck("Send request");
        //Send request and get response
        BaseModel lineInFact = app.getDocumentAPI().documentLineOperation(
                app.getDocumentAPI().returnHeaderParams(lineExpected),
                app.getDocumentAPI().getBodyInHashMap(lineExpected.getBodyMap()));


        app.setCheck("Assert fact");
        //Assert result
        logTrace("Assert:" + lineInFact + "\r\n" + lineExpected);
        //we need this to see every test case in Allure report
        lineInFact.setTestCase(lineExpected.getTestCase());

        assertEquals(lineInFact, lineExpected);

    }

}
