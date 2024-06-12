package com.evaluation.bankProperty.service.impl;

import com.evaluation.bankProperty.model.BorrowerEntity;
import com.evaluation.bankProperty.model.PropertyValuationEntity;
import com.evaluation.bankProperty.model.PsValuationRequestEntity;
import com.evaluation.bankProperty.model.dto.*;
import com.evaluation.bankProperty.response.GenericJsonResponse;
import com.evaluation.bankProperty.service.IGetAllDatasService;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class GetAllDatasServiceImpl implements IGetAllDatasService {

    @Autowired
    private FacilityDetailsServiceImpl facilityDetailsService;

    @Autowired
    private PropertyValuationServiceImpl propertyValuationService;

    @Autowired
    private BorrowerServiceImpl borrowerService;

    @Autowired
    private CommentsServiceImpl commentsService;

    @Autowired
    private UploadDocumentServiceImpl uploadDocumentService;

    @Autowired
    private PsValuationRequestService psValuationRequestService;

    @Autowired
    public GetAllDatasServiceImpl(){

    }

    @Override
    public List<PsValuationRequestEntity> saveAll(FacilityDetailsDto facilityDetailsDto, PropertyValuationDto propertyValuationDto,
           List<BorrowerDto> borrowersDto, CommentsDto commentsDto, UploadDocumentDto uploadDocumentDto) {
        List<BorrowerEntity> borrowerEntities = new ArrayList<>();
        facilityDetailsService.save(facilityDetailsDto);
        PropertyValuationEntity propertyValuationEntity = propertyValuationService.save(propertyValuationDto);
        for(BorrowerDto borrowerDto : borrowersDto) {
            BorrowerEntity borrowerEntity = borrowerService.save(borrowerDto);
            borrowerEntities.add(borrowerEntity);
        }
        commentsService.save(commentsDto);
        uploadDocumentService.save(uploadDocumentDto);
        PsValuationRequestDto psValuationRequestDto = new PsValuationRequestDto();

        LocalDate today = LocalDate.now();
        int year = today.getYear();
        int month = today.getMonthValue();
        int dayOfMonth = today.getDayOfMonth();

        List<PsValuationRequestEntity> psValuationRequestEntities = new ArrayList<>();
        for(BorrowerEntity borrowerEntity : borrowerEntities) {
            String pvValuationRequestReference = ("PV" + year + month + dayOfMonth + psValuationRequestService.maxId());
            psValuationRequestDto.setPvValuationRequestReference(pvValuationRequestReference);
            psValuationRequestDto.setReceivingDate(today.atStartOfDay());
            psValuationRequestDto.setPropertyValuationEntity(propertyValuationEntity);
            psValuationRequestDto.setCreationDate(today.atStartOfDay());
            psValuationRequestDto.setReceivingDate(today.atStartOfDay());
            psValuationRequestDto.setBorrowerEntity(borrowerEntity);
            psValuationRequestEntities.add(psValuationRequestService.save(psValuationRequestDto));
        }

        return psValuationRequestEntities;
    }
}
