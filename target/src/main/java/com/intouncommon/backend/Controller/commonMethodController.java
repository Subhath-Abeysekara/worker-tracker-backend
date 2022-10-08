package com.intouncommon.backend.Controller;

import com.intouncommon.backend.Entity.*;
import com.intouncommon.backend.Service.adminService;
import com.intouncommon.backend.Service.commonMethodService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/intouncommon")
@CrossOrigin(origins = "http://localhost:3000")
public class commonMethodController {

    @Autowired
    private commonMethodService commonMethodService;

    @Autowired
    private adminService adminService;

    /**Security **/

    @PostMapping("/getKey")
    private String getKey(@RequestBody admin admin){
        return adminService.madeSecreteKey(admin.getUsername(),admin.getPassword());
    }
    @PostMapping("/checkAdmin")
    private String checkAdmin(@RequestBody admin admin){
        return adminService.madeSecreteKey(admin.getUsername(),admin.getPassword());
    }

    @PostMapping("/addAdmin")
    private String addAdmin(@RequestBody admin admin){
        adminService.addAdmin(admin);
        return "added successfully";
    }
    @PutMapping ("/changeAdmin")
    private String changeAdmin(@RequestBody oldadmin admin){
        return adminService.changeAdmin(admin.getOldUsername(),admin.getUsername(),admin.getOldPassword(),admin.getPassword());
    }
    @GetMapping("/test")
    private String test(@RequestHeader String token) throws Exception {

//        response response = new response();
//        response.setResponse("test pass");
//        return response;
        if(adminService.checkTokenValidity(token)){
            return "successful";
        }
        return "Wrong token";
    }
    /** productions **/

    @GetMapping("/getproductsandcontact")
    private productResponse getAllProductswithContact(@RequestParam long id){
        return commonMethodService.getAllProductions(id);
    }

    @GetMapping("/getproducts")
    private List<productions> getAllProducts()
    {
        return commonMethodService.getProductions();
    }

    @PostMapping(value="/product/add" ,consumes = "application/json", produces = "application/json")
    private String addProduct(@RequestBody productions production){
        commonMethodService.addProduction(production);
        return "Successfully Added";
    }

    @PutMapping("/product/update")
    private String updateProduct(@RequestParam Long id, @RequestBody productions production){
        return commonMethodService.updateProduction(id,production);
    }

    @PostMapping("/product/url/add")
    private String addProductUrl(@RequestBody productImageDTO productImageDTO){
        commonMethodService.addImageUrl(productImageDTO);
        return "added";
    }

    @DeleteMapping("/product/delete")
    private String deleteProduct(@RequestParam Long id){
        return commonMethodService.deleteProduction(id);
    }

    /** Category **/

    @GetMapping("/getcategories")
    private List<categories> getAllCategories(){
        return commonMethodService.getAllCategories();
    }

    @PostMapping("/category/add")
    private String addCategory(@RequestBody categories category){
        commonMethodService.addCategory(category);
        return "Successfully Added";
    }

    @PutMapping("/category/update")
    private String updateCategory(@RequestParam Long id, @RequestBody categories category){
        return commonMethodService.updateCategory(id,category);
    }

    @DeleteMapping("/category/delete")
    private String deleteCategory(@RequestParam Long id){
        return commonMethodService.deleteCategory(id);
    }

    /** Producer **/

    @GetMapping("/getproducers")
    private List<producers> getAllProducers(){
        return commonMethodService.getAllProducers();
    }

    @PostMapping("/producer/add")
    private String addProducer(@RequestBody producers producer){
        commonMethodService.addProducer(producer);
        return "Successfully Added";
    }

    @PutMapping("/producer/update")
    private String updateProducer(@RequestParam Long id, @RequestBody producers producer){
        return commonMethodService.updateProducer(id,producer);
    }

    @DeleteMapping("/producer/delete")
    private String deleteProducer(@RequestParam Long id){
        return commonMethodService.deleteProducer(id);
    }

    /** StateCodes **/
    @GetMapping("/getstates")
    private List<statecodes> getAllStates(){
        return commonMethodService.getAllStates();
    }
    @PostMapping("/states/add")
    private String addStates(@RequestBody statecodes statecode){
        commonMethodService.addStateCode(statecode);
        return "Successfully Added";
    }

    @PutMapping("/states/update")
    private String updateStates(@RequestParam Long id, @RequestBody statecodes statecode){
        return commonMethodService.updateStateCode(id,statecode);
    }

    @DeleteMapping("/states/delete")
    private String deleteStates(@RequestParam Long id){
        return commonMethodService.deleteStateCode(id);
    }

    /** Uncommon **/

    @PostMapping("/uncommon/add")
    private String addUncommon(@RequestBody uncommonProduct uncommonProduct){
        commonMethodService.addUncommonProduction(uncommonProduct);
        return "Successfully Added";
    }

    @PutMapping("/uncommon/update")
    private String updateUncommon(@RequestParam Long id, @RequestBody uncommonProduct uncommonProduct){
        return commonMethodService.updateUncommonProduction(id,uncommonProduct);
    }

    @DeleteMapping("/uncommon/delete")
    private String deleteUncommon(@RequestParam Long id){
        return commonMethodService.deleteUncommonProduction(id);
    }

    /** User **/
    @GetMapping("/getusers")
    private List<users> getAllUsers(){
        return commonMethodService.getAllUsers();
    }

    @PostMapping("/user/add")
    private String addUser(@RequestBody users user){
        commonMethodService.addUser(user);
        return "Successfully Added";
    }

    @PutMapping("/user/update")
    private String updateUser(@RequestParam Long id, @RequestBody users user){
        return commonMethodService.updateUser(id,user);
    }

    @DeleteMapping("/user/delete")
    private String deleteUser(@RequestParam Long id){
        return commonMethodService.deleteUser(id);
    }
}
