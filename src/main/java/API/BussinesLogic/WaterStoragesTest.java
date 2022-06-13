package API.BussinesLogic;

import API.StatusCodes.StatusCode;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import org.testng.Assert;

import static constants.APIConstants.*;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class WaterStoragesTest {

    private static final String uri = URI ;
    private static final String path = PATH;

    public WaterStoragesTest(){
        RestAssured.baseURI = uri;
        RestAssured.basePath = path;
    }


    public WaterStoragesTest getAllStorages(){

        givenWaterStorage()
                .get("/water-storages" )
                .then()
                .assertThat()
                .statusCode(StatusCode.OK.value);

        return this;
    }

    public WaterStoragesTest createStorage(){

       String payload = "{\"name\":\"AQALastData\",\"coordNorth\":\"49.45686\",\"coordSouth\":\"51.42567\",\"city\":\"Drogobych\"}";

        givenWaterStorage()
                .body(payload)
                .post("/water-storages")
                .then()
                .assertThat().statusCode(StatusCode.OK.value)
                .extract().path("id");

        return this;
    }
    public WaterStoragesTest findWaterStorageByName(String name){
        Assert.assertNotNull(name, "You should enter name");
        givenWaterStorage()
                .queryParam("waterStorageName", name)
                .get("/water-storages/search/" + name)
                .then()
                .assertThat().statusCode(StatusCode.OK.value);
        return this;
    }

    public WaterStoragesTest deleteStorage(String id){
        Assert.assertNotNull(id, "Enter Id");
        givenWaterStorage()
                .delete("/water-storages/" + id)
                .then()
                .assertThat().statusCode(StatusCode.OK.value);
    return this;
    }

    public WaterStoragesTest updateStorage(String id){

        String payload = "{\"id\":2,\"name\":\"MarunkaRenamed\",\"coordNorth\":\"34.21241\",\"coordSouth\":\"53.21313\",\"city\":\"Drogobych\"}";

        Assert.assertNotNull(id, "Enter id");

        givenWaterStorage()
                .body(payload)
                .put("/water-storages/" + id)
                .then()
                .statusCode(StatusCode.OK.value)
                .assertThat()
                .body("city",equalTo("Drogobych"))
                .extract().path("id");

        return this;
    }

    private RequestSpecification givenWaterStorage(){
        return given()
                .contentType(ContentType.JSON)
                .log().all();
    }
}
