package com.evaluation.bankProperty.controller;

import com.evaluation.bankProperty.model.FacilityDetailsPurposeEntity;
import com.evaluation.bankProperty.response.GenericJsonResponse;
import com.evaluation.bankProperty.response.ResponseStatus;
import com.evaluation.bankProperty.service.impl.FacilityDetailsPurposeServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("bank_property/api/facility-details")
@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
public class FacilityDetailsPurposeController {

    FacilityDetailsPurposeServiceImpl facilityDetailsPurposeService;

    @Autowired
    public FacilityDetailsPurposeController(FacilityDetailsPurposeServiceImpl _facilityDetailsPurposeService){
        facilityDetailsPurposeService = _facilityDetailsPurposeService;
    }

    @RequestMapping(value = "/Purpose", method = RequestMethod.POST)
    @ResponseBody()
    public GenericJsonResponse getAll(){
        List<FacilityDetailsPurposeEntity> facilityDetailsPurposeEntities = facilityDetailsPurposeService.findAll();
        return new GenericJsonResponse(ResponseStatus.SUCCESS, true, facilityDetailsPurposeEntities);
    }
}
