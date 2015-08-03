package neo4jdemo.domain;

import org.springframework.data.neo4j.annotation.EndNode;
import org.springframework.data.neo4j.annotation.GraphId;
import org.springframework.data.neo4j.annotation.RelationshipEntity;
import org.springframework.data.neo4j.annotation.StartNode;

/**
 * Created by Madalin.Colezea on 7/31/2015.
 */
@RelationshipEntity(type = "ACTED_IN")
public class Role {
    @GraphId Long nodeId;
    @StartNode Person person;
    @EndNode Movie movie;
    String role;

    public Role(){}

    public Role(Person person, Movie movie, String role) {
        this.person = person;
        this.movie = movie;
        this.role = role;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    public Movie getMovie() {
        return movie;
    }

    public void setMovie(Movie movie) {
        this.movie = movie;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Role)) return false;

        Role role1 = (Role) o;

        if (!person.equals(role1.person)) return false;
        if (!movie.equals(role1.movie)) return false;
        return role.equals(role1.role);

    }

    @Override
    public int hashCode() {
        int result = person.hashCode();
        result = 31 * result + movie.hashCode();
        result = 31 * result + role.hashCode();
        return result;
    }
}
