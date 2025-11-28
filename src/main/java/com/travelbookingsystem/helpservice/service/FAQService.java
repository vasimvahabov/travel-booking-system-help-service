package com.travelbookingsystem.helpservice.service;

import com.travelbookingsystem.helpservice.dto.FAQResponse;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface FAQService {

    Flux<FAQResponse> findAll();

    Mono<FAQResponse> findById(Long id);

}
