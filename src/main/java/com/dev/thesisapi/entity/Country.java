package com.dev.thesisapi.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "country")
public class Country {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", unique = true, nullable = false)
    private Integer id;

    @Column(name = "name")
    private String name;

    @Column(name = "iso")
    private String ISO;

    public Country() {
    }

    public Country(String ISO, String name) {
        this.ISO = ISO;
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public Country setId(Integer id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public Country setName(String name) {
        this.name = name;
        return this;
    }

    public String getISO() {
        return ISO;
    }

    public Country setISO(String ISO) {
        this.ISO = ISO;
        return this;
    }
}
