package com.evaluation.bankProperty.controller;


import com.evaluation.bankProperty.model.PropertyValuationTypeEntity;
import com.evaluation.bankProperty.response.GenericJsonResponse;
import com.evaluation.bankProperty.response.ResponseStatus;
import com.evaluation.bankProperty.service.impl.PropertyValuationTypeServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RequestMapping("bank_property/api/property-valuation")
@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
public class PropertyValuationTypeController {

    private PropertyValuationTypeServiceImpl propertyValuationTypeService;

    @Autowired
    public PropertyValuationTypeController(PropertyValuationTypeServiceImpl _propertyValuationTypeServiceImpl){
        propertyValuationTypeService = _propertyValuationTypeServiceImpl;
    }

    @RequestMapping(value = "/Type", method = RequestMethod.POST)
    @ResponseBody()
    public GenericJsonResponse getAll(){
        List<PropertyValuationTypeEntity> propertyValuationTypeEntities = propertyValuationTypeService.findAll();
        return new GenericJsonResponse(ResponseStatus.SUCCESS, true, propertyValuationTypeEntities);
    }
}
