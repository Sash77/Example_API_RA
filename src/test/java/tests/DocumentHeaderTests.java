package tests;

import api.EndPoints;
import appmanager.TestBase;
import appmanager.TestListener;
import dataprovider.DataProviderDocument;
import io.qameta.allure.Description;
import model.entity.EntityHeader;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import static io.qameta.allure.Allure.step;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.emptyArray;

@Listeners(TestListener.class)
public class DocumentHeaderTests extends TestBase {

    @Description("Document header positive")
    @Test(dataProvider = "validDocHeaderPositive", dataProviderClass = DataProviderDocument.class, alwaysRun = true)
    public void testDocumentHeaderPositive(EntityHeader dataProvider) {

        step(String.format("Test case: %s", dataProvider.getTestCase()));

        given().
                spec(app.getSpecificationRequest().getRequestWithoutContentAccept()).
                header(dataProvider.getContentKey(), dataProvider.getContentValue()).
                header(dataProvider.getAcceptKey(), dataProvider.getAcceptValue()).
                when().
                post(EndPoints.documentHeader).
                then().
                assertThat().
                spec(app.getSpecificationResponse().getResponseRegular()).
                and().
                body("messages",emptyArray());

    }

    @Description("Document header negative")
    @Test(dataProvider = "validDocHeaderNegative", dataProviderClass = DataProviderDocument.class, alwaysRun = true)
    public void testDocumentHeaderNegative(EntityHeader dataProvider) {

        step(String.format("Test case: %s", dataProvider.getTestCase()));

        given().
                spec(app.getSpecificationRequest().getRequestWithoutContentAccept()).
                header(dataProvider.getContentKey(), dataProvider.getContentValue()).
                header(dataProvider.getAcceptKey(), dataProvider.getAcceptValue()).
                when().
                post(EndPoints.documentHeader).
                then().
                assertThat().
                statusCode(dataProvider.getCode());

    }

}
