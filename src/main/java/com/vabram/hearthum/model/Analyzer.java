package com.vabram.hearthum.model;

import javax.persistence.*;

/**
 * Created by brama051 on 23/06/2017.
 */
@Entity
@Table(name = "analyzer", schema = "hearthumschema")
public class Analyzer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id; // primary key

    @Column(name = "email")
    private String email; // analyzer email


    @Column(name = "name")
    private String name; // analyzer email

    // --- get / set methods --------------------------------------------------

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
