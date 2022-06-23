package br.com.lab.impacta.investment.application.dto.request;

import lombok.Data;

@Data
public class InvestmentRequest {

    private long productId;

    private Double value;
}
