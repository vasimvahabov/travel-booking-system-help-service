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
public class FAQRequest {

    @Nonnull
    Long id;

    @Nonnull
    String question;

    @Nonnull
    String answer;

    @Override
    public String toString() {
        return "FAQRequest{" +
                "id=" + id +
                ", question='" + question + '\'' +
                ", answer='" + answer + '\'' +
                '}';
    }

}
