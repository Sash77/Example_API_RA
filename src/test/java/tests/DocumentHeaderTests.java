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
public class DocumentHeaderTests extends TestBase {

        @Description("Document header positive")
    @Test(dataProvider = "validDocHeaderPositive", dataProviderClass = DataProviderDocument.class, alwaysRun = true)
    public void testDocumentHeaderPositive(EntityHeader dataProvider) throws ClassNotFoundException, InstantiationException, IllegalAccessException, IOException {

            step(String.format("Test case: %s", dataProvider.getTestCase()));
            app.setCheck("Send request");
            assertEquals(app.getHelperHTTPRequest().sendHeadersPost(dataProvider, EndPoints.documentHeader), dataProvider.getCode());
    }

    @Description("Document header negative")
    @Test(dataProvider = "validDocHeaderNegative", dataProviderClass = DataProviderDocument.class, alwaysRun = true)
    public void testDocumentHeaderNegative(EntityHeader dataProvider) throws ClassNotFoundException, InstantiationException, IllegalAccessException, IOException {

        step(String.format("Test case: %s", dataProvider.getTestCase()));
        app.setCheck("Send request");
        assertEquals(app.getHelperHTTPRequest().sendHeadersPost(dataProvider, EndPoints.documentHeader), dataProvider.getCode());
    }

//    @Description("Document header positive")
//    @Test(dataProvider = "validDocHeaderPositive", dataProviderClass = DataProviderDocument.class, alwaysRun = true)
//    public void testDocumentHeaderPositive(EntityHeader dataProvider) {
//
//        step(String.format("Test case: %s", dataProvider.getTestCase()));
//
//        given().
//                spec(app.getSpecificationRequest().getRequestForHeader(dataProvider)).
//                when().
//                post(EndPoints.documentHeader).
//                then().
//                assertThat().
//                spec(app.getSpecificationResponse().getResponseRegular());
//
//    }
//
//    @Description("Document header negative")
//    @Test(dataProvider = "validDocHeaderNegative", dataProviderClass = DataProviderDocument.class, alwaysRun = true)
//    public void testDocumentHeaderNegative(EntityHeader dataProvider) {
//
//        step(String.format("Test case: %s", dataProvider.getTestCase()));
//
//        given().
//                spec(app.getSpecificationRequest().getRequestForHeader(dataProvider)).
//                when().
//                post(EndPoints.documentHeader).
//                then().
//                assertThat().
//                statusCode(dataProvider.getCode());
//
//    }

}
