package com.phoneshop.phoneshop.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
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
}
