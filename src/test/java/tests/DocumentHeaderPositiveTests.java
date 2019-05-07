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
public class DocumentHeaderPositiveTests extends TestBase {

    @Description("Document header simple positive")
    @Test(dataProvider = "validDocHeaderPositive", dataProviderClass = DataProviderDocument.class, alwaysRun = true)
    public void testDocumentHeaderSimplePositive(EntityHeader dataProvider) {

        step(String.format("Test case: %s", dataProvider.getTestCase()));

        makeRequest(EndPoints.documentHeaderSimple, dataProvider);

    }

    @Description("Document header positive")
    @Test(dataProvider = "validDocHeaderPositive", dataProviderClass = DataProviderDocument.class, alwaysRun = true)
    public void testDocumentHeaderPositive(EntityHeader dataProvider) {

        step(String.format("Test case: %s", dataProvider.getTestCase()));

        makeRequest(EndPoints.documentHeader, dataProvider);

    }



    private void makeRequest(String endPoint, EntityHeader header){

        given().
                spec(app.getSpecificationRequest().getRequestWithoutContentAccept()).
                header(header.getContentKey(), header.getContentValue()).
                header(header.getAcceptKey(), header.getAcceptValue()).
                when().
                post(endPoint).
                then().
                assertThat().
                spec(app.getSpecificationResponse().getResponseRegular()).
                and().
                body("messages",emptyArray());

    }

}
