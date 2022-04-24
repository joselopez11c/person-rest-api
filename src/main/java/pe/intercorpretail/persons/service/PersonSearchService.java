package pe.intercorpretail.persons.service;

import pe.intercorpretail.persons.model.PersonKpiResponse;
import pe.intercorpretail.persons.model.PersonResponse;

import java.util.List;

public interface PersonSearchService {
    PersonKpiResponse searchKpi();

    List<PersonResponse> searchAllPerson();
}
