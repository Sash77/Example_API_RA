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
public class WorklistSelectionTests extends TestBase {

    @Description("Worklist selection positive")
    @Test(dataProvider = "validHeaderPositive", dataProviderClass = DataProviderDocument.class, alwaysRun = true)
    public void testWorklistSelectionHeaderPositive(EntityRequest dataProvider) throws ClassNotFoundException, InstantiationException, IllegalAccessException, IOException {

        step(String.format("Test case: %s", dataProvider.getTestCase()));
        app.setCheck("Send request");
        assertEquals(app.getHelperHTTPRequest().sendHeadersPost(dataProvider, EndPoints.workListSelection), dataProvider.getCode());//waiting for Rene
    }

    @Description("Worklist selection negative")
    @Test(dataProvider = "validHeaderNegative", dataProviderClass = DataProviderDocument.class, alwaysRun = true)
    public void testWorklistSelectionHeaderNegative(EntityRequest dataProvider) throws ClassNotFoundException, InstantiationException, IllegalAccessException, IOException {

        step(String.format("Test case: %s", dataProvider.getTestCase()));
        app.setCheck("Send request");
        assertEquals(app.getHelperHTTPRequest().sendHeadersPost(dataProvider, EndPoints.workListSelection), dataProvider.getCode());//waiting for Rene
    }

//    @Description("Worklist selection json schema validation")
//    @Test(dataProvider = "validWorklistSelectionJsonSchema", dataProviderClass = DataProviderDocument.class, alwaysRun = true)
//    public void testWorklistSelectionJsonSchema(EntityRequest dataProvider) {
//
//        step(String.format("Test case: %s", dataProvider.getTestCase()));
//
//        given().
//                spec(app.getSpecificationRequest().getRequestRegular()).
//                body(app.getHelperHTTPRequest().getBodyInHashMap(dataProvider.getBody())).
//                when().
//                post(EndPoints.workListSelection).
//                then().
//                assertThat().
//                body(matchesJsonSchemaInClasspath("UNKNOWN_YET.json"));              //here is no schema in response just string
//
//    }

    @Description("Worklist selection well formed negative")
    @Test(dataProvider = "validWorklistSelectionWellFormedNegative", dataProviderClass = DataProviderDocument.class, alwaysRun = true)
    public void testWorklistSelectionWellFormedNegative(EntityRequest dataProvider) {

        step(String.format("Test case: %s", dataProvider.getTestCase()));

        given().
                spec(app.getSpecificationRequest().getRequestRegular()).
                body(String.format(dataProvider.getWellFormed(), "main", "DocNo")).
                when().
                post(EndPoints.workListSelection).
                then().
                assertThat().
                statusCode(dataProvider.getCode());

    }


    @Description("Worklist selection body positive")
    @Test(dataProvider = "validWorklistSelectionBodyPositive", dataProviderClass = DataProviderDocument.class, alwaysRun = true)
    public void testWorklistSelectionBodyPositive(EntityRequest dataProvider) {

        step(String.format("Test case: %s", dataProvider.getTestCase()));

        given().
                spec(app.getSpecificationRequest().getRequestRegular()).
                body(app.getHelperHTTPRequest().getBodyInHashMap(dataProvider.getBody())).
                when().
                post(EndPoints.workListSelection).
                then().
                assertThat().
                spec(app.getSpecificationResponse().getResponseRegular()).
                and().
                body("messages", not(hasEntry("type", "ERROR"))).
                and().
                body("workListId", equalTo(String.format("%s", dataProvider.returnValueFromBody("workListId"))));

    }

//
//    @Description("Worklist selection body negative")
//    @Test(dataProvider = "validWorklistSelectionBodyNegative", dataProviderClass = DataProviderDocument.class, alwaysRun = true)
//    public void testWorklistSelectionBodyNegative(EntityRequest dataProvider) {
//
//        step(String.format("Test case: %s", dataProvider.getTestCase()));
//
//        given().
//                spec(app.getSpecificationRequest().getRequestRegular()).
//                body(app.getHelperHTTPRequest().getBodyInHashMap(dataProvider.getBody())).
//                when().
//                post(EndPoints.workListSelection).
//                then().
//                assertThat().
//                statusCode(dataProvider.getCode()).
//                and().
//                body("id", emptyOrNullString());
//
//    }
//
//    @Description("Worklist selection null test")
//    @Test(dataProvider = "validNullWorklistSelection", dataProviderClass = DataProviderDocument.class, alwaysRun = true)
//    public void testWorklistSelectionNullInBody(EntityRequest dataProvider) throws ClassNotFoundException, InstantiationException, IllegalAccessException, IOException {
//
//        step(String.format("Test case: %s", dataProvider.getTestCase()));
//        app.setCheck("Send request");
//        assertEquals(app.getHelperHTTPRequest().sendNullInBodyPost(dataProvider, EndPoints.workListSelection), dataProvider.getCode());
//    }

}
