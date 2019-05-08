package tests;

import static org.testng.Assert.assertEquals;

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

@Listeners(TestListener.class)
public class DocumentDetailSimpleTests extends TestBase {

    @Description("Document detail simple positive")
    @Test(dataProvider = "validDocHeaderPositive", dataProviderClass = DataProviderDocument.class, alwaysRun = true)
    public void testDocumentDetailSimplePositive(EntityHeader dataProvider) throws ClassNotFoundException, InstantiationException, IllegalAccessException, IOException {

        step(String.format("Test case: %s", dataProvider.getTestCase()));

        assertEquals(app.getHelperHTTPRequest().sendHeadersPost(dataProvider, EndPoints.documentDetailSimple), dataProvider.getCode());

    }

    @Description("Document detail simple negative")
    @Test(dataProvider = "validDocHeaderNegative", dataProviderClass = DataProviderDocument.class, alwaysRun = true)
    public void testDocumentDetailSimpleNegative(EntityHeader dataProvider) throws ClassNotFoundException, InstantiationException, IllegalAccessException, IOException {

        step(String.format("Test case: %s", dataProvider.getTestCase()));

        assertEquals(app.getHelperHTTPRequest().sendHeadersPost(dataProvider, EndPoints.documentDetailSimple), dataProvider.getCode());

    }



//    @Description("Document detail simple positive")
//    @Test(dataProvider = "validDocHeaderPositive", dataProviderClass = DataProviderDocument.class, alwaysRun = true)
//    public void testDocumentDetailSimplePositive(EntityHeader dataProvider) {
//
//        step(String.format("Test case: %s", dataProvider.getTestCase()));
//
//        given().
//                spec(app.getSpecificationRequest().getRequestForHeader(dataProvider)).
//                when().
//                post(EndPoints.documentDetailSimple).
//                then().
//                assertThat().
//                spec(app.getSpecificationResponse().getResponseRegular());
////                and().
////                body("messages",not(hasEntry("type","ERROR"))); body("messages",emptyArray())
//
//    }
//
//    @Description("Document detail simple negative")
//    @Test(dataProvider = "validDocHeaderNegative", dataProviderClass = DataProviderDocument.class, alwaysRun = true)
//    public void testDocumentDetailSimpleNegative(EntityHeader dataProvider) {
//
//        step(String.format("Test case: %s", dataProvider.getTestCase()));
//
//        given().
//                spec(app.getSpecificationRequest().getRequestForHeader(dataProvider)).
//                when().
//                post(EndPoints.documentDetailSimple).
//                then().
//                assertThat().
//                statusCode(dataProvider.getCode());
//
//    }

}
