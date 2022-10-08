package com.intouncommon.backend.Service;

import com.intouncommon.backend.Entity.*;

import java.util.List;

public interface commonMethodService {

    categories addCategory(categories category);
    String updateCategory(Long id, categories category);
    String deleteCategory(Long id);
    List<categories> getAllCategories();
    producers addProducer(producers producer);
    String updateProducer(Long id, producers producer);
    String deleteProducer(Long id);
    List<producers> getAllProducers();
    productions addProduction(productions production);
    String updateProduction(Long id, productions production);
    String deleteProduction(Long id);
    productResponse getAllProductions(Long id);
    List<productions> getProductions();
    statecodes addStateCode(statecodes statecode);
    String updateStateCode(Long id, statecodes statecode);
    String deleteStateCode(Long id);
    List<statecodes> getAllStates();
    uncommonProduct addUncommonProduction(uncommonProduct uncommonProduct);
    String updateUncommonProduction(Long id, uncommonProduct uncommonProduct);
    String deleteUncommonProduction(Long id);
    users addUser(users user);
    String updateUser(Long id, users user);
    String deleteUser(Long id);
    List<users> getAllUsers();
    productImages addImageUrl (productImageDTO productImageDTO);
}
