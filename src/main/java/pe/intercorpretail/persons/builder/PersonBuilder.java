package pe.intercorpretail.persons.builder;

import pe.intercorpretail.persons.model.PersonCreateRequest;
import pe.intercorpretail.persons.model.PersonEntity;
import pe.intercorpretail.persons.model.PersonResponse;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

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
                .probableDateDeath(generatedDateDeath(entity.getBirthDate()))
                .build();
    }

    private static LocalDate generatedDateDeath(LocalDate birthDate) {
        var year = birthDate.getYear();
        var date = LocalDate.now();
        return date.plusYears(new Random().nextInt( (year > 50 ? 10 : 50) + 1) + 5);
    }


}
