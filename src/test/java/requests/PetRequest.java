package requests;

import config.Config;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import models.pet.Pet;

public class PetRequest extends BaseRequest {
    private static final String PET_BASE;

    static {
        PET_BASE = Config.get().getPetUrl();
    }

    public static Response addNewPet(Pet pet) {
        return RestAssured.given().
                log().all()
                .body(pet)
                .contentType(ContentType.JSON)
                .post(PET_BASE);
    }
}
