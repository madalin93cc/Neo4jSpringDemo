package neo4jdemo;

import neo4jdemo.domain.Person;
import neo4jdemo.repository.PersonRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.neo4j.graphdb.GraphDatabaseService;
import org.neo4j.graphdb.Node;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.data.neo4j.core.GraphDatabase;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = Neo4jSpringDemoApplication.class)
public class Neo4jSpringDemoApplicationTests {

	@Autowired
	PersonRepository personRepository;

	@Autowired
	GraphDatabaseService graphDatabaseService;

	@Test
	public void contextLoads() {
	}

	@Test
	public void user_repository_test(){
		System.out.println(personRepository.findAll());
		try {
//			graphDatabaseService.beginTx();
			Person person = new Person("p1");
			Person person1 = new Person("p2");
//			person.worksWith(person1);
			personRepository.save(person);
			personRepository.save(person1);
			System.out.println(personRepository.findAll());
			System.out.println(personRepository.findOne(1L));
		} finally {
			graphDatabaseService.shutdown();
		}
	}

}
