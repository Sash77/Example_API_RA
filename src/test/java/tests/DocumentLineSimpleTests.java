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
public class DocumentLineSimpleTests extends TestBase {

    @Description("Document line simple positive")
    @Test(dataProvider = "validDocHeaderPositive", dataProviderClass = DataProviderDocument.class, alwaysRun = true)
    public void testDocumentLineSimplePositive(EntityHeader dataProvider) {

        step(String.format("Test case: %s", dataProvider.getTestCase()));

        given().
                spec(app.getSpecificationRequest().getRequestWithoutContentAccept()).
                header(dataProvider.getContentKey(), dataProvider.getContentValue()).
                header(dataProvider.getAcceptKey(), dataProvider.getAcceptValue()).
                when().
                post(EndPoints.documentLineSimple).
                then().
                assertThat().
                spec(app.getSpecificationResponse().getResponseRegular()).
                and().
                body("messages",emptyArray());

    }

    @Description("Document line simple negative")
    @Test(dataProvider = "validDocHeaderNegative", dataProviderClass = DataProviderDocument.class, alwaysRun = true)
    public void testDocumentLineSimpleNegative(EntityHeader dataProvider) {

        step(String.format("Test case: %s", dataProvider.getTestCase()));

        given().
                spec(app.getSpecificationRequest().getRequestWithoutContentAccept()).
                header(dataProvider.getContentKey(), dataProvider.getContentValue()).
                header(dataProvider.getAcceptKey(), dataProvider.getAcceptValue()).
                when().
                post(EndPoints.documentLineSimple).
                then().
                assertThat().
                statusCode(dataProvider.getCode());

    }

}
