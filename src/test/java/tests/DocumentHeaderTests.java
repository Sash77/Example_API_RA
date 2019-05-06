package tests;

import api.EndPoints;
import appmanager.TestBase;
import appmanager.TestListener;
import dataprovider.DataProviderDocument;
import io.qameta.allure.Description;
import model.BaseModel;
import model.exception.ExceptionRawEntityModel;
import model.regular.RegularRawEntityModel;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import java.io.IOException;

import static io.qameta.allure.Allure.step;
import static org.testng.Assert.assertEquals;

@Listeners(TestListener.class)
public class DocumentHeaderTests extends TestBase {

    @Description("Document header method positive")
    @Test(dataProvider = "validDocumentHeaderPositive", dataProviderClass = DataProviderDocument.class, alwaysRun = true)
    public void testHeaderPositive(RegularRawEntityModel headerExpected) throws IOException, IllegalAccessException, InstantiationException, ClassNotFoundException {
        step(String.format("Test case: %s", headerExpected.getTestCase()));

        app.setCheck("Clear variables");
        app.getDocumentAPI().clearVariables();

        app.setCheck("Send request");
        //Send request and get response

        if (!headerExpected.getId().equals("")) {
            headerExpected.addRowToBodyMap("id", headerExpected.getId());
        }


        BaseModel headerInFact = app.getDocumentAPI().documentHeaderOperation(
                app.getDocumentAPI().returnHeaderParams(headerExpected),
                app.getDocumentAPI().getBodyInHashMap(headerExpected.getBodyMap()));


        app.setCheck("Assert fact");
        //Assert result
        logTrace("Assert:" + headerInFact + "\r\n" + headerExpected);
        //we need this to see every test case in Allure report
        headerInFact.setTestCase(headerExpected.getTestCase());
        headerInFact.processResponce();

        assertEquals(headerInFact, headerExpected);

    }

    @Description("Document header method negative")
    @Test(dataProvider = "validDocumentHeaderNegative", dataProviderClass = DataProviderDocument.class, alwaysRun = false, enabled = false)
    public void testHeaderNegative(ExceptionRawEntityModel headerExpected) throws IOException, IllegalAccessException, InstantiationException, ClassNotFoundException {

        step(String.format("Test case: %s", headerExpected.getTestCase()));

        app.setCheck("Clear variables");
        app.getDocumentAPI().clearVariables();

        if (!headerExpected.getId().equals("")) {
            headerExpected.addRowToBodyMap("id", headerExpected.getId());
        }

        app.setCheck("Send request");
        //Send request and get response
        BaseModel headerInFact = app.getDocumentAPI().documentHeaderOperation(
                app.getDocumentAPI().returnHeaderParams(headerExpected),
                app.getDocumentAPI().getBodyInHashMap(headerExpected.getBodyMap()));


        app.setCheck("Assert fact");
        //Assert result
        logTrace("Assert:" + headerInFact + "\r\n" + headerExpected);
        //we need this to see every test case in Allure report
        headerInFact.setTestCase(headerExpected.getTestCase());

        assertEquals(headerInFact, headerExpected);

    }

}
