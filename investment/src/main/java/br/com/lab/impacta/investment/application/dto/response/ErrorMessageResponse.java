package br.com.lab.impacta.investment.application.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDateTime;

@AllArgsConstructor
@Data
public class ErrorMessageResponse {

    private LocalDateTime timestamp;
    private String message;
    private String description;
}
