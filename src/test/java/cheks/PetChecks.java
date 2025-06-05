package cheks;

import io.qameta.allure.Allure;
import io.qameta.allure.Step;
import io.restassured.response.Response;
import models.pet.Pet;
import org.junit.jupiter.api.Assertions;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static requests.BaseRequest.fromJson;

public class PetChecks {

    @Step("Checking received pet body is valid and equals to expected one")
    public static void checkPetBody(Pet expectedPet, Response response) {
        Allure.addAttachment("Expected body", expectedPet.toString());
        Allure.addAttachment("Actual body", response.body().asString());
        Pet actualPet = assertDoesNotThrow(() -> fromJson(response.asString(), Pet.class));
        Assertions.assertEquals(expectedPet, actualPet, "Received pet body does not equal to expected one");
    }
}
