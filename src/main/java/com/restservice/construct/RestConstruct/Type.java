package com.restservice.construct.RestConstruct;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

public class Type {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Integer type_id;

    private String name;

    public Integer getType_id() {
        return type_id;
    }

    public void setType_id(Integer type_id) {
        this.type_id = type_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
