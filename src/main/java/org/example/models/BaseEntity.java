package org.example.models;

import lombok.Getter;

@Getter
public class BaseEntity {
    private int id;

    public BaseEntity(int id) {
        this.id = id;
    }
}
