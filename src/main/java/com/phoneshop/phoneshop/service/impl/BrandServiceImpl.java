package com.phoneshop.phoneshop.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.phoneshop.phoneshop.entity.Brand;
import com.phoneshop.phoneshop.exception.ResourceNotFoundException;
import com.phoneshop.phoneshop.repository.BrandRepository;
import com.phoneshop.phoneshop.service.BrandService;

@Service
public class BrandServiceImpl implements BrandService{
    
    @Autowired
    private BrandRepository brandRepository;

    @Override
    public Brand create(Brand brand) {
        return  brandRepository.save(brand);
    }

    @Override
    public Brand getById(Integer id) {
        return brandRepository.findById(id)
                                .orElseThrow(() -> new ResourceNotFoundException("Brand", id));
    }

    @Override
    public Brand update(Integer id, Brand brandUpdate) {
        Brand brand = getById(id);
        brand.setName(brandUpdate.getName());    // TODO: use mapper
        return brandRepository.save(brand);
    }

    

    
}
