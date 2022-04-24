package pe.intercorpretail.persons.builder;

import pe.intercorpretail.persons.model.PersonCreateRequest;
import pe.intercorpretail.persons.model.PersonEntity;
import pe.intercorpretail.persons.model.PersonResponse;

import java.util.ArrayList;
import java.util.List;

public class PersonBuilder {
    public static PersonEntity requestToEntity(PersonCreateRequest request) {
        return PersonEntity.builder()
                .name(request.getName())
                .lastName(request.getLastName())
                .birthDate(request.getBirthDate())
                .age(Integer.parseInt(request.getAge()))
                .build();
    }

    public static List<PersonResponse> entityToResponseAll(Iterable<PersonEntity> entities) {
        var response = new ArrayList<PersonResponse>();
        entities.forEach(values -> response.add(entityToResponse(values)));
        return response;
    }

    public static PersonResponse entityToResponse(PersonEntity entity) {
        return PersonResponse.builder()
                .name(entity.getName())
                .lastName(entity.getLastName())
                .age(String.valueOf(entity.getAge()))
                .birthDate(entity.getBirthDate())
                .build();
    }
}
