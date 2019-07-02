package tests;

import api.EndPoints;
import appmanager.TestBase;
import appmanager.TestListener;
import dataprovider.DataProviderDocument;
import io.qameta.allure.Description;
import io.restassured.response.Response;
import model.entity.EntityNode;
import model.entity.EntityRequest;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.Arrays;

import static io.qameta.allure.Allure.step;
import static io.restassured.RestAssured.given;
import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;
import static org.hamcrest.Matchers.*;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

@Listeners(TestListener.class)
public class WorklistTreePostTests extends TestBase {

    @Description("Worklist tree positive")
    @Test(dataProvider = "validHeaderPositive", dataProviderClass = DataProviderDocument.class, alwaysRun = true)
    public void testWorklistTreeHeaderPositive(EntityRequest dataProvider) throws ClassNotFoundException, InstantiationException, IllegalAccessException, IOException {

        step(String.format("Test case: %s", dataProvider.getTestCase()));
        app.setCheck("Send request");
        assertEquals(app.getHelperHTTPRequest().sendHeadersPost(dataProvider, EndPoints.workListTree), dataProvider.getCode());
    }

    @Description("Worklist tree negative")
    @Test(dataProvider = "validHeaderNegative", dataProviderClass = DataProviderDocument.class, alwaysRun = true)
    public void testWorklistTreeHeaderNegative(EntityRequest dataProvider) throws ClassNotFoundException, InstantiationException, IllegalAccessException, IOException {

        step(String.format("Test case: %s", dataProvider.getTestCase()));
        app.setCheck("Send request");
        assertEquals(app.getHelperHTTPRequest().sendHeadersPost(dataProvider, EndPoints.workListTree), dataProvider.getCode());
    }

    @Description("Worklist tree json schema validation")
    @Test(dataProvider = "validWorklistTreeJsonSchema", dataProviderClass = DataProviderDocument.class, alwaysRun = true)
    public void testWorklistTreeJsonSchema(EntityRequest dataProvider) {

        step(String.format("Test case: %s", dataProvider.getTestCase()));

        given().
                spec(app.getSpecificationRequest().getRequestRegular()).
                body((dataProvider.isSimple()) ? app.getHelperHTTPRequest().getSimpleBody(dataProvider.getBody()) : app.getHelperHTTPRequest().getBodyInHashMap(dataProvider.getBody())).
                when().
                post(EndPoints.workListTree).
                then().
                assertThat().
                body(matchesJsonSchemaInClasspath("schemaNode.json"));

    }

    @Description("Worklist tree well formed negative")
    @Test(dataProvider = "validWorklistTreeWellFormedNegative", dataProviderClass = DataProviderDocument.class, alwaysRun = true)
    public void testWorklistTreeWellFormedNegative(EntityRequest dataProvider) {

        step(String.format("Test case: %s", dataProvider.getTestCase()));

        given().
                spec(app.getSpecificationRequest().getRequestRegular()).
                body(String.format(dataProvider.getWellFormed(), app.getDocID())).
                when().
                post(EndPoints.workListTree).
                then().
                assertThat().
                statusCode(dataProvider.getCode());

    }

    @Description("Worklist tree body positive")
    @Test(dataProvider = "validWorklistTreeBodyPositive", dataProviderClass = DataProviderDocument.class, alwaysRun = true)
    public void testWorklistTreeBodyPositive(EntityRequest dataProvider) {

        step(String.format("Test case: %s", dataProvider.getTestCase()));

        Response response = given().
                spec(app.getSpecificationRequest().getRequestRegular()).
                body((dataProvider.isSimple()) ? app.getHelperHTTPRequest().getSimpleBody(dataProvider.getBody()) : app.getHelperHTTPRequest().getBodyInHashMap(dataProvider.getBody())).
                when().
                post(EndPoints.workListTree).
                then().extract().response();

        response.then().
                        assertThat().
                spec(app.getSpecificationResponse().getResponseRegular()).
                and().
                body("errorMessage", not(hasEntry("type", "ERROR")));

        assertTrue(Arrays.deepEquals(nodesInFact(response.as(EntityNode.class)),dataProvider.getShouldbe()));

    }


    @Description("Worklist tree body negative")
    @Test(dataProvider = "validWorklistTreeBodyNegative", dataProviderClass = DataProviderDocument.class, alwaysRun = true)
    public void testWorklistTreeBodyNegative(EntityRequest dataProvider) {

        step(String.format("Test case: %s", dataProvider.getTestCase()));

        given().
                spec(app.getSpecificationRequest().getRequestRegular()).
                body((dataProvider.isSimple()) ? app.getHelperHTTPRequest().getSimpleBody(dataProvider.getBody()) : app.getHelperHTTPRequest().getBodyInHashMap(dataProvider.getBody())).
                when().
                post(EndPoints.workListTree).
                then().
                assertThat().
                statusCode(dataProvider.getCode()).
                and().
                body("id", is(emptyOrNullString()));

    }

    @Description("Worklist tree null test")
    @Test(dataProvider = "validNullWorklistTree", dataProviderClass = DataProviderDocument.class, alwaysRun = true)
    public void testWorklistTreeNullInBody(EntityRequest dataProvider) throws ClassNotFoundException, InstantiationException, IllegalAccessException, IOException {

        step(String.format("Test case: %s", dataProvider.getTestCase()));
        app.setCheck("Send request");
        assertEquals(app.getHelperHTTPRequest().sendNullInBodyPost(dataProvider, EndPoints.workListTree), dataProvider.getCode());
    }

    private String[] nodesInFact(EntityNode inFactId){

        String[] inFactNodes = returnId(inFactId).split(",");
        Arrays.sort(inFactNodes);

        return inFactNodes;
    }

    private String returnId(EntityNode inFactId){

        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(inFactId.getId()+",");

        if (inFactId.getChildren()!=null&&inFactId.getChildren().length!=0) {
            for (EntityNode entity:inFactId.getChildren()) {
                stringBuilder.append(returnId(entity));
            }
        }
        return stringBuilder.toString();
    }

}
