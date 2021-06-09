package com.parts.demo.controller;

import com.parts.demo.entity.Parts;
import com.parts.demo.service.partsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
//adding to portfolio
@RestController
public class partsRest {
    private partsService thePartService;
    @Autowired
    public partsRest(partsService onePartService){
        thePartService = onePartService;
    }
    @CrossOrigin
    @GetMapping("/parts")
    public List<Parts> home(){
        return thePartService.findAll();
    }
    @GetMapping("/parts/{id}")
    public Parts getPart(@PathVariable int id){
Parts part = thePartService.findById(id);
if(part == null){
    throw new RuntimeException("The part ID " +id+ " does not exist");
}
return part;
    }
    @PutMapping("/parts")
    public Parts updatePart(@RequestBody Parts thePart){
     thePartService.updatePart(thePart);
     return thePart;
    }
    @PostMapping("/parts")
    public Parts addPart(@RequestBody Parts thePart){
        thePart.setId(0);
        thePartService.updatePart(thePart);
        return thePart;
    }
    @DeleteMapping("/parts/{id}")
    public String deletePart(@PathVariable int id){
     Parts thePart = thePartService.findById(id);
     if(thePart == null){
         throw new RuntimeException("The part ID " + id + " does not exist");
     }
     thePartService.delete(id);
     return "The Part ID " + id + " has been successfully deleted";
    }


}
