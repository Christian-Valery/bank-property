package com.evaluation.bankProperty.controller;

import com.evaluation.bankProperty.model.FacilityDetailsCCYEntity;
import com.evaluation.bankProperty.model.FacilityDetailsCategoryEntity;
import com.evaluation.bankProperty.response.GenericJsonResponse;
import com.evaluation.bankProperty.response.ResponseStatus;
import com.evaluation.bankProperty.service.impl.FacilityDetailsCCYServiceImpl;
import com.evaluation.bankProperty.service.impl.FacilityDetailsCategoryServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("bank_property/api/facility-details")
@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
public class FacilityDetailsCCYController {

    FacilityDetailsCCYServiceImpl facilityDetailsCCYService;

    @Autowired
    public FacilityDetailsCCYController(FacilityDetailsCCYServiceImpl _facilityDetailsCCYService){
        facilityDetailsCCYService = _facilityDetailsCCYService;
    }

    @RequestMapping(value = "/CCY", method = RequestMethod.POST)
    @ResponseBody()
    public GenericJsonResponse getAll(){
        List<FacilityDetailsCCYEntity> facilityDetailsCCYEntities = facilityDetailsCCYService.findAll();
        return new GenericJsonResponse(ResponseStatus.SUCCESS, true, facilityDetailsCCYEntities);
    }
}
