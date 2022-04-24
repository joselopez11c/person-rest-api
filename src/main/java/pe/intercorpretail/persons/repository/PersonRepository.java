package pe.intercorpretail.persons.repository;

import org.springframework.data.repository.CrudRepository;
import pe.intercorpretail.persons.model.PersonEntity;

public interface PersonRepository extends CrudRepository<PersonEntity, Long>  {
}
