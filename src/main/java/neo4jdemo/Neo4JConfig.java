package neo4jdemo;

import org.neo4j.graphdb.GraphDatabaseService;
import org.neo4j.graphdb.factory.GraphDatabaseFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.neo4j.config.EnableNeo4jRepositories;
import org.springframework.data.neo4j.config.Neo4jConfiguration;
import org.springframework.data.neo4j.support.typesafety.TypeSafetyOption;
import org.springframework.data.neo4j.support.typesafety.TypeSafetyPolicy;

/**
 * Created by Madalin.Colezea on 7/30/2015.
 */
@Configuration
@EnableNeo4jRepositories(basePackages = "neo4jdemo.repository")
public class Neo4JConfig extends Neo4jConfiguration{

    public Neo4JConfig(){
        setBasePackage("neo4jdemo.domain");
    }

    @Bean
    public GraphDatabaseService graphDatabaseService(){
        return new GraphDatabaseFactory().newEmbeddedDatabase("D:\\Projects\\Neo4jSpringDemo\\Neo4JDB");
    }

    @Override
    public TypeSafetyPolicy typeSafetyPolicy() throws Exception {
        return new TypeSafetyPolicy(TypeSafetyOption.THROWS_EXCEPTION);
    }


}
