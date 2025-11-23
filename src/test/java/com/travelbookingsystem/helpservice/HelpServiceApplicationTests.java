package com.travelbookingsystem.helpservice;

import com.travelbookingsystem.helpservice.dto.FAQResponse;
import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;
import org.junit.jupiter.api.Test;
import org.mockito.BDDMockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.webtestclient.autoconfigure.AutoConfigureWebTestClient;
import org.springframework.test.web.reactive.server.WebTestClient;

@AutoConfigureWebTestClient
@FieldDefaults(level = AccessLevel.PRIVATE)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class HelpServiceApplicationTests {

    @Autowired
    WebTestClient webTestClient;

    @Test
    void whenFindAllFAQsThen200(){
        webTestClient.get()
                .uri("/api/v1/help/faqs")
                .exchange()
                .expectStatus().isOk()
                .expectBodyList(FAQResponse.class)
                .hasSize(5);
    }

}
