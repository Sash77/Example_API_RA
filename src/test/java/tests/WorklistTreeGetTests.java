package tests;

import api.EndPoints;
import appmanager.TestBase;
import appmanager.TestListener;
import dataprovider.DataProviderDocument;
import io.qameta.allure.Description;
import model.entity.EntityRequest;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import java.io.IOException;

import static io.qameta.allure.Allure.step;
import static io.restassured.RestAssured.given;
import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;
import static org.testng.Assert.assertEquals;

@Listeners(TestListener.class)
public class WorklistTreeGetTests extends TestBase {

    @Description("Worklist tree positive")
    @Test(dataProvider = "validHeaderPositive", dataProviderClass = DataProviderDocument.class, alwaysRun = true)
    public void testWorklistTreeHeaderPositive(EntityRequest dataProvider) throws ClassNotFoundException, InstantiationException, IllegalAccessException, IOException {

        step(String.format("Test case: %s", dataProvider.getTestCase()));
        app.setCheck("Send request");
        assertEquals(app.getHelperHTTPRequest().sendHeadersGet(dataProvider, EndPoints.workListTree), dataProvider.getCode());
    }

    @Description("Worklist tree negative")
    @Test(dataProvider = "validHeaderNegative", dataProviderClass = DataProviderDocument.class, alwaysRun = true)
    public void testWorklistTreeHeaderNegative(EntityRequest dataProvider) throws ClassNotFoundException, InstantiationException, IllegalAccessException, IOException {

        step(String.format("Test case: %s", dataProvider.getTestCase()));
        app.setCheck("Send request");
        assertEquals(app.getHelperHTTPRequest().sendHeadersGet(dataProvider, EndPoints.workListTree), dataProvider.getCode());
    }

    @Description("Worklist tree json schema validation")
    @Test(dataProvider = "validWorklistTreeJsonSchema", dataProviderClass = DataProviderDocument.class, alwaysRun = true)
    public void testWorklistTreeJsonSchema(EntityRequest dataProvider) {

        step(String.format("Test case: %s", dataProvider.getTestCase()));

        given().
                spec(app.getSpecificationRequest().getRequestRegular()).
                when().
                get(EndPoints.workListTree).
                then().
                assertThat().
                body(matchesJsonSchemaInClasspath("schemaNode.json"));//waiting for Rene

    }
}
