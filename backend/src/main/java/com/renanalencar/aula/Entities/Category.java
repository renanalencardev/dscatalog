package com.renanalencar.aula.Entities;

import jakarta.persistence.*;

import java.time.Instant;
import java.util.Objects;
@Entity(name = "Category")
@Table(name = "tb_product")
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    @Column(columnDefinition = "TIMESTAMP WHITOUT TIME ZONE")
    private Instant creationDate;
    @Column(columnDefinition = "TIMESTAMP WHITOUT TIME ZONE")
    private Instant modificationDate;

    public Category(){}
    public Category(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Instant getCreationDate() {
        return creationDate;
    }

    public Instant getModificationDate() {
        return modificationDate;
    }
    @PrePersist
    public void setCreationDate() {
        creationDate = Instant.now();
    }
    @PreUpdate
    public void setModificationDate() {
        modificationDate = Instant.now();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Category category = (Category) o;
        return Objects.equals(id, category.id) && Objects.equals(name, category.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
