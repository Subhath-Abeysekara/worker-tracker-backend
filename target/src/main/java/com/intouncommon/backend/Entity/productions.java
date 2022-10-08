package com.intouncommon.backend.Entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.ToString;

import javax.persistence.*;
import java.util.List;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public class productions {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String uses;
    private String specialData;
    private String size;
    private String color;
    private String price;
    private String material;
    private String options;
    private String warranty;
    private String delivery;
    private String brand;
    private int amount=0;


    @ManyToOne(cascade = CascadeType.REMOVE)
    @JoinColumn(name = "producer",referencedColumnName = "producerId")
    private producers producer;



    @ManyToOne(cascade = CascadeType.REMOVE)
    @JoinColumn(name = "category",referencedColumnName = "categoryId")
    private categories category;

    @OneToMany(mappedBy = "productions", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JsonManagedReference("product-image")
    @ToString.Exclude
    private List<productImages> productImages;

    public productions() {
    }

    public producers getProducer() {
        return producer;
    }

    public void setProducer(producers producer) {
        this.producer = producer;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public categories getCategory() {
        return category;
    }

    public void setCategory(categories category) {
        this.category = category;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUses() {
        return uses;
    }

    public void setUses(String uses) {
        this.uses = uses;
    }

    public String getSpecialData() {
        return specialData;
    }

    public void setSpecialData(String specialData) {
        this.specialData = specialData;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getMaterial() {
        return material;
    }

    public void setMaterial(String material) {
        this.material = material;
    }

    public String getOptions() {
        return options;
    }

    public void setOptions(String options) {
        this.options = options;
    }

    public String getWarranty() {
        return warranty;
    }

    public void setWarranty(String warranty) {
        this.warranty = warranty;
    }

    public String getDelivery() {
        return delivery;
    }

    public void setDelivery(String delivery) {
        this.delivery = delivery;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public List<com.intouncommon.backend.Entity.productImages> getProductImages() {
        return productImages;
    }

    public void setProductImages(List<com.intouncommon.backend.Entity.productImages> productImages) {
        this.productImages = productImages;
    }
}
