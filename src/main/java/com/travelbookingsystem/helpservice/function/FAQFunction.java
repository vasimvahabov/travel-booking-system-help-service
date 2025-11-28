package com.travelbookingsystem.helpservice.function;

import com.travelbookingsystem.helpservice.dto.FAQRequest;
import com.travelbookingsystem.helpservice.dto.FAQResponse;
import com.travelbookingsystem.helpservice.service.FAQService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.time.Duration;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;

@Slf4j
@Configuration
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class FAQFunction {

    @Bean
    Supplier<Flux<FAQResponse>> faqs(FAQService faqService) {
        log.info("Fetching all FAQs...");
        return () -> faqService.findAll().delaySequence(Duration.ofSeconds(1));
    }

    @Bean
    Function<Long, Mono<FAQResponse>> faqById(FAQService faqService) {
        return id -> {
            log.info("Fetching a FAQ with {} id ...", id);
            return faqService.findById(id);
        };
    }

    @Bean
    Consumer<FAQRequest> createFaq() {
        return request -> log.info("Creating a FAQ : {}", request);
    }

}
