package pe.intercorpretail.persons.service;

import org.springframework.http.ResponseEntity;
import pe.intercorpretail.persons.model.PersonCreateRequest;

import java.util.stream.Stream;

public interface PersonCreateService {
    Stream<ResponseEntity<Void>> createPerson(PersonCreateRequest personCreateRequest);
}
