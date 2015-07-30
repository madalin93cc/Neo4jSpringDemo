package neo4jdemo.repository;

import neo4jdemo.domain.Person;
import org.springframework.data.neo4j.repository.GraphRepository;

/**
 * Created by Madalin.Colezea on 7/30/2015.
 */
public interface PersonRepository extends GraphRepository<Person> {
}
