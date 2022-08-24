package com.movietime.mongodb.models;

import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="roles")
public class Role {
    private String id;
    private EnumRole role;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public EnumRole getRole() {
        return role;
    }

    public void setRole(EnumRole role) {
        this.role = role;
    }

    public Role(EnumRole role) {
        this.role = role;
    }
}
