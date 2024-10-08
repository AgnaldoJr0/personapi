package dio.projectApiRest.personapi.repository;

import dio.projectApiRest.personapi.entity.Person;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonRepository  extends JpaRepository<Person, Long> {
}
