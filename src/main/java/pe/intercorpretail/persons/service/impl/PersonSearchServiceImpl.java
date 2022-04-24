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
import java.util.stream.Collectors;

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

        BigDecimal standardDeviation = calculateStandardDeviation(persons, average);

        return PersonKpiResponse.builder()
                .averageAge(average)
                .standardDeviation(standardDeviation)
                .build();
    }

    private BigDecimal calculateStandardDeviation(List<PersonResponse> persons, BigDecimal average) {
        var standardDeviation = 0D;
        var listNumbers = persons.stream().map(value ->
                Double.valueOf(value.getAge())).collect(Collectors.toList());

        for (double num : listNumbers) {
            standardDeviation += Math.pow(num - average.doubleValue(), 2);
        }
        return BigDecimal.valueOf(Math.sqrt(standardDeviation / persons.size()));
    }

    @Override
    public List<PersonResponse> searchAllPerson() {
        return PersonBuilder.entityToResponseAll(repository.findAll());
    }
}
