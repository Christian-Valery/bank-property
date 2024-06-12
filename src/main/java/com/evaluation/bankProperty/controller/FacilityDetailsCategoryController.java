package com.evaluation.bankProperty.controller;

import com.evaluation.bankProperty.bean.UsersToken;
import com.evaluation.bankProperty.model.FacilityDetailsCategoryEntity;
import com.evaluation.bankProperty.response.GenericJsonResponse;
import com.evaluation.bankProperty.response.ResponseStatus;
import com.evaluation.bankProperty.service.impl.FacilityDetailsCategoryServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("bank_property/api/facility-details")
@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
public class FacilityDetailsCategoryController {

    FacilityDetailsCategoryServiceImpl facilityDetailsCategoryService;

    @Autowired
    public FacilityDetailsCategoryController(FacilityDetailsCategoryServiceImpl _facilityDetailsCategoryService){
        facilityDetailsCategoryService = _facilityDetailsCategoryService;
    }

    @RequestMapping(value = "/category", method = RequestMethod.POST)
    @ResponseBody()
    public GenericJsonResponse getAll(){
        List<FacilityDetailsCategoryEntity> facilityDetailsCategoryEntities = facilityDetailsCategoryService.findAll();
        return new GenericJsonResponse(ResponseStatus.SUCCESS, true, facilityDetailsCategoryEntities);
    }
}
