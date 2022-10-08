package com.intouncommon.backend.Controller;


import com.intouncommon.backend.Entity.*;
import com.intouncommon.backend.Service.mainService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/intouncommon")
@CrossOrigin(origins = "http://localhost:3000")
public class mainController {

    @Autowired
    private mainService mainService;


    @GetMapping("/get/category/ids")
    private List<Long> getCategoriesIds(@RequestParam boolean common){
        return mainService.getAllCategoryIds(common);
    }

    @GetMapping("/get/category/type")
    private String getCategoryType(@RequestParam Long id){
        return mainService.getCategoryType(id);
    }

    @GetMapping("/get/product/ids")
    private List<Long> getProductIds(@RequestParam Long id){
        return mainService.getProductIds(id);
    }

    @GetMapping("/get/product")
    private Optional<productions> getProduct(@RequestParam Long id){
        return mainService.getProductById(id);
    }

    @GetMapping("/get/state")
    private Long getState(@RequestParam Long id){
        return mainService.getStateCodeId(id);
    }

    @GetMapping("/get/contact")
    private String getContact(@RequestParam Long id){
        return mainService.getUserContact(id);
    }

    @PutMapping("/insert/category")
    private String addCategory(@RequestParam Long id){
        mainService.updateCategoryInProduction(id,null);
        return "Successfully Added";
    }

    @PutMapping("/insert/producer")
    private String addProducer(@RequestParam Long id){
        mainService.updateProducerInProduction(id,null);
        return "Successfully Added";
    }

    @PutMapping("/insert/state")
    private String addState(@RequestParam Long id){
        mainService.updateStateCodeInUncommon(id,null);
        return "Successfully Added";
    }

    @PutMapping("/addAmount")
    private String addAmount(@RequestParam int amount,@RequestParam Long id){
        mainService.updateImageAmount(amount, id);
        return "Successfully Added";
    }

    @GetMapping("/getAmount")
    private int getAmount(@RequestParam Long id){
        return mainService.getImageAmount(id);
    }
}
