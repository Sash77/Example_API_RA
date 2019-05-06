package tests;

import api.EndPoints;
import appmanager.TestBase;
import appmanager.TestListener;
import dataprovider.DataProviderDocument;
import io.qameta.allure.Description;
import model.BaseModel;
import model.exception.ExceptionRawRecordModel;
import model.exception.ExceptionWorklistSelectionModel;
import model.regular.RegularRawRecordModel;
import model.regular.RegularWorklistSelectionModel;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import java.io.IOException;

import static io.qameta.allure.Allure.step;
import static org.testng.Assert.assertEquals;

@Listeners(TestListener.class)
public class WorklistSelectionTests extends TestBase {

    @Description("Worklist selection method positive")
    @Test(dataProvider = "validWorklistSelectionPositive", dataProviderClass = DataProviderDocument.class, alwaysRun = true)
    public void testWorklistSelectionPositive(RegularWorklistSelectionModel listExpected) throws IOException, IllegalAccessException, InstantiationException, ClassNotFoundException {
        step(String.format("Test case: %s", listExpected.getTestCase()));

        app.setCheck("Clear variables");
        app.getDocumentAPI().clearVariables();

        app.setCheck("Send request");
        //Send request and get response

        BaseModel listInFact = app.getDocumentAPI().worklistSelectionOperation(
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

    @Description("Worklist selection method negative")
    @Test(dataProvider = "validWorklistSelectionNegative", dataProviderClass = DataProviderDocument.class, alwaysRun = false, enabled = false)
    public void testWorklistSelectionNegative(ExceptionWorklistSelectionModel listExpected) throws IOException, IllegalAccessException, InstantiationException, ClassNotFoundException {

        step(String.format("Test case: %s", listExpected.getTestCase()));

        app.setCheck("Clear variables");
        app.getDocumentAPI().clearVariables();

        app.setCheck("Send request");
        //Send request and get response
        BaseModel listInFact = app.getDocumentAPI().worklistSelectionOperation(
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
