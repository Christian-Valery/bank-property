package com.evaluation.bankProperty.service;

import com.evaluation.bankProperty.model.PsValuationRequestEntity;
import com.evaluation.bankProperty.model.dto.*;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface IGetAllDatasService {
    List<PsValuationRequestEntity>  saveAll(FacilityDetailsDto facilityDetailsDto, PropertyValuationDto propertyValuationDto,
            List<BorrowerDto> borrowersDto, CommentsDto commentsDto, UploadDocumentDto uploadDocumentDto);
}
