package com.intouncommon.backend.Service;

import com.intouncommon.backend.Entity.productions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class mainServiceImplementation implements mainService {


    private com.intouncommon.backend.Repository.categoryRepository categoryRepository;


    private com.intouncommon.backend.Repository.producerRepository producerRepository;


    private com.intouncommon.backend.Repository.productionRepository productionRepository;


    private com.intouncommon.backend.Repository.statecodesRepository statecodesRepository;

   // @Autowired
    private com.intouncommon.backend.Repository.uncommonRepository uncommonRepository;

   // @Autowired
    private com.intouncommon.backend.Repository.userRepository userRepository;

    @Override
    public List<Long> getAllCategoryIds(boolean common) {
        return categoryRepository.getIds(common);
    }

    @Override
    public String getCategoryType(Long id) {
        return categoryRepository.getType(id);
    }

    @Override
    public List<Long> getProductIds(Long id) {
        return productionRepository.getIdsByCategory(id);
    }

    @Override
    public Long getStateCodeId(Long id) {
        return uncommonRepository.getStateCode(id);
    }

    @Override
    public Optional<productions> getProductById(Long id) {
        return productionRepository.findById(id);
    }

    @Override
    public String getUserContact(Long id) {
        return userRepository.getContact(id);
    }

    @Override
    public void updateCategoryInProduction(Long cat, Long old) {
       productionRepository.setCategory(cat,old);
    }

    @Override
    public void updateProducerInProduction(Long pro, Long old) {
        productionRepository.setProducer(pro,old);
    }

    @Override
    public void updateStateCodeInUncommon(Long state, Long old) {
        uncommonRepository.setStateCode(state,old);
    }

    @Override
    public int getImageAmount(Long id) {
        return productionRepository.getAmount(id);
    }

    @Override
    public void updateImageAmount(int amount, Long id) {
        productionRepository.setImageAmount(amount, id);
    }
}
