package tests.pet.add;

import cheks.CommonChecks;
import cheks.PetChecks;
import io.qameta.allure.Description;
import io.restassured.response.Response;
import models.pet.Pet;
import org.apache.http.HttpStatus;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import requests.PetRequest;

@DisplayName("Add pet api tests")
public class AddPetTest {

    @ParameterizedTest
    @MethodSource("data.provider.pet.PetProvider#singleValidPetProvider")
    @DisplayName("Positive test")
    @Description("Sending valid pet body to api point. Should receive code 200 and body with the same pet parameters")
    public void positiveTestShouldReturn200AndBodyEqualsToSent(Pet pet) {
        Response response = PetRequest.addNewPet(pet);
        CommonChecks.checkResponseCode(HttpStatus.SC_OK, response);
        PetChecks.checkPetBody(pet, response);
        System.out.println(PetRequest.deletePet(pet.getId()).asString());
    }
}
