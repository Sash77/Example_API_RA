package tests;

import api.EndPoints;
import appmanager.TestBase;
import appmanager.TestListener;
import dataprovider.DataProviderDocument;
import io.qameta.allure.Description;
import model.entity.EntityHeader;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import java.io.IOException;

import static io.qameta.allure.Allure.step;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.emptyArray;
import static org.testng.Assert.assertEquals;

@Listeners(TestListener.class)
public class DocumentTabSimpleTests extends TestBase {

    @Description("Document tab simple positive")
    @Test(dataProvider = "validDocHeaderPositive", dataProviderClass = DataProviderDocument.class, alwaysRun = true)
    public void testDocumentTabSimplePositive(EntityHeader dataProvider) throws ClassNotFoundException, InstantiationException, IllegalAccessException, IOException {

        step(String.format("Test case: %s", dataProvider.getTestCase()));

        assertEquals(app.getHelperHTTPRequest().sendHeadersPost(dataProvider, EndPoints.documentTabSimple), dataProvider.getCode());

    }

    @Description("Document tab simple negative")
    @Test(dataProvider = "validDocHeaderNegative", dataProviderClass = DataProviderDocument.class, alwaysRun = true)
    public void testDocumentTabSimpleNegative(EntityHeader dataProvider) throws ClassNotFoundException, InstantiationException, IllegalAccessException, IOException {

        step(String.format("Test case: %s", dataProvider.getTestCase()));

        assertEquals(app.getHelperHTTPRequest().sendHeadersPost(dataProvider, EndPoints.documentTabSimple), dataProvider.getCode());

    }

//    @Description("Document tab simple positive")
//    @Test(dataProvider = "validDocHeaderPositive", dataProviderClass = DataProviderDocument.class, alwaysRun = true)
//    public void testDocumentTabSimplePositive(EntityHeader dataProvider) {
//
//        step(String.format("Test case: %s", dataProvider.getTestCase()));
//
//        given().
//                spec(app.getSpecificationRequest().getRequestForHeader(dataProvider)).
//                when().
//                post(EndPoints.documentTabSimple).
//                then().
//                assertThat().
//                spec(app.getSpecificationResponse().getResponseRegular());
//
//    }
//
//    @Description("Document tab simple negative")
//    @Test(dataProvider = "validDocHeaderNegative", dataProviderClass = DataProviderDocument.class, alwaysRun = true)
//    public void testDocumentTabSimpleNegative(EntityHeader dataProvider) {
//
//        step(String.format("Test case: %s", dataProvider.getTestCase()));
//
//        given().
//                spec(app.getSpecificationRequest().getRequestForHeader(dataProvider)).
//                when().
//                post(EndPoints.documentTabSimple).
//                then().
//                assertThat().
//                statusCode(dataProvider.getCode());
//
//    }

}
