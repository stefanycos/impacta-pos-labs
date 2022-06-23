package br.com.lab.impacta.investment.application.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Date;

@AllArgsConstructor
@Data
public class InvestmentResponse {

    private Long id;

    private Double value;

    private Date creation;
}
