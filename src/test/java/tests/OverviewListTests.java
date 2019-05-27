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
import static org.hamcrest.Matchers.*;
import static org.testng.Assert.assertEquals;

@Listeners(TestListener.class)
public class OverviewListTests extends TestBase {

    @Description("Overview list positive")
    @Test(dataProvider = "validHeaderPositive", dataProviderClass = DataProviderDocument.class, alwaysRun = true)
    public void testOverviewListHeaderPositive(EntityRequest dataProvider) throws ClassNotFoundException, InstantiationException, IllegalAccessException, IOException {

        step(String.format("Test case: %s", dataProvider.getTestCase()));
        app.setCheck("Send request");
        assertEquals(app.getHelperHTTPRequest().sendHeadersPost(dataProvider, EndPoints.overViewList), dataProvider.getCode());
    }

    @Description("Overview list negative")
    @Test(dataProvider = "validHeaderNegative", dataProviderClass = DataProviderDocument.class, alwaysRun = true)
    public void testOverviewListHeaderNegative(EntityRequest dataProvider) throws ClassNotFoundException, InstantiationException, IllegalAccessException, IOException {

        step(String.format("Test case: %s", dataProvider.getTestCase()));
        app.setCheck("Send request");
        assertEquals(app.getHelperHTTPRequest().sendHeadersPost(dataProvider, EndPoints.overViewList), dataProvider.getCode());
    }

    @Description("Overview list json schema validation")
    @Test(dataProvider = "validOverviewJsonSchema", dataProviderClass = DataProviderDocument.class, alwaysRun = true)
    public void testOverviewListJsonSchema(EntityRequest dataProvider) {

        step(String.format("Test case: %s", dataProvider.getTestCase()));

        given().
                spec(app.getSpecificationRequest().getRequestRegular()).
                body(app.getHelperHTTPRequest().getBodyInHashMap(dataProvider.getBody())).
                when().
                post(EndPoints.overViewList).
                then().
                assertThat().
                body(matchesJsonSchemaInClasspath("schemaRawSchema.json"));

    }

    @Description("Overview list well formed negative")
    @Test(dataProvider = "validOverviewWellFormedNegative", dataProviderClass = DataProviderDocument.class, alwaysRun = true)
    public void testOverviewListWellFormedNegative(EntityRequest dataProvider) {

        step(String.format("Test case: %s", dataProvider.getTestCase()));

        given().
                spec(app.getSpecificationRequest().getRequestRegular()).
                body(String.format(dataProvider.getWellFormed(), app.getDocID())).
                when().
                post(EndPoints.overViewList).
                then().
                assertThat().
                statusCode(dataProvider.getCode());

    }

    @Description("Overview list body positive")
    @Test(dataProvider = "validOverviewBodyPositive", dataProviderClass = DataProviderDocument.class, alwaysRun = true)
    public void testOverviewListBodyPositive(EntityRequest dataProvider) {

        step(String.format("Test case: %s", dataProvider.getTestCase()));

        given().
                spec(app.getSpecificationRequest().getRequestRegular()).
                body(app.getHelperHTTPRequest().getBodyInHashMap(dataProvider.getBody())).
                when().
                post(EndPoints.overViewList).
                then().
                assertThat().
                spec(app.getSpecificationResponse().getResponseRegular()).
                and().
                body("messages", not(hasEntry("type", "ERROR"))).
                and().
                body("id", equalTo(String.format("%s", app.getDocID()))).
                and().
                body("type", is(in(app.getHelperHTTPRequest().getSchemaTypeList()))).
                and().
                body("documentType", not(emptyOrNullString()));

    }

    @Description("Overview list body negative")
    @Test(dataProvider = "validOverviewBodyNegative", dataProviderClass = DataProviderDocument.class, alwaysRun = true)
    public void testOverviewListBodyNegative(EntityRequest dataProvider) {

        step(String.format("Test case: %s", dataProvider.getTestCase()));

        given().
                spec(app.getSpecificationRequest().getRequestRegular()).
                body(app.getHelperHTTPRequest().getBodyInHashMap(dataProvider.getBody())).
                when().
                post(EndPoints.overViewList).
                then().
                assertThat().
                statusCode(dataProvider.getCode()).
                and().
                body("id", emptyOrNullString());

    }

    @Description("Overview list null test")
    @Test(dataProvider = "validNullOverview", dataProviderClass = DataProviderDocument.class, alwaysRun = true)
    public void testOverviewListNullInBody(EntityRequest dataProvider) throws ClassNotFoundException, InstantiationException, IllegalAccessException, IOException {

        step(String.format("Test case: %s", dataProvider.getTestCase()));
        app.setCheck("Send request");
        assertEquals(app.getHelperHTTPRequest().sendNullInBodyPost(dataProvider, EndPoints.overViewList), dataProvider.getCode());
    }

}
