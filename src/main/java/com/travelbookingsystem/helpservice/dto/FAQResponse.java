package com.travelbookingsystem.helpservice.dto;

import jakarta.annotation.Nonnull;
import lombok.*;
import lombok.experimental.FieldDefaults;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class FAQResponse {

    @Nonnull
    Long id;

    @Nonnull
    String question;

    @Nonnull
    String answer;

}
