package neo4jdemo.domain;

import org.springframework.data.neo4j.annotation.GraphId;
import org.springframework.data.neo4j.annotation.Indexed;
import org.springframework.data.neo4j.annotation.NodeEntity;

import java.util.Set;

/**
 * Created by Madalin.Colezea on 7/31/2015.
 */
@NodeEntity
public class Movie {
    @GraphId Long nodeId;
    @Indexed(unique = true)
    String id;
    String title;
    int year;
    Set<Role> roles;

    public Movie(Long nodeId, String id, String title, int year, Set<Role> roles) {
        this.nodeId = nodeId;
        this.id = id;
        this.title = title;
        this.year = year;
        this.roles = roles;
    }

    public Movie() {
    }

    public Long getNodeId() {
        return nodeId;
    }

    public void setNodeId(Long nodeId) {
        this.nodeId = nodeId;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public Set<Role> getRoles() {
        return roles;
    }

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Movie)) return false;

        Movie movie = (Movie) o;

        return nodeId.equals(movie.nodeId);

    }

    @Override
    public int hashCode() {
        return nodeId.hashCode();
    }
}
