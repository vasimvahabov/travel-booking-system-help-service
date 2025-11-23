package com.travelbookingsystem.helpservice.entity;

import jakarta.annotation.Nonnull;
import lombok.*;
import lombok.experimental.FieldDefaults;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class FAQ {

    @Nonnull
    Long id;

    @Nonnull
    String question;

    @Nonnull
    String answer;

}
