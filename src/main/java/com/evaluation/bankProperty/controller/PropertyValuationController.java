package com.evaluation.bankProperty.controller;


import com.evaluation.bankProperty.service.impl.PropertyValuationServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("bank_property/api/property-valuation")
@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
public class PropertyValuationController {

    private PropertyValuationServiceImpl propertyValuationService;

    @Autowired
    public PropertyValuationController(PropertyValuationServiceImpl _propertyValuationServiceImpl){
        propertyValuationService = _propertyValuationServiceImpl;
    }
}
