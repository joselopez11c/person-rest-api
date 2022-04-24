package pe.intercorpretail.persons.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;
import pe.intercorpretail.persons.builder.PersonBuilder;
import pe.intercorpretail.persons.model.PersonCreateRequest;
import pe.intercorpretail.persons.repository.PersonRepository;
import pe.intercorpretail.persons.service.PersonCreateService;

import java.util.stream.Stream;

@Service
@RequiredArgsConstructor
public class PersonCreateServiceImpl implements PersonCreateService {

    private final PersonRepository repository;

    @Override
    public Stream<ResponseEntity<Void>> createPerson(PersonCreateRequest personCreateRequest) {
        return Stream.of(repository.save(PersonBuilder.requestToEntity(personCreateRequest)))
                 .map(personEntity -> ResponseEntity.noContent().build());

    }
}
