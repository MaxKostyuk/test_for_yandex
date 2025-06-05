package data.provider.pet;

import models.pet.Pet;
import models.pet.Status;

import java.util.List;
import java.util.stream.Stream;

public class PetProvider {
    private static final int VALID_PET_ID = 300;
    private static final String VALID_PET_NAME = "TestPet";
    private static final List<String> VALID_URL_LIST = List.of("https://images.app.goo.gl/Uiw5G8XpK2ZTnNmZ8");
    private static final Status VALID_PET_STATUS = Status.AVAILABLE;

    public static Stream<Pet> singleValidPetProvider() {
        return Stream.of(generateValidPet());
    }

    private static Pet generateValidPet() {
        return Pet.builder()
                .id(VALID_PET_ID)
                .category(CategoryProvider.singleValidCategoryProvider().findAny().get())
                .name(VALID_PET_NAME)
                .photoUrls(VALID_URL_LIST)
                .tags(TagProvider.singleValidTagProvider().toList())
                .status(VALID_PET_STATUS)
                .build();
    }
}
