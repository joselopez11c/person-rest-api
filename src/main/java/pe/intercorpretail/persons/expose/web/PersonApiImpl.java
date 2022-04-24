package pe.intercorpretail.persons.expose.web;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.NativeWebRequest;
import pe.intercorpretail.persons.exponse.web.CreaclienteApi;
import pe.intercorpretail.persons.exponse.web.KpideclientesApi;
import pe.intercorpretail.persons.exponse.web.ListclientesApi;
import pe.intercorpretail.persons.model.PersonCreateRequest;
import pe.intercorpretail.persons.model.PersonKpiResponse;
import pe.intercorpretail.persons.model.PersonResponse;
import pe.intercorpretail.persons.service.PersonCreateService;
import pe.intercorpretail.persons.service.PersonSearchService;

import java.util.List;
import java.util.Optional;

@Component
@RequiredArgsConstructor
public class PersonApiImpl implements CreaclienteApi, KpideclientesApi, ListclientesApi {

    private final PersonCreateService createService;
    private final PersonSearchService searchService;

    @Override
    public ResponseEntity<Void> createPerson(PersonCreateRequest personCreateRequest) {
        return createService.createPerson(personCreateRequest).findFirst().orElseThrow();
    }

    @Override
    public ResponseEntity<List<PersonKpiResponse>> searchKpiPerson() {
        return searchService.searchKpi();
    }

    @Override
    public ResponseEntity<List<PersonResponse>> searchListClient() {
        return searchService.searchAllPerson();
    }



    @Override
    public Optional<NativeWebRequest> getRequest() {
        return CreaclienteApi.super.getRequest();
    }

    @Override
    public ResponseEntity<List<PersonResponse>> _searchListClient() {
        return ListclientesApi.super._searchListClient();
    }

    @Override
    public ResponseEntity<List<PersonKpiResponse>> _searchKpiPerson() {
        return KpideclientesApi.super._searchKpiPerson();
    }

    @Override
    public ResponseEntity<Void> _createPerson(PersonCreateRequest personCreateRequest) {
        return CreaclienteApi.super._createPerson(personCreateRequest);
    }
}
