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
import static org.testng.Assert.assertEquals;

@Listeners(TestListener.class)
public class DocumentDetailTests extends TestBase {

        @Description("Document detail positive")
    @Test(dataProvider = "validDocHeaderPositive", dataProviderClass = DataProviderDocument.class, alwaysRun = true)
    public void testDocumentDetailPositive(EntityHeader dataProvider) throws ClassNotFoundException, InstantiationException, IllegalAccessException, IOException {

            step(String.format("Test case: %s", dataProvider.getTestCase()));
            app.setCheck("Send request");
            assertEquals(app.getHelperHTTPRequest().sendHeadersPost(dataProvider, EndPoints.documentDetail), dataProvider.getCode());
    }

    @Description("Document detail negative")
    @Test(dataProvider = "validDocHeaderNegative", dataProviderClass = DataProviderDocument.class, alwaysRun = true)
    public void testDocumentDetailNegative(EntityHeader dataProvider) throws ClassNotFoundException, InstantiationException, IllegalAccessException, IOException {

        step(String.format("Test case: %s", dataProvider.getTestCase()));
        app.setCheck("Send request");
        assertEquals(app.getHelperHTTPRequest().sendHeadersPost(dataProvider, EndPoints.documentDetail), dataProvider.getCode());
    }

//    @Description("Document detail positive")
//    @Test(dataProvider = "validDocHeaderPositive", dataProviderClass = DataProviderDocument.class, alwaysRun = true)
//    public void testDocumentDetailPositive(EntityHeader dataProvider) {
//
//        step(String.format("Test case: %s", dataProvider.getTestCase()));
//
//        given().
//                spec(app.getSpecificationRequest().getRequestForHeader(dataProvider)).
//                header(dataProvider.getContentKey(), dataProvider.getContentValue()).
//                header(dataProvider.getAcceptKey(), dataProvider.getAcceptValue()).
//                when().
//                post(EndPoints.documentDetail).
//                then().
//                assertThat().
//                spec(app.getSpecificationResponse().getResponseRegular());
//
//    }
//
//    @Description("Document detail negative")
//    @Test(dataProvider = "validDocHeaderNegative", dataProviderClass = DataProviderDocument.class, alwaysRun = true)
//    public void testDocumentDetailNegative(EntityHeader dataProvider) {
//
//        step(String.format("Test case: %s", dataProvider.getTestCase()));
//
//        given().
//                spec(app.getSpecificationRequest().getRequestForHeader(dataProvider)).
//                when().
//                post(EndPoints.documentDetail).
//                then().
//                assertThat().
//                statusCode(dataProvider.getCode());
//
//    }


}
