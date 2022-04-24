package pe.intercorpretail.persons.builder;

import pe.intercorpretail.persons.model.PersonCreateRequest;
import pe.intercorpretail.persons.model.PersonEntity;
import pe.intercorpretail.persons.model.PersonResponse;

public class PersonBuilder {
    public static PersonEntity requestToEntity(PersonCreateRequest request) {
        return PersonEntity.builder()
                .name(request.getName())
                .lastName(request.getLastName())
                .birthDate(request.getBirthDate())
                .age(request.getAge())
                .build();
    }

    public static PersonResponse entityToResponseAll(Iterable<PersonEntity> all) {
    }
}
