package requests;

import config.Config;
import io.qameta.allure.Step;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import models.pet.Pet;

public class PetRequest extends BaseRequest {
    private static final String PET_BASE;

    static {
        PET_BASE = Config.get().getPetUrl();
    }


    @Step("Sending add pet request with parameters {pet}")
    public static Response addNewPet(Pet pet) {
        return RestAssured.given()
                .body(pet)
                .contentType(ContentType.JSON)
                .post(PET_BASE);
    }

    @Step("Sending delete pet request with pet id {petId} and api key {apiKey}")
    public static Response deletePet(int petId, String apiKey) {
        RequestSpecification request = RestAssured.given().accept(ContentType.JSON);
        if (apiKey != null)
            request = request.headers("api_key", apiKey);
        return request.delete(PET_BASE + petId);
    }

    public static Response deletePet(int petId) {
        return deletePet(petId, null);
    }

    @Step("Sending get pet request with pet id {petId}")
    public static Response getPetById(long petId) {
        return RestAssured.given().get(PET_BASE + petId);
    }

    @Step("Updating pet with body {pet}")
    public static Response updatePet(Pet pet) {
        return RestAssured.given()
                .body(pet)
                .contentType(ContentType.JSON)
                .put(PET_BASE);
    }
}
