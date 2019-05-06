package tests;

import appmanager.TestBase;
import appmanager.TestListener;
import dataprovider.DataProviderDocument;
import io.qameta.allure.Description;
import model.BaseModel;
import model.exception.ExceptionModel;
import model.exception.ExceptionSimpleEntityModel;
import model.regular.RegularSimpleEntityModel;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import java.io.IOException;

import static io.qameta.allure.Allure.step;
import static org.testng.Assert.assertEquals;

@Listeners(TestListener.class)
public class DocumentHeaderSimpleTests extends TestBase {

    @Description("Document simple method positive")
    @Test(dataProvider = "validDocumentHeaderSimplePositive", dataProviderClass = DataProviderDocument.class, alwaysRun = true)
    public void testHeaderSimplePositive(RegularSimpleEntityModel detailHeadSimpleExpected) throws IOException, IllegalAccessException, InstantiationException, ClassNotFoundException {
        step(String.format("Test case: %s", detailHeadSimpleExpected.getTestCase()));

        app.setCheck("Clear variables");
        app.getDocumentAPI().clearVariables();

        app.setCheck("Send request");
        //Send request and get response

        if (!detailHeadSimpleExpected.getId().equals("")) {
            detailHeadSimpleExpected.addRowToBodyMap("id", detailHeadSimpleExpected.getId());
        }

        BaseModel detailHeadSimpleInFact = app.getDocumentAPI().documentHeaderSimpleOperation(
                app.getDocumentAPI().returnHeaderParams(detailHeadSimpleExpected),
                app.getDocumentAPI().getBodyInHashMap(detailHeadSimpleExpected.getBodyMap()));


        app.setCheck("Assert fact");
        //Assert result
        logTrace("Assert:" + detailHeadSimpleInFact + "\r\n" + detailHeadSimpleExpected);
        //we need this to see every test case in Allure report
        detailHeadSimpleInFact.setTestCase(detailHeadSimpleExpected.getTestCase());
        detailHeadSimpleInFact.processResponce();

        assertEquals(detailHeadSimpleInFact, detailHeadSimpleExpected);

    }

    @Description("Document head simple method negative")
    @Test(dataProvider = "validDocumentHeaderSimpleNegative", dataProviderClass = DataProviderDocument.class, alwaysRun = false, enabled = false)
    public void testHeaderSimpleNegative(ExceptionSimpleEntityModel detailHeadSimpleExpected) throws IOException, IllegalAccessException, InstantiationException, ClassNotFoundException {

        step(String.format("Test case: %s", detailHeadSimpleExpected.getTestCase()));

        app.setCheck("Clear variables");
        app.getDocumentAPI().clearVariables();

        if (!detailHeadSimpleExpected.getId().equals("")) {
            detailHeadSimpleExpected.addRowToBodyMap("id", detailHeadSimpleExpected.getId());
        }

        app.setCheck("Send request");
        //Send request and get response
        BaseModel detailHeadSimpleInFact = app.getDocumentAPI().documentHeaderSimpleOperation(
                app.getDocumentAPI().returnHeaderParams(detailHeadSimpleExpected),
                app.getDocumentAPI().getBodyInHashMap(detailHeadSimpleExpected.getBodyMap()));


        app.setCheck("Assert fact");
        //Assert result
        logTrace("Assert:" + detailHeadSimpleInFact + "\r\n" + detailHeadSimpleExpected);
        //we need this to see every test case in Allure report
        detailHeadSimpleInFact.setTestCase(detailHeadSimpleExpected.getTestCase());

        assertEquals(detailHeadSimpleInFact, detailHeadSimpleExpected);

    }

}
