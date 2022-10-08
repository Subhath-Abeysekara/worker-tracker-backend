package com.intouncommon.backend.Entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.ToString;

import javax.persistence.*;

@Entity
public class producerCategories {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long catId;
    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL, optional = false)
    @JoinColumn(name = "producers", foreignKey = @ForeignKey(name = "producer_category"))
    @JsonBackReference(value = "producer-producerCategory")
    @ToString.Exclude
    private com.intouncommon.backend.Entity.producers producers;

    public producerCategories() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getCatId() {
        return catId;
    }

    public void setCatId(Long catId) {
        this.catId = catId;
    }

    public com.intouncommon.backend.Entity.producers getProducers() {
        return producers;
    }

    public void setProducers(com.intouncommon.backend.Entity.producers producers) {
        this.producers = producers;
    }
}
