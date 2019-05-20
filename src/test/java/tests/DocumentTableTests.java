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
public class DocumentTableTests extends TestBase {

    @Description("Document table positive")
    @Test(dataProvider = "validDocHeaderPositive", dataProviderClass = DataProviderDocument.class, alwaysRun = true)
    public void testDocumentTableHeaderPositive(EntityRequest dataProvider) throws ClassNotFoundException, InstantiationException, IllegalAccessException, IOException {

        step(String.format("Test case: %s", dataProvider.getTestCase()));
        app.setCheck("Send request");
        assertEquals(app.getHelperHTTPRequest().sendHeadersPost(dataProvider, EndPoints.documentTable), dataProvider.getCode());
    }

    @Description("Document table negative")
    @Test(dataProvider = "validDocHeaderNegative", dataProviderClass = DataProviderDocument.class, alwaysRun = true)
    public void testDocumentTableHeaderNegative(EntityRequest dataProvider) throws ClassNotFoundException, InstantiationException, IllegalAccessException, IOException {

        step(String.format("Test case: %s", dataProvider.getTestCase()));
        app.setCheck("Send request");
        assertEquals(app.getHelperHTTPRequest().sendHeadersPost(dataProvider, EndPoints.documentTable), dataProvider.getCode());
    }

    @Description("Document table json schema validation")
    @Test(dataProvider = "validDocJsonSchema", dataProviderClass = DataProviderDocument.class, alwaysRun = true)
    public void testDocumentTableJsonSchema(EntityRequest dataProvider) {

        step(String.format("Test case: %s", dataProvider.getTestCase()));

        given().
                spec(app.getSpecificationRequest().getRequestRegular()).
                when().
                post(EndPoints.documentTable).
                then().
                assertThat().
                body(matchesJsonSchemaInClasspath("schemaRawEntity.json"));
    }

    @Description("Document table well formed negative")
    @Test(dataProvider = "validDocWellFormedNegative", dataProviderClass = DataProviderDocument.class, alwaysRun = true)
    public void testDocumentTableWellFormedNegative(EntityRequest dataProvider) {

        step(String.format("Test case: %s", dataProvider.getTestCase()));

        given().
                spec(app.getSpecificationRequest().getRequestRegular()).
                when().
                post(EndPoints.documentTable).
                then().
                assertThat().
                statusCode(dataProvider.getCode());

    }

    @Description("Document table body positive")
    @Test(dataProvider = "validDocBodyPositive", dataProviderClass = DataProviderDocument.class, alwaysRun = true)
    public void testDocumentTableBodyPositive(EntityRequest dataProvider) {

        step(String.format("Test case: %s", dataProvider.getTestCase()));

        given().
                spec(app.getSpecificationRequest().getRequestRegular()).
                body(app.getHelperHTTPRequest().getBodyInHashMap(dataProvider.getBody())).
                when().
                post(EndPoints.documentTable).
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

    @Description("Document table body negative")
    @Test(dataProvider = "validDocBodyNegative", dataProviderClass = DataProviderDocument.class, alwaysRun = true)
    public void testDocumentTableBodyNegative(EntityRequest dataProvider) {

        step(String.format("Test case: %s", dataProvider.getTestCase()));

        given().
                spec(app.getSpecificationRequest().getRequestRegular()).
                body(app.getHelperHTTPRequest().getBodyInHashMap(dataProvider.getBody())).
                when().
                post(EndPoints.documentTable).
                then().
                assertThat().
                statusCode(dataProvider.getCode()).
                and().
                body("id", emptyOrNullString());

    }

}
