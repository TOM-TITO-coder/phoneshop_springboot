package com.phoneshop.phoneshop.service;

import com.phoneshop.phoneshop.entity.Brand;

public interface BrandService {

    Brand create(Brand brand);
    Brand getById(Integer id);
    Brand update(Integer id, Brand brand);
} 
