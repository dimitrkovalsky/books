package com.liberty.models;

import org.springframework.data.neo4j.annotation.GraphId;
import org.springframework.data.neo4j.annotation.NodeEntity;

/**
 * User: Dmytro_Kovalskyi
 * Date: 12.03.2015
 * Time: 16:29
 */
@NodeEntity
public class Genre {
    @GraphId
    private Long id;
    private String name;

    public Genre() {
    }

    public Genre(long id) {
        this.id = id;
    }

    public Genre(String name) {
        this.name = name;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Genre{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
