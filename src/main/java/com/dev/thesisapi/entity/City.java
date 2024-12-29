package com.dev.thesisapi.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

@Entity
@Table(name = "city")
public class City {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", unique = true, nullable = false)
    private Integer id;

    @Column(name = "name")
    private String name;

    @ManyToOne
    @JoinColumn(name = "country_id", referencedColumnName = "id")
    @JsonIgnore
    private Country country;

    public City() {
    }

    public City(String name, Country country) {
        this.name = name;
        this.country = country;
    }

    public Integer getId() {
        return id;
    }

    public City setId(Integer id) {
        this.id = id;
        return this;
    }

    public Country getCountry() {
        return country;
    }

    public City setCountry(Country country) {
        this.country = country;
        return this;
    }

    public String getName() {
        return name;
    }

    public City setName(String name) {
        this.name = name;
        return this;
    }
}
