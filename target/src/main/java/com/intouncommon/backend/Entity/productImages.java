package com.intouncommon.backend.Entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.ToString;

import javax.persistence.*;

@Entity
public class productImages {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String url;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL, optional = false)
    @JoinColumn(name = "productions", foreignKey = @ForeignKey(name = "product_image_fk1"))
    @JsonBackReference(value = "product-image")
    @ToString.Exclude
    private productions productions;

    public productImages() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public com.intouncommon.backend.Entity.productions getProductions() {
        return productions;
    }

    public void setProductions(com.intouncommon.backend.Entity.productions productions) {
        this.productions = productions;
    }
}
