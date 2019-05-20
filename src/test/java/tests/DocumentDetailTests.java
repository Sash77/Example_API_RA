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
public class DocumentDetailTests extends TestBase {

    @Description("Document detail positive")
    @Test(dataProvider = "validDocHeaderPositive", dataProviderClass = DataProviderDocument.class, alwaysRun = true)
    public void testDocumentDetailHeaderPositive(EntityRequest dataProvider) throws ClassNotFoundException, InstantiationException, IllegalAccessException, IOException {

        step(String.format("Test case: %s", dataProvider.getTestCase()));
        app.setCheck("Send request");
        assertEquals(app.getHelperHTTPRequest().sendHeadersPost(dataProvider, EndPoints.documentDetail), dataProvider.getCode());
    }

    @Description("Document detail negative")
    @Test(dataProvider = "validDocHeaderNegative", dataProviderClass = DataProviderDocument.class, alwaysRun = true)
    public void testDocumentDetailHeaderNegative(EntityRequest dataProvider) throws ClassNotFoundException, InstantiationException, IllegalAccessException, IOException {

        step(String.format("Test case: %s", dataProvider.getTestCase()));
        app.setCheck("Send request");
        assertEquals(app.getHelperHTTPRequest().sendHeadersPost(dataProvider, EndPoints.documentDetail), dataProvider.getCode());
    }

    @Description("Document detail json schema validation")
    @Test(dataProvider = "validDocJsonSchema", dataProviderClass = DataProviderDocument.class, alwaysRun = true)
    public void testDocumentDetailJsonSchema(EntityRequest dataProvider) {

        step(String.format("Test case: %s", dataProvider.getTestCase()));

        given().
                spec(app.getSpecificationRequest().getRequestRegular()).
                when().
                post(EndPoints.documentDetail).
                then().
                assertThat().
                body(matchesJsonSchemaInClasspath("schemaRawSchema.json"));

    }

    @Description("Document detail well formed negative")
    @Test(dataProvider = "validDocWellFormedNegative", dataProviderClass = DataProviderDocument.class, alwaysRun = true)
    public void testDocumentDetailWellFormedNegative(EntityRequest dataProvider) {

        step(String.format("Test case: %s", dataProvider.getTestCase()));

        given().
                spec(app.getSpecificationRequest().getRequestRegular()).
                when().
                post(EndPoints.documentDetail).
                then().
                assertThat().
                statusCode(dataProvider.getCode());

    }

    @Description("Document detail body positive")
    @Test(dataProvider = "validDocBodyPositive", dataProviderClass = DataProviderDocument.class, alwaysRun = true)
    public void testDocumentDetailBodyPositive(EntityRequest dataProvider) {

        step(String.format("Test case: %s", dataProvider.getTestCase()));

        given().
                spec(app.getSpecificationRequest().getRequestRegular()).
                body(app.getHelperHTTPRequest().getBodyInHashMap(dataProvider.getBody())).
                when().
                post(EndPoints.documentDetail).
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

    @Description("Document detail body negative")
    @Test(dataProvider = "validDocBodyNegative", dataProviderClass = DataProviderDocument.class, alwaysRun = true)
    public void testDocumentDetailBodyNegative(EntityRequest dataProvider) {

        step(String.format("Test case: %s", dataProvider.getTestCase()));

        given().
                spec(app.getSpecificationRequest().getRequestRegular()).
                body(app.getHelperHTTPRequest().getBodyInHashMap(dataProvider.getBody())).
                when().
                post(EndPoints.documentDetail).
                then().
                assertThat().
                statusCode(dataProvider.getCode()).
                and().
                body("id", emptyOrNullString());

    }

}
