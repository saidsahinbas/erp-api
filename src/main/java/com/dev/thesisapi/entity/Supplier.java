package com.dev.thesisapi.entity;

import jakarta.persistence.*;

import java.util.Set;

@Entity
@Table(name = "supplier")
public class Supplier {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", unique = true, nullable = false)
    private Integer id;

    @Column(name = "name")
    private String name;

    @Column(name = "contact")
    private String contact;

    @ManyToMany(mappedBy = "suppliers")
    private Set<Product> products;
}
