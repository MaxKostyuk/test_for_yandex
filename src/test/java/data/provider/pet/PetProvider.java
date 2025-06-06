package data.provider.pet;

import models.pet.Pet;
import models.pet.Status;
import net.datafaker.Faker;

import java.util.List;

public class PetProvider {
    private static final Faker faker = new Faker();
    private static final Status VALID_PET_STATUS = Status.AVAILABLE;

    public static Pet singleValidPetProvider() {
        return generateValidPet();
    }

    public static Pet singleValidPetWithName(String name) {
        return Pet.builder()
                .id(faker.random().nextInt(1000, 99999))
                .category(CategoryProvider.singleValidCategoryProvider().findAny().get())
                .name(name)
                .photoUrls(List.of(faker.internet().url()))
                .tags(TagProvider.singleValidTagProvider().toList())
                .status(VALID_PET_STATUS)
                .build();
    }

    private static Pet generateValidPet() {
        return singleValidPetWithName(faker.animal().name());
    }
}
