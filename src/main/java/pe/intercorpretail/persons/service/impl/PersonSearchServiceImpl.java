package pe.intercorpretail.persons.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import pe.intercorpretail.persons.builder.PersonBuilder;
import pe.intercorpretail.persons.model.PersonKpiResponse;
import pe.intercorpretail.persons.model.PersonResponse;
import pe.intercorpretail.persons.repository.PersonRepository;
import pe.intercorpretail.persons.service.PersonSearchService;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PersonSearchServiceImpl implements PersonSearchService {

    private final PersonRepository repository;

    @Override
    public List<PersonKpiResponse> searchKpi() {
        return PersonBuilder.entityToResponseAll(repository.findAll());
    }

    @Override
    public List<PersonResponse> searchAllPerson() {
        var persons = PersonBuilder.entityToResponseAll(repository.findAll());
        return null;
    }
}
