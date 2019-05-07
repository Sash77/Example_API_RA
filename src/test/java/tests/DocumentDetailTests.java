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
import static org.hamcrest.Matchers.hasEntry;
import static org.hamcrest.Matchers.not;

@Listeners(TestListener.class)
public class DocumentDetailTests extends TestBase {

    @Description("Document detail positive")
    @Test(dataProvider = "validDocHeaderPositive", dataProviderClass = DataProviderDocument.class, alwaysRun = true)
    public void testDocumentDetailPositive(EntityHeader dataProvider) {

        step(String.format("Test case: %s", dataProvider.getTestCase()));

        given().
                spec(app.getSpecificationRequest().getRequestWithoutContentAccept()).
                header(dataProvider.getContentKey(), dataProvider.getContentValue()).
                header(dataProvider.getAcceptKey(), dataProvider.getAcceptValue()).
                when().
                post(EndPoints.documentDetail).
                then().
                assertThat().
                spec(app.getSpecificationResponse().getResponseRegular()).
                and().
                body("messages",not(hasEntry("type","ERROR")));

    }

    @Description("Document detail negative")
    @Test(dataProvider = "validDocHeaderNegative", dataProviderClass = DataProviderDocument.class, alwaysRun = true)
    public void testDocumentDetailNegative(EntityHeader dataProvider) {

        step(String.format("Test case: %s", dataProvider.getTestCase()));

        given().
                spec(app.getSpecificationRequest().getRequestWithoutContentAccept()).
                header(dataProvider.getContentKey(), dataProvider.getContentValue()).
                header(dataProvider.getAcceptKey(), dataProvider.getAcceptValue()).
                when().
                post(EndPoints.documentDetail).
                then().
                assertThat().
                statusCode(dataProvider.getCode());

    }


}
