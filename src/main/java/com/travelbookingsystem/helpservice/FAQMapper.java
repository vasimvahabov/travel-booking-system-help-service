package com.travelbookingsystem.helpservice;

import com.travelbookingsystem.helpservice.dto.FAQResponse;
import com.travelbookingsystem.helpservice.entity.FAQ;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface FAQMapper {

    FAQResponse entityToResponse(FAQ faq);

}
