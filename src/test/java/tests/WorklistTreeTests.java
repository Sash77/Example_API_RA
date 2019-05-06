package tests;

import api.EndPoints;
import appmanager.TestBase;
import appmanager.TestListener;
import dataprovider.DataProviderDocument;
import io.qameta.allure.Description;
import model.BaseModel;
import model.exception.ExceptionNodeModel;
import model.regular.RegularNodeModel;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import java.io.IOException;

import static io.qameta.allure.Allure.step;
import static org.testng.Assert.assertEquals;

@Listeners(TestListener.class)
public class WorklistTreeTests extends TestBase {

    @Description("Worklist tree post method positive")
    @Test(dataProvider = "validWorklistTreePositive", dataProviderClass = DataProviderDocument.class, alwaysRun = true)
    public void testWorklistTreePostPositive(RegularNodeModel nodeExpected) throws IOException, IllegalAccessException, InstantiationException, ClassNotFoundException {
        step(String.format("Test case: %s", nodeExpected.getTestCase()));

        app.setCheck("Clear variables");
        app.getDocumentAPI().clearVariables();

        app.setCheck("Send request");
        //Send request and get response

        BaseModel nodeInFact = app.getDocumentAPI().worklistTreePostOperation(
                app.getDocumentAPI().returnHeaderParams(nodeExpected),
                app.getDocumentAPI().getBodyInHashMap(nodeExpected.getBodyMap()));


        app.setCheck("Assert fact");
        //Assert result
        logTrace("Assert:" + nodeInFact + "\r\n" + nodeExpected);
        //we need this to see every test case in Allure report
        nodeInFact.setTestCase(nodeExpected.getTestCase());
        nodeInFact.processResponce();

        assertEquals(nodeInFact, nodeExpected);

    }

    @Description("Worklist tree post method negative")
    @Test(dataProvider = "validWorklistTreeNegative", dataProviderClass = DataProviderDocument.class, alwaysRun = false, enabled = false)
    public void testWorklistTreePostNegative(ExceptionNodeModel nodeExpected) throws IOException, IllegalAccessException, InstantiationException, ClassNotFoundException {

        step(String.format("Test case: %s", nodeExpected.getTestCase()));

        app.setCheck("Clear variables");
        app.getDocumentAPI().clearVariables();

        app.setCheck("Send request");
        //Send request and get response
        BaseModel nodeInFact = app.getDocumentAPI().worklistTreePostOperation(
                app.getDocumentAPI().returnHeaderParams(nodeExpected),
                app.getDocumentAPI().getBodyInHashMap(nodeExpected.getBodyMap()));


        app.setCheck("Assert fact");
        //Assert result
        logTrace("Assert:" + nodeInFact + "\r\n" + nodeExpected);
        //we need this to see every test case in Allure report
        nodeInFact.setTestCase(nodeExpected.getTestCase());

        assertEquals(nodeInFact, nodeExpected);

    }

    @Description("Worklist tree get method positive")
    @Test(dataProvider = "validWorklistTreeGetPositive", dataProviderClass = DataProviderDocument.class, alwaysRun = true)
    public void testWorklistTreeGetPositive(RegularNodeModel nodeExpected) throws IOException, IllegalAccessException, InstantiationException, ClassNotFoundException {
        step(String.format("Test case: %s", nodeExpected.getTestCase()));

        app.setCheck("Clear variables");
        app.getDocumentAPI().clearVariables();

        app.setCheck("Send request");
        //Send request and get response

        BaseModel nodeInFact = app.getDocumentAPI().worklistTreeGetOperation(
                app.getDocumentAPI().returnHeaderParams(nodeExpected),
                app.getDocumentAPI().getBodyInHashMap(nodeExpected.getBodyMap()));


        app.setCheck("Assert fact");
        //Assert result
        logTrace("Assert:" + nodeInFact + "\r\n" + nodeExpected);
        //we need this to see every test case in Allure report
        nodeInFact.setTestCase(nodeExpected.getTestCase());
        nodeInFact.processResponce();

        assertEquals(nodeInFact, nodeExpected);

    }

    @Description("Worklist tree get method negative")
    @Test(dataProvider = "validWorklistTreeGetNegative", dataProviderClass = DataProviderDocument.class, alwaysRun = false, enabled = false)
    public void testWorklistTreeGetNegative(ExceptionNodeModel nodeExpected) throws IOException, IllegalAccessException, InstantiationException, ClassNotFoundException {

        step(String.format("Test case: %s", nodeExpected.getTestCase()));

        app.setCheck("Clear variables");
        app.getDocumentAPI().clearVariables();

        app.setCheck("Send request");
        //Send request and get response
        BaseModel nodeInFact = app.getDocumentAPI().worklistTreeGetOperation(
                app.getDocumentAPI().returnHeaderParams(nodeExpected),
                app.getDocumentAPI().getBodyInHashMap(nodeExpected.getBodyMap()));


        app.setCheck("Assert fact");
        //Assert result
        logTrace("Assert:" + nodeInFact + "\r\n" + nodeExpected);
        //we need this to see every test case in Allure report
        nodeInFact.setTestCase(nodeExpected.getTestCase());

        assertEquals(nodeInFact, nodeExpected);

    }

}
