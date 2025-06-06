package tests.pet.delete;

import cheks.CommonChecks;
import io.qameta.allure.Description;
import io.restassured.response.Response;
import lombok.extern.slf4j.Slf4j;
import models.pet.Pet;
import org.apache.http.HttpStatus;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import requests.PetRequest;
import tests.BaseTestClass;

import static data.provider.pet.PetProvider.singleValidPetProvider;

@Slf4j
@DisplayName("Delete pet api test")
public class DeletePetTest extends BaseTestClass {
    private static Pet pet;

    @BeforeAll
    public static void setUp() {
        pet = singleValidPetProvider();
    }

    @BeforeEach
    public void addPetSetup() {
        PetRequest.addNewPet(pet);
    }

    @Test
    @DisplayName("Positive test for delete pet")
    @Description("Delete pet twice. First time should return code 200. Second time - code 404")
    public void deletePetPositiveTestShouldReturn200AndThen404() {
        log.info("Start test with pet id {} ", pet.getId());
        Response response = PetRequest.deletePet(pet.getId());
        CommonChecks.checkResponseCode(HttpStatus.SC_OK, response);
        response = PetRequest.deletePet(pet.getId());
        CommonChecks.checkResponseCode(HttpStatus.SC_NOT_FOUND, response);
    }
}
