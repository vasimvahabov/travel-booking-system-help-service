package com.travelbookingsystem.helpservice.controller;

import com.travelbookingsystem.helpservice.dto.FAQResponse;
import com.travelbookingsystem.helpservice.service.FAQService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/help/faqs")
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class FAQController {

    FAQService faqService;

    @GetMapping
    public Flux<FAQResponse> findAll() {
        return faqService.findAll();
    }

}
