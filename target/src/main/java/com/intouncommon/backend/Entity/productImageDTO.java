package com.intouncommon.backend.Entity;

import lombok.Data;

@Data
public class productImageDTO {

    private productImages productImages;
    private Long productId;

    public productImageDTO() {
    }

    public com.intouncommon.backend.Entity.productImages getProductImages() {
        return productImages;
    }

    public void setProductImages(com.intouncommon.backend.Entity.productImages productImages) {
        this.productImages = productImages;
    }

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }
}
