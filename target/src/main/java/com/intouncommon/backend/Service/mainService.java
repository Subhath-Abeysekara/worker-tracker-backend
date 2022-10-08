package com.intouncommon.backend.Service;

import com.intouncommon.backend.Entity.productions;

import java.util.List;
import java.util.Optional;

public interface mainService {
    List<Long> getAllCategoryIds(boolean common);
    String getCategoryType(Long id);
    List<Long> getProductIds(Long id);
    Long getStateCodeId(Long id);
    Optional<productions> getProductById(Long id);
    String getUserContact(Long id);
    void updateCategoryInProduction(Long cat, Long old);
    void updateProducerInProduction(Long pro, Long old);
    void updateStateCodeInUncommon(Long state, Long old);
    int getImageAmount(Long id);
    void updateImageAmount(int amount,Long id);

}
