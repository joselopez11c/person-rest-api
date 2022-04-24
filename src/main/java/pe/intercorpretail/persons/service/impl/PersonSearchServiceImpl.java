package pe.intercorpretail.persons.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pe.intercorpretail.persons.builder.PersonBuilder;
import pe.intercorpretail.persons.model.PersonKpiResponse;
import pe.intercorpretail.persons.model.PersonResponse;
import pe.intercorpretail.persons.repository.PersonRepository;
import pe.intercorpretail.persons.service.PersonSearchService;

import java.math.BigDecimal;
import java.util.List;

@Service
@RequiredArgsConstructor
public class PersonSearchServiceImpl implements PersonSearchService {

    private final PersonRepository repository;

    @Override
    public PersonKpiResponse searchKpi() {
        var persons = PersonBuilder.entityToResponseAll(repository.findAll());
        var average = BigDecimal.valueOf(
                persons.stream()
                        .mapToDouble(value -> Double.parseDouble(value.getAge()))
                        .average().orElse(Double.NaN));

        return PersonKpiResponse.builder()
                .averageAge(average)
                .standardDeviation(BigDecimal.ZERO)
                .build();
    }

    @Override
    public List<PersonResponse> searchAllPerson() {
        var persons = PersonBuilder.entityToResponseAll(repository.findAll());
        return persons;
    }
}
