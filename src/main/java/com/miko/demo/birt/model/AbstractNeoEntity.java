package com.miko.demo.birt.model;

import org.springframework.data.neo4j.annotation.GraphId;

/**
 * Created with IntelliJ IDEA.
 * User: miroslavkopecky
 * Date: 5/27/14
 */
public class AbstractNeoEntity {

    @GraphId
    private Long id;

    public Long getId() {
        return id;
    }

    @Override
    public boolean equals(Object obj) {

        if (this == obj) {
            return true;
        }

        if (id == null || obj == null || !getClass().equals(obj.getClass())) {
            return false;
        }
        return id.equals(((AbstractNeoEntity) obj).id);

    }

    @Override
    public int hashCode() {
        return id == null ? 0 : id.hashCode();
    }

}
