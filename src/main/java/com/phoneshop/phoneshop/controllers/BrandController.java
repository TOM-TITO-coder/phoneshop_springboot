package com.phoneshop.phoneshop.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.phoneshop.phoneshop.dto.BrandDTO;
import com.phoneshop.phoneshop.entity.Brand;
import com.phoneshop.phoneshop.service.BrandService;
import com.phoneshop.phoneshop.service.util.Mapper;

@RestController
@RequestMapping("brands")
public class BrandController {
    
    @Autowired
    private BrandService brandService;
    
    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<?> create(@RequestBody BrandDTO brandDTO){    // @RequestBody is used to get brandDTO from user input
        Brand brand = Mapper.toBrand(brandDTO);      // get brand from brandDTO or from user input
        brand = brandService.create(brand);         // save brand to database or how to save brand to database

        //return ResponseEntity.ok(brand);            // return brand to user or how to return brand to user
        
        return ResponseEntity.ok(Mapper.toBrandDTO(brand));            // return brand to user or how to return brand to user

    }
    
    @GetMapping("{id}")
    public ResponseEntity<?> getOneBrand(@PathVariable("id") Integer brandId){
        Brand brand = brandService.getById(brandId);
        return ResponseEntity.ok(Mapper.toBrandDTO(brand));      // return brandDTO by mapping from brand to brandDTO
    }

    @PutMapping("{id}")
    public ResponseEntity<?> update(@PathVariable("id") Integer brandId, @RequestBody BrandDTO brandDTO){
        Brand brand = Mapper.toBrand(brandDTO);
        Brand updateBrand = brandService.update(brandId, brand);
        return ResponseEntity.ok(Mapper.toBrandDTO(updateBrand));
    }
}
