package com.evaluation.bankProperty.controller;

import com.evaluation.bankProperty.response.GenericJsonResponse;
import com.evaluation.bankProperty.response.ResponseStatus;
import com.evaluation.bankProperty.service.impl.DocumentTypeServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RequestMapping("bank_property/api/document")
@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
public class DocumentTypeController {
    private DocumentTypeServiceImpl documentTypeService;

    @Autowired
    public DocumentTypeController(DocumentTypeServiceImpl _documentTypeService){
        documentTypeService = _documentTypeService;
    }


    @RequestMapping(value = "/type", method = RequestMethod.POST)
    @ResponseBody()
    public GenericJsonResponse findAll(){
        return new GenericJsonResponse(ResponseStatus.SUCCESS, true, documentTypeService.findAll());
    }
}
