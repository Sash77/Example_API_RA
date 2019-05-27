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
public class OverviewListFullTests extends TestBase {

    @Description("Overview list full positive")
    @Test(dataProvider = "validHeaderPositive", dataProviderClass = DataProviderDocument.class, alwaysRun = true)
    public void testOverviewListFullHeaderPositive(EntityRequest dataProvider) throws ClassNotFoundException, InstantiationException, IllegalAccessException, IOException {

        step(String.format("Test case: %s", dataProvider.getTestCase()));
        app.setCheck("Send request");
        assertEquals(app.getHelperHTTPRequest().sendHeadersPost(dataProvider, EndPoints.overViewListFull), dataProvider.getCode());
    }

    @Description("Overview list full negative")
    @Test(dataProvider = "validHeaderNegative", dataProviderClass = DataProviderDocument.class, alwaysRun = true)
    public void testOverviewListFullHeaderNegative(EntityRequest dataProvider) throws ClassNotFoundException, InstantiationException, IllegalAccessException, IOException {

        step(String.format("Test case: %s", dataProvider.getTestCase()));
        app.setCheck("Send request");
        assertEquals(app.getHelperHTTPRequest().sendHeadersPost(dataProvider, EndPoints.overViewListFull), dataProvider.getCode());
    }

    @Description("Overview list full json schema validation")
    @Test(dataProvider = "validOverviewJsonSchema", dataProviderClass = DataProviderDocument.class, alwaysRun = true)
    public void testOverviewListFullJsonSchema(EntityRequest dataProvider) {

        step(String.format("Test case: %s", dataProvider.getTestCase()));

        given().
                spec(app.getSpecificationRequest().getRequestRegular()).
                body(app.getHelperHTTPRequest().getBodyInHashMap(dataProvider.getBody())).
                when().
                post(EndPoints.overViewListFull).
                then().
                assertThat().
                body(matchesJsonSchemaInClasspath("schemaRawSchema.json"));

    }

    @Description("Overview list full well formed negative")
    @Test(dataProvider = "validOverviewWellFormedNegative", dataProviderClass = DataProviderDocument.class, alwaysRun = true)
    public void testOverviewListFullWellFormedNegative(EntityRequest dataProvider) {

        step(String.format("Test case: %s", dataProvider.getTestCase()));

        given().
                spec(app.getSpecificationRequest().getRequestRegular()).
                body(String.format(dataProvider.getWellFormed(), app.getDocID())).
                when().
                post(EndPoints.overViewListFull).
                then().
                assertThat().
                statusCode(dataProvider.getCode());

    }

    @Description("Overview list full body positive")
    @Test(dataProvider = "validOverviewBodyPositive", dataProviderClass = DataProviderDocument.class, alwaysRun = true)
    public void testOverviewListFullBodyPositive(EntityRequest dataProvider) {

        step(String.format("Test case: %s", dataProvider.getTestCase()));

        given().
                spec(app.getSpecificationRequest().getRequestRegular()).
                body(app.getHelperHTTPRequest().getBodyInHashMap(dataProvider.getBody())).
                when().
                post(EndPoints.overViewListFull).
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

    @Description("Overview list full body negative")
    @Test(dataProvider = "validOverviewBodyNegative", dataProviderClass = DataProviderDocument.class, alwaysRun = true)
    public void testOverviewListFullBodyNegative(EntityRequest dataProvider) {

        step(String.format("Test case: %s", dataProvider.getTestCase()));

        given().
                spec(app.getSpecificationRequest().getRequestRegular()).
                body(app.getHelperHTTPRequest().getBodyInHashMap(dataProvider.getBody())).
                when().
                post(EndPoints.overViewListFull).
                then().
                assertThat().
                statusCode(dataProvider.getCode()).
                and().
                body("id", emptyOrNullString());

    }

    @Description("Overview list full null test")
    @Test(dataProvider = "validNullOverview", dataProviderClass = DataProviderDocument.class, alwaysRun = true)
    public void testOverviewListFullNullInBody(EntityRequest dataProvider) throws ClassNotFoundException, InstantiationException, IllegalAccessException, IOException {

        step(String.format("Test case: %s", dataProvider.getTestCase()));
        app.setCheck("Send request");
        assertEquals(app.getHelperHTTPRequest().sendNullInBodyPost(dataProvider, EndPoints.overViewListFull), dataProvider.getCode());
    }

}
