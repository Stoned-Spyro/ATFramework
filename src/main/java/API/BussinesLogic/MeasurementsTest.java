package API.BussinesLogic;

import API.StatusCodes.StatusCode;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import org.testng.Assert;

import static constants.APIConstants.PATH;
import static constants.APIConstants.URI;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class MeasurementsTest {

    private static final String uri = URI ;
    private static final String path = PATH;

    public MeasurementsTest(){
        RestAssured.baseURI = uri;
        RestAssured.basePath = path;
    }

  public MeasurementsTest createMeasurement(){
        String payload = "{\"date\":\"2022-06-12T20:13:09.787Z\",\"ammonia\":5,\"phosphates\":5,\"ferrum\":6,\"nitrates\":1,\"nitrities\":6,\"suspendedSolids\":4,\"waterStorageId\":5}";

        givenMeasurement()
                .body(payload)
                .post("/measurements")
                .then()
                .assertThat().statusCode(StatusCode.OK.value)
                .extract().path("id");

        return this;
    }
    public MeasurementsTest getAllMeasurements(){
        givenMeasurement()
                .get("/measurements")
                .then()
                .assertThat()
                .statusCode(StatusCode.OK.value);
        return this;
    }
    public MeasurementsTest FindMeasurementByWaterStorage(String waterStorageId){
                givenMeasurement()
                .get("/measurements/get-measurements-by-storage/" + waterStorageId)
                .then()
                .assertThat()
                .statusCode(StatusCode.OK.value);

        return this;
    }
    public MeasurementsTest deleteMeasurement(String id){
        Assert.assertNotNull(id, "Enter Id");
        givenMeasurement()
                .delete("/measurements/" + id)
                .then()
                .assertThat().statusCode(StatusCode.OK.value);
        return this;
    }
    private RequestSpecification givenMeasurement(){
        return given()
                .contentType(ContentType.JSON)
                .log().all();
    }


}
