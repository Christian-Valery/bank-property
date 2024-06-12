package com.evaluation.bankProperty.controller;

import com.evaluation.bankProperty.model.dto.FacilityDetailsDto;
import com.evaluation.bankProperty.response.GenericJsonResponse;
import com.evaluation.bankProperty.response.ResponseStatus;
import com.evaluation.bankProperty.service.impl.FacilityDetailsServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;


@RequestMapping("bank_property/api/facility-details")
@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
public class FacilityDetailsController {
    FacilityDetailsServiceImpl facilityDetailsService;

    @Autowired
    public FacilityDetailsController(FacilityDetailsServiceImpl _facilityDetailsService){
        facilityDetailsService = _facilityDetailsService;
    }

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    @ResponseBody()
    public GenericJsonResponse save(@Validated @RequestBody FacilityDetailsDto facilityDetailsDto){
        return new GenericJsonResponse(ResponseStatus.SUCCESS, true, facilityDetailsService.save(facilityDetailsDto));
    }

}
