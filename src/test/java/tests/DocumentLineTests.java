package tests;

import api.EndPoints;
import appmanager.TestBase;
import appmanager.TestListener;
import dataprovider.DataProviderDocument;
import io.qameta.allure.Description;
import model.entity.EntityRequest;
import model.enums.SchemaType;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static io.qameta.allure.Allure.step;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;
import static org.hamcrest.Matchers.emptyOrNullString;
import static org.testng.Assert.assertEquals;

@Listeners(TestListener.class)
public class DocumentLineTests extends TestBase {

    @Description("Document line positive")
    @Test(dataProvider = "validDocHeaderPositive", dataProviderClass = DataProviderDocument.class, alwaysRun = true)
    public void testDocumentLineHeaderPositive(EntityRequest dataProvider) throws ClassNotFoundException, InstantiationException, IllegalAccessException, IOException {

        step(String.format("Test case: %s", dataProvider.getTestCase()));
        app.setCheck("Send request");
        assertEquals(app.getHelperHTTPRequest().sendHeadersPost(dataProvider, EndPoints.documentLine), dataProvider.getCode());
    }

    @Description("Document line negative")
    @Test(dataProvider = "validDocHeaderNegative", dataProviderClass = DataProviderDocument.class, alwaysRun = true)
    public void testDocumentLineHeaderNegative(EntityRequest dataProvider) throws ClassNotFoundException, InstantiationException, IllegalAccessException, IOException {

        step(String.format("Test case: %s", dataProvider.getTestCase()));
        app.setCheck("Send request");
        assertEquals(app.getHelperHTTPRequest().sendHeadersPost(dataProvider, EndPoints.documentLine), dataProvider.getCode());
    }

    @Description("Document line well formed negative")
    @Test(dataProvider = "validDocWellFormedNegative", dataProviderClass = DataProviderDocument.class, alwaysRun = true)
    public void testDocumentLineWellFormedNegative(EntityRequest dataProvider) {

        step(String.format("Test case: %s", dataProvider.getTestCase()));

        given().
                spec(app.getSpecificationRequest().getRequestRegular()).
                when().
                post(EndPoints.documentLine).
                then().
                assertThat().
                statusCode(dataProvider.getCode());

    }

    @Description("Document line body positive")
    @Test(dataProvider = "validDocBodyPositive", dataProviderClass = DataProviderDocument.class, alwaysRun = true)
    public void testDocumentLineBodyPositive(EntityRequest dataProvider) {

        step(String.format("Test case: %s", dataProvider.getTestCase()));

        given().
                spec(app.getSpecificationRequest().getRequestRegular()).
                body(app.getHelperHTTPRequest().getBodyInHashMap(dataProvider.getBody())).
                when().
                post(EndPoints.documentLine).
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

    @Description("Document line body negative")
    @Test(dataProvider = "validDocBodyNegative", dataProviderClass = DataProviderDocument.class, alwaysRun = true)
    public void testDocumentLineBodyNegative(EntityRequest dataProvider) {

        step(String.format("Test case: %s", dataProvider.getTestCase()));

        given().
                spec(app.getSpecificationRequest().getRequestRegular()).
                body(app.getHelperHTTPRequest().getBodyInHashMap(dataProvider.getBody())).
                when().
                post(EndPoints.documentLine).
                then().
                assertThat().
                statusCode(dataProvider.getCode()).
                and().
                body("id", emptyOrNullString());

    }

}
