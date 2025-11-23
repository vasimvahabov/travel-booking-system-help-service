package com.travelbookingsystem.helpservice.service;

import com.travelbookingsystem.helpservice.dto.FAQResponse;
import reactor.core.publisher.Flux;

public interface FAQService {

    Flux<FAQResponse> findAll();

}
