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
public class DocumentLineSimpleTests extends TestBase {

    @Description("Document line simple positive")
    @Test(dataProvider = "validDocHeaderPositive", dataProviderClass = DataProviderDocument.class, alwaysRun = true)
    public void testDocumentLineSimpleHeaderPositive(EntityRequest dataProvider) throws ClassNotFoundException, InstantiationException, IllegalAccessException, IOException {


        step(String.format("Test case: %s", dataProvider.getTestCase()));
        app.setCheck("Send request");
        assertEquals(app.getHelperHTTPRequest().sendHeadersPost(dataProvider, EndPoints.documentLineSimple), dataProvider.getCode());
    }

    @Description("Document line simple negative")
    @Test(dataProvider = "validDocHeaderNegative", dataProviderClass = DataProviderDocument.class, alwaysRun = true)
    public void testDocumentLineSimpleHeaderNegative(EntityRequest dataProvider) throws ClassNotFoundException, InstantiationException, IllegalAccessException, IOException {


        step(String.format("Test case: %s", dataProvider.getTestCase()));
        app.setCheck("Send request");
        assertEquals(app.getHelperHTTPRequest().sendHeadersPost(dataProvider, EndPoints.documentLineSimple), dataProvider.getCode());
    }

    @Description("Document line simple json schema validation")
    @Test(dataProvider = "validDocJsonSchema", dataProviderClass = DataProviderDocument.class, alwaysRun = true)
    public void testDocumentLineSimpleJsonSchema(EntityRequest dataProvider) {

        step(String.format("Test case: %s", dataProvider.getTestCase()));

        given().
                spec(app.getSpecificationRequest().getRequestRegular()).
                when().
                post(EndPoints.documentLineSimple).
                then().
                assertThat().
                body(matchesJsonSchemaInClasspath("schemaSimpleRecord.json"));

    }

    @Description("Document line simple well formed negative")
    @Test(dataProvider = "validDocWellFormedNegative", dataProviderClass = DataProviderDocument.class, alwaysRun = true)
    public void testDocumentLineSimpleWellFormedNegative(EntityRequest dataProvider) {

        step(String.format("Test case: %s", dataProvider.getTestCase()));

        given().
                spec(app.getSpecificationRequest().getRequestRegular()).
                when().
                post(EndPoints.documentLineSimple).
                then().
                assertThat().
                statusCode(dataProvider.getCode());

    }

    @Description("Document line simple body positive")
    @Test(dataProvider = "validDocBodyPositive", dataProviderClass = DataProviderDocument.class, alwaysRun = true)
    public void testDocumentLineSimpleBodyPositive(EntityRequest dataProvider) {

        step(String.format("Test case: %s", dataProvider.getTestCase()));

        given().
                spec(app.getSpecificationRequest().getRequestRegular()).
                body(app.getHelperHTTPRequest().getBodyInHashMap(dataProvider.getBody())).
                when().
                post(EndPoints.documentLineSimple).
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

    @Description("Document line simple body negative")
    @Test(dataProvider = "validDocBodyNegative", dataProviderClass = DataProviderDocument.class, alwaysRun = true)
    public void testDocumentLineSimpleBodyNegative(EntityRequest dataProvider) {

        step(String.format("Test case: %s", dataProvider.getTestCase()));

        given().
                spec(app.getSpecificationRequest().getRequestRegular()).
                body(app.getHelperHTTPRequest().getBodyInHashMap(dataProvider.getBody())).
                when().
                post(EndPoints.documentLineSimple).
                then().
                assertThat().
                statusCode(dataProvider.getCode()).
                and().
                body("id", emptyOrNullString());

    }

}
