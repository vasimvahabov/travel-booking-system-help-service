package com.travelbookingsystem.helpservice.service.impl;

import com.travelbookingsystem.helpservice.mapper.FAQMapper;
import com.travelbookingsystem.helpservice.dto.FAQResponse;
import com.travelbookingsystem.helpservice.entity.FAQ;
import com.travelbookingsystem.helpservice.service.FAQService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import java.util.stream.Stream;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class FAQServiceImpl implements FAQService {

    FAQMapper mapper;

    @Override
    public Flux<FAQResponse> findAll() {
        return Flux.fromStream(this::FAQ_STREAM);
    }

    @Override
    public Mono<FAQResponse> findById(Long id) {
        var response = FAQ_STREAM()
                .filter(faq -> id.equals(faq.getId()))
                .findFirst()
                .orElseThrow(() ->
                        new ResponseStatusException(
                                HttpStatus.NOT_FOUND,
                                "FAQ with %s id found ...".formatted(id)
                        ));
        return Mono.just(response);
    }

    private Stream<FAQResponse> FAQ_STREAM() {
        return Stream.of(
                FAQ.builder()
                        .id(1L)
                        .question("How do I book a flight?")
                        .answer("Search for flights, select your preferred option, and follow the checkout process to complete your booking.")
                        .build(),
                FAQ.builder()
                        .id(2L)
                        .question("Can I cancel or change my booking?")
                        .answer("Yes, cancellations and changes depend on the airline's policy. Fees may apply.")
                        .build(),
                FAQ.builder()
                        .id(3L)
                        .question("What payment methods are accepted?")
                        .answer("We accept credit/debit cards, PayPal, and other online payment methods.")
                        .build(),
                FAQ.builder()
                        .id(4L)
                        .question("How can I get a refund?")
                        .answer("Refunds are processed according to the airline or hotel policy. Check your booking confirmation for details.")
                        .build(),
                FAQ.builder()
                        .id(5L)
                        .question("Do you offer travel insurance?")
                        .answer("Yes, you can add travel insurance during the booking process for an extra fee.")
                        .build()
        ).map(mapper::entityToResponse);
    }

}
